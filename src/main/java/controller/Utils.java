package controller;

import java.io.File;
import java.util.Scanner;

public class Utils {
	public static String[] getSQLAuth() {
		String[] res = new String[2];
		try (Scanner in = new Scanner(new File("db/auth.txt"))) {
			res[0] = in.next();
			res[1] = in.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
