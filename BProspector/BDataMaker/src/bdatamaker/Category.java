package bdatamaker;

import java.util.ArrayList;

public class Category
{
    String[][] saData;
    String categoryName;
    String firstLetter;
    ArrayList<Triple> triples = new ArrayList<>();
    
    Triple get(int n)
    {
	if (n >= 0 && n< triples.size())
	{
	    return triples.get(n);
	}
	return null;
    }
    Category(String[][] array)
    {
	saData = array;
	

	for (int x = 0; x < array.length; x++)
	{
	    String[] sa = array[x];
	    if (x == 0)
	    {
		categoryName = sa[0];
		firstLetter = sa[1];
	    }
	    else
	    {
		Triple t = new Triple(sa);
		triples.add(t);
	    }
	}
	
	assignPercents();
    }
    
    int whichRandom(double percent)
    {
	double percs = 0;
	int x = 0;
	for (int i = 0; i < triples.size(); i++)
	{
	    Triple t = triples.get(i);
	    percs += t.percentLikely;
	    if (percent < percs)
		return x;
	    x++;
	}
	return -1;
    }
    
    int countDivisors()
    {
	int divs = 0;
	for (Triple t: triples)
	{
	    divs += t.getDivs();
	}
	return divs;
    }
    
    void assignPercents()
    {
	if (triples.isEmpty())
	{
	    System.out.println("Can't work with an empty array of categories");
	}
	double p = 1.00 / countDivisors();
	int x = 0;
	for (Triple triple: triples)
	{
	    int divs = triple.getDivs();
	    double percent = p * divs;
	    triple.setPerc(percent);
	    triples.set(x++, triple);
	}
    }
    
    @Override
    public String toString()
    {
	String s = "";
	for (Triple t: triples)
	{
	    s+= String.format("%-15s %10s %3s %5.3f\n",t.getS1(), t.getS2(), t.getS3(), t.getPerc());
	}
	return s;
    }
    
}

