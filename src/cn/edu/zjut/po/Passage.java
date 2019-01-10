package cn.edu.zjut.po;
public class Passage {
	int id;
	String title;
	String author;
	String date;
	String text;


	public Passage() {
		super();
	}

	public Passage(int id) {
		super();
		this.id = id;
	}

	public Passage(int id, String title, String author, String date, String text) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

    
   
}
