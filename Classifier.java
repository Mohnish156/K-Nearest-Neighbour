import java.io.File;
import java.util.*;

public class Classifier {

    private static String TestingFile;
    private static String TrainingFile;

    private static int k = 1; //CHANGE THIS VALUE

    private double [] Ranges = new double[14]; //Array that contains the range of all features in the training set


    public Classifier(String wineTraining, String wineTesting, int kNumber) {
        TrainingFile = wineTraining;
        TestingFile = wineTesting;
        k = kNumber;
    } //Constructor

    public static void main(String[] args) {


        TrainingFile = (args[0]);
        TestingFile = (args[1]);


        Classifier c = new Classifier(args[0],args[1],k);
        c.k_Nearest_Neigh(k);
    }

    /**
     * Runs the algorithm that checks each test wine against the closest training wines
     * Finds the majority class of nearest neighbours and keeps that record.
     * @param k - The number of nearest neighbours to find
     */
    public void k_Nearest_Neigh(int k){

        WineTraining trainSet = new WineTraining();
        WineTesting testSet = new WineTesting();

        File TrainFile = new File(TrainingFile);
        File TestFile = new File(TestingFile);

        trainSet.createWineObjects(TrainFile);
        testSet.createWineObjects(TestFile);

        for(int i = 0;i <13; i++){ //Initialises Ranges
            Ranges[i] = trainSet.getRange(i);
        }

        double wrongA = 0;
        double wrongB = 0;
        double wrongC = 0;

        double correctA = 0;
        double correctB = 0;
        double correctC = 0;

        double totalCorrect = 0;

        for(Wine testObject : testSet.getWineTestingObjects()){ //Going through each test wine


            ArrayList<Wine> closest = new ArrayList<>(); // Closest Neighbours
            ArrayList<Double> distances = new ArrayList<>(); // All distances to from Test wine to training wines
            HashMap<Double,Wine> Map = new HashMap<>(); // Assigns distance to each training wine

            for(Wine trainObject : trainSet.getWineTrainingObjects()){
                double dist = 0;
                dist = findDist(testObject,trainObject); // Finds distance of from test wine to training wine
                Map.put(dist,trainObject);
                distances.add(dist);
            }

            Collections.sort(distances); //Sorts distances in ascending order
            for(int i = 0; i<k ;i++){ //Adds the closest neighbours based on k-value
                closest.add(Map.get(distances.get(i)));

            }

            double A = 0;
            double B = 0;
            double C = 0;

            double majorityClass = 0; ////Keeps track of majority class

            for(Wine closestWines : closest){ //Finds class of the closest wines
                if(closestWines.get_Class()==1) A++;
                if(closestWines.get_Class()==2) B++;
                if(closestWines.get_Class()==3) C++;

            }

            //Calculates the majority class
            if(A>B & A>C) majorityClass = 1;
            if(B>A & B>C) majorityClass = 2;
            if(C>A & C>B) majorityClass = 3;


            //Splits the accuracy of classifier between classes, so can show how accurate individual classes are
            if(testObject.get_Class() == majorityClass) {
                if (majorityClass == 1) {
                    correctA++;
                    System.out.println("Class Label: "+ testObject.get_Class() + " Predicted Correct: " + 1);
                }
                if (majorityClass == 2) {
                    correctB++;
                    System.out.println("Class Label: "+ testObject.get_Class() + " Predicted Correct: " + 2);
                }
                if (majorityClass == 3) {
                    correctC++;
                    System.out.println("Class Label: "+ testObject.get_Class() + " Predicted Correct: " + 3);
                }
                totalCorrect++;


            }else if(testObject.get_Class() == 1){
                wrongA++;
                System.out.println("Class Label: "+ testObject.get_Class() + " Predicted Wrong: " + 1);
            }else if(testObject.get_Class() == 2){
                wrongB++;
                System.out.println("Class Label: "+ testObject.get_Class() + " Predicted Wrong: " + 2);
            }else if (testObject.get_Class() == 3){
                wrongC++;
                System.out.println("Class Label: "+ testObject.get_Class() + " Predicted Wrong: " + 3);

            }
        }

        //Prints out accuracy values of each class and the overall accuracy
        System.out.println("Accuracy of class 1 = " + (correctA/(correctA+wrongA)) * 100);
        System.out.println("Accuracy of class 2 = "+ (correctB/(correctB+wrongB)) * 100);
        System.out.println("Accuracy of class 3 = "+ (correctC/(correctC+wrongC)) * 100);

        System.out.println("Accuracy Overall = "+(totalCorrect/testSet.getWineTestingObjects().size()) * 100);

    }

    /**
     * Finds the distance between two instance by implementing Euclidean distance and taking into account all features.
     * @param wineTest is the unseen instance and the one that is being tested against a training set
     * @param wineTrain is the known instance being used to classify and unseen instance
     * @return
     */
    public double findDist(Wine wineTest, Wine wineTrain){

        double sum = 0; //Total

        for(int i =0; i<13; i++){ //Going through each wine feature. E.g. Alcohol, Ash etc.

            double feature1 = wineTest.featureVals[i];
            double feature2 = wineTrain.featureVals[i];
            double range = Ranges[i];

           sum += Math.pow(feature1-feature2,2)/Math.pow(range,2); //Euclidean distance formula

       }

        sum = Math.sqrt(sum);
        return sum;


    }






}




