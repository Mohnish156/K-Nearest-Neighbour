import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

   private File parseFile;  //File to be parsed
   private double wineValues[];
   private ArrayList<Wine> wineObject = new ArrayList<>(); //Stores wine objects

    public Parser(File file){
        parseFile = file;
    }

    /**
     * Uses a scanner to parse through a file, in order to attain all the features and assigns them to the object.
     * @return ArrayList of wine objects
     */
    public ArrayList<Wine> readFile(){

        try {
            Scanner scan = new Scanner(parseFile);
            scan.nextLine(); //Skips Headings
            while(scan.hasNextLine()){
                Wine wine = new Wine();

                wine.setAlcohol(scan.nextDouble());
                wine.setMalic_acid(scan.nextDouble());
                wine.setAsh(scan.nextDouble());
                wine.setAlcalinity_of_ash(scan.nextDouble());
                wine.setMagnesium(scan.nextDouble());
                wine.setTotal_phenols(scan.nextDouble());
                wine.setFlavanoids(scan.nextDouble());
                wine.setNonflavanoid_phenols(scan.nextDouble());
                wine.setProanthocyanins(scan.nextDouble());
                wine.setColor_intensity(scan.nextDouble());
                wine.setHue(scan.nextDouble());
                wine.setOD280OD315_of_diluted_wines(scan.nextDouble());
                wine.setProline(scan.nextDouble());
                wine.setClass(scan.nextDouble());

                wineObject.add(wine);
                    scan.nextLine();
            }
            scan.close();

        }catch (Exception e){
            e.printStackTrace();
        };
    return wineObject;
    }
}
