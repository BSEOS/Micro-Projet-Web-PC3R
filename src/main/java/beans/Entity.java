package beans;

import com.google.gson.Gson;

public class Entity {
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJson() {
		return new Gson().toJson(this).toString();
	}
}
