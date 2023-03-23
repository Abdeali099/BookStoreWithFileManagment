package Backend.Listener;

import Frontend.BookStore;

import javax.swing.*;

public class WindowClosingListener {

    private static BookStore bookStore;

    public static void ValidateWindowClosing(BookStore bookStore) {
        WindowClosingListener.bookStore=bookStore;

        String title = bookStore.getTitle();

        if (title.charAt(0) == '*') {

            int userChoice = JOptionPane.showConfirmDialog(bookStore, "Maybe there is some unchanged data which can lost!! \n Are you want to save changes?", "Save unsaved changes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            /* userChoice :
            * 0 -> Yes
            * 1 -> No
            * other -> cancel
            * */
             if (userChoice==0) {
                BookActionListener bookActionListener=new BookActionListener(bookStore);
                bookActionListener.saveAllChanges(1);
             }
             else if (userChoice == 1) {
                 bookStore.dispose();
             }
             else {
                 bookStore.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
             }

        }
        else {
            bookStore.dispose();
        }

    }

}
