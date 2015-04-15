package bdatamaker;
/**
 * CategoryLineItem = values read from file.
 * 
 * this class contains four members, s1, s2, s3, and percentLikely
 * 
 * s1, s2, s3 contain three values read from a file
 * s1 represents category label
 * s2 represents category number (abbreviation)
 * s3 represents chances it will be chosen randomly
 * 
 * percentLikely contains the fractional chance that this
 * category will be chosen randomly when generating
 * random data
 * 
 * percentLikely is filled in by the Category.assignPercents method.
 *
 * @author Jeff
 */

public class CategoryLineItem
{
    final private String s1, s2, s3;
    public double percentLikely;
    
    public String toString()
    {
        String s = "";
        s+= String.format("%-15s %10s %3s %5.3f%%", getS1(), getS2(), getS3(), getPercentLikely()*100);
        return s;
    }
    
    public CategoryLineItem(String[] sa)
    {
	s1 = sa[0];
	s2 = sa[1];
	s3 = sa[2];
    }
    
    public CategoryLineItem(String s1, String s2, String s3)
    {
	this.s1 = s1;
	this.s2 = s2;
	this.s3 = s3;
    }
    
    public static CategoryLineItem make(String s1, String s2, String s3)
    {
	CategoryLineItem t = new CategoryLineItem(s1, s2, s3);
	return t;
    }
    
    public static CategoryLineItem make(String[] sa)
    {
	CategoryLineItem t = new CategoryLineItem(sa);
	return t;
    }

    public String getS1() {
	return s1;
    }

    public String getS2() {
	return s2;
    }

    public String getS3() {
	return s3;
    }

    public double getPercentLikely() {
	return percentLikely;
    }
    
    public void setPercentLikely(double d) 
    {
	this.percentLikely = d;
    }

    int getChancesOld() 
    {
	
	int chances = 1; // every category at least gets one chance
        
        // if there is more than once + sign in the
        // chances field (s3), then this item has additional
        // likelihood of being randomly chosen
        
        int extraChances = this.getS3().length();
	if ( extraChances > 1)
	{
	    chances += extraChances;
	}
	return chances;
    } // end getChances

    int getChances() 
    {
	
        int chances = this.getS3().length();
	return chances;
    } // end getChances

    public String toString2() {
        String s = "";
        s+= String.format("%-6s %-15s", getS2(), getS1());
        return s;
    }
    
    
} // end class
