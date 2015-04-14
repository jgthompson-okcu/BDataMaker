/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatamaker;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Jeff
 */


public class ASet2 
{
    TreeMap<String, Integer> map = new TreeMap<>();
    int itemCount = 0;
    

    public int treeMap_getTotalCount()
    {
	int count;
	count = itemCount;
	return count;
    }
    
    public void add(String key)
    {
	boolean match = false;
	
	if (map.containsKey(key))
	{
	    map.put(key, map.get(key) + 1);
	}
	else
	{
	    map.put(key, 1);
	}
    }
    
    
    public TreeMap<String, Double> getSubTree(double minimumPercent)
    {
	TreeMap<String, Double> subTree = new TreeMap<>();
	
	double count = this.treeMap_getTotalCount();
	int countAboveThreshhold = 0;
	for(Map.Entry<String, Integer> entry : map.entrySet())
	{
	    double certainty = 100.0 * entry.getValue() / count;
	    if (minimumPercent == 0.00 || certainty >= minimumPercent)
	    {
		subTree.put(entry.getKey(), certainty);
	    }
	}
	
	return subTree;
    }
    
    public String toString(double minimumPercent)
    {
	String s = "";
	double count = this.treeMap_getTotalCount();
	s += "Total records = "+count+"\n";
	int countAboveThreshhold = 0;
	
	TreeMap<String, Double> subTree;
	subTree = getSubTree(minimumPercent);
	
	for(Map.Entry<String, Double> entry : subTree.entrySet())
	{
	    countAboveThreshhold++;
	    s+= String.format("%-13s, %6.2f", 
		    entry.getKey(), 
		    entry.getValue()
		    );
	    s+= "\n";
	}
	if (minimumPercent > 0.00)
	{
	    s+= String.format("Keys above threshhold = %6.2f",100.00 * countAboveThreshhold/count);
	}
	return s;
	
    }

    @Override
    public String toString()
    {
	String s;
	s = this.toString(0);
	return s;
	
    }

    
    public ASet2 add(ArrayList<MortgageTuple> mortgageDataList) 
    {
	this.itemCount = 0;
	for (MortgageTuple m: mortgageDataList)
	{
	    this.itemCount ++;
	    String[] sa = new String[4];
	    int x = 0;
	    sa[x++] = m.getChildren();
	    sa[x++] = m.getAge();
	    sa[x++] = m.getIncome();
	    sa[x++] = m.getRelocationDate();
	    
	    ArrayList<String> results = PowerSet.makePowerSet(sa);
	    for (String s : results)
	    {
		this.add(s);
	    }

	}
	return this;
    }
}
