package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtikelList {

    @JsonProperty("results")
    private List<Artikel> results;

    public ArtikelList(){
    }

    public List<Artikel> getResults() {
        return results;
    }

    public void setResults(List<Artikel> results) {
        this.results = results;
    }
}
