package beans;

import java.io.Serializable;

public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id_report;
	private int idviser_id;
	private int crypto_id;
	private String title;
    private String content;
    private String created_at;
    
	public int getId_report() {
		return id_report;
	}
	public void setId_report(int id_report) {
		this.id_report = id_report;
	}
	public int getIdviser_id() {
		return idviser_id;
	}
	public void setIdviser_id(int idviser_id) {
		this.idviser_id = idviser_id;
	}
	public int getCrypto_id() {
		return crypto_id;
	}
	public void setCrypto_id(int crypto_id) {
		this.crypto_id = crypto_id;
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