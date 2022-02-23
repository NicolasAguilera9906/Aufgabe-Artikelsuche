package com.example.demo.Services;

import Model.StockList;
import com.example.demo.ApiConsumerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KoronaCloudServicesImpl implements KoronaCloudServices {

    private String userCredentials = "demo2016:demo2016";

    @Autowired
    ApiConsumerImpl apiConsumer;

    @Override
    public List<StockList> getStockPerWarehouse(String accountId, String auth, Map<String, String> parameters) throws Exception {
        try{
            List<String> artikelList = getArtikelByParameters(accountId,auth,parameters);
            List<StockList> stocksList = apiConsumer.getStockPerWarehouse(accountId,auth,artikelList);
            return stocksList;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Override
    public List<String> getArtikelByParameters(String accountId, String auth, Map<String, String> parameters) throws Exception {
        List<String> stock = apiConsumer.getProductsByParameters(accountId,auth,parameters);
        return stock;
    }

}
