package Frontend.BooksPanel.AddBookPanel;

import Backend.Listener.BookActionListener;
import Frontend.BookStore;

import javax.swing.*;
import java.awt.*;

/* Book cover panel */
public class BookCover extends JPanel {

    /* Main container */
    BookStore mainContainer;

    /*Action Listener clas*/
    BookActionListener bookActionListener;

    /* Component */
   public JLabel bookCoverImage;
   public JButton btnBrowseImage;

   /* For Book Cover path */
    public String bookCoverPath="src\\assets\\byDefaultCover.jpg";

    BookCover(BookStore mainContainer) {
        this.mainContainer = mainContainer;
        bookActionListener=new BookActionListener(mainContainer);

        bookCoverImage = new JLabel();
        bookCoverImage.setBounds(80, 20, 200, 250);
        ImageIcon test = new ImageIcon(bookCoverPath);
        Image img = test.getImage().getScaledInstance(bookCoverImage.getWidth(), bookCoverImage.getHeight(), Image.SCALE_SMOOTH);
        bookCoverImage.setIcon(new ImageIcon(img));
        this.add(bookCoverImage);

        ImageIcon browseIcon = new ImageIcon("src\\assets\\browseIcon.png");
        btnBrowseImage = new JButton("Cover", browseIcon);
        btnBrowseImage.setBounds(100, 290, 150, 35);
        btnBrowseImage.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
        btnBrowseImage.setForeground(Color.white);
        btnBrowseImage.setBackground(new Color(0, 103, 184));
        btnBrowseImage.addActionListener(bookActionListener);
        this.add(btnBrowseImage);



    }


}
