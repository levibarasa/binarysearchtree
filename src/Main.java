import project5.Wearable;
import project5.WearableManager;
public class Main {
    
    public static void main(String[] args) { //generateCsv(int[] positions, String filename)
        WearableManager wearableManager = new WearableManager(); 
           System.out.println(wearableManager.getWearableAtIndex(10).getCoNamePosition());
           System.out.println(wearableManager.getWearableAtIndex(10).getPricePosition());
           System.out.println(wearableManager.getWearableAtIndex(10).getRankingPosition());

           int[] positions = { 10 }; 
          wearableManager.generateCsv(positions,"datacsv");
           
    }
}
