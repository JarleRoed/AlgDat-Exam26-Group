package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/// //////////////////////////////////////////////////////////////////////////////////////
/// Sources:
/// Oracle. (2024). Scanner (Java Platform SE 8). Retrieved April 16, 2026, from https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
/// Oracle. (2024). ArrayList (Java Platform SE 8). Retrieved April 16, 2026, from https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
/// //////////////////////////////////////////////////////////////////////////////////////

public class DataLoader {
    //Defining the DELIMITER
    private static final String COMMA_DELIMITER = ";";

    //Create a arrayList for the comma separated files (CSV).
    //Outer function (Used to read the whole file).
    // 1. For red wine.
    public static List<List<Double>> loadWineContentRed() {
        List<List<Double>> wineContentRed = new ArrayList<>();

        //Scanning the whole file for red wine:
        try (Scanner fileScanner = new Scanner(new java.io.File("resources/winequality-red.csv"))) {
            if(fileScanner.hasNextLine()) {
                //Skipping the header row.
                fileScanner.nextLine();
            }

            while(fileScanner.hasNextLine()) {
                wineContentRed.add(getWineContentRedFromLine(fileScanner.nextLine()));
            }
        }
        catch(Exception e) {
            e.printStackTrace(); //Prints information about what went wrong.
        }

        return wineContentRed;
    }

        //Inner helper: Line by line into list of doubles
        private static List<Double> getWineContentRedFromLine(String line){
            //values red is created as an empty Arraylist:
            List<Double> valuesRed = new ArrayList<>();

            //Scans line by line to clean into new array list values
            try (Scanner lineScannerRed = new Scanner(line)) {
                lineScannerRed.useDelimiter(COMMA_DELIMITER);

                while (lineScannerRed.hasNext()) {
                    valuesRed.add(Double.parseDouble(lineScannerRed.next().trim()));
                }
            }
            return valuesRed;
        }

    //Outer function 2 (Used to read the whole file).
    // 2. For white wine.
    public static List<List<Double>> loadWineContentWhite() {
        List<List<Double>> wineContentWhite = new ArrayList<>();

        //Scanning the whole file for white wine:
        try (Scanner fileScanner = new Scanner(new java.io.File("resources/winequality-white.csv"))) {
            if(fileScanner.hasNextLine()) {
                //Skipping the header row.
                fileScanner.nextLine();
            }

            while(fileScanner.hasNextLine()) {
                wineContentWhite.add(getWineContentWhiteFromLine(fileScanner.nextLine()));
            }
        }
        catch (Exception e){
            e.printStackTrace(); //Prints information about what went wrong.
        }

        return wineContentWhite;
    }


    //Inner helper: Line by line into list of doubles
    private static List<Double> getWineContentWhiteFromLine(String line){
        List<Double> valuesWhite = new ArrayList<>();

        //Scans line by line to clean into new array list values
        try (Scanner lineScannerWhite = new Scanner(line)) {
            lineScannerWhite.useDelimiter(COMMA_DELIMITER);

            while (lineScannerWhite.hasNext()) {
                valuesWhite.add(Double.parseDouble(lineScannerWhite.next().trim()));
            }
        }
        return valuesWhite;
    }

}