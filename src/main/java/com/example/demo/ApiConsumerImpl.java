package com.example.demo;

import Model.Artikel;
import Model.ArtikelList;
import Model.StockList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class ApiConsumerImpl implements ApiConsumer {

    private String url;



    public ApiConsumerImpl() {
        url = "https://128.koronacloud.com/web/api/v3";
    }


    @Override
    public List<String> getProductsByParameters(String accountId, String auth, Map<String, String> parameters) throws Exception {
        List<String> idArtikelList =  new ArrayList<>();
        String parametersPath = "?";
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            parametersPath += entry.getKey() + "=" + entry.getValue() + "&";
        }
        parametersPath =  parametersPath.substring(0, parametersPath.length() - 1);
        String urlString = url + "/accounts/" + accountId + "/products" + parametersPath;
        String response = getConnectionResponse(urlString,auth);
        ObjectMapper objectMapper = new ObjectMapper();
        ArtikelList artikelList = objectMapper.readValue(response, ArtikelList.class);
        for(Artikel artikel : artikelList.getResults()){
            idArtikelList.add(artikel.getIdProduct());
        }
        if(idArtikelList.size() == 0){
            throw new Exception("No content");
        }
        return idArtikelList;
    }

    @Override
    public List<StockList> getStockPerWarehouse(String accountId, String auth, List<String> artikelList) throws Exception {
        List<StockList> stocksList = new ArrayList<>();
        for(String artikelId : artikelList){
            String urlString = url + "/accounts/" + accountId + "/products/" + artikelId + "/stocks";
            String response = getConnectionResponse(urlString,auth);
            if(response!=null) {
                ObjectMapper objectMapper = new ObjectMapper();
                StockList stockList = objectMapper.readValue(response, StockList.class);
                stockList.setIdArtikel(artikelId);
                stocksList.add(stockList);
            }
        }
        if(stocksList.size() == 0){
            throw new Exception("No content");
        }
        return stocksList;
    }

    private String getConnectionResponse(String urlString, String auth) throws Exception{
        URL obj = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty ("Authorization", auth);
        con.setRequestMethod("GET");
        StringBuffer response = null;
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        }
        if(response!=null) {
            return response.toString();
        }
        return null;
    }
}
