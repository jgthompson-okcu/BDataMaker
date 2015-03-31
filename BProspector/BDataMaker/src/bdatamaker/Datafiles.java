package bdatamaker;

// contains data for categories for four data sets
//
// children 
// age 
// relocation
// income
//
// currently these values are hardcoded.  They should be
// read from a file.

/* File definition:
 * File will have three tokens per line and be delimited by commas
 * First line:    
 *      category title, category abreviation, someignoredtext
 * Subsequent lines: 
 *      line item title, abbreviation, probability
 * 
 * column position is not important since the files are
 * delimited by commas (CSV)
 * 
 * So, to match the hardcoded data for the category class,
 * as shown here:
 * 
     private String[][] childrenCategories = {
        {"Number of children", "C", "Probability"},
        {"0  Children", "C0", "+"},
        {"1  Child", "C1", "+"},
        {"2  Children", "C2", "+"},
        {"3  Children", "C3", "++"},
        {"4+ Children", "C4", "++"}
    };
 * 
 * the file childrenCategory.txt would contain: 

Number of children, C, Probability
Children, C0, + 
Child, C1, + 
2  Children, C2, +
3  Children, C3", ++ 
4+ Children, C4", ++

 * We should also support comments -- lines beginning with
 * double slashes // will be skipped.  So should blank lines
 *
 */
public class Datafiles {

    private String[][] childrenCategories = {
        {"Number of children",  "C",    ""              },
        {"0  Children",         "C0",   "+"             },
        {"1  Child",            "C1",   "+"             },
        {"2  Children",         "C2",   "+"             },
        {"3  Children",         "C3",   "++"            },
        {"4+ Children",         "C4",   "++"            }
    };
    private String[][] ageCategories = {
        {"Age range",   "A",    ""                      },
        {"18-25",       "A0",   "+"                     },
        {"26-35",       "A1",   "++"                    },
        {"36-45",       "A2",   "+++"                   },
        {"46-55",       "A3",   "++"                    },
        {"56-65",       "A4",   "+"                     },
        {"66+",         "A5",   "+"                     }
    };
    private String[][] relocationCategories = {
        {"DATE MOVED",      "M",    ""                  },
        {"This year",       "M0",   "++"                },
        {"Last year",       "M1",   "+"                 },
        {"Last 2 years",    "M2",   "+"                 },
        {"Last 3 years",    "M3",   "+"                 },
        {"Last 4 years",    "M4",   "+"                 }
    };
    private String[][] incomeCategories = {
        {"INCOME",          "I",    ""                  },
        {"<30000",          "I0",   "+"                 },
        {"30000 < 40000",   "I1",   "+"                 },
        {"40000 < 50000",   "I2",   "++"                },
        {"50000 < 60000",   "I3",   "+++"               },
        {"60000 < 70000",   "I4",   "++"                },
        {"70000 <100000",   "I5",   "+"                 },
        {"100001+",         "I6",   "+"                 }
    };

    boolean read() {
        System.err.println("DataFiles.read() -- Read from files not implemented yet");
        System.err.println("                    Using default values");
        System.err.println("                    (This is ok for prototype");
        return true;
    }

    public String[][] getChildrenCategories() {
        return childrenCategories;
    }

    public String[][] getAgeCategories() {
        return ageCategories;
    }

    public String[][] getRelocationCategories() {
        return relocationCategories;
    }

    public String[][] getIncomeCategories() {
        return incomeCategories;
    }
}
