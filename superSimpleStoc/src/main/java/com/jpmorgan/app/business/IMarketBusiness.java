package com.jpmorgan.app.business;

import com.jpmorgan.app.StockSymbols;

public interface IMarketBusiness {
	
	
	/**
	 * Given a price introduced by users, this method calculates the Dividend Yield.
	 * Returns a <code>Double</code> to be able to work with decimal numbers. 
	 * @param price Introduced by user.
	 * @param symbol stored in memory.
	 * @param showResult Assesses if the methoh has to show the result in console.
	 * @return
	 * @throws Exception
	 * @author Daniel Carrasco
	 */
	public Double getDividendYield(Double price, StockSymbols symbol, boolean showResult) throws Exception;
	
	
	
	/**
	 * Once the user introduced a price, this method will be executed to return the P/E Ratio value.
	 * Returns a <code>Double</code> to be able to work with decimal numbers. 
	 * @param price
	 * @param symbol
	 * @return
	 * @throws Exception
	 * @author Daniel Carrasco
	 */
	public Double getPERatio(Double price, StockSymbols symbol) throws Exception;

}
