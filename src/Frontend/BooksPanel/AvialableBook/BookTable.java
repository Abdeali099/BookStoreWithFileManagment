package Frontend.BooksPanel.AvialableBook;

import Backend.Listener.RowSelectionListener;
import Frontend.BookStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class BookTable extends JPanel {

    /* Main container */
    BookStore mainContainer;

    /* Component */
    public DefaultTableModel defaultTableModel;
    public JTable bookTable;
    JScrollPane jspBookTable;

    /* Selection Listener */
    RowSelectionListener rowSelectionListener;

    /* Variables */
    String[] column = {"ID", "BOOK NAME", "BOOK SUBJECT", "AUTHOR NAME", "PUBLICATION", "DATE", "PRICE", "QUANTITY", "TOTAL COST", "COVER"};

    public BookTable(BookStore mainContainer) {
        this.mainContainer = mainContainer;

        /* Initialize listener */
        rowSelectionListener=new RowSelectionListener(mainContainer);

        this.setPreferredSize(new Dimension(1400, 400));

        {
            defaultTableModel = new DefaultTableModel(column, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;  //all cells are not editable!
                }
            };
        }

        bookTable = new JTable(defaultTableModel);
        bookTable.setVisible(true);
        bookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); /* Select Only One Row at a time */
        bookTable.getSelectionModel().addListSelectionListener(rowSelectionListener);
        bookTable.setRowHeight(60);

        /* Modifying for store the image in row*/
        bookTable.getColumn("COVER").setCellRenderer(new MyTableCellRender());
        TableColumn tableColumn=bookTable.getColumn("COVER");
        tableColumn.setMaxWidth(120);
        tableColumn.setMinWidth(120);

        jspBookTable = new JScrollPane(bookTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspBookTable.setBounds(0, 0, 1500, 400);

        this.add(jspBookTable);
        validate(); /* At loading Table visible */
    }

}

class MyTableCellRender implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        return (Component) value;
    }
}
