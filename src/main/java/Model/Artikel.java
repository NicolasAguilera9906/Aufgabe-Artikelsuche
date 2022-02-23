package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artikel {

    @JsonProperty("id")
    private String id;

    public Artikel(){
    }

    public String getIdProduct() {
        return id;
    }

    public void setIdProduct(String idProduct) {
        this.id = id;
    }


}
