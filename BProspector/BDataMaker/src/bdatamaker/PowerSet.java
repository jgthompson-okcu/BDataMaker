package bdatamaker;

import java.util.ArrayDeque;
import java.util.ArrayList;




// Powerset set.
class StringSet 
{
    final ArrayList<String> names = new ArrayList<>();

    void adjoin(String a) {
        names.add(a);
    }
    
    public ArrayList<String> get()
    {
	ArrayList<String> sa = new ArrayList<>();
	sa.add(this.toString());
	return sa;
    }

    @Override
    public String toString() 
    {
	int n = names.size();
        StringBuilder sb = new StringBuilder();
        sb.append(""+ n+",");
	int x = 1;
        for (String name : names) {
            sb.append(name);
	    if (x++ < n)
		sb.append(",");
        }
        sb.append("");
        return sb.toString();
    }
}

// Make power sets.

public class PowerSet 
{
    

    // Stack for intermediate results.
    final ArrayDeque<String> stack = new ArrayDeque<>();

    // Source data.
    ArrayList<String> src;

    // Powerset under construction
    ArrayList<StringSet> dst;

    // Recursive powerset calculator
    private void recur(int i) {
        if (i >= src.size()) {
            // Stack is complete. If more than 1 element,
            // add its contents to the result.
            if (stack.size() > 0) 
	    {
                StringSet set = new StringSet();
                for (String a : stack) set.adjoin(a);
                dst.add(set);
            }
        }
        else {
            // Otherwise recur both without and with this element
            // added to the stack.  Clean up the stack before return.
            recur(i + 1);
            stack.offerLast(src.get(i));
            recur(i + 1);
            stack.pollLast();
        }
    }

    // Get a powerset for the givens source data.
    ArrayList<StringSet> getPowerSet(ArrayList<String> src) {
        this.src = src;
        this.dst = new ArrayList<>();
        recur(0);
        return dst;
    }

    public ArrayList<String> AListPowerSet(ArrayList<String> data) 
    {
        ArrayList<String> r = new ArrayList<>();
	for (StringSet set : getPowerSet(data)) 
	{
	    r.addAll(set.get());
        }
	return r;
    }

    public static ArrayList<String> makePowerSet(String[] sa)
    {
	ArrayList<String> data = new ArrayList<>();
	for (String s : sa)
	{
	    if (s != null)
		data.add(s);
	}
	PowerSet ps = new PowerSet();
	return ps.AListPowerSet(data);
    }

}
