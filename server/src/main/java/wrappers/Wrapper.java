package wrappers;

import com.google.gson.JsonElement;

public abstract class Wrapper {
	public abstract JsonElement makeAPICall(final String uri);
}
