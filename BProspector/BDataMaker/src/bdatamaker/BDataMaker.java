package bdatamaker;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


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
        
        ArrayList<MortgageTuple> recordsList = new ArrayList<>();
        ArrayList<Integer> mortgageList = new ArrayList<>();
        
        // generate 100 recordsList, selecting each category in
        // the object randomly.
        
        int recordsToMake = 10000;
        for (int counter = 0; counter < recordsToMake; counter++) 
        {
            
            MortgageTuple mt = new MortgageTuple(); // new record
            mt = categories.makeRandomTuples();     // randomly assign categories
            recordsList.add(mt);                         // add it to our list
            // System.out.println(mt);

            double p = categories.getTotalPercentageForTuple(mt);
            
            
            if (Math.random() < p)
            {
                
                mortgageList.add(counter);
            }
            System.out.printf(" percentage to be mortgage = equals %.6f\n",  
                    p);
            
        }
        
        // let's print out our list.  Comment this out
        // later.
        
        for (MortgageTuple mt: recordsList)
        {
            // System.out.println(mt);
        }
        
        for (int index : mortgageList)
        {
            System.out.println(recordsList.get(index));
        }
        
        // now print out the percentage of records generated
        // that were marked as mortgaged
        
        double average = 100.0 * mortgageList.size() / recordsList.size(); 
        System.out.printf("%d mortgaged, %d total, Average mortgaged = %.8f\n", 
                mortgageList.size(), recordsList.size(), average);
        
        String filename = "mortgagedata.txt";
        
        saveToFile(filename, recordsList);
    }

    public static void saveToFile(String filename, ArrayList<MortgageTuple> recordsList) 
    {
        // let's save our results to a file.
        PrintWriter pwFile1 = null;
        try 
        {
            FileWriter fl = new FileWriter(filename, true);
            BufferedWriter br = new BufferedWriter(fl);
            pwFile1 = new PrintWriter(br) ;      
            // write the string beginning from the 3rd char until the 8th
            for (MortgageTuple mt: recordsList)
            {
                pwFile1.println(mt.getCSV());
            }
            System.out.println("Add new lines to the file successfully");
        }
        catch(FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        catch(SecurityException e) 
        {
            e.printStackTrace();
        }
        catch (IOException e) 
        {
            // for FileWriter
            e.printStackTrace();
        }
        finally 
        {
            // no matter what happen, close the output stream
            if(pwFile1 != null){
                pwFile1.close();
            }
        }
    }

    
}
