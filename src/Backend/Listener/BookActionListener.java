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
    private PerformedOperation performedOperation;
    /* Data of Book */
     private BookDataClass bookDataClass;
    /* ArrayList for data of Book*/
    private ArrayList<BookDataClass> bookDataClassArrayList;

    public BookActionListener(BookStore bookStore) {
        this.bookStore = bookStore;
        bookDataClass=new BookDataClass();
        performedOperation=new PerformedOperation();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String opeartionHappen=event.getActionCommand();

        if (opeartionHappen.equals("Add")) {
              doAddOperation();
        }
        else if (opeartionHappen.equals("Cover")) {
            browseCover();
        }

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
}
