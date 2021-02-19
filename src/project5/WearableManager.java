package project5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.io.FileWriter;
import com.opencsv.CSVWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WearableManager {

    private static ArrayList list = new ArrayList<>();

    public WearableManager() {
        this.list = getDataList();
        System.out.println(getDataList());
    }
 
    public boolean generateCsv(int[] positions, String filename) {
        boolean generated = false;
        CSVWriter writer;
        try {
            writer = new CSVWriter(new FileWriter(filename));
            for (int i : positions) {
                String companyName = getWearableAtIndex(i).getCoNamePosition();
                String price = Double.toString(getWearableAtIndex(i).getPricePosition());
                int ranking = getWearableAtIndex(i).getRankingPosition();
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

    public static int[] getCoNamePositionData() {
        int[] pos = null;
        TreeMap< String, Integer> ht = getCompanyName(list);
        for (int i = 0; i < ht.size(); i++) {
            pos = (int[]) new Vector(ht.keySet()).get(i);
        }
        return pos;
    }

    public static int[] getPricePositionData() {
        int[] pos = null;
        TreeMap< String, Integer> ht = getPrice(list);
        for (int i = 0; i < ht.size(); i++) {
            pos = (int[]) new Vector(ht.keySet()).get(i);
        }
        return pos;
    }

    public static int[] getRankingPositionData() {
        int[] pos = null;
        TreeMap< String, Integer> ht = getRanking(list);
        for (int i = 0; i < ht.size(); i++) {
            pos = (int[]) new Vector(ht.keySet()).get(i);
        }
        return pos;
    }

    public Wearable getWearableAtIndex(int index) {
        TreeMap< String, Integer> ranking = getRanking(list);// 
        TreeMap< String, Integer> price = getPrice(list);
        TreeMap< String, Integer> coName = getCompanyName(list);
        System.out.println();
        Wearable wr = new Wearable(Integer.parseInt(new Vector(ranking.values()).get(index).toString()), Double.valueOf(new Vector(price.values()).get(index).toString()), new Vector(coName.values()).get(index).toString());
        return wr;
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

}
