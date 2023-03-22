package Backend.FileManagment;

import Backend.Modal.BookDataClass;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadBookFromFile {

    private static final String dataFilePath = "src\\Data\\AllBooksData.dat";
    private static ArrayList<BookDataClass> arrayListBookDataClass;

    public static ArrayList<BookDataClass> fetchAllStoredDataFromFile() throws IOException {

        FileInputStream fis =null;
        ObjectInputStream readBookDataFromFile = null;

        try {
             fis = new FileInputStream(dataFilePath);
             readBookDataFromFile = new ObjectInputStream(fis);
            BookDataClass bookDataClass = new BookDataClass();
            arrayListBookDataClass=new ArrayList<>();

            while (fis.available() != 0) {

                bookDataClass = (BookDataClass) readBookDataFromFile.readObject();

                arrayListBookDataClass.add(bookDataClass);
            }

        } catch (EOFException ignored) {
        } catch (Exception e) {
            System.out.println("Error in reading  file : " + e + " Msg : " + e.getMessage());
        }finally {

            if (fis!=null){
                fis.close();
            }

            if (readBookDataFromFile != null) {
                readBookDataFromFile.close();
            }
        }
        return arrayListBookDataClass;
    }
}
