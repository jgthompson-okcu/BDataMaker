/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatamaker;

import static bdatamaker.BDataMaker.DEFAULT_FILE_NAME;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




public class BDataReader {
    static Scanner sc = new Scanner(System.in);
    static void main(String[] args)
    {
    
	BufferedReader reader = null;


	String filename = DEFAULT_FILE_NAME;
	
	if (args.length > 0)
	{
	    filename = args[0];
	}
	
	String fullPathFileName;
	fullPathFileName = getFullPath( filename );
	
	System.out.println("reading category data");
	Categories categories = new Categories();
        boolean ok = categories.readFromDataFiles();

	ArrayList<MortgageTuple> mortgageDataList = new ArrayList<>();
	
	long records = 0;
	records += readMortgageDataFromFile(filename, mortgageDataList);
	System.out.printf("%d records read from %s\n", records, fullPathFileName);

	ArrayList<MortgageTuple> filteredMortgageDataList = new ArrayList<>();
	ArrayList<MortgageTuple> filteredUnmortgageDataList = new ArrayList<>();
	
	for (int x = 0; x < mortgageDataList.size(); x++)
	{
	    MortgageTuple mt = mortgageDataList.get(x);
	    if (mt.getiMortgageBought() == 1)
	    {
		filteredMortgageDataList.add(mt);
	    }
	    else
	    {
		filteredUnmortgageDataList.add(mt);
	    }
	}
	
	System.out.printf("Mortaged = %d, Unmortgaged = %d, Total = %d\n",
		filteredMortgageDataList.size(), 
		filteredUnmortgageDataList.size(),
		mortgageDataList.size()		
		);
		
	ASet2 aset = addRecordsToASet(filteredMortgageDataList);
	
//	for (MortgageTuple mt : filteredMortgageDataList)
//	{
//	    System.out.println(mt.toStringShort());
//	}
	
	double threshhold = 0.00;
	while (threshhold >= 0.00)
	{
	    System.out.println("Filter out records below what percent certainty?");
	    String thresh = sc.next();
	    threshhold = Utils.parseDoubleSafely(thresh);
	    if (threshhold >= 0)
	    {
		System.out.println(aset.toString(threshhold));
	    }
	}
	
	
    } //////////////////////////////// end main ///////////////////////   

    public static ASet2 addRecordsToASet(ArrayList<MortgageTuple> mortgageDataList) {
	ASet2 aset = new ASet2();
	aset.add(mortgageDataList);
	return aset;
    }
    
    public static String getFullPath(String filename)
    {
	java.io.File f = new java.io.File( filename );
	return f.getAbsolutePath();
	
    }

    public static int readMortgageDataFromFile(String filename, 
						    ArrayList<MortgageTuple> mortgageDataList
						    ) 
    {
	BufferedReader reader = null;
	try
	{
	    System.out.println("Reading from: " + getFullPath( filename ));
	    reader = new BufferedReader(new FileReader( filename ) );

	    String in = "";
	    
	    
	    for (int counter = 0; in != null; counter++)
	    {
		in = reader.readLine();
		if (in != null)
		{
		    String[] tk = in.split(",");
		    MortgageTuple mt = new MortgageTuple(tk); // new record
		    mortgageDataList.add(mt);
		    
		    if (counter % 10000 == 0 && counter != 0)
		    {
			System.out.println(counter + " tuples read");
		    }
		    
		    
		} // end if
	    } // end while
	} // end try // end try
	catch (FileNotFoundException ex) 
	{
	    System.err.printf("File not found: %s\n", filename);
	    Logger.getLogger(BDataReader.class.getName()).log(Level.SEVERE, null, ex);
	}
	catch (IOException ex) 
	{
	    Logger.getLogger(BDataReader.class.getName()).log(Level.SEVERE, null, ex);
	}
	finally 
	{
	    try
	    {
		if (reader != null) reader.close();
	    }
	    catch (IOException ex)
	    {
		// no need to report error
		// Logger.getLogger(BDataReader.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return mortgageDataList.size();
    }
    

    public static void printStringArray(String[] tk) {
	for (String t : tk)
	{
	    System.out.printf("[%s]",t);

	} // end for
	System.out.println();

    }
}
