package beans;

import java.io.Serializable;

public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int commentID;
	private String username;
	private int reportID;
    private String content;
    private String createdAt;
    
	public int getComment_id() {
		return commentID;
	}
	public void setComment_id(int comment_id) {
		this.commentID = comment_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getReport_id() {
		return reportID;
	}
	public void setReport_id(int report_id) {
		this.reportID = report_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated_at() {
		return createdAt;
	}
	public void setCreated_at(String created_at) {
		this.createdAt = created_at;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}