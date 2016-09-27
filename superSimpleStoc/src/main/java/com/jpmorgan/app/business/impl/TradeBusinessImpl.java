package com.jpmorgan.app.business.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jpmorgan.app.AppUtil;
import com.jpmorgan.app.business.ITradeBusiness;
import com.jpmorgan.app.model.TradingModel;

public class TradeBusinessImpl implements ITradeBusiness {
	
	public Map<Date, TradingModel> memoryMap = null;

	public void savingTrade(TradingModel model) {
		
		if(memoryMap==null)
			memoryMap = new HashMap<Date, TradingModel>();
		
		memoryMap.put(model.getTimeTrading(), model);
		System.out.println("\nTrade added successfully. ["+memoryMap.size()+"]" + " trades have been added so far. \nThe last one is: "+ model.toString());
	}
	
	public Map<Date, TradingModel> getAllMemoryMap() {
		return memoryMap;
	}

	public Double getCalculationVWSPPast5Minutes() {

		Date nowLessFive 	    = AppUtil.getNowLessMinutes(5);
		Map<Date, TradingModel> map = this.getAllMemoryMap();
		double quantityAcum 	    = 0.0;
		double operAcum 	    = 0.0;
		double result 		    = 0.0;
		
		for (Map.Entry<Date, TradingModel> entry : map.entrySet()) {
			
			Date keyDate    		= ((Date) entry.getKey());
			TradingModel tradingObject 	= ((TradingModel) entry.getValue());
			
			if(nowLessFive.before(keyDate) || nowLessFive.equals(keyDate)){
				
				operAcum += (tradingObject.getPrice().doubleValue() * tradingObject.getQuantity().doubleValue());
				quantityAcum += tradingObject.getQuantity();

				if(quantityAcum > 0.0){
					result = operAcum / quantityAcum;	
				}
				
			}
		    
		}

		System.out.println("\nVolume Weighted Stock Price based on trades in past 5 minutes is: " + AppUtil.returnNumerTwoDecimals(result));
		return result;
	}

	public Double getValueGBCEAllStocks() {
		//@TODO I need more information to complete this requirement.
		return null;
	}

}
