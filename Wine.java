import java.io.File;

public class Wine {

    public double Alcohol;
    public double Malic_acid;
    private double Ash;
    private double Alcalinity_of_ash;
    private double Magnesium;
    private double Total_phenols;
    private double Flavanoids;
    private double Nonflavanoid_phenols;
    private double Proanthocyanins;
    private double Color_intensity;
    private double Hue;
    private double OD280OD315_of_diluted_wines;
    private double Proline;
    private double Class;

    public double [] featureVals = new double[14];

    /**
     * Constructs wine object
     */
    public Wine(){}


    public void setAlcohol(double alcohol) {
        Alcohol = alcohol;
        featureVals[0] = alcohol;
    }

    public void setMalic_acid(double malic_acid) {
        Malic_acid = malic_acid;
        featureVals[1] = malic_acid;
    }

    public void setAsh(double ash) {
        Ash = ash;
        featureVals[2] = ash;
    }

    public void setAlcalinity_of_ash(double alcalinity_of_ash) {
        Alcalinity_of_ash = alcalinity_of_ash;
        featureVals[3] = alcalinity_of_ash;
    }

    public void setMagnesium(double magnesium) {
        Magnesium = magnesium;
        featureVals[4] = magnesium;
    }

    public void setTotal_phenols(double total_phenols) {
        Total_phenols = total_phenols;
        featureVals[5] = total_phenols;
    }

    public void setFlavanoids(double flavanoids) {
        Flavanoids = flavanoids;
        featureVals[6] = flavanoids;
    }

    public void setNonflavanoid_phenols(double nonflavanoid_phenols) {
        Nonflavanoid_phenols = nonflavanoid_phenols;
        featureVals[7] = nonflavanoid_phenols;
    }

    public void setProanthocyanins(double proanthocyanins) {
        Proanthocyanins = proanthocyanins;
        featureVals[8] = proanthocyanins;
    }

    public void setColor_intensity(double color_intensity) {
        Color_intensity = color_intensity;
        featureVals[9] = color_intensity;
    }

    public void setHue(double hue) {
        Hue = hue;
        featureVals[10] = hue;
    }

    public void setOD280OD315_of_diluted_wines(double OD280OD315_of_diluted_wines) {
        this.OD280OD315_of_diluted_wines = OD280OD315_of_diluted_wines;
        featureVals[11] = OD280OD315_of_diluted_wines;
    }

    public void setProline(double proline) {
        Proline = proline;
        featureVals[12] = proline;
    }

    public void setClass(double aClass) {
        Class = aClass;
        featureVals[13] = aClass;
    }



    public double get_Class() {
        return Class;
    }


}
