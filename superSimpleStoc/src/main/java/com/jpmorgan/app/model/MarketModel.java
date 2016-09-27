package com.jpmorgan.app.model;

import java.util.HashMap;
import java.util.Map;

import com.jpmorgan.app.StockSymbols;
import com.jpmorgan.app.Type;

public class MarketModel {
	
	private StockSymbols stcokSymbol;
	private Type type;
	private Double lastDividend;
	private Double fixDividend;
	private Double parValue;
	
	public MarketModel() {
		super();
	}

	public MarketModel(StockSymbols stcokSymbol, Type type, Double lastDividend, Double fixDividend, Double parValue) {
		super();
		this.stcokSymbol = stcokSymbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixDividend = fixDividend;
		this.parValue = parValue;
	}
	
	public StockSymbols getStcokSymbol() {
		return stcokSymbol;
	}
	public void setStcokSymbol(StockSymbols stcokSymbol) {
		this.stcokSymbol = stcokSymbol;
	}
	public Double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public Double getFixDividend() {
		return fixDividend;
	}
	public void setFixDividend(Double fixDividend) {
		this.fixDividend = fixDividend;
	}
	public Double getParValue() {
		return parValue;
	}
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
	public static Map<StockSymbols, MarketModel> getFullStoredData(){
		Map<StockSymbols, MarketModel> map = new HashMap<StockSymbols, MarketModel>();
		
		map.put(StockSymbols.TEA, new MarketModel(StockSymbols.TEA, Type.COMMON, 0D, null, 100D));
		map.put(StockSymbols.POP, new MarketModel(StockSymbols.POP, Type.COMMON, 8D, null, 100D));
		map.put(StockSymbols.ALE, new MarketModel(StockSymbols.ALE, Type.COMMON, 23D, null, 60D));
		map.put(StockSymbols.GIN, new MarketModel(StockSymbols.GIN, Type.PREFERRED, 8D, 2D, 100D));
		map.put(StockSymbols.JOE, new MarketModel(StockSymbols.JOE, Type.COMMON, 13D, null, 250D));
		
		return map;
		
	}
	
	public static MarketModel getRowByStockSymbol(StockSymbols symbol){
		MarketModel row = null; 
		
		Map<StockSymbols, MarketModel> map = getFullStoredData();
		row = map.get(symbol);
		
		return row;
		
	}

	@Override
	public String toString() {
		return "MarketModel [stcokSymbol=" + stcokSymbol + ", type=" + type + ", lastDividend=" + lastDividend
				+ ", fixDividend=" + fixDividend + ", parValue=" + parValue + "]";
	}
	
}
