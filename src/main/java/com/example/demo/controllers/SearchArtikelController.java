package com.example.demo.controllers;

import Model.StockList;
import com.example.demo.Services.KoronaCloudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "")
public class SearchArtikelController {

    @Autowired
    KoronaCloudServices koronaCloudServices = null;

    @GetMapping(value = "/accounts/{koronaAccountId}/products")
    public ResponseEntity<?> getArtikelByParameters(@RequestHeader("Authorization") String auth,
                                                @PathVariable String koronaAccountId,
                                                @RequestParam(required=false) String number,
                                                  @RequestParam(required=false) String commodityGroup,
                                                     @RequestParam(required=false) String productCodes,
                                                  @RequestParam(required=false) String assortment) {

        Map<String,String> parameters = new HashMap<String,String>();
        if (!(number == null)) parameters.put("number",number);
        if (!(commodityGroup == null)) parameters.put("commodityGroup",commodityGroup);
        if (!(assortment == null)) parameters.put("assortment",assortment);
        if (!(productCodes == null)) parameters.put("productCodes",productCodes);

        try {
            return new ResponseEntity<String>(String.valueOf(koronaCloudServices.getArtikelByParameters(koronaAccountId,auth,parameters)), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/accounts/{koronaAccountId}/productStocks")
    public ResponseEntity<?> getStocksByWarehouses(@RequestHeader("Authorization") String auth,
                                                    @PathVariable String koronaAccountId,
                                                    @RequestParam(required=false) String number,
                                                    @RequestParam(required=false) String commodityGroup,
                                                    @RequestParam(required=false) String productCodes,
                                                    @RequestParam(required=false) String assortment) {

        Map<String,String> parameters = new HashMap<String,String>();
        if (!(number == null)) parameters.put("number",number);
        if (!(commodityGroup == null)) parameters.put("commodityGroup",commodityGroup);
        if (!(assortment == null)) parameters.put("assortment",assortment);
        if (!(productCodes == null)) parameters.put("productCodes",productCodes);

        try {
            return new ResponseEntity<List<StockList>>(koronaCloudServices.getStockPerWarehouse(koronaAccountId,auth,parameters), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}