package bdatamaker;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

final class SessionIdentifierGenerator 
{
  private final SecureRandom random = new SecureRandom();

  public String nextSessionId() {
    return new BigInteger(130, random).toString(32);
  }
}







public class BDataMaker 
{
    
    

    static SessionIdentifierGenerator sig = new SessionIdentifierGenerator();
    
    static int isInt(String s)
    {
	int r = 0;
	try
	{
	    r = Integer.parseInt(s);
	}
	catch (Exception ex)
	{
	    r = 0;
	}
	return r;
    }
    
    public static void main(String[] args) 
    {
	
	String[][] childrenSA = {
		    {"Number of children","C", ""},
		    {"0  Children",     "C0",  ""},
		    {"1  Child",        "C1",  ""},
		    {"2  Children",     "C2",  ""},
		    {"3  Children",     "C3",  "+"},
		    {"4+ Children",     "C4",  "+"}
	};	

	Category childCat = new Category(childrenSA);
	{
	    System.out.println(childCat);	    
	    double rnd = Math.random();
	    int x = childCat.whichRandom(rnd);
	    String cat = childCat.get(x).getS2();
	    System.out.printf("%.2f = %s\n",rnd, cat);
	}
	
	String[][] ageSA = {
		{"Age range", "A", ""},
		{"18-25", "A0", "",  },
		{"26-35", "A1", "+", },
		{"36-45", "A2", "++" },
		{"46-55", "A3", "+"  },
		{"56-65", "A4", ""   },
		{"66+",   "A5", ""   }	
	    };
	
	Category ageCat = new Category(ageSA);
	
	{
	    double rnd = Math.random();
	    int x = ageCat.whichRandom(rnd);
	    String age = ageCat.get(x).getS2();
	    System.out.println(ageCat);
	    System.out.printf("%.2f = %s\n",rnd, age);
	}

	String[][] dateMovedSA = {
	    {"DATE MOVED",       "M",  ""  },
	    {"This year",        "M0", "+" },
	    {"Last 1 year",      "M1", ""  },
	    {"Last 2 years",     "M2", ""  },
	    {"Last 3 years",     "M3", ""  },
	    {"Last 4 years",     "M4", ""  },
	    };
	
	Category dateMovedCat = new Category(dateMovedSA);
	System.out.println(dateMovedCat);



	String[][] incomeCatSA ={
	    {"INCOME","I",""},
	    {"<30000",           "I0",  ""},
	    {"30000 < 40000",    "I1",  ""},
	    {"40000 < 50000",    "I2",  "+"},
	    {"50000 < 60000",    "I3",  "++"},
	    {"60000 < 70000",    "I4",  "+"},
	    {"70000 <100000",    "I5",  ""},
	    {"100001+",          "I6",  ""}
	    };
	
	Category incomeCat = new Category(incomeCatSA);
	System.out.println(incomeCat);
	
	int specials = 0;
	int recordsToMake = 1;
	System.out.println(childCat);

	
	for (int x = 0; x < recordsToMake; x++)
	{
	    int specialness = 1;
	    String s = sig.nextSessionId();
	    System.out.print(s);
	    int max = s.length()-4;
	    String s2 = s.substring(max, max+3);
	    int i = isInt(s2);
	    if (isInt(s2) > 0)
	    {
		specials ++;
		specialness += i;
		System.out.print(" Special ");
	    }
	    System.out.println();
	}
	System.out.printf("Specials = %f \n",100.0 * specials / recordsToMake );
    }
}
