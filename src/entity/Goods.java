package entity;

public class Goods {
	private String gid;
	private String gtitle;
	private String gauthor;
	private String gsaleprice;
	private String ginprice;
	private String gdesc;
	private String gimg; //ͼƬ --���ݿ��д��ͼƬ���Ƽ���;
	private String gclicks;
	private String cid;
	private String pid;
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
	public String getGauthor() {
		return gauthor;
	}
	public void setGauthor(String gauthor) {
		this.gauthor = gauthor;
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
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
	public String getGimg() {
		return gimg;
	}
	public void setGimg(String gimg) {
		this.gimg = gimg;
	}
	public String getGclicks() {
		return gclicks;
	}
	public void setGclicks(String gclicks) {
		this.gclicks = gclicks;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	public Goods(String gid, String gtitle, String gauthor, String gsaleprice,
			String ginprice, String gdesc, String gimg, String gclicks,
			String cid, String pid) {
		super();
		this.gid = gid;
		this.gtitle = gtitle;
		this.gauthor = gauthor;
		this.gsaleprice = gsaleprice;
		this.ginprice = ginprice;
		this.gdesc = gdesc;
		this.gimg = gimg;
		this.gclicks = gclicks;
		this.cid = cid;
		this.pid = pid;
	}
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	
}

