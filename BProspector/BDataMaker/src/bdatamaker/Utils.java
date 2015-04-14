package bdatamaker;



import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class Utils {

    static SessionIdentifierGenerator sig = new SessionIdentifierGenerator();

    

    public static int getIntFromCategory(String s) {

        // retrieves the numeric value indicating an element
        // in a category table.
        //
        // s is a string of at least two characters in length
        //
        // the first character is an alphabet letter indicating
        // a category (A-Z)
        //
        // followup characters are digits .. 0..n
        //
        // this method skips the first character and returns
        // the numeric value of the digits contained in the string
        // past the first character

        int ret = 0;
        try 
        {
            String s2 = s.substring(1);
            ret = parseIntSafely(s2);
        } 
        catch (Exception ex) 
        {
            System.err.printf("getIntFromCategory Error: %s\n", ex.getMessage());
            System.err.printf("Could not convert category '%s' to numeric value\n", s);
        }
        return ret;
    }

    public static BigInteger parseBigIntSafely(String s) {
        BigInteger r;
        try {
            r = new BigInteger(s, 32);
        } catch (Exception ex) {
            System.err.printf("Could not convert '%s' to numeric value\n", s);
            r = new BigInteger("0");
        }
        return r;
    }

    public static long parseLongSafely(String s) {
        long r;
        try {
            r = Long.parseLong(s);
        } catch (Exception ex) {
            System.err.printf("Could not convert '%s' to numeric value\n", s);
            r = 0;
        }
        return r;
    }
    
    public static int getSafeInt(String msg, Scanner sc, int defaultInt)
    {
	int r;
	String s;
	while (true)
	{

	    System.out.println(msg);
	    s = sc.next();
	    if (s.equalsIgnoreCase("OK"))
	    {
		r = defaultInt;
		break;
	    }
	    try 
	    {
		r = Integer.parseInt(s);
		break;
	    }
	    catch (Exception ex) 
	    {
		System.out.printf("%s is not a valid integer",s);
	    }
	} // end while
	return r;
    }

    public static int parseIntSafely(String s) {
        int r;
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

    static Double parseDoubleSafely(String s) {
        Double r;
        try 
	{
            r = Double.parseDouble(s);
        }
	catch (Exception ex) 
	{
            r = new Double(0f);
        }
        return r;
    }
    
    
    
    public double addTuplePercents(MortgageTuple mt)
    {
	double d = 0;

	int which = (int) mt.getiAge();




	return d;

    }
}

final class SessionIdentifierGenerator {
    
    // the ids we select are generated randomly.  They are
    // lengthy to prevent duplicates.
    
    private final SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}