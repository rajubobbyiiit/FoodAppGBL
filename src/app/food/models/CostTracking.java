package app.food.models;

import java.util.Objects;

public class CostTracking {
	private int noOfOrders;
	
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
    
	public CostTracking(int type, int noOfOrders) {
		super();
		this.type = type;
		this.noOfOrders = noOfOrders;
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
		CostTracking other = (CostTracking) obj;
		return noOfOrders == other.noOfOrders && type == other.type;
	}
	
	@Override
	public String toString() {
		return "CostTracking [type=" + type + ", noOfOrders=" + noOfOrders + "]";
	}

}
