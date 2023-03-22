/* This Class is for Action Listener for Buttons
*
*  Operation in this  listener :
*                              1) Add
*                              2) Delete
*                              3) Update
*                              4) Cancel
*                              5) Clear Field
*                              6) Fetch all Previous store data
*                              7) Fetch BookCover
*
*  This will provide or complete job by calling Controller "PerformOperationOnBookData".
*  */
package Backend.Listener;

import Backend.Controller.PerformOperationOnBookData;
import Backend.Modal.BookDataClass;
import Frontend.BookStore;
import com.raven.datechooser.DateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookActionListener implements ActionListener {

    /* main frame */
    public BookStore bookStore;
    /* Operation On Book (as a Controller)*/
    private final PerformOperationOnBookData performOperationOnBookData;
    /* Data of Book (Modal) */
     private BookDataClass bookDataClass;

     /* ArrayList for data of Book*/
    public static ArrayList<BookDataClass> bookDataClassArrayList;

    /* ArrayList for BookId (Helps to check ID is not assign already) */
    public static ArrayList<Integer> idOfBooks;

    /* Actual data of Book Data (Modal) */
    private int bookId,bookPrice=200,bookQuantity=1,totalCost=bookPrice*bookQuantity;
    private String bookName,bookSubject,authorName,dateOfPublication,publication,bookCoverPath="src\\assets\\byDefaultCover.jpg";

    public BookActionListener(BookStore bookStore) {
        this.bookStore = bookStore;
        performOperationOnBookData =new PerformOperationOnBookData();
        bookDataClassArrayList=new ArrayList<>();
        idOfBooks=new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String operationHappen=event.getActionCommand();

        switch (operationHappen) {
            case "Add" -> doAddOperation();
            case "Update" -> doUpdateOperation();
            case "Delete" -> doDeleteOperation();
            case "Cancel" -> doCancelOperation();
            case "Cover" -> browseCover();
        }

    }

    private void doAddOperation() {

        /* Checking RegEx */
        boolean shouldGoFurther=checkValidation();

        if (!shouldGoFurther) {
            return;
        }

        bookDataClass=new BookDataClass();

        /* Data already fetched when validate input */
        bookDataClass.setBookId(bookId);
        bookDataClass.setBookName(bookName);
        bookSubject=bookStore.addBookPanel.tfBookSubject.getText();
        bookDataClass.setAuthorName(authorName);
        bookDataClass.setPublication(publication);
        bookDataClass.setDateOfPublication(dateOfPublication);
        bookDataClass.setBookPrice(bookPrice);
        bookDataClass.setBookQuantity(bookQuantity);
        bookDataClass.setTotalCost(totalCost);
        bookDataClass.setBookCoverPath(bookCoverPath);

        /* I have to Add This at 3 Place
         *
         * 1) In File : By File Management (Cause every time Adding ArrayList is not Good (It is on Controller side)
         * 2) In ArrayList : to do Easy Operation
         * 3) Adding data in Table Row.
         * */

        try {
            /* Add in ArrayList */
            bookDataClassArrayList.add(bookDataClass);
            idOfBooks.add(bookId); /* Adding book ID in array list , helpful in validation */

            /* send to controller*/
            performOperationOnBookData.AddBook(bookDataClass);

            /* <--- Adding it to JTable Row ---> */
            /* Referencing Table Modal */
            DefaultTableModel tableModel=bookStore.bookTable.defaultTableModel;

            Object[] dataOfRow = {bookId,bookName,bookSubject,authorName,publication,dateOfPublication,bookPrice,bookQuantity,totalCost,bookCoverPath};

            tableModel.addRow(dataOfRow);

            clearInputFields();
        } catch (Exception e) {
            System.out.println("Error  at listener Add : " + e.getMessage());
        }

    }

    private void doUpdateOperation() {
    }

    private void doDeleteOperation() {
    }

    private void doCancelOperation() {
        /* Eventually it is clear field Operation */

        try {
            clearInputFields();
        } catch (Exception e) {
            System.out.println("Error  at cancel operation : " + e.getMessage());
        }

    }

    private void browseCover() {

        /* Taking path */
        String pathOfBookCover= performOperationOnBookData.fetchBookCover();

        /* Updating in frontend so Take value when adding */
        bookStore.addBookPanel.bookCover.bookCoverPath=pathOfBookCover;

        /* Taking reference from Frame*/
        JLabel bookCoverImage=bookStore.addBookPanel.bookCover.bookCoverImage;

        /* Setting Cover on Frame */
        ImageIcon bookCoverIcon = new ImageIcon(pathOfBookCover);
        Image img = bookCoverIcon.getImage().getScaledInstance(bookCoverImage.getWidth(), bookCoverImage.getHeight(), Image.SCALE_SMOOTH);
        bookCoverImage.setIcon(new ImageIcon(img));

    }

    private void clearInputFields() {

        bookStore.addBookPanel.tfBookID.setText("");
        bookStore.addBookPanel.tfBookName.setText("");
        bookStore.addBookPanel.tfBookSubject.setText("");
        bookStore.addBookPanel.tfAuthorName.setText("");
        bookStore.addBookPanel.tfPublication.setText("");

        DateChooser dateChooser = bookStore.addBookPanel.dateChooser;
        dateChooser.setTextRefernce(bookStore.addBookPanel.tfDatePublication);

        bookStore.addBookPanel.spBookPrice.setValue(200);
        bookStore.addBookPanel.spBookQuantity.setValue(1);
        bookStore.addBookPanel.tfTotalCost.setText("200");
        bookStore.addBookPanel.bookCover.bookCoverPath="src\\assets\\byDefaultCover.jpg";


        /* Taking reference from Frame*/
        JLabel bookCoverImage=bookStore.addBookPanel.bookCover.bookCoverImage;

        /* Setting Cover on Frame */
        ImageIcon bookCoverIcon = new ImageIcon("src\\assets\\byDefaultCover.jpg");
        Image img = bookCoverIcon.getImage().getScaledInstance(bookCoverImage.getWidth(), bookCoverImage.getHeight(), Image.SCALE_SMOOTH);
        bookCoverImage.setIcon(new ImageIcon(img));

    }

    public void FetchAllBooks(){
                /* This method call from BookStore constructor only for one time */
        try {

            /* Taking data from Controller : Not direct calling File method */
            bookDataClassArrayList = performOperationOnBookData.fetchAllStoredData();

            if (bookDataClassArrayList.isEmpty()) {
                return;
            }

            /* <--- Adding it to JTable Row ---> */

            /* Referencing Table Modal */
            DefaultTableModel tableModel = bookStore.bookTable.defaultTableModel;

            /* mapping / Iterating arraylist */
            bookDataClassArrayList.forEach(bookDataClass -> {

                bookId = bookDataClass.getBookId();
                idOfBooks.add(bookId); /* Adding book ID in array list , helpful in validation */

                bookName = bookDataClass.getBookName();
                bookSubject = bookDataClass.getBookSubject();
                authorName = bookDataClass.getAuthorName();
                publication = bookDataClass.getPublication();
                dateOfPublication = bookDataClass.getDateOfPublication();
                bookPrice = bookDataClass.getBookPrice();
                bookQuantity = bookDataClass.getBookQuantity();
                totalCost = bookDataClass.getTotalCost();
                bookCoverPath = bookDataClass.getBookCoverPath();

                /* Making One Row */
                Object[] dataOfRow = {bookId, bookName, bookSubject, authorName, publication, dateOfPublication, bookPrice, bookQuantity, totalCost, bookCoverPath};

                /* Adding One Row */
                tableModel.addRow(dataOfRow);
            });

        } catch (Exception e) {
            System.out.println("Error  at Fetching data Listener : " + e.getMessage());
        }//catch close
    }

    public boolean checkValidation() {

        try {

            /* Fetching All data from frontend */

            bookId=Integer.parseInt(bookStore.addBookPanel.tfBookID.getText());
            bookName=bookStore.addBookPanel.tfBookName.getText();
            bookSubject=bookStore.addBookPanel.tfBookSubject.getText();
            authorName=bookStore.addBookPanel.tfAuthorName.getText();
            publication=bookStore.addBookPanel.tfPublication.getText();
            dateOfPublication=bookStore.addBookPanel.tfDatePublication.getText();
            bookPrice=(Integer) bookStore.addBookPanel.spBookPrice.getValue();
            bookQuantity=(Integer) bookStore.addBookPanel.spBookQuantity.getValue();
            totalCost=Integer.parseInt(bookStore.addBookPanel.tfTotalCost.getText());
            bookCoverPath=bookStore.addBookPanel.bookCover.bookCoverPath;

            /* Checking For ID is duplicate or not */
            if (idOfBooks.contains(bookId)) {
                JOptionPane.showMessageDialog(null,"Id : '" + bookId +"' is already assigned!!","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }

            /* Checking if any contain null or empty */
            if (bookId < 100 || bookName.isEmpty() || bookSubject.isEmpty() || authorName.isEmpty() || publication.isEmpty() || dateOfPublication.isEmpty() || bookCoverPath.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Maybe Some Inputs are missing!!","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }

            /* For String (No digit) : Other fields */
            String regExForString = "[a-zA-Z]+";
            Pattern pattern=Pattern.compile(regExForString);
            Matcher matcher=null;

            String[] listForRegEx={bookName,bookSubject,authorName,publication};

            for (String forRegEx : listForRegEx) {

                matcher=pattern.matcher(forRegEx);

                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null,"Can't have digit in String input","Error",JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Some Inputs are not Proper!!","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println("Error in Regex : " + e + " Msg : " + e.getMessage());
            return false;
        }
        return true;
    }


} // class close
