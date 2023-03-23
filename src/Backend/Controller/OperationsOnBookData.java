/* This Interface have Basic Method Declaration which is used in book data Manipulation*/

package Backend.Controller;

import Backend.Modal.BookDataClass;

import java.util.ArrayList;

public interface OperationsOnBookData {

    void AddBook(ArrayList<BookDataClass> bookDataClassArrayList);

    void updateBook(int bookId);
    void deleteBook(int bookId);

    // Refresh or when Application Starts load all previous data  //
    ArrayList<BookDataClass> fetchAllStoredData();

//    BookDataClass searchBook(int bookId);
    String fetchBookCover();
}
