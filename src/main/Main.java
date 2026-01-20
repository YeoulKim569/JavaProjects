package main;

public class Main {

	public static void main(String[] args) {
		CurrencyConverter currencyConverter = new CurrencyConverter();
		double amount = currencyConverter.convertCurrency("PHP", "USD", 1000);
		System.out.println(amount);
		amount = currencyConverter.convertCurrency("USD", "PHP", 1000);
		System.out.println(amount);
	}

}
