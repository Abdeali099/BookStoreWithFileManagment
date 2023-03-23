package Backend.Listener;

import Frontend.BookStore;
import com.raven.datechooser.DateChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class RowSelectionListener implements ListSelectionListener {

    private static BookStore bookStore;
    public static Vector test;
    public static int selectedRow=-1;

    public RowSelectionListener(BookStore bookStore) {
        RowSelectionListener.bookStore =bookStore;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {

        try {

            /* Which Row is selected*/
             selectedRow = bookStore.bookTable.bookTable.getSelectedRow();

             /* Data Of Row selected */
            if (!event.getValueIsAdjusting() && selectedRow != -1) {

                test = bookStore.bookTable.defaultTableModel.getDataVector().elementAt(bookStore.bookTable.bookTable.convertRowIndexToModel(bookStore.bookTable.bookTable.getSelectedRow()));

                /* Fill Text Field with data */

                bookStore.addBookPanel.tfBookID.setText(String.valueOf(test.get(0)));

                /* and Making ID Not Editable (ID can't change) */
                bookStore.addBookPanel.tfBookID.setEditable(false);
                Cursor cursor = Cursor.getSystemCustomCursor("Invalid.32x32");
                bookStore.addBookPanel.tfBookID.setCursor(cursor);

                bookStore.addBookPanel.tfBookName.setText(String.valueOf(test.get(1)));
                bookStore.addBookPanel.tfBookSubject.setText(String.valueOf(test.get(2)));
                bookStore.addBookPanel.tfAuthorName.setText(String.valueOf(test.get(3)));
                bookStore.addBookPanel.tfPublication.setText(String.valueOf(test.get(4)));

                DateChooser dateChooser = bookStore.addBookPanel.dateChooser;
                dateChooser.setTextRefernce(bookStore.addBookPanel.tfDatePublication);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(String.valueOf(test.get(5)));
                dateChooser.setSelectedDate(date);

                bookStore.addBookPanel.spBookPrice.setValue(test.get(6));
                bookStore.addBookPanel.spBookQuantity.setValue(test.get(7));
                bookStore.addBookPanel.tfTotalCost.setText(String.valueOf(test.get(8)));
                bookStore.addBookPanel.bookCover.bookCoverPath = String.valueOf(test.get(9));


                /* Taking reference from Frame*/
                JLabel bookCoverImage = bookStore.addBookPanel.bookCover.bookCoverImage;

                /* Setting Cover on Frame */
                ImageIcon bookCoverIcon = new ImageIcon(String.valueOf(test.get(9)));
                Image img = bookCoverIcon.getImage().getScaledInstance(bookCoverImage.getWidth(), bookCoverImage.getHeight(), Image.SCALE_SMOOTH);
                bookCoverImage.setIcon(new ImageIcon(img));

            }

        } catch (Exception e) {
//            System.out.println("Error at List selection : " + e + " Msg : " + e.getMessage());
            System.out.println(e);
        }
    }

}
