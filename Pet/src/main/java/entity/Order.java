package entity;

public class Order {
	private int order_id;
	private String re_name;
	private int re_phone;
	private int o_money;
	private int o_pay;
	private String re_address;
	private Integer user_id;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getRe_name() {
		return re_name;
	}
	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	public int getRe_phone() {
		return re_phone;
	}
	public void setRe_phone(int re_phone) {
		this.re_phone = re_phone;
	}
	public int getO_money() {
		return o_money;
	}
	public void setO_money(int money) {
		this.o_money = money;
	}
	public int getO_pay() {
		return o_pay;
	}
	public void setO_pay(int pay) {
		this.o_pay = pay;
	}
	public String getRe_address() {
		return re_address;
	}
	public void setRe_address(String re_address) {
		this.re_address = re_address;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", re_name=" + re_name + ", re_phone=" + re_phone + ", money=" + o_money
				+ ", pay=" + o_pay + ", re_address=" + re_address + ", user_id=" + user_id + "]";
	}
	
	
}
