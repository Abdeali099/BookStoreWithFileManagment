package Frontend.BooksPanel.AvialableBook;

import Frontend.BookStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookTable extends JPanel {

    /* Main container */
    BookStore mainContainer;

    /* Component */
    public DefaultTableModel defaultTableModel;
    public JTable bookTable;
    JScrollPane jspBookTable;

    /* Variables */
    String[] column = {"ID", "BOOK NAME", "BOOK SUBJECT", "AUTHOR NAME", "PUBLICATION", "DATE", "PRICE", "QUANTITY", "TOTAL COST", "COVER"};

    public BookTable(BookStore mainContainer) {
        this.mainContainer = mainContainer;
        this.setPreferredSize(new Dimension(1400,400));

        {
            defaultTableModel = new DefaultTableModel(column, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
        }

        bookTable = new JTable(defaultTableModel);
        bookTable.setVisible(true);

        jspBookTable = new JScrollPane(bookTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspBookTable.setBounds(0, 0, 1500, 400);

        this.add(jspBookTable);
        validate();
    }

}
