package com.elham.restfulwebservice.messenger.resources.beans;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.QueryParam;

public class RestfulParamsBean {
	

	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	private @HeaderParam("firstHeader") String firstHeader;
	private @CookieParam("myCookie") String myCookie;
	private @MatrixParam("myMatrix") String myMatrix;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getFirstHeader() {
		return firstHeader;
	}
	public void setFirstHeader(String firstHeader) {
		this.firstHeader = firstHeader;
	}
	public String getMyCookie() {
		return myCookie;
	}
	public void setMyCookie(String myCookie) {
		this.myCookie = myCookie;
	}
	public String getMyMatrix() {
		return myMatrix;
	}
	public void setMyMatrix(String myMatrix) {
		this.myMatrix = myMatrix;
	}
	
	
}
