package entity;

public class News {

		private String tid;
		private String title;
		private String tcontent;
		private String tpubdate;
		
		public News(){}
		public News(String tid, String title, String tcontent, String tpubdate) {
			super();
			this.tid = tid;
			this.title = title;
			this.tcontent = tcontent;
			this.tpubdate = tpubdate;
		}
		
		public String getTid() {
			return tid;
		}
		public void setTid(String tid) {
			this.tid = tid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getTcontent() {
			return tcontent;
		}
		public void setTcontent(String tcontent) {
			this.tcontent = tcontent;
		}
		public String getTpubdate() {
			return tpubdate;
		}
		public void setTpubdate(String tpubdate) {
			this.tpubdate = tpubdate;
		}
		
}
