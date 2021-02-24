package project5;
//new
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import java.util.*;

public class WearableManager {

    List<Wearable> wearable;
    Index<Integer> rankingIndex;
    Index<Double> priceIndex;
    Index<String> companyNameIndex;
    String bodyLocation;
    String category;
    Company company;
    private static ArrayList list = new ArrayList<>();

    public WearableManager() {
        this.list = getDataList(); 
        this.company = new Company();
    }

    public Wearable getWearableAtIndex(int index) {
        return new Wearable(this.rankingIndex.get(index), this.getCompanyNamePositionData().getClass().getName(), Double.valueOf(this.getPricePositionData().getClass().getName()), bodyLocation, "", this.company);
    }

    public Integer[] getRankingPositionData() {
        return getRankingPositionData();
    }

    public Integer[] getPricePositionData() {
        return getPricePositionData();
    }

    public Integer[] getCompanyNamePositionData() {
        return getCompanyNamePositionData();
    }

    public boolean geterateCsv(Integer[] positions, String fileName) {
        return geterateCsv(positions, fileName);
    }

    public void readFileAndFill() {
        ArrayList data =  this.getDataList();
        System.out.println(this.getDataList());
    }

    public static ArrayList getDataList() {
        ArrayList arr = new ArrayList();
        File pr = new File();
        String uploadFilepath = pr.getDBProperty().getProperty("data.file");
        String line;
        try {
            FileInputStream fs = new FileInputStream(uploadFilepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String[] split;
            String root = br.readLine();
            br.readLine();
            // arr.add(root);
            while ((line = br.readLine()) != null) {
                split = line.split("\\@");
                ArrayList one = new ArrayList<>();
                one.add(split[0]); //ranking
                one.add(split[2]); //price
                one.add(split[5]); //company name
                arr.add(one);
            }
            fs.close();
            br.close();
        } catch (Exception asd) {
            asd.getMessage();
        }
        return arr;
    }

    @Override
    public String toString() {
        return "WearableManager{" + "wearable=" + wearable + ", rankingIndex=" + rankingIndex + ", priceIndex=" + priceIndex + ", companyNameIndex=" + companyNameIndex + '}';
    }
    public boolean generateCsv(Integer [] positions, String filename) {
        boolean generated = false;
        CSVWriter writer;
        try {
            writer = new CSVWriter(new FileWriter(filename));
            for (int i : positions) {
                String companyName = getWearablesAtIndex(i).getName();
                String price = Double.toString(getWearablesAtIndex(i).getPrice());
                int ranking = getWearablesAtIndex(i).getRanking();
                String line1[] = {ranking + ",", ranking + ",", ranking + ""};
                //Writing data to the csv file
                writer.writeNext(line1);
                generated = true;
                //Flushing data from writer to file
                writer.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(WearableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generated;
    }

    public static int[] getCoNamesPositionData() {
        int[] pos = null;
        TreeMap< String, Integer> ht = getCompanyName(list);
        for (int i = 0; i < ht.size(); i++) {
            pos = (int[]) new Vector(ht.keySet()).get(i);
        }
        return pos;
    }

    public static int[] getPricesPositionData() {
        int[] pos = null;
        TreeMap< String, Integer> ht = getPrice(list);
        for (int i = 0; i < ht.size(); i++) {
            pos = (int[]) new Vector(ht.keySet()).get(i);
        }
        return pos;
    }

    public static int[] getRankingsPositionData() {
        int[] pos = null;
        TreeMap< String, Integer> ht = getRanking(list);
        for (int i = 0; i < ht.size(); i++) {
            pos = (int[]) new Vector(ht.keySet()).get(i);
        }
        return pos;
    }

     

    public static TreeMap< String, Integer> getCompanyName(ArrayList list) {
        TreeMap< String, Integer> ht = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList items = (ArrayList) list.get(i);
            String ranking = (String) items.get(2);
            ht.put(ranking, i);
        }
        return ht;
    }

    public static TreeMap< String, Integer> getRanking(ArrayList list) {
        TreeMap< String, Integer> ht = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList items = (ArrayList) list.get(i);
            String ranking = (String) items.get(0);
            ht.put(ranking, i);
        }
        return ht;
    }

    public static TreeMap< String, Integer> getPrice(ArrayList list) {
        TreeMap< String, Integer> ht = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList items = (ArrayList) list.get(i);
            String ranking = (String) items.get(1);
            ht.put(ranking, i);
        }
        return ht;
    }
    public Wearable getWearablesAtIndex(int index) {
        TreeMap< String, Integer> ranking = getRanking(list);// 
        TreeMap< String, Integer> price = getPrice(list);
        TreeMap< String, Integer> coName = getCompanyName(list);
        System.out.println();
        Wearable wr = new Wearable(Integer.parseInt(new Vector(ranking.values()).get(index).toString()), Double.valueOf(new Vector(price.values()).get(index).toString()), new Vector(coName.values()).get(index).toString());
        return wr;
    }

}
