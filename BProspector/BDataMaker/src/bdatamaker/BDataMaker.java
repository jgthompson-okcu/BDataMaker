package bdatamaker;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class BDataMaker 
{
    
    public static void main(String[] args) {
        
        // retrieve our data tables -- categories to place
        // each record into
        
        Categories categories = new Categories();
        boolean ok = categories.readFromDataFiles();
        
        System.out.println(categories);
        
        // this is our arraylist of records that we will write out
        // to a file.
        
        ArrayList<MortgageTuple> tuples = new ArrayList<>();
        
        // generate 100 tuples, selecting each category in
        // the object randomly.
        
        int recordsToMake = 5;
        for (int counter = 0; counter < recordsToMake; counter++) 
        {
            
            MortgageTuple mt = new MortgageTuple(); // new record
            mt = categories.makeRandomTuples();     // randomly assign categories
            tuples.add(mt);                         // add it to our list
            // System.out.println(mt);
            double[] percentages = categories.getProbabilitiesList(mt);
            double percentForMortgage = 1;
            for (double d: percentages)
            {
                percentForMortgage *= d;
                // System.out.printf("%6.2f ", d);
            }
            System.out.printf(" equals %.6f\n", percentForMortgage);
            
        }
        
        // let's print out our list.  Comment this out
        // later.
        
        for (MortgageTuple mt: tuples)
        {
            System.out.println(mt);
        }
    }
}
