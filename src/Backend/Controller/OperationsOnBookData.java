package Backend.Controller;

import Backend.Modal.BookDataClass;

public interface OperationsOnBookData {

    void AddBook(BookDataClass bookDataClass);
    void updateBook(int bookId);
    void deleteBook(int bookId);
//    BookDataClass searchBook(int bookId);
    String fetchBookCover();
}
