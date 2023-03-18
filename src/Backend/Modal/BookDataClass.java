package Backend.Modal;


/* This is basic POJO class for Book*/
public class BookDataClass {

    /* Defining All Attributes */

    private int bookId,bookPrice=200,bookQuantity=1,totalCost=bookPrice*bookQuantity;
    private String bookName,bookSubject,authorName,dateOfPublication,publication;


    public int getBookId() {
        return bookId;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookSubject() {
        return bookSubject;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public String getPublication() {
        return publication;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookSubject(String bookSubject) {
        this.bookSubject = bookSubject;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "BookDataClass{" +
                "bookId=" + bookId +
                ", bookPrice=" + bookPrice +
                ", bookQuantity=" + bookQuantity +
                ", totalCost=" + totalCost +
                ", bookName='" + bookName + '\'' +
                ", bookSubject='" + bookSubject + '\'' +
                ", authorName='" + authorName + '\'' +
                ", dateOfPublication='" + dateOfPublication + '\'' +
                ", publication='" + publication + '\'' +
                '}';
    }
}
