package hello;

import java.util.Date;

public class Email {

	private String to;
	private String body;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Email() {
	}

	public Email(String to, String body, Date date) {
		this.to = to;
		this.body = body;
		this.date = date;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	

	@Override
	public String toString() {
		return String.format("Email{to=%s, body=%s, date=%s}", getTo(), getBody(), getDate());
	}

}
