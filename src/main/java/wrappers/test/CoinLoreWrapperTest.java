package wrappers.test;

import javax.naming.NameNotFoundException;

import wrappers.CoinLoreWrapper;

public class CoinLoreWrapperTest {
	public static void main(String[] args) throws NameNotFoundException {
		
		CoinLoreWrapper clw = new CoinLoreWrapper();
		int btcID = 90;
		
//		System.out.printf("BTC price:%s\n", clw.getCryptoPriceByID(btcID));
//		System.out.println(clw.getGlobal());
		
//		System.out.println(clw.getTop10Coins());
		System.out.println(clw.getCoinPriceByID(clw.getCoinID("avax")));
	}	
}
