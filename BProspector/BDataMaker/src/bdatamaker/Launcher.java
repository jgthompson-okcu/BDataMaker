/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatamaker;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher 
{
    public static final String DEFAULT_FILE_NAME = "g:\\mortgagedata.txt";
    public static final int DEFAULT_HOWMANY = 10000;
    public static final double DEFAULT_PERCENT = 0.05;
    public static boolean guiExitOnClose = false;
    public static void main(String[] args)
    {
	String choice = "";
	if (args.length > 0)
	{
	    guiExitOnClose = true;
	    choice = args[0];
	}
	
	outerloop:
	while (true)
	{
	    boolean appLaunched = false;
	    
	    ArrayList<String> log = new ArrayList<>();
	    String choices = "DM  DR  GM  GR  EX";
	    Scanner sc = new Scanner(System.in);
	    
	    String prompt =	"DM for datamaker, DR for datareader, \n"
		    +		"GM for GUI datamaker, GR for GUI data reader\n"
		    +		"EX to exit\n";
	    
	    if (choice.equals("") == true)
		choice = getChoice(sc, prompt, choices);

	    if (choice.equalsIgnoreCase("EX"))
	    {
		System.exit(0);
	    }
	    else if (choice.equalsIgnoreCase("GM"))
	    {
		launchGM();
		
		if (guiExitOnClose)
		    return;
		appLaunched = true;
	    }
	    else if (choice.equalsIgnoreCase("GR"))
	    {
		launchGR();
		if (guiExitOnClose)
		    return;
		appLaunched = true;
		
	    }
	    
	    if (appLaunched == false)
	    {

		System.out.printf("Enter filename, or type OK to accept default (%s) ",DEFAULT_FILE_NAME);
		String userSpecifiedFileName = sc.next();
		if (userSpecifiedFileName.equalsIgnoreCase("OK")== true)
		{
		    userSpecifiedFileName = DEFAULT_FILE_NAME;
		}

		if (choice.equalsIgnoreCase("DM"))
		{
		    String[] args3 = new String[3];
		    String msg =String.format("Enter number of records to make, or type OK to accept default (%d) ", 
			    DEFAULT_HOWMANY);
		    String userSpecifiedPercent = ""+DEFAULT_PERCENT;
		    args3[0] = userSpecifiedFileName;
		    int iUserSpecifiedNumberOfRecords = Utils.getSafeInt(msg, sc, DEFAULT_HOWMANY);
		    String userSpecifiedNumberOfRecords = "" + iUserSpecifiedNumberOfRecords;
		    args3[1] = userSpecifiedNumberOfRecords;
		    args3[2] = ""+userSpecifiedPercent;

		    log.addAll(BDataMaker.main2(args3));
		}
		else if (choice.equalsIgnoreCase("DR"))
		{
		    String[] args2 = new String[1];
		    args2[0] = userSpecifiedFileName;
		    BDataReader.main(args2);
		}
		else 
		{
		    System.out.printf("%s is not a recognized choice\n",choice);
		}

		for (String s : log)
		{
		    System.out.println("*** "+s);
		}
	    }
	    
	    appLaunched = false;
	    
	    choice = "";
	}
            
    } // end main

    public static void launchGR()
    {
	Thread GR; 
	GR = new Thread() 
	{
	    @Override
	    public void run() 
	    {
		try 
		{
		    DataReaderGUI.bExitOnClose = guiExitOnClose;
		    DataReaderGUI.main(null);
		    System.out.println("Launching GR app");
		    Thread.sleep(1);
		}
		catch(InterruptedException v)
		{
		}
	    }  
	};

	GR.start();
	try
	{
	    Thread.sleep(2000);
	} 
	catch (InterruptedException ex) 
	{
	}
	
    }
    public static void launchGM()
    {
	Thread GM; 
	GM = new Thread() 
	{
	    @Override
	    public void run() 
	    {
		try 
		{
		    DataMakerGUI.bExitOnClose = guiExitOnClose;
		    DataMakerGUI.main(null);
		    System.out.println("Launching GM app");
		    Thread.sleep(1);
		}
		catch(InterruptedException v)
		{
		}
	    }  
	};

	GM.start();
	try
	{
	    Thread.sleep(2000);
	} 
	catch (InterruptedException ex) 
	{
	}
	
    }
    
    public static String getChoice(Scanner sc, String choices) {
	String choice = "";
	getchoiceloop:
	while (true)
	{
	    System.out.println(	"DM for datamaker, DR for datareader, \n"
		    +		"GM for GUI datamaker, GR for GUI data reader\n"
		    +		"EX to exit\n");
	    
	    choice = sc.next().toUpperCase();
	    boolean ok1 = choice.length() == 2;
	    boolean ok2 = (choices.contains(choice) == true);
	    if ( ok1 && ok2 )
	    {
		break getchoiceloop;
	    }
	    System.out.printf("Choice %s not recognized\n", choice);
	}
	return choice;
    }
        
    public static String getChoice(Scanner sc, String prompt, String choices) {
	String choice = "";
	getchoiceloop:
	while (true)
	{
	    System.out.println( prompt	);
	    
	    choice = sc.next().toUpperCase();
	    boolean ok1 = choice.length() == 2;
	    boolean ok2 = (choices.contains(choice) == true);
	    if ( ok1 && ok2 )
	    {
		break getchoiceloop;
	    }
	    System.out.printf("Choice %s not recognized\n", choice);
	}
	return choice;
    }
    
} // end class
