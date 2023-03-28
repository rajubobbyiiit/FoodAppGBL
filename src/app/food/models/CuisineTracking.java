package app.food.models;

import java.util.Objects;

public class CuisineTracking {
	private int noOfOrders;
	private Cuisine type;

	public int getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
    public Cuisine getType() {
		return type;
	}
	public CuisineTracking(Cuisine type, int noOfOrders) {
		super();
		this.type = type;
		this.noOfOrders = noOfOrders;
	}
	public void setType(Cuisine type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CuisineTracking [type=" + type + ", noOfOrders=" + noOfOrders + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(noOfOrders, type);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuisineTracking other = (CuisineTracking) obj;
		return noOfOrders == other.noOfOrders && type == other.type;
	}
}
