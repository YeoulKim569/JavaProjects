package main;

public class CurrencyConverter {
	String inputCurrency;
	String outputCurrency;
	
	public CurrencyConverter() {
		inputCurrency = "";
		outputCurrency = "";
	}
	
	public double convertCurrency(String inputCurrency, String outputCurrency, double inputAmount) {
		double conversionRate = 0.0;
		double outputAmount = 0.0;
		
		if(inputCurrency.equals("PHP") && outputCurrency.equals("USD")) {
			conversionRate = 0.017;
		}
		else if(inputCurrency.equals("USD") && outputCurrency.equals("PHP")) {
			conversionRate = 59.34;
		}
		
		outputAmount = conversionRate * inputAmount;
		return outputAmount;
	}
}
