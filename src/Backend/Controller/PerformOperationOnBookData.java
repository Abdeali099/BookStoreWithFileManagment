/* This controller will handle / call File classes */
package Backend.Controller;

import Backend.FileManagment.AddUpdateDeleteByFile;
import Backend.FileManagment.FetchBookCoverByFile;
import Backend.FileManagment.ReadBookFromFile;
import Backend.Modal.BookDataClass;

import java.io.IOException;
import java.util.ArrayList;

public class PerformOperationOnBookData implements OperationsOnBookData{

    @Override
    public void AddBook(ArrayList<BookDataClass> bookDataClassArrayList) {

        /* I have to Add This at 2 Place
         *
         * 1) In File : By File Management (Cause every time Adding ArrayList is not Good)
         * 2) In ArrayList : to do Easy Operation (It is On Listener side)
         * */

         /* 1) Adding in File */
        try {
            AddUpdateDeleteByFile.AddUpdateDeleteToFile(bookDataClassArrayList);
        } catch (IOException e) {
            System.out.println("Error in Controlled Add Data: " + e + " Msg : " + e.getMessage());
        }
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
        try {
            System.out.println("I am in control");
            return ReadBookFromFile.fetchAllStoredDataFromFile();
        } catch (IOException e) {
            System.out.println("Error in Controlled Fetched Data: " + e + " Msg : " + e.getMessage());
        }
        return null;
    }

}
