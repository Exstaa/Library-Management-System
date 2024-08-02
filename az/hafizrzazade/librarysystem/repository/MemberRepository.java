package az.hafizrzazade.librarysystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import az.hafizrzazade.librarysystem.database.Database;
import az.hafizrzazade.librarysystem.model.Member;

public class MemberRepository {
	private final Connection conn = Database.getConn();

	public void registerMember(Member m) {
		try {
			String query = "INSERT INTO members(username,password) VALUES (?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, m.getUsername());
			st.setString(2, m.getPassword());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Member getMemberByUsername(String username) {
		Member member = new Member();
		String query = "SELECT * FROM members WHERE username = ?";
		try {
			member.setUsername(username);
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			ResultSet response = st.executeQuery();
			while (response.next()) {
				member.setPassword(response.getString("password"));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
}
