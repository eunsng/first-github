package egovframework.example.sample.service;

public class deptVO {
	//접근지정자
	private String deptno;  //인스턴스변수
	private String dname;
	private String loc;
	
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	
}
