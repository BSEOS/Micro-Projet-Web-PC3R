package wrappers.coinlore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Coin {

	private int id;
	private String symbol, name, nameid;
	private int rank;
	private double priceUSD, priceBTC;
	private double percentChange24h, percentChange1h, percentChange7d;
	private String marketCapUSD;
	private String volume24, volume24Native;
	private String csupply, tsupply, msupply;
	private JsonElement coinJson;

	public Coin(int id) {
		this.id = id;
	}

	public Coin(JsonObject obj) {
		coinJson = obj;
		id = obj.get("id").getAsInt();
		symbol = obj.get("symbol").getAsString();
		name = obj.get("name").getAsString();
		nameid = obj.get("nameid").getAsString();
		rank = obj.get("rank").getAsInt();
		priceUSD = obj.get("price_usd").getAsDouble();
		priceBTC = obj.get("price_btc").getAsDouble();
		percentChange24h = obj.get("percent_change_24h").getAsDouble();
		percentChange1h = obj.get("percent_change_1h").getAsDouble();
		percentChange7d = obj.get("percent_change_7d").getAsDouble();
		marketCapUSD = obj.get("market_cap_usd").getAsString();
		volume24 = obj.get("volume24").getAsString();
		volume24Native = obj.get("volume24_native").getAsString();
		csupply = obj.get("csupply").getAsString();
		tsupply = obj.get("tsupply").getAsString();
		msupply = obj.get("msupply").getAsString();
	}

	@Override
	public String toString() {
		if (coinJson == null) {
			Gson gson = new Gson();
			coinJson = gson.toJsonTree(this);
		}

		return coinJson.toString();

	}

	public JsonElement getJson() {
		return this.coinJson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameid() {
		return nameid;
	}

	public void setNameid(String nameid) {
		this.nameid = nameid;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getPriceUSD() {
		return priceUSD;
	}

	public void setPriceUSD(double priceUSD) {
		this.priceUSD = priceUSD;
	}

	public double getPriceBTC() {
		return priceBTC;
	}

	public void setPriceBTC(double priceBTC) {
		this.priceBTC = priceBTC;
	}

	public double getPercentChange24h() {
		return percentChange24h;
	}

	public void setPercentChange24h(double percentChange24h) {
		this.percentChange24h = percentChange24h;
	}

	public double getPercentChange1h() {
		return percentChange1h;
	}

	public void setPercentChange1h(double percentChange1h) {
		this.percentChange1h = percentChange1h;
	}

	public double getPercentChange7d() {
		return percentChange7d;
	}

	public void setPercentChange7d(double percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	public String getMarketCapUSD() {
		return marketCapUSD;
	}

	public void setMarketCapUSD(String marketCapUSD) {
		this.marketCapUSD = marketCapUSD;
	}

	public String getVolume24() {
		return volume24;
	}

	public void setVolume24(String volume24) {
		this.volume24 = volume24;
	}

	public String getVolume24Native() {
		return volume24Native;
	}

	public void setVolume24Native(String volume24Native) {
		this.volume24Native = volume24Native;
	}

	public String getCsupply() {
		return csupply;
	}

	public void setCsupply(String csupply) {
		this.csupply = csupply;
	}

	public String getTsupply() {
		return tsupply;
	}

	public void setTsupply(String tsupply) {
		this.tsupply = tsupply;
	}

	public String getMsupply() {
		return msupply;
	}

	public void setMsupply(String msupply) {
		this.msupply = msupply;
	}

}
