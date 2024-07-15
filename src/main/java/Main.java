package main.java;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyRates currencyRates = new CurrencyRates();
        currencyRates.fetchRates();
        
        while (true) {
            System.out.println("Seleccione la opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            int option = scanner.nextInt();

            if (option == 2) {
                System.out.println("Gracias por usar el convertidor de monedas.");
                break;
            } else if (option == 1) {
                currencyRates.displayCurrencies();
                System.out.print("Ingrese la moneda base: ");
                String fromCurrency = scanner.next().toUpperCase();
                System.out.print("Ingrese la moneda destino: ");
                String toCurrency = scanner.next().toUpperCase();
                System.out.print("Ingrese el monto a convertir: ");
                double amount = scanner.nextDouble();

                CurrencyConverter converter = new CurrencyConverter(currencyRates);
                double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                System.out.printf("Monto convertido: %.2f %s%n", convertedAmount, toCurrency);
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
