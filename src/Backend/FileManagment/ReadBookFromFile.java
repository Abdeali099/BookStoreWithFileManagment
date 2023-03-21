package Backend.FileManagment;

import Backend.Modal.BookDataClass;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadBookFromFile {

    private static final String dataFilePath="src\\Data\\AllBooksData.dat";


    public static void main(String[] args) {

        try {
            FileInputStream fis=new FileInputStream("src\\Data\\AllBooksData.dat");
            ObjectInputStream readBookDataFromFile = new ObjectInputStream(fis);
            BookDataClass bookDataClass=new BookDataClass();

        while(fis.available() != 0){

            bookDataClass=(BookDataClass) readBookDataFromFile.readObject();

            System.out.println(bookDataClass);
        }

        fis.close();
        readBookDataFromFile.close();

        }catch (EOFException eof){}
        catch (Exception e) {
            System.out.println("Error in reading  file : " + e + " Msg : " + e.getMessage());
        }

    }

}
