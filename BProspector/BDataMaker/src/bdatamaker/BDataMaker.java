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
        boolean ok = categories.read();
        
        // this is our arraylist of records that we will write out
        // to a file.
        
        ArrayList<MortgageTuple> tuples = new ArrayList<>();
        
        // generate 100 tuples, selecting each category in
        // the object randomly.
        
        int recordsToMake = 100;
        for (int counter = 0; counter < recordsToMake; counter++) 
        {
            
            MortgageTuple mt = new MortgageTuple(); // new record
            Categories.assignRandomCategories(           // randomly assign categories
                                mt); 
            tuples.add(mt);                         // add it to our list
        }
        
        // let's print out our list.  Comment this out
        // later.
        
        for (MortgageTuple mt: tuples)
        {
            System.out.println(mt);
        }
    }
}
