
package project5;

public class Wearable {
    private int rankingPosition;
    private Double pricePosition;
    private String coNamePosition; 

    public Wearable(int rankingPosition, Double pricePosition, String coNamePosition) {
        this.rankingPosition = rankingPosition;
        this.pricePosition = pricePosition;
        this.coNamePosition = coNamePosition;
    }

    public int getRankingPosition() {
        return rankingPosition;
    }

    public void setRankingPosition(int rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public Double getPricePosition() {
        return pricePosition;
    }

    public void setPricePosition(Double pricePosition) {
        this.pricePosition = pricePosition;
    }

    public String getCoNamePosition() {
        return coNamePosition;
    }

    public void setCoNamePosition(String coNamePosition) {
        this.coNamePosition = coNamePosition;
    }
    
}
