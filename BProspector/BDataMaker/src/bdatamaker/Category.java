package bdatamaker;

import java.util.ArrayList;

public class Category
{
    String[][] saData;
    String categoryName;
    String firstLetter;
    ArrayList<CategoryLineItem> categoryLineItems = new ArrayList<>();
    
    CategoryLineItem get(int n)
    {
	if (n >= 0 && n< categoryLineItems.size())
	{
	    return categoryLineItems.get(n);
	}
        else
        {
            System.err.printf("Error: Category.get(%d) - no such category\n",n);
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
		CategoryLineItem t = new CategoryLineItem(sa);
		categoryLineItems.add(t);
	    }
	}
	
	assignPercents();
    }
    
    int whichChance(double percent)
    {
	double percs = 0;
	int x = 0;
	for (int i = 0; i < categoryLineItems.size(); i++)
	{
	    CategoryLineItem t = categoryLineItems.get(i);
	    percs += t.percentLikely;
	    if (percent < percs)
		return x;
	    x++;
	}
	return -1;
    }
    
    int countTotalCategoryChances()
    {
	int chances = 0;
	for (CategoryLineItem t: categoryLineItems)
	{
	    chances += t.getChances();
	}
	return chances;
    }
    
    void assignPercents()
    {
	if (categoryLineItems.isEmpty())
	{
	    System.out.println("Can't work with an empty array of categories");
	}
	double p = 1.00 / countTotalCategoryChances();
	int x = 0;
	for (CategoryLineItem categoryLineItem: categoryLineItems)
	{
	    int chances = categoryLineItem.getChances();
	    double percent = p * chances;
	    categoryLineItem.setPercentLikely(percent);
	    categoryLineItems.set(x++, categoryLineItem);
	}
    }
    
    @Override
    public String toString()
    {
	String s = "";
	for (CategoryLineItem t: categoryLineItems)
	{
	    s+= String.format("%s\n", t);
	}
	return s;
    }

    String toString2() 
    {
	String s = "";
	for (CategoryLineItem t: categoryLineItems)
	{
	    s+= String.format("%s\n", t.toString2());
	}
	return s;
    }
    
}

