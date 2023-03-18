package Backend.Listener;

import Backend.Controller.PerformedOperation;
import Backend.Modal.BookDataClass;
import Frontend.BookStore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookActionListener implements ActionListener {

    private BookStore bookStore;
    private PerformedOperation performedOperation;

    private ArrayList<BookDataClass> bookDataClassArrayList;

    public BookActionListener(BookStore bookStore) {
        this.bookStore = bookStore;

        /* Taking data from field text and store in BookDataClass */

        BookDataClass bookDataClass=new BookDataClass();

//        bookDataClass.setBookId(Integer.parseInt(bookStore.addBookPanel.));



    }
    @Override
    public void actionPerformed(ActionEvent event) {

    }
}
