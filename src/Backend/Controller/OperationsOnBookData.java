package Backend.Controller;

import Backend.Modal.BookDataClass;

import java.util.ArrayList;

public interface OperationsOnBookData {

    void AddBook(BookDataClass bookDataClass);
    void updateBook(int bookId);
    void deleteBook(int bookId);

    // Refresh or when Application Starts load all previous data  //
    ArrayList<BookDataClass> fetchAllStoredData();

//    BookDataClass searchBook(int bookId);
    String fetchBookCover();
}
