package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Amount {

    @JsonProperty("actual")
    private double actual;


    @JsonProperty("lent")
    private double lent;


    @JsonProperty("maxLevel")
    private double maxLevel;


    @JsonProperty("ordered")
    private double ordered;

    @JsonProperty("reorderLevel")
    private double reorderLevel;

    public Amount() {
    }

    public double getActual() {
        return actual;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }

    public double getLent() {
        return lent;
    }

    public void setLent(double lent) {
        this.lent = lent;
    }

    public double getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(double maxLevel) {
        this.maxLevel = maxLevel;
    }

    public double getOrdered() {
        return ordered;
    }

    public void setOrdered(double ordered) {
        this.ordered = ordered;
    }

    public double getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(double reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
}
