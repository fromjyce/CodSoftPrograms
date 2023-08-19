
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;
import java.net.http.*;
import java.net.*;
import java.io.*;


public class CurrencyConverter {
    HttpClient client = HttpClient.newHttpClient();
    String apiKey = "YOUR_API_KEY";
    JSONParser parser = new JSONParser();
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        CurrencyConverter curcoun = new CurrencyConverter();
        System.out.println("Welcome to Real Time Currency Converter!!");
        int choice = 0;
        while (choice != 3) {
        System.out.print("Do you want to \n1. See the list of currencies with their country names \n2. Convert the Currencies \n3. Exit \nEnter your choice: ");
        choice = curcoun.scan.nextInt();
        curcoun.scan.nextLine();
        switch(choice) {
            case 1:
                curcoun.list_countries();
            case 2:
                double currency = curcoun.ask_amount();
                String fromcur = curcoun.ask_from_currency();
                String tocur = curcoun.ask_to_currency();
                curcoun.ConvertionCurrency(fromcur, tocur, currency);
        }
        }
        if (choice ==3) {
            System.out.println("Exiting....");
            System.exit(0);
        }
    }

    void list_countries() throws IOException, InterruptedException, ParseException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.apilayer.com/exchangerates_data/symbols"))
                .header("apikey", apiKey)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            String responseBody = response.body();
            
            
            JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
            JSONObject symbolsObject = (JSONObject) jsonObject.get("symbols");
            int count = 1;
            for (Object key : symbolsObject.keySet()) {
                String symbol = (String) key;
                String countryName = (String) symbolsObject.get(key);
                System.out.println(count + ". " + symbol + ": " + countryName);
                count++;
            
            }
        }
     else {
            System.out.println("API request failed with status code: " + response.statusCode());
        }
    }

    double ask_amount() {
        System.out.print("Enter the amount you want to convert: ");
        double amount = scan.nextInt();
        scan.nextLine();
        return amount;


    }

    String ask_from_currency() {
        System.out.print("Enter the \"from\" Currency: ");
        String from = scan.nextLine();
        return from.toUpperCase();
    }

    String ask_to_currency() {
        System.out.print("Enter the \"to\" Currency: ");
        String to = scan.nextLine();
        return to.toUpperCase();
    }

    void ConvertionCurrency(String from, String to, double amount) throws IOException, InterruptedException, ParseException {
        String uri = "https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount;
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("apikey", apiKey)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
            Double currencyValue = (Double) jsonObject.get("result");
            System.out.println("Currency Value: " + currencyValue);
        }
     else {
            System.out.println("API request failed with status code: " + response.statusCode());
        }
    }
}
