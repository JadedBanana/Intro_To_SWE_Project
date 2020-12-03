package PizzaSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import Engine.Constants;
import Engine.JSON;
import Engine.Logging;

public class Menu {

	private static HashMap<String, Object> pizzas;
	private static ArrayList<HashMap<String, Object>> toppings;
	private static ArrayList<HashMap<String, Object>> sides;
	private static HashMap<String, Object> coupons;
	
	
	/* ================================================================================
	 * Initializes the menu.
	 * This method just loads the JSON from the menu and converts it into object form.
	 * ================================================================================
	*/
	public static void initialize() {
		HashMap<String, Object> fullMenu = null;
		try {
			fullMenu = JSON.read(new File(Menu.class.getResource(Constants.MENU_JSON_PATH).getPath()));			
			// Pizzas first, just loading a HashMap.
			pizzas = (HashMap<String, Object>) fullMenu.get("pizzas");
			// Toppings next. They're a HashMap list, so we have to do a little conversion.
			Object[] tempToppings = (Object[]) fullMenu.get("toppings");
			toppings = new ArrayList<HashMap<String, Object>>();
			for(int i = 0; i < tempToppings.length; i++)
				toppings.add((HashMap<String, Object>) tempToppings[i]);
			// Then sides. The same conversion as toppings is necessary.
			Object[] tempSides = (Object[]) fullMenu.get("sides");
			sides = new ArrayList<HashMap<String, Object>>();
			for(int i = 0; i < tempSides.length; i++)
				sides.add((HashMap<String, Object>) tempSides[i]);
			// Then coupons. Again, just a HashMap, so only one line.
			coupons = (HashMap<String, Object>) fullMenu.get("coupons");
		} catch (FileNotFoundException | JSON.JSONFormattingError e) {
			Logging.error(e.getStackTrace());
			System.exit(-1);
		}
	}
	
	
	/* =====================================
	 * Returns a HashMap of all the pizzas.
	 * =====================================
	*/
	public static HashMap<String, Object> getPizzas() {
		return pizzas;
	}
	
	
	/* ============================================
	 * Returns a HashMap list of all the toppings.
	 * ============================================
	*/
	public static ArrayList<HashMap<String, Object>> getToppings() {
		return toppings;
	}
	
	
	/* =========================================
	 * Returns a HashMap list of all the sides.
	 * =========================================
	*/
	public static ArrayList<HashMap<String, Object>> getSides() {
		return sides;
	}
	
	
	/* =================================================
	 * Returns a HashMap of all the AUTOMATIC coupons.
	 * We only want to send over the automatic coupons.
	 * =================================================
	*/
	public static HashMap<String, Object> getAutoCoupons() {
		return coupons;
	}
	
	
	/* ================================================================================
	 * Returns a coupon, keyed by the coupon code.
	 * ================================================================================
	*/
	public static HashMap<String, Object> findCoupon(int code) {
		return null;
	}
}
