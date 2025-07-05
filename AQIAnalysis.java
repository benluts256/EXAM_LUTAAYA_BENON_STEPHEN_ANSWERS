/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gui.arraylist;

/**
 *
 * @author LUTS
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AQIAnalysis {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> aqiReadings = new ArrayList<>();

        System.out.println("Generating 30 AQI readings (1-300):");
        for (int i = 0; i < 30; i++) {
            int aqi = random.nextInt(300) + 1; 
            aqiReadings.add(aqi);
            System.out.print(aqi + " ");
            if ((i + 1) % 10 == 0) { 
                System.out.println();
            }
        }
        System.out.println("\n------------------------------------");

        Collections.sort(aqiReadings);
        System.out.println("Sorted AQI Readings: " + aqiReadings);

        double median;
        int size = aqiReadings.size();
        if (size % 2 == 1) { 
            median = aqiReadings.get(size / 2);
        } else { 
            int mid1 = aqiReadings.get(size / 2 - 1);
            int mid2 = aqiReadings.get(size / 2);
            median = (double) (mid1 + mid2) / 2;
        }
        System.out.println("Median AQI Value: " + median);

      
        int hazardousDaysCount = 0;
        List<Integer> hazardousReadings = new ArrayList<>();
        System.out.print("Hazardous Days (AQI >= 200): ");
        for (int aqi : aqiReadings) {
            if (aqi >= 200) {
                hazardousDaysCount++;
                hazardousReadings.add(aqi);
            }
        }
        if (hazardousReadings.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.println(hazardousReadings);
        }

        System.out.println("Number of Hazardous Days: " + hazardousDaysCount);
    }
}
