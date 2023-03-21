package Backend.Controller;

import Backend.FileManagment.AddBookFromFile;
import Backend.FileManagment.FetchBookCoverByFile;
import Backend.Modal.BookDataClass;

import java.util.ArrayList;

public class PerformOperationOnBookData implements OperationsOnBookData{


    @Override
    public void AddBook(BookDataClass bookDataClass) {
        System.out.println("2) I am in addBook");

        /* I have to Add This at 2 Place
         *
         * 1) In File : By File Management (Cause every time Adding ArrayList is not Good)
         * 2) In ArrayList : to do Easy Operation (It is On Listener side)
         * */

         /* 1) Adding in File */
        AddBookFromFile.AddOneBookToFile(bookDataClass);
    }

    @Override
    public void updateBook(int bookId) {
        int i=0;
    }

    @Override
    public void deleteBook(int bookId) {
        int i=0;

    }

//    @Override
//    public BookDataClass searchBook(int bookId) {
//        int i=0;
//    }
    @Override
    public String fetchBookCover() {
       return FetchBookCoverByFile.fetchBookCoverFromDevice();
    }


    @Override
    public ArrayList<BookDataClass> fetchAllStoredData() {

        ArrayList<BookDataClass> arrayListBookDataClass=new ArrayList<>();



        return arrayListBookDataClass;
    }

}
