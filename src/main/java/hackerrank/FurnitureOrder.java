package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {

	private final Map<Furniture, Integer> order;

	/**
	 * Initialize a new mapping of Furniture types to order quantities.
	 */
	FurnitureOrder() {
		order = new HashMap<>();
	}

	public void addToOrder(final Furniture type, final int furnitureCount) {
		int count = 0;
		if (order.containsKey(type)) {
			count = order.get(type);
		}
		order.put(type, count + furnitureCount);
	}

	public HashMap<Furniture, Integer> getOrderedFurniture() {
		return new HashMap<Furniture, Integer>(order);
	}

	public float getTotalOrderCost() {
		if (!order.isEmpty()) {
			float sum = 0.0f;
			for (Furniture f : order.keySet()) {
				sum += (f.cost() * order.get(f));
			}
			return sum;
		}
		return 0.0f;
	}

	public int getTypeCount(Furniture type) {
		if (order.containsKey(type)) {
			return order.get(type);
		}
		return 0;
	}

	public float getTypeCost(Furniture type) {
		if (order.containsKey(type)) {
			return order.get(type) * type.cost();
		}
		return 0.0f;
	}

	public int getTotalOrderQuantity() {
		if (!order.isEmpty()) {
			int quantities = 0;
			for (int quantity : order.values()) {
				quantities += quantity;
			}
			return quantities;
		}
		return 0;
	}
}