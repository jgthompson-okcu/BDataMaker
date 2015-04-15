package bdatamaker;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class BDataMaker 
{
    

    

    
    /////////////////////////////////////////////////////////////////
    public static ArrayList<String> main2(String[] args) 
    {
        
        // retrieve our data tables -- categories to place
        // each record into
	
        ArrayList<String> log = new ArrayList<>();
	
	String filename = Launcher.DEFAULT_FILE_NAME;
	int recordsToMake = Launcher.DEFAULT_HOWMANY;	
	Double percent = Launcher.DEFAULT_PERCENT;
	
	if (args.length > 0)
	{
	    filename = args[0];
	}
	if (args.length > 1)
	{
	    recordsToMake = (int) Utils.parseLongSafely(args[1]);
	    if (recordsToMake < 1)
	    {
		
		System.out.println("Invalid number of records specified");
		log.add("Invalid number of records specified");
		return log;
	    }
	}
	
	if (args.length > 2)
	{
	    percent = Utils.parseDoubleSafely(args[2]);
	    if (percent <= 0)
	    {
		log.add("Invalid number of records specified"+percent);
		System.out.println("Invalid percent specified: "+percent);
		return log;
	    }
	}
	
	log.addAll( main3(filename, recordsToMake, percent) );
	return log;
    }
    
    /////////////////////////////////////////////////////////////////
    public static ArrayList<String> main3(String filename, int recordsToMake, double percentMortgaged)
    {

        ArrayList<String> log = new ArrayList<>();
	Categories categories = new Categories();
        boolean ok = categories.readFromDataFiles();
        
        System.out.println(categories);
	log.add(categories.toString());
        
        // this is our arraylist of records that we will write out
        // to a file.
        
        ArrayList<MortgageTuple> recordsList = new ArrayList<>();
        
	ArrayList<MortgageTuple> mortgageList = new ArrayList<>();
        
        
	System.out.println("Generating random data records");
	log.add("Generating random data records");
        
        // generate specified number of random records
	// categories are defined evenly, unless the record
	// is marked as a mortgage-bought record.
	
	for (int counter = 0; counter < recordsToMake; counter++) 
        {
	    
	    if (counter > 0 && counter % 50000 == 0)
	    {
		System.out.println(counter + " random records created");
		log.add(counter + " random records created");
	    } else {
	    }
            
            MortgageTuple mt; 
	    
            mt = categories.makeRandomTuples_EvenDistribution();
	    
            double p = percentMortgaged; // categories.getTotalPercentageForTuple(mt);
            
            if (Math.random() < p)
            {
		// regenerate our records, using probabilities 
		// defined in our data files so that some categories
		// are shown as having mortgaged more often than others

		mt = categories.makeRandomTuples_UnevenDistribution();     // true = evenly distributed
		mt.setMortgageBought("B1");
		mortgageList.add(mt);
		recordsList.add(mt);
		
            }
	    else
	    {
		mt.setMortgageBought("B0");
		recordsList.add(mt);
	    }
	    
            
        }
        
        double average = 100.0 * mortgageList.size() / recordsList.size(); 
       
	String dbg = String.format("%d marked as mortgaged, %d total, Average mortgaged = %.8f", 
                mortgageList.size(), recordsList.size(), average);
	System.out.print(dbg);
	log.add(dbg);
	

	
        saveToFile(filename, recordsList);
	return log;
    }

    /////////////////////////////////////////////////////////////////
    public static void saveToFile(String filename, ArrayList<MortgageTuple> recordsList) 
    {
	System.out.printf("Saving %d records to file %s\n", recordsList.size(), filename );
        // let'userSpecifiedFileName save our results to a file.
        
	PrintWriter pwFile1 = null;
        try 
        {
            FileWriter fl = new FileWriter(filename, false); // don't append
            BufferedWriter br = new BufferedWriter(fl);
            pwFile1 = new PrintWriter(br) ;      
            // write the string beginning from the 3rd char until the 8th
            for (MortgageTuple mt: recordsList)
            {
                pwFile1.println(mt.getCSV());
            }
            System.out.println("File created successfully");
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















//    public static void main(String[] args) {
//	
//	
//	main0(args);
	
//	else
//	{
//	    String[] sa = {"A1","B2", "C3", "D4", "E5"};
//	    ArrayList<String> results = PowerSet.makePowerSet(sa);
//
//	    ASet2 aset = new ASet2();
//
//	    for (String s : results)
//	    {
//		aset.add(s);
//	    }
//
//	    for (String s : results) {
//		aset.add(s);
//	    }
//
//	    System.out.println(aset);
//	}
//    }
//    
    /////////////////////////////////////////////////////////////////
