package beans;

import java.io.Serializable;

public class Crypto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int Crypto_id;
	private String Name;
    private Double price;
   
    public int getCrypto_id() {
		return Crypto_id;
	}
	public void setCrypto_id(int crypto_id) {
		Crypto_id = crypto_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	private String created_at;
}
