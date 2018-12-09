package com.mvc.entities;

import java.util.List;
import java.util.Map;

public class ProductDetails {
	private String s;
	private String sk;
	private int[] arrsInt;
	private String[] arrsString;
	private List<String> arrLst;
	private Map<String, String> mapStr;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getSk() {
		return sk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}

	public int[] getArrsInt() {
		return arrsInt;
	}

	public void setArrsInt(int[] arrsInt) {
		this.arrsInt = arrsInt;
	}

	public String[] getArrsString() {
		return arrsString;
	}

	public void setArrsString(String[] arrsString) {
		this.arrsString = arrsString;
	}

	public List<String> getArrLst() {
		return arrLst;
	}

	public void setArrLst(List<String> arrLst) {
		this.arrLst = arrLst;
	}

	public Map<String, String> getMapStr() {
		return mapStr;
	}

	public void setMapStr(Map<String, String> mapStr) {
		this.mapStr = mapStr;
	}

}
