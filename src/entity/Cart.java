package entity;

public class Cart {
	private String gid;
	private String gtitle;
	private String gsaleprice;
	private String ginprice;
	private int amount;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public String getGsaleprice() {
		return gsaleprice;
	}
	public void setGsaleprice(String gsaleprice) {
		this.gsaleprice = gsaleprice;
	}
	public String getGinprice() {
		return ginprice;
	}
	public void setGinprice(String ginprice) {
		this.ginprice = ginprice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Cart(String gid, String gtitle, String string, String string2,
			int amount) {
		super();
		this.gid = gid;
		this.gtitle = gtitle;
		this.gsaleprice = string;
		this.ginprice = string2;
		this.amount = amount;
	}
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
}
