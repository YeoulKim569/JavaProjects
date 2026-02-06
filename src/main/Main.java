package main;

import java.io.IOException;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		APIHandler apiHandler = new APIHandler();
		System.out.println("Hello World");

		// If you want to use the raw data elsewhere:
		String allFields = apiHandler.getAllFields();
		System.out.println(allFields);

		Map<String, Double> conversionRates = apiHandler.parseConversionRates(allFields);
		System.out.println(conversionRates.get("PHP"));

		/*CurrencyConverter currencyConverter = new CurrencyConverter();
		double amount = currencyConverter.convertCurrency("PHP", "USD", 1000);
		System.out.println(amount);
		amount = currencyConverter.convertCurrency("USD", "PHP", 1000);
		System.out.println(amount);*/
	}

}