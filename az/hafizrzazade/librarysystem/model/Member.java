package az.hafizrzazade.librarysystem.model;

public class Member {
	private String id;
	private String username;
	private String password;

	public Member() {
		
	}
	
	public Member(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Member(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
