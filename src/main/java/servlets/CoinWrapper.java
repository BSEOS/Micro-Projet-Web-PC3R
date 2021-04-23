package servlets;

/** 
 * This example uses the Apache HTTPComponents library. 
 */

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
import java.util.List;

public class CoinWrapper {

	private static String apiKey = "key";

	public static String getCryptoPriceByID(int cryptoID) {
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

//			System.out.println(je);
			price = je.getAsJsonArray().get(0).getAsJsonObject().get(priceKey).toString();

			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return price;
	}

	public static String getGlobal() {
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

//			final List<NameValuePair> l = EntityUtils.parse(entity);
//			System.out.println(l.get(0));
			response_content = EntityUtils.toString(entity);
//			EntityUtils.consume(entity);
			JsonParser js = new JsonParser();
			JsonElement je = js.parse(response_content);

			System.out.println(je);
			System.out.println(je.getAsJsonArray().get(0).getAsJsonObject().get("volume_ath"));

//	        String pageName = jsonObject.getAsJsonObject("pageInfo").get("pageName").getAsString();
//	        String pageName = jsonObject.get("coins_count").getAsString();
//	        System.out.println(pageName);

//	        JsonArray arr = jsonObject.getAsJsonArray("posts");
//	        for (int i = 0; i < arr.size(); i++) {
//	            String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
//	            System.out.println(post_id);
//	        }
//			
			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response_content;

	}

	public static void main(String[] args) {
		int btcID = 90;
		System.out.printf("BTC price:%s\n", getCryptoPriceByID(btcID));
//		System.out.println(getGlobal());
	}

	public static void testCoinMarket() {
		String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
		List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
		paratmers.add(new BasicNameValuePair("start", "1"));
		paratmers.add(new BasicNameValuePair("limit", "1"));
		paratmers.add(new BasicNameValuePair("convert", "USD"));

		try {
			String result = makeAPICall(uri, paratmers);
			System.out.println(result);
		} catch (IOException e) {
			System.out.println("Error: cannont access content - " + e.toString());
		} catch (URISyntaxException e) {
			System.out.println("Error: Invalid URL " + e.toString());
		}
	}

	public static String makeAPICall(String uri, List<NameValuePair> parameters)
			throws URISyntaxException, IOException {
		String response_content = "";

		URIBuilder query = new URIBuilder(uri);
		query.addParameters(parameters);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(query.build());

		request.setHeader(HttpHeaders.ACCEPT, "application/json");
		request.addHeader("X-CMC_PRO_API_KEY", apiKey);

		CloseableHttpResponse response = client.execute(request);

		try {
			System.out.println(response.getCode());
			HttpEntity entity = response.getEntity();
			response_content = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			response.close();
		}

		return response_content;
	}

}