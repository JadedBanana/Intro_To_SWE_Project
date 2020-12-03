package PizzaSource;

import java.util.HashMap;

public class Order {

	public HashMap<String, Object>[] items;
	public int currentItem;
	public int orderType;
	public Customer customer;
	public double payment;
	public int paymentType;
	public long orderTime;
	public static Order currentOrder;
	
	public Order(int orderType) {
		this.orderType = orderType;
		orderTime = System.currentTimeMillis();
	}
	
}
