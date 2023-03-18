package Backend.Controller;

import Backend.Modal.BookDataClass;

import java.util.ArrayList;

public interface OperationsOnBookData {

    ArrayList<BookDataClass> AddBook(BookDataClass bookDataClass);
    ArrayList<BookDataClass> updateBook(int bookId);
    ArrayList<BookDataClass> deleteBook(int bookId);
    BookDataClass searchBook(int bookId);


}
