package bdatamaker;

import java.math.BigInteger;


public class MortgageTuple 
{
    
        // the Strings are representations like "C1" ,"I3" and so on.
        // the longs are equivalent values of the digit of the string.
        //
        // so children could equal "C3" and iChildren would equal "3";

        // our id is a BigInt.  In string form it is converted to base 32
        //                      for display.
    
        private String id;
        private BigInteger iId;
        private String children;
        private long iChildren;
        private String age;
        private long iAge;
        private String datemoved;
        private long iDateMoved;
        private String income;
        private long iIncome;
        private String mortgageBought;
        private long iMortgageBought;
        private String mortgageCandidateRating;
        private long iMortgageCandidateRating;
        
        
        public MortgageTuple()
        {
            reset(this);
        }
        public static MortgageTuple reset(MortgageTuple mt)
        {
                mt.id = "xx";
                mt.iId = new BigInteger("-1");
                mt.children = "xx";
                mt.iChildren = -1;
                mt.age = "xx";
                mt.iAge = -1;
                mt.datemoved  = "xx";
                mt.iDateMoved = -1;
                mt.income  = "xx";
                mt.iIncome = -1;
                mt.mortgageBought  = "xx";
                mt.iMortgageBought = -1;
                mt.mortgageCandidateRating  = "xx";
                mt.iMortgageCandidateRating = -1;
                return mt;
        }
        
        @Override
        public String toString()
        {
            String s = "";
            
            // don't print out bignum because it is a huge string that
            // looks confusing
            
            String f1 = "MortgageTuple record: (%s\t%s\t%s\t%s\t%s\t%s)";
            String f2 = "MortgageTuple values: (%d\t%d\t%d\t%d\t%d\t%d)";
            
            s += String.format(f1,
                    this.children, 
                    this.age, 
                    this.datemoved,
                    this.income, 
                    this.mortgageBought, 
                    this.mortgageCandidateRating
                    );
            
            s += "\n" + String.format(f2,
                    this.iChildren,
                    this.iAge,
                    this.iDateMoved,
                    this.iIncome,
                    this.iMortgageBought,
                    this.iMortgageCandidateRating
                    );
            
            return s;
        }

    public String getId() {
        return id;
    }
    
    public String getChildren() {
        return children;
    }

    public String getAge() {
        return age;
    }

    public String getDatemoved() {
        return datemoved;
    }
    public String getIncome() {
        return income;
    }
    public String getMortgageBought() {
        return mortgageBought;
    }
    public String getMortgageCandidateRating() {
        return mortgageCandidateRating;
    }
    
    public void setId(String s) {
        this.id = s;
        BigInteger bi = Utils.parseBigIntSafely(s);
        this.setiId(bi);
    }

    public void setChildren(String s) {
        this.children = s;
        long l = Utils.getLongFromCategory(s);
        this.setiChildren(l);
    }

    public void setAge(String s) {
        this.age = s;
        long l = Utils.getLongFromCategory(s);
        this.setiAge(l);
    }

    public void setDatemoved(String s) {
        this.datemoved = s;
        long l = Utils.getLongFromCategory(s);
        this.setiDateMoved(l);
    }

    public void setIncome(String s) {
        this.income = s;
        long l = Utils.getLongFromCategory(s);
        this.setiIncome(l);        
    }

    public void setMortgageBought(String s) {
        this.mortgageBought = s;
        long l = Utils.getLongFromCategory(s);
        this.setiMortgageBought(l);        
    }

    public void setMortgageCandidateRating(String s) {
        this.mortgageCandidateRating = s;
        long l = Utils.getLongFromCategory(s);
        this.setiMortgageCandidateRating(l);        
    }
    public BigInteger getiId() {
        return iId;
    }

    public long getiChildren() {
        return iChildren;
    }

    public long getiAge() {
        return iAge;
    }

    public long getiDateMoved() {
        return iDateMoved;
    }

    public long getiIncome() {
        return iIncome;
    }

    public long getiMortgageBought() {
        return iMortgageBought;
    }
    
    public long getiMortgageCandidateRating() {
        return iMortgageCandidateRating;
    }

    public void setiId(BigInteger iId) {
        this.iId = iId;
    }

    public void setiDateMoved(long iDateMoved) {
        this.iDateMoved = iDateMoved;
    }
    
    public void setiChildren(long iChildren) {
        this.iChildren = iChildren;
    }

    public void setiAge(long iAge) {
        this.iAge = iAge;
    }
    
    public void setiIncome(long iIncome) {
        this.iIncome = iIncome;
    }
    
    public void setiMortgageBought(long iMortgageBought) {
        this.iMortgageBought = iMortgageBought;
    }

    public void setiMortgageCandidateRating(long iMortgageCandidateRating) {
        this.iMortgageCandidateRating = iMortgageCandidateRating;
    }
}