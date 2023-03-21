package Backend.FileManagment;

import Backend.Modal.BookDataClass;

import java.io.*;

public class AddBookFromFile {

//   ObjectOutputStream addBookInFile;
   private static File dataFile;
    private static final String dataFilePath="src\\Data\\AllBooksData.dat";

    public static void AddOneBookToFile(BookDataClass bookDataClass) {

        try {

            System.out.println("3) I am in FileBook");

            dataFile = new File(dataFilePath);

            FileOutputStream fos=null;
            fos=new FileOutputStream(dataFilePath,true);

            /* Checking condition If File was written or not*/

            if (dataFile.length() == 0) {

                /* Initialize Data Object file class */
                ObjectOutputStream addBookInFile = new ObjectOutputStream(fos);

                /* Add One book Object in File*/
                addBookInFile.writeObject(bookDataClass);

                /* Closing file*/
                addBookInFile.close();
            }

            else {

                MyObjectOutputStream oos = null;
                oos = new MyObjectOutputStream(fos);
                oos.writeObject(bookDataClass);

                // Closing the FileOutputStream object
                // to release memory resources
                oos.close();
            }

            fos.close();

        } catch (Exception e) {
            System.out.println("Error in Adding in file : " + e + " Msg : " + e.getMessage());
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
