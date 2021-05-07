package beans;

import java.io.Serializable;

import com.google.gson.Gson;

public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int adviserID;
	private int cryptoID;
	private String title;
	private String content;
	private String created_at;

	public String getJson() {
		return new Gson().toJson(this).toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdviserID() {
		return adviserID;
	}

	public void setAdviserID(int adviserID) {
		this.adviserID = adviserID;
	}

	public int getCryptoID() {
		return cryptoID;
	}

	public void setCryptoID(int cryptoID) {
		this.cryptoID = cryptoID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}