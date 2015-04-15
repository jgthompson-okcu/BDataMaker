/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatamaker;

import java.util.ArrayList;

/**
 *
 * @author Jeff
 */

class A
{
    String item;
    int count;
    
    public A(String item)
    {
	this.item = item;
	this.count = 1;
    }
    
    public boolean equals(String item2)
    {
	return item.equals(item2);
    }
    
    public boolean incrementIfMatch(String item2)
    {
	if (equals(item2))
	{
	    count++;
	    return true;
	}
	return false;
    }
    
    
    
}
public class ASet 
{
    ArrayList<A> aset = new ArrayList<>();
    
    public void add(String s)
    {
	boolean match = false;
	for (int x = 0; x < aset.size(); x ++)
	{
	    A a = aset.get(x);
	     match = a.incrementIfMatch(s);
	    if (match)
		break;
	    
	}
	if (!match)
	{
	    aset.add( new A(s) );
	}
    }
    
    @Override
    public String toString()
    {
	String r = "{ ";
	for (A a : aset)
	{
	    r += String.format("(%s:%d) ", a.item, a.count);
	}
	r+= "}";
	return r;
	
    }
    
    
}
