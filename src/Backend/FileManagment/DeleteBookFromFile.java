package Backend.FileManagment;

import Backend.Modal.BookDataClass;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeleteBookFromFile {

    private static final String dataFilePath = "src\\Data\\AllBooksData.dat";

//    boolean deleteOneBookFromFile()
    public static void main(String[] args) throws IOException {

        FileInputStream fis =null;
        ObjectInputStream readBookDataFromFile = null;

        int bookId=786,rowNumber=2; /* Hardcore */

        try {
            fis = new FileInputStream(dataFilePath);
            readBookDataFromFile = new ObjectInputStream(fis);
            BookDataClass bookDataClass;

            while (fis.available() != 0) {

                bookDataClass = (BookDataClass) readBookDataFromFile.readObject();

                if (bookDataClass.getBookId()==bookId) {
//                    bookDataClass=null;
//                    System.gc();
                    bookDataClass.setBookName("Changed By File");
                }

            }

        } catch (EOFException ignored) {
        } catch (Exception e) {
            System.out.println("Error in Deleting from  file : " + e + " Msg : " + e.getMessage());
        }finally {

            if (fis!=null){
                fis.close();
            }

            if (readBookDataFromFile != null) {
                readBookDataFromFile.close();
            }
        }
//        return true;
    }

}
