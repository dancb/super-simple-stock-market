package com.jpmorgan.app;

public enum StockSymbols {
	TEA("TEA"), POP("POP"), ALE("ALE"), GIN("GIN"), JOE("JOE");
	
	String strValue;

	private StockSymbols(String strValue) {
		this.strValue = strValue;
	}

	public String getStrValue() {
		return strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}
	

}
