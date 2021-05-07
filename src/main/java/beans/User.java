package beans;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String username;
	protected String full_name;
	protected String password;
	protected String created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return String.format("{id: %d\nusername: %s\nfull_name: %s\npassword:%s\ncreated_at: %s\n}", id, username,
				full_name, password, created_at);
	}

}
