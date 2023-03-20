package Backend.Listener;

import Backend.Controller.PerformedOperation;
import Backend.Modal.BookDataClass;
import Frontend.BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookActionListener implements ActionListener {

    /* main frame */
    public BookStore bookStore;
    /* Operation On Book (as a Controller)*/
    private final PerformedOperation performedOperation;
    /* Data of Book */
     private final BookDataClass bookDataClass;
    /* ArrayList for data of Book*/
    public ArrayList<BookDataClass> bookDataClassArrayList;

    public BookActionListener(BookStore bookStore) {
        this.bookStore = bookStore;
        bookDataClass=new BookDataClass();
        performedOperation=new PerformedOperation();
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
        bookDataClass.setBookId(Integer.parseInt(bookStore.addBookPanel.tfBookID.getText()));
        bookDataClass.setBookName(bookStore.addBookPanel.tfBookName.getText());
        bookDataClass.setBookSubject(bookStore.addBookPanel.tfBookSubject.getText());
        bookDataClass.setAuthorName(bookStore.addBookPanel.tfAuthorName.getText());
        bookDataClass.setPublication(bookStore.addBookPanel.tfPublication.getText());
        bookDataClass.setDateOfPublication(bookStore.addBookPanel.tfDatePublication.getText());
        int bookPrice=(Integer) bookStore.addBookPanel.spBookPrice.getValue();
        bookDataClass.setBookPrice(bookPrice);
        int bookQuantity=(Integer) bookStore.addBookPanel.spBookQuantity.getValue();
        bookDataClass.setBookQuantity(bookQuantity);
        bookDataClass.setTotalCost(bookPrice*bookQuantity);

        bookDataClassArrayList=performedOperation.AddBook(bookDataClass);

        bookDataClassArrayList.forEach(student -> System.out.println(student));
    }

    private void doUpdateOperation() {
    }

    private void doDeleteOperation() {
    }

    private void doCancelOperation() {
    }

    private void browseCover() {

        /* Taking path */
        String pathOfBookCover=performedOperation.fetchBookCover();

        /* Taking reference from Frame*/
        JLabel bookCoverImage=bookStore.addBookPanel.bookCover.bookCoverImage;

        /* Setting Cover on Frame */
        ImageIcon bookCoverIcon = new ImageIcon(pathOfBookCover);
        Image img = bookCoverIcon.getImage().getScaledInstance(bookCoverImage.getWidth(), bookCoverImage.getHeight(), Image.SCALE_SMOOTH);
        bookCoverImage.setIcon(new ImageIcon(img));

    }
}
