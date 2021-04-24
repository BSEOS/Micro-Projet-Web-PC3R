package wrappers.coinlore;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.tomcat.util.json.JSONParser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.naming.NameNotFoundException;

public class CoinLoreWrapper {

	public static HashMap<String, Integer> nameID = new HashMap<>();

	// caching some coins data
	{
		nameID.put("bitcoin", 90);
		nameID.put("ethereum", 80);
		nameID.put("binance-coin", 2710);
		nameID.put("binance coin", 2710);
		nameID.put("ripple", 58);
		nameID.put("dogecoin", 2);
		nameID.put("cardano", 257);
		nameID.put("polkadot", 45219);
		nameID.put("litecoin", 1);
		nameID.put("bitcoin-cash", 2321);
		nameID.put("bitcoin cash", 2321);
		nameID.put("chainlink", 2751);
		nameID.put("vechain", 2741);
		nameID.put("stellar", 89);
		nameID.put("uniswap", 47305);
	}

	public CoinLoreWrapper() {

	}

	public String getTop10Coins() {
		return getTopCoins(0, 10);
	}

	public String getTopCoins(int start, int limit) {
		final String uri = String.format("https://api.coinlore.net/api/tickers/?start=%d&limit=%d", start, limit);
		final String priceKey = "price_usd";

		String resp = "";

		try {
			URIBuilder query = new URIBuilder(uri);

			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet request = new HttpGet(query.build());

			request.setHeader(HttpHeaders.ACCEPT, "application/json");

			CloseableHttpResponse response = client.execute(request);

			System.out.printf("status code: %d\n", response.getCode());

			HttpEntity entity = response.getEntity();
			resp = EntityUtils.toString(entity);

			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resp;
	}

	public int getCoinID(String coinName) throws NameNotFoundException {
		final String uri = "https://api.coinlore.net/api/tickers/";
		int coinID = -1;
		coinName = coinName.toLowerCase();

		if (nameID.containsKey(coinName)) {
			coinID = nameID.get(coinName);
		} else {
			JsonElement elem = makeAPICall(uri);
			JsonArray data = elem.getAsJsonObject().get("data").getAsJsonArray();
			Iterator<JsonElement> it = data.iterator();
			while (it.hasNext()) {
				JsonObject obj = (JsonObject) it.next();
				String symbol = obj.get("symbol").getAsString().toLowerCase();
				String name = obj.get("name").getAsString().toLowerCase();
				String nameid = obj.get("nameid").getAsString().toLowerCase();
				if (name.contains(coinName) || nameid.contains(coinName) || symbol.contains(coinName)) {
					int id = obj.get("id").getAsInt();
					coinID = id;
					nameID.put(name, id);
					nameID.put(nameid, id);
					nameID.put(symbol, id);
				}

			}

		}

		if (coinID == -1) {
			throw new NameNotFoundException("can't find the name in the list of actual ctrypto-currencies");
		}

		return coinID;
	}

	public JsonElement makeAPICall(final String uri) {
		String resp = "";
		JsonElement elem = null;
		try {
			URIBuilder query = new URIBuilder(uri);

			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet request = new HttpGet(query.build());

			request.setHeader(HttpHeaders.ACCEPT, "application/json");

			CloseableHttpResponse response = client.execute(request);

			System.out.printf("status code: %d\n", response.getCode());

			HttpEntity entity = response.getEntity();

			resp = EntityUtils.toString(entity);
			JsonParser jp = new JsonParser();
			elem = jp.parse(resp);

			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return elem;
	}

	public String getCoinPriceByID(int cryptoID) {
		final String uri = String.format("https://api.coinlore.net/api/ticker/?id=%d", cryptoID);
		final String priceKey = "price_usd";

		String resp = "";
		String price = "";

		try {
			URIBuilder query = new URIBuilder(uri);

			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet request = new HttpGet(query.build());

			request.setHeader(HttpHeaders.ACCEPT, "application/json");

			CloseableHttpResponse response = client.execute(request);

			System.out.printf("status code: %d\n", response.getCode());

			HttpEntity entity = response.getEntity();

			resp = EntityUtils.toString(entity);
			JsonParser jp = new JsonParser();
			JsonElement je = jp.parse(resp);

			price = je.getAsJsonArray().get(0).getAsJsonObject().get(priceKey).getAsString();

			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return price;
	}

	public String getGlobal() {
		String uri = "https://api.coinlore.net/api/global/";
		String response_content = "";

		try {
			URIBuilder query = new URIBuilder(uri);

			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet request = new HttpGet(query.build());

			request.setHeader(HttpHeaders.ACCEPT, "application/json");

			CloseableHttpResponse response = client.execute(request);

			System.out.println(response.getCode());

			HttpEntity entity = response.getEntity();


			response_content = EntityUtils.toString(entity);
			JsonParser js = new JsonParser();
			JsonElement je = js.parse(response_content);

			System.out.println(je);
			System.out.println(je.getAsJsonArray()
					.get(0)
					.getAsJsonObject()
					.get("volume_ath"));
	
			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response_content;

	}

}