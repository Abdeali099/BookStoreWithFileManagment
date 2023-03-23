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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookActionListener implements ActionListener {

    /* main frame */
    public BookStore bookStore;
    /* Operation On Book (as a Controller)*/
    private final PerformOperationOnBookData performOperationOnBookData;

    /* ArrayList of Book Data (Helpful in Update and Delete when selected row data will be showed up in text field) */
    private static ArrayList<BookDataClass> bookDataClassArrayList;

    /* ArrayList for BookId (Helps to check ID is not assign already) */
    public static ArrayList<Integer> idOfBooks;

    /* Flags to know what had done ? : Add|Delete|Update (Cancel is not necessary)*/

    public static boolean  addBookDone,updateBookDone,deleteBookDone,saveAllChangesDone;

    /* Actual data of Book Data (Modal) */
    private int bookId,bookPrice=200,bookQuantity=1,totalCost=bookPrice*bookQuantity;
    private String bookName,bookSubject,authorName,dateOfPublication,publication,bookCoverPath="src\\assets\\byDefaultCover.jpg";

    public BookActionListener(BookStore bookStore) {
        this.bookStore = bookStore;
        performOperationOnBookData =new PerformOperationOnBookData();
        bookDataClassArrayList=new ArrayList<>();
        idOfBooks=new ArrayList<>();

        addBookDone=false;
        updateBookDone=false;
        deleteBookDone=false;
        saveAllChangesDone=false;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String operationHappen=event.getActionCommand();

        switch (operationHappen) {
            case "Save" -> saveAllChanges();
            case "Add" -> doAddOperation();
            case "Update" -> doUpdateOperation();
            case "Delete" -> doDeleteOperation();
            case "Cancel" -> doCancelOperation();
            case "Cover" -> browseCover();
        }

    }

    /* User defined methods - by Abdeali */

    public void saveAllChanges() {

        /* First check Some Operation Has Ocuured or Not*/

        if (!(addBookDone || deleteBookDone)) {
            JOptionPane.showMessageDialog(null,"No data for saving!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* send to controller to Save changes Permanently */
        saveAllChangesDone =  performOperationOnBookData.SaveToFilePermanently(bookDataClassArrayList);

        if (!saveAllChangesDone) {
            JOptionPane.showMessageDialog(null,"Error In saving File!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Set Title */
        BookKeyListener.TitleFlag=false;
        bookStore.setTitle("Book Store");

        /* reset flag of update and add*/
        addBookDone=false;
        deleteBookDone=false;

        /* Here give Toast */

    }

    public void FetchAllBooks(){
        /* This method call from BookStore constructor only for one time */
        try {

            /* Taking data from Controller : Not direct calling File method */
            bookDataClassArrayList = performOperationOnBookData.fetchAllStoredData();

            if (bookDataClassArrayList == null) {
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

    private void doAddOperation() {

        /* Checking Validation  */
        boolean shouldGoFurther=checkValidation();

        if (!shouldGoFurther) {
            return;
        }

        /* Data of Book (Modal) */
        BookDataClass bookDataClass = new BookDataClass();

        /* Data already fetched when validate input */
        bookDataClass.setBookId(bookId);
        bookDataClass.setBookName(bookName);
        bookDataClass.setBookSubject(bookSubject);
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
         * 2) In ArrayList
         * 3) Adding data in Table Row.
         * */

        try {

            /* Adding object in arrayList */
            bookDataClassArrayList.add(bookDataClass);
            /* Adding book ID in array list , helpful in validation */
            idOfBooks.add(bookId);

            /* <--- Adding it to JTable Row ---> */
            /* Referencing Table Modal */
            DefaultTableModel tableModel=bookStore.bookTable.defaultTableModel;

            Object[] dataOfRow = {bookId,bookName,bookSubject,authorName,publication,dateOfPublication,bookPrice,bookQuantity,totalCost,bookCoverPath};

            tableModel.addRow(dataOfRow);

            /* Updating status of add */
            addBookDone=true;

            clearInputFields();
        } catch (Exception e) {
            System.out.println("Error  at listener Add : " + e.getMessage());
        }

    }

    private void doUpdateOperation() {

    }

    private void doDeleteOperation() {

        int rowSelected=RowSelectionListener.selectedRow;

        /* Check Whether Row is selected or Not */
        if (rowSelected<=0) {
            JOptionPane.showMessageDialog(null,"No row is selected!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Taking confirmation */
        int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        // input : 0=yes, 1=no

        if (input == 1) {
            /* DeSelect row */
            bookStore.bookTable.bookTable.getSelectionModel().clearSelection();

            clearInputFields();

            /* Reset ID Field which  was changed when Row selected */
            bookStore.addBookPanel.tfBookID.setEditable(true);
            Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
            bookStore.addBookPanel.tfBookID.setCursor(cursor);

            return;
        }

        /* if ( Selected & confirmed ) then Remove it from Table*/
        bookStore.bookTable.defaultTableModel.removeRow(rowSelected);

        /* Also from ArrayList */
        bookDataClassArrayList.remove(rowSelected);

        /* Updating status of deletion */
        deleteBookDone=true;

        clearInputFields();

        /* DeSelect row */
        bookStore.bookTable.bookTable.getSelectionModel().clearSelection();

        /* Reset ID Field which  was changed when Row selected */
        bookStore.addBookPanel.tfBookID.setEditable(true);
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        bookStore.addBookPanel.tfBookID.setCursor(cursor);

    }

    private void doCancelOperation() {
        /* Eventually it is clear field Operation but have to add confirmation */

        try {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure to cancel?", "Cancel", JOptionPane.YES_NO_OPTION);
            // input : 0=yes, 1=no

            if (input == 1) {
                return;
            }

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

            /* Checking Date is not greater than current date. */

            /* Fetching Current date*/
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String todayDate = formatter.format(date);

            Date selectedDate=formatter.parse(dateOfPublication);
            Date currentDate=formatter.parse(todayDate);

            int shouldAllowed = selectedDate.compareTo(currentDate);

            if (shouldAllowed > 0) {
                JOptionPane.showMessageDialog(null,"Publication date can't be in future","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }

            /* Checking if any contain null or empty */
            if (bookName.isEmpty() || bookSubject.isEmpty() || authorName.isEmpty() || publication.isEmpty() || dateOfPublication.isEmpty() || bookCoverPath.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Maybe Some Inputs are missing!!","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }

            /* For String (No digit) : Other fields */
            String regExForString = "^[ A-Za-z]+$";
            Pattern pattern=Pattern.compile(regExForString);
            Matcher matcher;

            String[] listForRegEx={bookName,authorName,publication};

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
