package rent;

import java.io.Serializable;
import java.util.Date;

public class RentVO implements Serializable {
	
    private int rentNo;
    private String memberId;
    private int recordNo;
    private Date rentDate;
    private Date returnDueDate;
    private boolean isReturned;
    
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	public Date getReturnDueDate() {
		return returnDueDate;
	}
	public void setReturnDueDate(Date returnDueDate) {
		this.returnDueDate = returnDueDate;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

    // 생성자, getter/setter, toString
}