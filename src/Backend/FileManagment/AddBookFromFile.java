package Backend.FileManagment;

import Backend.Modal.BookDataClass;

import java.io.*;

public class AddBookFromFile {

   private static File dataFile;
    private static final String dataFilePath="src\\Data\\AllBooksData.dat";
    private static FileOutputStream fos=null;

    /* -- Method --*/
    public static void AddOneBookToFile(BookDataClass bookDataClass) throws IOException {

        try {

            dataFile = new File(dataFilePath);

            fos=new FileOutputStream(dataFilePath,true);

            /* Checking condition If File was written or not*/

            if (dataFile.length() == 0) {

                ObjectOutputStream addBookInFile=null;

                try {

                    /* Initialize Data Object file class */
                    addBookInFile = new ObjectOutputStream(fos);

                    /* Add One book Object in File*/
                    addBookInFile.writeObject(bookDataClass);

                    addBookInFile.flush();

                } catch (Exception e) {
                    System.out.println("Error in Adding in file once : " + e + " Msg : " + e.getMessage());
                } finally {
                    if (addBookInFile!=null){
                        addBookInFile.close();
                    }
                }

            }

            else {

                MyObjectOutputStream oos = null;

                try {
                    oos = new MyObjectOutputStream(fos);
                    oos.writeObject(bookDataClass);

                    oos.flush();

                } catch (Exception e) {
                    System.out.println("Error in Adding in file every time : " + e + " Msg : " + e.getMessage());
                }finally {
                    // Closing the FileOutputStream object
                    // to release memory resources
                    if (oos!=null){
                        oos.close();
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Error in Adding in file last : " + e + " Msg : " + e.getMessage());
        } finally {
             if (fos!=null){
                fos.close();
            }
        }

    }

}

/* This is a helper class which helps to remove Error when we're reading a file
    * like : Error in reading  file : java.io.StreamCorruptedException: invalid type code: AC Msg : invalid type code: AC
    * Taken from GFG : https://www.geeksforgeeks.org/how-to-fix-java-io-streamcorruptedexception-invalid-type-code-in-java/
    */
class MyObjectOutputStream extends ObjectOutputStream {

    // Constructor of this class
    // 1. Default
    MyObjectOutputStream() throws IOException
    {
        // Super keyword refers to parent class instance
        super();
    }

    // Constructor of this class
    // 1. Parameterized constructor
    MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    // Method of this class
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}