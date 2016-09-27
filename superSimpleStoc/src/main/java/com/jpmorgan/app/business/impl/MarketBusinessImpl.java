package com.jpmorgan.app.business.impl;

import com.jpmorgan.app.AppUtil;
import com.jpmorgan.app.StockSymbols;
import com.jpmorgan.app.Type;
import com.jpmorgan.app.business.IMarketBusiness;
import com.jpmorgan.app.model.MarketModel;

public class MarketBusinessImpl implements IMarketBusiness {

	public Double getDividendYield(Double price, StockSymbols symbol, boolean showValue) throws IllegalArgumentException {

		Double result       = 0D;
		
		MarketModel object  = MarketModel.getRowByStockSymbol(symbol);
		
		Double dividend     = object.getLastDividend();
		Double fixedDividend= object.getFixDividend();
		Double parValue     = object.getParValue();
		
		if(symbol==null || price==null)
			throw new IllegalArgumentException("Values are required");
		
		if(object.getType().equals(Type.COMMON)){
			result = dividend / price.doubleValue();
			
		}else{
			result = (fixedDividend * parValue ) / price;
		}
		
		if(showValue)
			System.out.print("\nDividend yield is: " + AppUtil.returnNumerTwoDecimals(result) + " and its Type is: " + object.getType());
			
		return AppUtil.returnNumerTwoDecimals(result);
	}

	public Double getPERatio(Double price, StockSymbols symbol) throws Exception {
		Double result 		= 0.0D;
		Double dividendYield 	= getDividendYield(price, symbol, false);	

		if(dividendYield==null || price==null)
			throw new Exception("Values are required");
		
		if(dividendYield.equals(AppUtil.ZERO)){
			System.out.print("Is not possible to operate with a Dividend value = 0");

		} else {
			result = price / dividendYield;
			System.out.print("\nP/E Ratio: " + AppUtil.returnNumerTwoDecimals(result));
		}

		return result;
	}

}
