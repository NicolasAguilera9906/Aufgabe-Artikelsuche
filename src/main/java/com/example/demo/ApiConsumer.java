package com.example.demo;


import Model.StockList;

import java.util.List;
import java.util.Map;

public interface ApiConsumer {

    public List<String> getProductsByParameters(String accountId, String auth, Map<String, String> parameters) throws Exception;

    public List<StockList> getStockPerWarehouse(String accountId, String auth, List<String> artikelList) throws Exception;

}