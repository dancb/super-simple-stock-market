package com.jpmorgan.app.business;

import com.jpmorgan.app.model.TradingModel;

public interface ITradeBusiness {
	
	
	/**
	 * This method save and keeps in memory the fields required by the speficcations, which are: timestamp, quantity, buy or sell indicator and price.
	 * @param model
	 * @author Daniel Carasco
	 */
	public void savingTrade(TradingModel model);
	
	
	
	/**
	 * Calculate Volume Weighted Stock Price based on trades in past 5 minutes.
	 * @return Double
	 * @author Daniel Carasco
	 */
	public Double getCalculationVWSPPast5Minutes();
	
	
	
	/**
	 * This method must calculate the GBCE All Share Index using the geometric mean of the Volume Weighted Stock Price for all stocks.
	 * @return Double
	 * @author Daniel Carasco
	 */
	public Double getValueGBCEAllStocks();

}
