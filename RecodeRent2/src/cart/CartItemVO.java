package cart;

public class CartItemVO {

	private int recordNo;
	private int quantity;
	
	public CartItemVO(int recordNo, int quantity) {
		this.recordNo = recordNo;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "[" + recordNo + "번 음반, " + quantity + "권]";
	}
	
	
}