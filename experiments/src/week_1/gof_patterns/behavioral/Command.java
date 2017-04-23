package week_1.gof_patterns.behavioral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Command {
	public static void main(String[] args) {
		StockTrade stock = new StockTrade();
		BuyStockOrder bsc = new BuyStockOrder(stock);
		SellStockOrder ssc = new SellStockOrder(stock);
		Agent agent = new Agent();

		agent.placeOrder(bsc); // Buy Shares
		agent.placeOrder(ssc); // Sell Shares
	}
}

interface Order {
	public abstract void execute();
}

// Receiver class.
class StockTrade {
	public void buy() {
		System.out.println("You want to buy stocks");
	}

	public void sell() {
		System.out.println("You want to sell stocks ");
	}
}

// Invoker.
class Agent {
	private Queue m_ordersQueue = new LinkedList();

	public Agent() {
	}

	void placeOrder(Order order) {
		m_ordersQueue.add(order);
	}
}

// ConcreteCommand Class.
class BuyStockOrder implements Order {
	private StockTrade stock;

	public BuyStockOrder(StockTrade st) {
		stock = st;
	}

	public void execute() {
		stock.buy();
	}
}

// ConcreteCommand Class.
class SellStockOrder implements Order {
	private StockTrade stock;

	public SellStockOrder(StockTrade st) {
		stock = st;
	}

	public void execute() {
		stock.sell();
	}
}
