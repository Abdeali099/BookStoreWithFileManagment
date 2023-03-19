package Backend.Controller;

import Backend.Modal.BookDataClass;

import java.util.ArrayList;

public class PerformedOperation implements OperationsOnBookData{

   private static final ArrayList<BookDataClass> booksAvialableArrayList=new ArrayList<>();

    @Override
    public ArrayList<BookDataClass> AddBook(BookDataClass bookDataClass) {
        booksAvialableArrayList.add(bookDataClass);
        return booksAvialableArrayList;
    }

    @Override
    public ArrayList<BookDataClass> updateBook(int bookId) {
        return null;
    }

    @Override
    public ArrayList<BookDataClass> deleteBook(int bookId) {
        return null;
    }

    @Override
    public BookDataClass searchBook(int bookId) {
        return null;
    }
}
