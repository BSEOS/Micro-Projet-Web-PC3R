package wrappers.coinlore.test;

import javax.naming.NameNotFoundException;

import wrappers.coinlore.Coin;
import wrappers.coinlore.CoinLoreWrapper;

public class CoinLoreWrapperTest {
	public static void main(String[] args) throws NameNotFoundException {

		CoinLoreWrapper clw = new CoinLoreWrapper();

//		int btcID = clw.getCoinIDbyName("bitcoin");
//		Coin coin = clw.getCoinByID(btcID);
//		Coin luna = clw.getCoinByID(clw.getCoinIDbyName("lun"));
//		System.out.println(coin.getMarketCapUSD());
//		System.out.println(luna.getPercentChange1h() + "  " + luna.getSymbol());
//		System.out.println(coin.getPriceUSD());

		// or directy get coin by its name

		System.out.println("ETH: " + clw.getCoinByName("telcoin").getPriceUSD() + "$");
	}
}
