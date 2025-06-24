package record;

import java.io.Serializable;
import java.util.Date;

public class RecordVO implements Serializable {
	private int recordNo;
	private String title;
	private String artist;
	private String label;
	private int price;
	private int instock;
	private Date regdate;
	
	public RecordVO(int recordNo, String title, String artist, String label, int price, int instock, Date regdate) {
	    this.recordNo = recordNo;
	    this.title = title;
	    this.artist = artist;   // ✔ 제대로 할당됨
	    this.label = label;     // ✔ 제대로 할당됨
	    this.price = price;
	    this.instock = instock;
	    this.regdate = regdate;
	}
	
	public RecordVO(String title, String artist, String label, int price, int instock) {
	    this(-1, title, artist, label, price, instock, null);
	}
	
	public String toString() {
		return "[" + recordNo + ", " + title + ", " + artist + ", " + label + ", " + price + ", " + instock + "]";
	}

	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
	    return artist;
	}
	public void setArtist(String artist) {
	    this.artist = artist;
	}

	public String getLabel() {
	    return label;
	}
	public void setLabel(String label) {
	    this.label = label;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
