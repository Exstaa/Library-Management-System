package az.hafizrzazade.librarysystem.model;

public class Book {
	private String id;
	private String title;
	private String author;
	private boolean isIssued;

	public Book() {

	}

	public Book(String title, String author, boolean isIssued) {
		this.title = title;
		this.author = author;
		this.isIssued = isIssued;
	}
	
	public Book(String id, String title, String author, boolean isIssued) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isIssued = isIssued;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isIssued=" + isIssued + "]";
	}

}
