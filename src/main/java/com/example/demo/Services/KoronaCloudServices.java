package com.example.demo.Services;

import Model.StockList;

import java.util.List;
import java.util.Map;

public interface KoronaCloudServices {

    List<StockList> getStockPerWarehouse(String accountId, String auth, Map<String, String> parameters) throws Exception;

    public List<String> getArtikelByParameters(String AccountId, String auth, Map<String,String> parameters) throws Exception;

}
