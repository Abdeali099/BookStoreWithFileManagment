package Backend.FileManagment;

import Backend.Modal.BookDataClass;

import java.io.*;
import java.util.ArrayList;

public class ReadBookFromFile {

    private static final String dataFilePath = "src\\Data\\AllBooksData.dat";
    private static ArrayList<BookDataClass> arrayListBookDataClass;

    private static FileInputStream fis =null;
    private static ObjectInputStream readBookDataFromFile = null;

    public static ArrayList<BookDataClass> fetchAllStoredDataFromFile() throws IOException {

        try {

            File f=new File(dataFilePath);
             fis = new FileInputStream(dataFilePath);
             readBookDataFromFile = new ObjectInputStream(fis);
            arrayListBookDataClass=new ArrayList<>();

            if (f.length()!=0) {
                arrayListBookDataClass = (ArrayList<BookDataClass>) readBookDataFromFile.readObject();
            }

        } catch (EOFException ignored) {
            System.out.println("File is Empty");
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
