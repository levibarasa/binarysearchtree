import project5.Wearable;
import project5.WearableManager;
public class Main {
    
    public static void main(String[] args) {  
           WearableManager wm = new WearableManager();
           wm.readFileAndFill();
           Integer [] ranking = wm.getRankingPositionData();
           Integer [] name =wm.getCompanyNamePositionData();
           Integer [] price =wm.getPricePositionData();
           //wm.generateCsv(ranking, "Ranking.csv");
           //wm.generateCsv(name, "Name.csv");
           //wm.generateCsv(price, "Price.csv");
           
    }
}
