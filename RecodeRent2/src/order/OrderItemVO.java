package order;

import java.io.Serializable;

public class OrderItemVO implements Serializable {
	private int recordNo;
	private int quantity;
	private int price;
	
	public OrderItemVO(int recordNo, int quantity, int price) {
		this.recordNo = recordNo;
		this.quantity = quantity;
		this.price = price;
	}

	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\t***" + recordNo + ", " + quantity + "(권), " + price + "(원)";
	}
	
	
}