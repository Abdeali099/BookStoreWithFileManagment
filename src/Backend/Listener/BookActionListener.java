package Backend.Listener;

import Backend.Controller.PerformOperationOnBookData;
import Backend.Modal.BookDataClass;
import Frontend.BookStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookActionListener implements ActionListener {

    /* main frame */
    public BookStore bookStore;
    /* Operation On Book (as a Controller)*/
    private final PerformOperationOnBookData performOperationOnBookData;
    /* Data of Book */
     private BookDataClass bookDataClass;
    /* ArrayList for data of Book*/
    public ArrayList<BookDataClass> bookDataClassArrayList;
    public static int NumberOfBookAdded;

    /* Actual data of Book Data (Modal) */
    private int bookId,bookPrice=200,bookQuantity=1,totalCost=bookPrice*bookQuantity;
    private String bookName,bookSubject,authorName,dateOfPublication,publication,bookCoverPath="src\\assets\\byDefaultCover.jpg";

    public BookActionListener(BookStore bookStore) {
        this.bookStore = bookStore;
        performOperationOnBookData =new PerformOperationOnBookData();
        bookDataClassArrayList=new ArrayList<>();
        NumberOfBookAdded=0;
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

        System.out.println("1) I am in doAddOperation");

        bookDataClass=new BookDataClass();

        bookId=Integer.parseInt(bookStore.addBookPanel.tfBookID.getText());
        bookDataClass.setBookId(bookId);

        bookName=bookStore.addBookPanel.tfBookName.getText();
        bookDataClass.setBookName(bookName);

        bookSubject=bookStore.addBookPanel.tfBookSubject.getText();
        bookDataClass.setBookSubject(bookSubject);

        authorName=bookStore.addBookPanel.tfAuthorName.getText();
        bookDataClass.setAuthorName(authorName);

        publication=bookStore.addBookPanel.tfPublication.getText();
        bookDataClass.setPublication(publication);

        dateOfPublication=bookStore.addBookPanel.tfDatePublication.getText();
        bookDataClass.setDateOfPublication(dateOfPublication);

        bookPrice=(Integer) bookStore.addBookPanel.spBookPrice.getValue();
        bookDataClass.setBookPrice(bookPrice);

        bookQuantity=(Integer) bookStore.addBookPanel.spBookQuantity.getValue();
        bookDataClass.setBookQuantity(bookQuantity);

        totalCost=Integer.parseInt(bookStore.addBookPanel.tfTotalCost.getText());
        bookDataClass.setTotalCost(totalCost);

        bookCoverPath=bookStore.addBookPanel.bookCover.bookCoverPath;
        bookDataClass.setBookCoverPath(bookCoverPath);

        /* I have to Add This at 2 Place
         *
         * 1) In File : By File Management (Cause every time Adding ArrayList is not Good (It is on Controller side)
         * 2) In ArrayList : to do Easy Operation
         * 3) Adding data in Table Row.
         * */

        try {
            /* Add in ArrayList */
            bookDataClassArrayList.add(bookDataClass);

            /* send to controller*/
            performOperationOnBookData.AddBook(bookDataClass);

            /* <--- Adding it to JTable Row ---> */
            /* Referencing Table Modal */
            DefaultTableModel tableModel=bookStore.bookTable.defaultTableModel;

            Object[] dataOfRow = {bookId,bookName,bookSubject,authorName,publication,dateOfPublication,bookPrice,bookQuantity,totalCost,bookCoverPath};

            tableModel.addRow(dataOfRow);

        } catch (Exception e) {
            System.out.println("Error  at listener Add : " + e.getMessage());
        }

        clearInputFields();

    }

    private void doUpdateOperation() {
    }

    private void doDeleteOperation() {
    }

    private void doCancelOperation() {
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

        bookStore.addBookPanel.tfDatePublication.setText("");

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

}
