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

	String[][] ageSA = {
		{"Age range", "A", ""},
		{"18-25", "A0", "",  },
		{"26-35", "A1", "+", },
		{"36-45", "A2", "++" },
		{"46-55", "A3", "+"  },
		{"56-65", "A4", ""   },
		{"66+",   "A5", ""   }	
	    };
	

	String[][] dateMovedSA = {
	    {"DATE MOVED",       "M",  ""  },
	    {"This year",        "M0", "+" },
	    {"Last 1 year",      "M1", ""  },
	    {"Last 2 years",     "M2", ""  },
	    {"Last 3 years",     "M3", ""  },
	    {"Last 4 years",     "M4", ""  },
	    };
	



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
	
	
	Category childCat = new Category(childrenSA);
        Category ageCat = new Category(ageSA);
        Category dateMovedCat = new Category(dateMovedSA);
	Category incomeCat = new Category(incomeCatSA);
        
        // int specials = 0;
	int recordsToMake = 1;
	
	for (int counter = 0; counter < recordsToMake; counter++)
	{
	    int specialness = 1;
	    String id = sig.nextSessionId();
	    System.out.print(id);
	    //int max = s.length()-4;
	    // String s2 = s.substring(max, max+3);
	    //int i = isInt(s2);
	    //if (isInt(s2) > 0)
	    //{
		// specials ++;
		// specialness += i;
		// System.out.print(" Special ");
	    //}
            
            MortgageTuple mt = new MortgageTuple();
            mt.setId(id);
            {
                System.out.println(childCat);	    
                double rnd = Math.random();
                int x = childCat.whichRandom(rnd);
                String cat = childCat.get(x).getS2();
                System.out.printf("%.2f = %s\n",rnd, cat);
                mt.setChildren(cat);
            }
            {
                double rnd = Math.random();
                int x = ageCat.whichRandom(rnd);
                String age = ageCat.get(x).getS2();
                System.out.printf("%.2f = %s\n",rnd, age);
                System.out.println(age);
                mt.setAge(age);
                
            }
            
            
            
            
            
	    System.out.println();
	}
	System.out.printf("Specials = %f \n",100.0 * specials / recordsToMake );
    }
}
