import java.io.File;
import java.util.ArrayList;

public class WineTesting {

        private ArrayList<Wine> WineTestingObjects = new ArrayList<>(); //Stores all the testWines instances

    public WineTesting(){}

    /**
     * Creates wine objects by calling a parser and adds it to a list.
     */
    public void createWineObjects(File file) {

            Parser parser = new Parser(file);
            WineTestingObjects = parser.readFile();

        }


    public ArrayList<Wine> getWineTestingObjects() {
        return WineTestingObjects;
    }

}
