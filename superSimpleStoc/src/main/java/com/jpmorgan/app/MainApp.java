package com.jpmorgan.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

import com.jpmorgan.app.business.IMarketBusiness;
import com.jpmorgan.app.business.ITradeBusiness;
import com.jpmorgan.app.business.impl.MarketBusinessImpl;
import com.jpmorgan.app.business.impl.TradeBusinessImpl;
import com.jpmorgan.app.model.TradingModel;

public class MainApp {
	
	ITradeBusiness tradeBusiness 	= null;
	BufferedReader br 		= null;
        int selectedOption;

	 public static void main(String[] args) throws Exception {
	    	try {
			new MainApp();
		} catch (Exception e) {
			throw new Exception("An error has been found. " + e.getMessage());
		}
	 }
	 
	 private void mainMenu() throws Exception {
	    showMainMenu();
	    br = new BufferedReader(new InputStreamReader(System.in));
	
	    try {
	  
		    selectedOption = Integer.parseInt(br.readLine());

		    switch (selectedOption) {
			case 1:
			    showSubMenuDividendOptions(1);
			    break;

			case 2:
			    showSubMenuRatioOptions(1);
			    break;

			case 3:
			    showSubMenuRecordTradeOptions();
			    break;

			case 4:
			    showSubMenuCalculateWeightedOptions();
			    break;

			case 5:
			    quitProgram();
			    break;
		    }

	    } catch (Exception e) {
	    	System.out.println("Error trying to read your input. " + e.getMessage());
	    	this.goBackMainMenuAfterAnError();
	    } 
	 }
   
   public MainApp() throws Exception {
	this.mainMenu();
   }
 

    public void showMainMenu() {
    	
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("---------------------------");
        System.out.println("1. Calculates the dividend yield");
        System.out.println("2. Calculates the the P/E Ratio");
        System.out.println("3. Records trade");
        System.out.println("4. Calculate Volume Weighted Stock Price based on trades in past 5 minutes");
        System.out.println("5. Exit the program");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }
 
   
    public void showSubMenuDividendOptions(int mainMenuChoice) throws Exception {
    	
    	Double price 	    = null;
    	StockSymbols symbol = null;
    	Scanner back 	    = null;

        switch (mainMenuChoice) {

            case 1:
                System.out.println("");
                System.out.println("Please choose a Stock (1=TEA, 2=POP, 3=ALE, 4=GIN, 5=JOE) ");
                System.out.println("---------------------------");
                System.out.println("1. TEA: ");
                System.out.println("2. POP: ");
                System.out.println("3. ALE: ");
                System.out.println("4. GIN: ");
                System.out.println("5. JOE: ");
                System.out.println("6. Back to main menu");
                System.out.println("");
                break;

        }

        br = new BufferedReader(new InputStreamReader(System.in));

        try {
        	
            selectedOption              = Integer.parseInt(br.readLine());
            IMarketBusiness business 	= new MarketBusinessImpl();
            
            switch (selectedOption) {
            
	            case 1:
	            	Scanner scPrice = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the op1eration");
			System.out.print("Price: ");

			price 	= scPrice.nextDouble();
			symbol 	= getValueStockSymbolByInput("1");

			business.getDividendYield(price, symbol, true);
								
	              break;
	                
	            case 2:
	            	Scanner scPrice1 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice1.nextDouble();
			symbol 	= getValueStockSymbolByInput("2");

			business.getDividendYield(price, symbol, true);
								
	              break;
	                
	            case 3:
	            	Scanner scPrice2 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice2.nextDouble();
			symbol 	= getValueStockSymbolByInput("3");

			business.getDividendYield(price, symbol, true);
								
	              break;
	                
	            case 4:
	            	Scanner scPrice3 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice3.nextDouble();
			symbol 	= getValueStockSymbolByInput("4");

			business.getDividendYield(price, symbol, true);
								
	              break;
	                
	                
	            case 5:
	            	Scanner scPrice4 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice4.nextDouble();
			symbol 	= getValueStockSymbolByInput("5");

			business.getDividendYield(price, symbol, true);
								
	              break;
	                
                case 6:
                    new MainApp();
                    break; 

            }
            
           	back = new Scanner(System.in);
		System.out.print("\n\nBack to main menu? Y/N: "); 
		String yn = back.next();
		if(yn.equalsIgnoreCase("Y"))
		this.mainMenu();

	} catch (Exception e) {
		System.out.println("An error has been found. " + e.getMessage());
		this.goBackMainMenuAfterAnError();
	} 

    }
    
    
    public void showSubMenuRatioOptions(int mainMenuChoice) throws Exception {
    	IMarketBusiness marketBusiness 	= null;
    	Double price 			= null;
    	StockSymbols symbol 		= null;
    	Scanner back 			= null;

        switch (mainMenuChoice) {

            case 1:
                System.out.println("");
                System.out.println("Please choose a Stock (1=TEA, 2=POP, 3=ALE, 4=GIN, 5=JOE) ");
                System.out.println("---------------------------");
                System.out.println("1. TEA: ");
                System.out.println("2. POP: ");
                System.out.println("3. ALE: ");
                System.out.println("4. GIN: ");
                System.out.println("5. JOE: ");
                System.out.println("6. Back to main menu");
                System.out.println("");
                break;

        }

        br = new BufferedReader(new InputStreamReader(System.in));

        try {
        	
            selectedOption = Integer.parseInt(br.readLine());

            switch (selectedOption) {
            
	            case 1:
	            	marketBusiness  = new MarketBusinessImpl();
	            	Scanner scPrice = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice.nextDouble();
			symbol 	= getValueStockSymbolByInput("1");

			marketBusiness.getPERatio(price, symbol);
								
	              break;
	                
	            case 2:
	            	marketBusiness   = new MarketBusinessImpl();
	            	Scanner scPrice1 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice1.nextDouble();
			symbol 	= getValueStockSymbolByInput("2");

			marketBusiness.getPERatio(price, symbol);
								
	              break;
	                
	            case 3:
	            	marketBusiness   = new MarketBusinessImpl();
	            	Scanner scPrice2 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice2.nextDouble();
			symbol 	= getValueStockSymbolByInput("3");

			marketBusiness.getPERatio(price, symbol);
								
	              break;
	                
	            case 4:
	            	marketBusiness   = new MarketBusinessImpl();
	            	Scanner scPrice3 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice3.nextDouble();
			symbol 	= getValueStockSymbolByInput("4");

			marketBusiness.getPERatio(price, symbol);
								
	              break;
	                
	                
	            case 5:
	            	marketBusiness   = new MarketBusinessImpl();
	            	Scanner scPrice4 = new Scanner(System.in);
	            	System.out.println("");
	                System.out.println("Write its Price to complete the operation");
			System.out.print("Price: ");

			price 	= scPrice4.nextDouble();
			symbol 	= getValueStockSymbolByInput("5");

			marketBusiness.getPERatio(price, symbol);
								
	              break;
	                
                case 6:
                    new MainApp();
                    break; 

            }
            
		back = new Scanner(System.in);
		System.out.print("\n\nBack to main menu? Y/N: "); 
		String yn = back.next();
		if(yn.equalsIgnoreCase("Y"))
			this.mainMenu();

        } catch (Exception e) {
		System.out.println("An error has been found. " + e.getMessage());
		this.goBackMainMenuAfterAnError();
	} 

    }
    
    private void goBackMainMenuAfterAnError() throws Exception{
    	Scanner scan = new Scanner(System.in);
	System.out.print("Press any key to go back to main menu");
	boolean hasNexLine = scan.hasNextLine();
	if(hasNexLine){
		mainMenu();
	}
    }
    
    
    public void showSubMenuRecordTradeOptions() throws Exception {
    	Scanner three1 = null;
    	Scanner three2 = null;
    	Scanner three3 = null;
    	
        try {
        	
        	if(tradeBusiness==null)
        		tradeBusiness = new TradeBusinessImpl();
        	
        	three1 = new Scanner(System.in);
		System.out.print("Please write a Quantity "); 
		Double quantity = three1.nextDouble();

		three2 = new Scanner(System.in);
		System.out.print("Please write a Buy (B) or Sell (S): ");
		String bs = three2.next().toUpperCase();

		three3 = new Scanner(System.in);
		System.out.print("Please write a Price: "); 
		Double price4 = three3.nextDouble();

		TradingModel model = new TradingModel();
		model.setIndicator(bs);
		model.setPrice(price4);
		model.setQuantity(quantity);
		model.setTimeTrading(new Date());

		tradeBusiness.savingTrade(model);

		this.backToMainMenuQuestion();

	} catch (Exception e) {
		System.out.println("Error trying to execute the process. " + e.getMessage());
		this.goBackMainMenuAfterAnError();
	}

    }
    
    private void backToMainMenuQuestion() throws Exception{
    	Scanner back = new Scanner(System.in);
			System.out.print("Back to main menu? Y/N: "); 
			String yn = back.next();
			if(yn.equalsIgnoreCase("Y"))
				this.mainMenu();
    }
    
    
    public void showSubMenuCalculateWeightedOptions() throws Exception {
    		
        try {
        	
        	if(tradeBusiness==null || ((TradeBusinessImpl)tradeBusiness).getAllMemoryMap().size()<1){
			System.out.print("\nYou have to record trades before calculate. Please choose menu 3. \n "); 
			this.mainMenu();
			return;
        	} 

        	tradeBusiness.getCalculationVWSPPast5Minutes();
    			
        	this.backToMainMenuQuestion();
            

	  } catch (Exception e) {
		 System.out.println("Error trying to execute the process." + e);
		 this.goBackMainMenuAfterAnError();
	  } 

    }
    
    
    

    public void quitProgram() {
        System.out.println("Bye");
        System.exit(1);

    }
 
    
    private static StockSymbols getValueStockSymbolByInput(String val) {
		
		if(val.equals("1"))
			return StockSymbols.TEA;
		
		if(val.equals("2"))
			return StockSymbols.POP;
		
		if(val.equals("3"))
			return StockSymbols.ALE;
		
		if(val.equals("4"))
			return StockSymbols.GIN;
		
		if(val.equals("5"))
			return StockSymbols.JOE;
		
		return null;
	}

}
