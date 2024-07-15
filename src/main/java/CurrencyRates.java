package main.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class CurrencyRates {
    private final String apiUrl = "https://v6.exchangerate-api.com/v6/24cd2d8cc2710d8f4f21406b/latest/USD";
    private final Map<String, Double> rates = new HashMap<>();

    public void fetchRates() {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            JSONObject json = new JSONObject(content.toString());
            JSONObject conversionRates = json.getJSONObject("conversion_rates");
            for (String key : conversionRates.keySet()) {
                rates.put(key, conversionRates.getDouble(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getRate(String currencyCode) {
        return rates.getOrDefault(currencyCode, 0.0);
    }

    public void displayCurrencies() {
        System.out.println("Monedas disponibles:");
        for (String currency : rates.keySet()) {
            System.out.println(currency);
        }
    }
}
