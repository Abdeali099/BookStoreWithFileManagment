package Backend.Listener;

import Backend.Controller.PerformedOperation;
import Backend.Modal.BookDataClass;
import Frontend.BookStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookActionListener implements ActionListener {

    public BookStore bookStore;
    private PerformedOperation performedOperation;
    private ArrayList<BookDataClass> bookDataClassArrayList;
   private BookDataClass bookDataClass;
    public BookActionListener(BookStore bookStore) {
        this.bookStore = bookStore;

        /* Taking data from field text and store in BookDataClass */

         bookDataClass=new BookDataClass();
        performedOperation=new PerformedOperation();

        /* commiting */
//        try {
////            bookStore.addBookPanel.spBookPrice.commitEdit();
////            bookStore.addBookPanel.spBookQuantity.commitEdit();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }

    }
    @Override
    public void actionPerformed(ActionEvent event) {

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
