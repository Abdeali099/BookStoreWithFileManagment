package Frontend.BooksPanel.AddBookPanel;

import Frontend.BookStore;

import javax.swing.*;
import java.awt.*;

/* Book cover panel */
public class BookCover extends JPanel {

    /* Main container */
    BookStore mainContainer;

    /* Component */
    JLabel bookCoverImage;
    JButton btnBrowseImage;


    BookCover(BookStore mainContainer) {
        this.mainContainer = mainContainer;


        bookCoverImage = new JLabel();
        bookCoverImage.setBounds(80, 20, 200, 250);
        ImageIcon test = new ImageIcon("src\\assets\\bookCover.png");
        Image img = test.getImage().getScaledInstance(bookCoverImage.getWidth(), bookCoverImage.getHeight(), Image.SCALE_SMOOTH);
        bookCoverImage.setIcon(new ImageIcon(img));
        this.add(bookCoverImage);

        ImageIcon browseIcon = new ImageIcon("src\\assets\\browseIcon.png");
        btnBrowseImage = new JButton("Cover", browseIcon);
        btnBrowseImage.setBounds(100, 290, 150, 35);
        btnBrowseImage.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
//        btnBrowseImage.setBackground(new java.awt.Color(240, 240, 140, 185));
        btnBrowseImage.setForeground(Color.white);
        btnBrowseImage.setBackground(new Color(0, 103, 184));
        this.add(btnBrowseImage);
    }


}
