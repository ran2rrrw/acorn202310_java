package test.dto;

public class OrderDto {
	// 필드
	private int id;
	private String pname;
	private int price;
	private int qtt;

	public OrderDto() {
	};

	public OrderDto(int id, String pname, int price, int qtt) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.qtt = qtt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQtt() {
		return qtt;
	}

	public void setQtt(int qtt) {
		this.qtt = qtt;
	}

}
