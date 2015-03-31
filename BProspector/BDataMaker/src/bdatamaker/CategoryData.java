package bdatamaker;

// this aggregates our collection of category tables -
// the category tables contain items in a category and their
// relative likelyhood to be selected randomly when generating
// data.

public class CategoryData {
    
    DataFiles datafiles = new DataFiles();
    
    Category childCat = new Category(datafiles.getChildrenSA());
    Category incomeCat = new Category(datafiles.getIncomeCatSA());
    Category ageCat = new Category(datafiles.getAgeSA());
    Category dateMovedCat = new Category(datafiles.getDateMovedSA());
}
