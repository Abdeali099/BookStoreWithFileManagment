package Backend.FileManagment;

import Backend.Modal.BookDataClass;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadBookFromFile {

    private static final String dataFilePath = "src\\Data\\AllBooksData.dat";
    private static ArrayList<BookDataClass> arrayListBookDataClass;

    public static ArrayList<BookDataClass> fetchAllStoredDataFromFile() {

        try {
            FileInputStream fis = new FileInputStream("src\\Data\\AllBooksData.dat");
            ObjectInputStream readBookDataFromFile = new ObjectInputStream(fis);
            BookDataClass bookDataClass = new BookDataClass();
            arrayListBookDataClass=new ArrayList<>();

            while (fis.available() != 0) {

                bookDataClass = (BookDataClass) readBookDataFromFile.readObject();

                arrayListBookDataClass.add(bookDataClass);
            }

            fis.close();
            readBookDataFromFile.close();

        } catch (EOFException ignored) {
        } catch (Exception e) {
            System.out.println("Error in reading  file : " + e + " Msg : " + e.getMessage());
        }
        return arrayListBookDataClass;
    }
}
