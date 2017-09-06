package entity;

import java.sql.Date;

public class Log {
			private String adminid;
			private String done;
			private String obj;
			private String objid;
			private Date ddate;
			public Log(){}
			public Log(String adminid, String done, String obj, String objid,
					Date ddate) {
				super();
				this.adminid = adminid;
				this.done = done;
				this.obj = obj;
				this.objid = objid;
				this.ddate = ddate;
			}
			public String getAdminid() {
				return adminid;
			}
			public void setAdminid(String adminid) {
				this.adminid = adminid;
			}
			public String getDone() {
				return done;
			}
			public void setDone(String done) {
				this.done = done;
			}
			public String getObj() {
				return obj;
			}
			public void setObj(String obj) {
				this.obj = obj;
			}
			public String getObjid() {
				return objid;
			}
			public void setObjid(String objid) {
				this.objid = objid;
			}
			public Date getDdate() {
				return ddate;
			}
			public void setDdate(Date ddate) {
				this.ddate = ddate;
			}

}
