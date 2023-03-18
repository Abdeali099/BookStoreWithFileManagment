/* This is a Main Frontend Class */

package Frontend.BooksPanel.FilterBookPanel;
import Frontend.BookStore;

import javax.swing.*;
import java.awt.*;


public class BookFilterPanel extends JPanel {

    /* Main container */
    BookStore mainContainer;

    /* Component */

    JTextField tfSearchField;
    JButton btnSearch;
    ImageIcon searchIcon;
    DefaultListCellRenderer listRenderer;

    JComboBox<String> comboBoxFilter;

    public BookFilterPanel(BookStore mainContainer) {
        this.mainContainer=mainContainer;

        /* ComboBox for option */
        comboBoxFilter = new JComboBox<>();
        comboBoxFilter.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 18)); // NOI18N
        comboBoxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Book Name", "Author Name", "Publication" }));
        comboBoxFilter.setBounds(15,10,350,30);
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        comboBoxFilter.setRenderer(listRenderer);
        this.add(comboBoxFilter);

        /* Filter TextField */
        tfSearchField = new javax.swing.JTextField();
        tfSearchField.setFont(new java.awt.Font("Trebuchet MS",Font.PLAIN, 18));
        tfSearchField.setToolTipText("Enter data");
        tfSearchField.setBounds(385,10,400,30);
        this.add(tfSearchField);

         /* Search Button */
        searchIcon=new ImageIcon("src\\assets\\searchIcon.png");
        btnSearch=new JButton("Search",searchIcon);
        btnSearch.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
        btnSearch.setBounds(795,10,200,30);
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setBackground(new java.awt.Color(0, 103, 184));
        this.add(btnSearch);

    }




}

/* Table Panel */

