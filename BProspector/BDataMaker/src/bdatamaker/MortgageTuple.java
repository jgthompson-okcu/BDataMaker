package bdatamaker;

import java.math.BigInteger;


public class MortgageTuple 
{
    
        // the Strings are representations like "C1" ,"I3" and so on.
        // the longs are equivalent values of the digit of the string.
        //
        // if children could equal "C3" then iChildren would equal "3";

        // id is a BigInt.  In string form it is converted to base 32
        //                  for display.
    
        private String id;
        private BigInteger iId;
        private String children;
        private int iChildren;
        private String age;
        private int iAge;
        private String relocationDate;
        private int iRelocationDate;
        private String income;
        private int iIncome;
        private String mortgageBought;
        private int iMortgageBought;
        private String mortgageCandidateRating;
        private int iMortgageCandidateRating;
        

        
        public MortgageTuple()
        {
            reset(this);
        }
        
        public void generateNewID()
        {
            String nid = Utils.sig.nextSessionId();
            this.setId(nid);
            
            
        }
        private MortgageTuple reset(MortgageTuple mt)
        {
                mt.id = "xx";
                mt.iId = new BigInteger("-1");
                mt.children = "xx";
                mt.iChildren = -1;
                mt.age = "xx";
                mt.iAge = -1;
                mt.relocationDate  = "xx";
                mt.iRelocationDate = -1;
                mt.income  = "xx";
                mt.iIncome = -1;
                mt.mortgageBought  = "xx";
                mt.iMortgageBought = -1;
                mt.mortgageCandidateRating  = "xx";
                mt.iMortgageCandidateRating = -1;
                return mt;
        }
        
        public String getCSV()
        {
            // this is like toString except it returns clean out,
            // of members separated by commas only
            String s;
            s = String.format("%s,%s,%s,%s,%s,%s,%s",
                    this.id, this.children, this.age, this.relocationDate,
                    this.income, this.iMortgageBought, this.mortgageCandidateRating);
            return s;
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
                    this.relocationDate,
                    this.income, 
                    this.mortgageBought, 
                    this.mortgageCandidateRating
                    );
            
            s += "\n" + String.format(f2,
                    this.iChildren,
                    this.iAge,
                    this.iRelocationDate,
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

    public String getRelocationDate() {
        return relocationDate;
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

    public int setChildren(String s) {
        this.children = s;
        int l = Utils.getIntFromCategory(s);
        this.setiChildren(l);
        return l;
    }

    public int setAge(String s) {
        this.age = s;
        int l = Utils.getIntFromCategory(s);
        this.setiAge(l);
        return l;
    }

    public int setRelocationDate(String s) {
        this.relocationDate = s;
        int l = Utils.getIntFromCategory(s);
        this.setiRelocationDate(l);
        return l;
    }

    public int setIncome(String s) {
        this.income = s;
        int l = Utils.getIntFromCategory(s);
        this.setiIncome(l);  
        return l;
    }

    public int setMortgageBought(String s) {
        this.mortgageBought = s;
        int l = Utils.getIntFromCategory(s);
        this.setiMortgageBought(l);        
        return l;
    }

    public int setMortgageCandidateRating(String s) {
        this.mortgageCandidateRating = s;
        int l = Utils.getIntFromCategory(s);
        this.setiMortgageCandidateRating(l);    
        return l;
    }
    public BigInteger getiId() {
        return iId;
    }

    public int getiChildren() {
        return iChildren;
    }

    public int getiAge() {
        return iAge;
    }

    public int getiRelocationDate() {
        return iRelocationDate;
    }

    public int getiIncome() {
        return iIncome;
    }

    public int getiMortgageBought() {
        return iMortgageBought;
    }
    
    public int getiMortgageCandidateRating() {
        return iMortgageCandidateRating;
    }

    public void setiId(BigInteger iId) {
        this.iId = iId;
    }

    public void setiRelocationDate(int iRelocationDate) {
        this.iRelocationDate = iRelocationDate;
    }
    
    public void setiChildren(int iChildren) {
        this.iChildren = iChildren;
    }

    public void setiAge(int iAge) {
        this.iAge = iAge;
    }
    
    public void setiIncome(int iIncome) {
        this.iIncome = iIncome;
    }
    
    public void setiMortgageBought(int iMortgageBought) {
        this.iMortgageBought = iMortgageBought;
    }

    public void setiMortgageCandidateRating(int iMortgageCandidateRating) {
        this.iMortgageCandidateRating = iMortgageCandidateRating;
    }
}