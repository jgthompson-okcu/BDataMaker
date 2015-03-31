package bdatamaker;

// this aggregates our collection of categories
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
    
    private static Category childCategories = new Category(
            datafiles.getChildrenCategories());
    private static Category incomeCategories = new Category(
            datafiles.getIncomeCategories());
    private static Category ageCategories = new Category(
            datafiles.getAgeCategories());
    private static Category relocationDateCategories = new Category(
            datafiles.getRelocationCategories());

    static boolean read() {
        return datafiles.read();
    }

    public static Category getChildCategories() {
        return childCategories;
    }

    public static Category getIncomeCategories() {
        return incomeCategories;
    }

    public static Category getAgeCategories() {
        return ageCategories;
    }

    public static Category getRelocationDateCategories() {
        return relocationDateCategories;
    }
    
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

    
    public static MortgageTuple assignRandomCategories(
                    MortgageTuple mt
                    )
            
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
            
    {
        String s;

        s = getRandomCategory( getChildCategories() );
        mt.setChildren(s);

        s = getRandomCategory( getAgeCategories() );
        mt.setAge(s);

        s = getRandomCategory( getRelocationDateCategories() );
        mt.setDatemoved(s);

        s = getRandomCategory( getIncomeCategories() );
        mt.setIncome(s);
        
        return mt;
    }
    
}
