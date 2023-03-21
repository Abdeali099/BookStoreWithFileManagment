package Frontend.BooksPanel.AvialableBook;

import Frontend.BookStore;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookTable extends JPanel {

    /* Main container */
    BookStore mainContainer;

    /* Component */
//    String[][] data = {{"101", "abc", "OS", "Abdeali", "Mat", "25/12/2002", "200", "1", "200", "cover"}};
    String[] column = {"ID", "BOOK NAME", "BOOK SUBJECT", "AUTHOR NAME", "PUBLICATION", "DATE", "PRICE", "QUANTITY", "TOTAL COST", "COVER"};
    public DefaultTableModel defaultTableModel;
    public JTable bookTable;
    JScrollPane jspBookTable;

    public BookTable(BookStore mainContainer) {
        this.mainContainer = mainContainer;

        defaultTableModel = new DefaultTableModel(column,0);
        bookTable = new JTable(defaultTableModel);
        bookTable.setVisible(true);

        jspBookTable = new JScrollPane(bookTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspBookTable.setBounds(0, 0, 1500, 400);

        this.add(jspBookTable);
        validate();
    }

}
