package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockList {

    private String idArtikel;

    @JsonProperty("results")
    private List<Stock> results;

    public StockList(){
    }

    public String getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(String idArtikel) {
        this.idArtikel = idArtikel;
    }

    public List<Stock> getResults() {
        return results;
    }

    public void setResults(List<Stock> results) {
        this.results = results;
    }
}
