package test.dto;

public class OrderDto {
	// 필드
	private int o_id;
	private int p_id;
	private int quantity;
	private String o_date;

	// 디폴트 생성자
	public OrderDto() {
	}

	public OrderDto(int o_id, int p_id, int quantity, String o_date) {
		super();
		this.o_id = o_id;
		this.p_id = p_id;
		this.quantity = quantity;
		this.o_date = o_date;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

}
