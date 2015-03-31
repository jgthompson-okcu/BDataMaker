/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatamaker;

/**
 *
 * @author jgthompson
 */
public class DataFiles 
{
    private String[][] childrenSA = {{"Number of children", "C", ""}, {"0  Children", "C0", ""}, {"1  Child", "C1", ""}, {"2  Children", "C2", ""}, {"3  Children", "C3", "+"}, {"4+ Children", "C4", "+"}};
    private String[][] ageSA = {{"Age range", "A", ""}, {"18-25", "A0", ""}, {"26-35", "A1", "+"}, {"36-45", "A2", "++"}, {"46-55", "A3", "+"}, {"56-65", "A4", ""}, {"66+", "A5", ""}};
    private String[][] dateMovedSA = {{"DATE MOVED", "M", ""}, {"This year", "M0", "+"}, {"Last 1 year", "M1", ""}, {"Last 2 years", "M2", ""}, {"Last 3 years", "M3", ""}, {"Last 4 years", "M4", ""}};
    private String[][] incomeCatSA = {{"INCOME", "I", ""}, {"<30000", "I0", ""}, {"30000 < 40000", "I1", ""}, {"40000 < 50000", "I2", "+"}, {"50000 < 60000", "I3", "++"}, {"60000 < 70000", "I4", "+"}, {"70000 <100000", "I5", ""}, {"100001+", "I6", ""}};

    boolean read() {
        System.err.println("DataFiles.read() -- Reading from data files not implemented yet");
        System.err.println("DataFiles.read() -- Using default values");
        return true;

    }

    /**
     * @return the childrenSA
     */
    public String[][] getChildrenSA() {
        return childrenSA;
    }

    /**
     * @param childrenSA the childrenSA to set
     */
    public void setChildrenSA(String[][] childrenSA) {
        this.childrenSA = childrenSA;
    }

    /**
     * @return the ageSA
     */
    public String[][] getAgeSA() {
        return ageSA;
    }

    /**
     * @param ageSA the ageSA to set
     */
    public void setAgeSA(String[][] ageSA) {
        this.ageSA = ageSA;
    }

    /**
     * @return the dateMovedSA
     */
    public String[][] getDateMovedSA() {
        return dateMovedSA;
    }

    /**
     * @param dateMovedSA the dateMovedSA to set
     */
    public void setDateMovedSA(String[][] dateMovedSA) {
        this.dateMovedSA = dateMovedSA;
    }

    /**
     * @return the incomeCatSA
     */
    public String[][] getIncomeCatSA() {
        return incomeCatSA;
    }

    /**
     * @param incomeCatSA the incomeCatSA to set
     */
    public void setIncomeCatSA(String[][] incomeCatSA) {
        this.incomeCatSA = incomeCatSA;
    }
    
}
