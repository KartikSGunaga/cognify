import netscape.javascript.JSObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.*;

public class CurrencyConverter {
    private final String baseCurrency, targetCurrency, key;

    public CurrencyConverter(String key, String baseCurrency, String targetCurrency){
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.key = key;
    }

    public double fetchCurrencyValue(double amount) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        String url = "https://v6.exchangerate-api.com/v6/"
                + this.key + "/pair/" + this.baseCurrency + "/"
                + this.baseCurrency + "/"+ amount;

        URI uri = new URI(url);

        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200){
            JSONObject obj = new JSONObject(response.body());

            double rate = obj.getJSONObject("");
        }

    }
}
