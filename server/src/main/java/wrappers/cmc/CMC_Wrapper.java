package wrappers.cmc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

public class CMC_Wrapper {
	private static final String apiKey = "key";
	
	
	public CMC_Wrapper() {
	}
	
	public void testCoinMarket() {
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
