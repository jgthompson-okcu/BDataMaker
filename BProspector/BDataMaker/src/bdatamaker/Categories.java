package bdatamaker;

// this aggregates our collection of categories

import java.util.ArrayList;

// We have categories of data, like
//      categories for number of childen
//      categories for age ranges
//      categories for relocation date ranges
//      categories for income ranges
//
// This class encapsulates the tables (arrayLists) of
// categories
//
// it also has methods for assigning categories randomly
// to a record, assignRandomCategories
// relative likelyhood to be selected randomly when generating
// data.

public class Categories {
    
    final static Datafiles datafiles = new Datafiles();
    
    private  final  Category childCategories; 
    private  final  Category incomeCategories;
    private  final  Category ageCategories;
    private  final  Category relocationDateCategories;
    

    public String toString()
    {
        String s = "";
        s += String.format("childCategories\n%s\n",childCategories);
        s += String.format("incomeCategories\n%s\n",incomeCategories);
        s += String.format("ageCategories\n%s\n",ageCategories);
        s += String.format("relocationDateCategories\n%s\n",relocationDateCategories);
        return s;
    }
    public Categories()
    {

        
        childCategories = new Category(
            datafiles.getChildrenCategories());
        incomeCategories = new Category(
            datafiles.getIncomeCategories());
        ageCategories = new Category(
            datafiles.getAgeCategories());
       relocationDateCategories = new Category(
            datafiles.getRelocationCategories());
    }

    boolean readFromDataFiles() {
        return datafiles.read();
    }

    public  Category getChildCategories() {
        return childCategories;
    }

    public  Category getIncomeCategories() {
        return incomeCategories;
    }

    public  Category getAgeCategories() {
        return ageCategories;
    }

    public  Category getRelocationDateCategories() {
        return relocationDateCategories;
    }
    
    public int getRandomCategoryByEvenProbability(Category category) {
        
        // based on the data in a category table, this method picks
        // one of the elements of the table randomly and returns the index
        // value of the element.
        
        String s;
        double rnd = Math.random();
        int max = category.categoryLineItems.size();
        int x = (int)(Math.random() * max);
        s = category.get(x).getS2();
        return x;
    }    
    
    public int getRandomCategoryBySpecifiedProbabilities(Category category) {
        
        // based on the data in a category table, this method picks
        // one of the elements of the table randomly and returns the index
        // value of the element.
        
        String s;
        double rnd = Math.random();
        int x = category.whichChance(rnd);
        s = category.get(x).getS2();
        // System.out.printf("%.2f = %s\n", rnd, s);
        // System.out.println(s);
        return x;
    }

    public MortgageTuple makeRandomTuples_EvenDistribution()
                    
        // this method fills in the members of of a mortgage record by 
        // randomly picking from the categories for each member.
	//
	//    Distribution is even, rather than following probabilities
	//    defined in category files.
	//    
        // 
        // currently fills in the members 
        //
        //      id (with generateNewID)
        //      
        // and picks random categories for
        //    
        //      children
        //      age 
        //      relocationDate
        //      income
        //
            
    {
	
	
        String s;
        int c;

        MortgageTuple mt = new MortgageTuple();
        
        mt.generateNewID();                     
        
        Category category;
                
        category = childCategories;
        c = getRandomCategoryByEvenProbability( category );
        s = category.get(c).getS2();
        mt.setChildren(s);

        category = this.ageCategories;
        c = getRandomCategoryByEvenProbability( category );
        s = category.get(c).getS2();
        mt.setAge(s);

        category = this.relocationDateCategories;
        c = getRandomCategoryByEvenProbability( category );
        s = category.get(c).getS2();        
        mt.setRelocationDate(s);

        category = this.incomeCategories;
        c = getRandomCategoryByEvenProbability( category );
        s = category.get(c).getS2();
        mt.setIncome(s);
        
        return mt;
    }
    
    
    public MortgageTuple makeRandomTuples_UnevenDistribution()
                    
        // using data from the category tables,
        // this method fills in the members of of a mortgage record by 
        // randomly picking from the categories for each member.
        //
	//    Distribution is not even-- it follows the probabilities
	//    defined in category files.
	//    
        // currently fills in the members 
        //
        //      id (with generateNewID)
        //      
        // and picks random categories for
        //    
        //      children
        //      age 
        //      relocationDate
        //      income
        //
            
    {
	
        String s;
        int c;

        MortgageTuple mt = new MortgageTuple();
        
        mt.generateNewID();                     
        
        Category category;
                
        category = childCategories;
        c = getRandomCategoryBySpecifiedProbabilities( category );
        s = category.get(c).getS2();
        mt.setChildren(s);

        category = this.ageCategories;
        c = getRandomCategoryBySpecifiedProbabilities( category );
        s = category.get(c).getS2();
        mt.setAge(s);

        category = this.relocationDateCategories;
        c = getRandomCategoryBySpecifiedProbabilities( category );
        s = category.get(c).getS2();        
        mt.setRelocationDate(s);

        category = this.incomeCategories;
        c = getRandomCategoryBySpecifiedProbabilities( category );
        s = category.get(c).getS2();
        mt.setIncome(s);
        
        return mt;
    }
    
    public double[] getProbabilitiesList(MortgageTuple mt)
    {
        double[] list = new double[4];
        
        double p1, p2, p3, p4;
        
        int children = (int) mt.getiChildren();
        int age = (int) mt.getiAge();
        int income = (int) mt.getiIncome();
        int relocation = (int) mt.getiRelocationDate();

        p1 = getPercentage( "children",     children,   this.childCategories );
        p2 = getPercentage( "age",          age,        this.ageCategories );
        p3 = getPercentage( "income",       income,     this.incomeCategories );
        p4 = getPercentage( "relocation",   relocation, this.relocationDateCategories );
        
        int x = 0;
        
        list[x++] = p1;
        list[x++] = p2;
        list[x++] = p3;
        list[x++] = p4;
        
        return list;
    }
    

    public CategoryLineItem getLineItem(String swhich, int incCat, Category category) {
        CategoryLineItem cil;
        cil = category.get(incCat);
        if (cil == null)
        {
            System.err.printf("lineitem %d null in getLineItem for %s\n",
                    incCat, swhich);
        }

        return cil;
    }
    
    public double getPercentage(String swhich, int index, Category category) {
        double d = 0;
        CategoryLineItem cil = getLineItem(swhich, index, category);
        d = cil.percentLikely;
        return d;
    }
    
    public double getTotalPercentageForTuple(MortgageTuple mt) {
        double p;
        double percentForMortgage = 1;
        {
            
            double[] percentages = this.getProbabilitiesList(mt);
            for (double d: percentages)
            {
                percentForMortgage *= d;
                // System.out.printf("%6.2f ", d);
            }
            percentForMortgage *= 5;
        }
        p = percentForMortgage;
        return p;
    }    
    
    
    
}
