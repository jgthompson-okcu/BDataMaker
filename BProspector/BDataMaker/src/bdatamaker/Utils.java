package bdatamaker;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Utils {

    static SessionIdentifierGenerator sig = new SessionIdentifierGenerator();

    
    public static String getRandomCategory(Category category) {
        // based on the data in a category table, this method picks
        // one of the elements of the table randomly and returns the index
        // value of the element.
        String s;
        double rnd = Math.random();
        int x = category.whichRandom(rnd);
        s = category.get(x).getS2();
        System.out.printf("%.2f = %s\n", rnd, s);
        System.out.println(s);
        return s;
    }

    
    public static void fillInRandomValuesForCategoris(
            
        // using data from the category tables,
        // this method fills in the members of of a mortgage record by 
        // randomly picking from the categories for each member.
        // 
        // currently fills in the members 
        //
        //      ID, 
        //      children, 
        //      age, 
        //      dateMoved
            
        MortgageTuple mt,
        CategoryData categoryDataTables) {
        String s;

        String id = sig.nextSessionId();
        mt.setId(id);

        s = getRandomCategory(categoryDataTables.childCat);
        mt.setChildren(s);

        s = getRandomCategory(categoryDataTables.ageCat);
        mt.setAge(s);

        s = getRandomCategory(categoryDataTables.dateMovedCat);
        mt.setDatemoved(s);

        s = getRandomCategory(categoryDataTables.incomeCat);
        mt.setIncome(s);
    }

    public static long getLongFromCategory(String s) {

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

        long ret = 0;
        try 
        {
            String s2 = s.substring(1);
            ret = parseLongSafely(s2);
        } 
        catch (Exception ex) 
        {
            System.err.printf("getLongFromCategory Error: %s\n", ex.getMessage());
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

    public static int parseIntSafely(String s) {
        int r;
        try {
            r = Integer.parseInt(s);
        } catch (Exception ex) {
            r = 0;
        }
        return r;
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