package com.jpmorgan.test;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.jpmorgan.app.AppUtil;
import com.jpmorgan.app.StockSymbols;
import com.jpmorgan.app.Type;
import com.jpmorgan.app.business.IMarketBusiness;
import com.jpmorgan.app.business.impl.MarketBusinessImpl;
import com.jpmorgan.app.business.impl.TradeBusinessImpl;
import com.jpmorgan.app.model.MarketModel;
import com.jpmorgan.app.model.TradingModel;

public class GeneralMarketTest {
	
	private Logger log = Logger.getLogger(GeneralMarketTest.class.toString());

	/**
	 * Given a price that is set in the first argument of <code>getDividendYield</code> method, It will process
	 * the Dividend Yield for a <code>Type.COMMON</code>.
	 */
	@Test
	public void testDividendYield1() {
		
		log.info("\n::: Starting testDividendYield1 :::");
		
		try {
			IMarketBusiness business = new MarketBusinessImpl();
			MarketModel mkModel = new MarketModel();
			mkModel.setType(Type.COMMON);
			Double result = business.getDividendYield(200D, StockSymbols.POP, true);
			Assert.assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("\n::: End testDividendYield1 :::");
		
	}
	
	/**
	 * Given a price that is set in the first argument of <code>getDividendYield</code> method, It will process
	 * the Dividend Yield for a <code>Type.PREFERRED</code>.
	 */
	@Test
	public void testDividendYield2() {
		
		log.info("\n::: Starting testDividendYield2 :::");
		
		try {
			IMarketBusiness business = new MarketBusinessImpl();
			MarketModel mkModel = new MarketModel();
			mkModel.setType(Type.PREFERRED);
			Double result = business.getDividendYield(115D, StockSymbols.GIN, true);
			Assert.assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("\n::: End testDividendYield2 :::");
		
	}
	
	/**
	 * This test method calls to the process business to return in console the value of P/E Ratio operation.
	 */
	@Test
	public void testPERatio() {
		
		log.info("\n::: Starting testPERatio :::");
		
		try {
			IMarketBusiness business = new MarketBusinessImpl();
			Double result = business.getPERatio(90D, StockSymbols.GIN);
			Assert.assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("\n::: End testPERatio :::");
		
	}
	
	/**
	 * This methos makes two operations:
	 * 
	 * 1- Record a trade, with timestamp, quantity, buy or sell indicator and price
	 * 2- Calculate Volume Weighted Stock Price based on trades in past 5 minutes
	 * 
	 * Explanation: The method inserts into a Map four models that will be keeping in memory 
	 * to calculate the Volume Weighted Stock Price based on trades in past 5 minutes.
	 * The firts two code snippets will be out of the process due to their <code>timeTrading</code> fields
	 * have been set with more than five minutes before now. However, from the instance call <code>model3</code>
	 * onwards, the <code>timeTrading</code> fields will be set to calculate the 
	 * Volume Weighted Stock Price based on trades in past 5 minutes.
	 * snippet code 
	 */
	@Test
	public void testCalculationVWSPPast5Minutes() {
		
		log.info("\n::: Starting testCalculationVWSPPast5Minutes :::");
		
		try {
			TradeBusinessImpl business = new TradeBusinessImpl();
			TradingModel model = new TradingModel();
			model.setIndicator("BUY");
			model.setPrice(200d);
			model.setQuantity(1d);
			model.setTimeTrading(AppUtil.getNowLessMinutes(10));
			business.savingTrade(model);
			
			TradingModel model2 = new TradingModel();
			model2.setIndicator("SELL");
			model2.setPrice(120d);
			model2.setQuantity(4d);
			model2.setTimeTrading(AppUtil.getNowLessMinutes(17));
			business.savingTrade(model2);
			
			TradingModel model3 = new TradingModel();
			model3.setIndicator("SELL");
			model3.setPrice(310d);
			model3.setQuantity(1d);
			model3.setTimeTrading(AppUtil.getNowLessMinutes(3));
			business.savingTrade(model3);
			
			TradingModel model4 = new TradingModel();
			model4.setIndicator("BUY");
			model4.setPrice(70d);
			model4.setQuantity(2d);
			model4.setTimeTrading(AppUtil.getNowLessMinutes(2));
			business.savingTrade(model4);
			
			Double result = business.getCalculationVWSPPast5Minutes();
			Assert.assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("\n::: End testCalculationVWSPPast5Minutes :::");
		
	}
	
	

}
