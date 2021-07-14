import java.io.File;
import java.util.ArrayList;

public class WineTraining {

    private ArrayList<Wine> WineTrainingObjects = new ArrayList<>(); //List of wine training object


    public WineTraining(){}

    /**
     * Constructor to create wine objects
     */
    public void createWineObjects(File file) {

        Parser parser = new Parser(file);
        WineTrainingObjects = parser.readFile();

        }

    /**
     * Obtains all the range values for each feature
     * @param featureIndex - used to get the range for a particular feature
     * @return returns the range
     */
    public double getRange(int featureIndex) {
        ArrayList<Double> vals = new ArrayList<>();

        for (Wine w : getWineTrainingObjects()) {
            vals.add(w.featureVals[featureIndex]);

        }
        return findRange(vals);
    }

    /**
     * Finds the highest value and the lowest value, subtracts them and returns the answer
     * @param vals
     * @return
     */
    public double findRange(ArrayList<Double> vals){

        double range = 0;

        double High = 0;

        for(int i = 0 ;i< vals.size(); i++){
            if(vals.get(i) > High)
                High = vals.get(i);
        }

        double Low = 9999999;

        for(int i = 0 ;i<vals.size();i++){
            if(vals.get(i) < Low)
                Low = vals.get(i);
        }

        range = High - Low;
        return range;


    }

    public ArrayList<Wine> getWineTrainingObjects() {
        return WineTrainingObjects;
    }


}






