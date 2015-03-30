/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatamaker;

/**
 *
 * @author Jeff
 */
public class Triple
{
    final private String s1, s2, s3;
    public double percentLikely;
    
    public Triple(String[] sa)
    {
	s1 = sa[0];
	s2 = sa[1];
	s3 = sa[2];
    }
    
    public Triple(String s1, String s2, String s3)
    {
	this.s1 = s1;
	this.s2 = s2;
	this.s3 = s3;
    }
    
    public static Triple make(String s1, String s2, String s3)
    {
	Triple t = new Triple(s1, s2, s3);
	return t;
    }
    
    public static Triple make(String[] sa)
    {
	Triple t = new Triple(sa);
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

    public double getPerc() {
	return percentLikely;
    }
    
    public void setPerc(double d) 
    {
	this.percentLikely = d;
    }

    int getDivs() {
	int divs = 1;
	if (this.getS3().length() > 0)
	{
	    divs += this.getS3().length();
	}
	return divs;
    }
    

    
}
