/* This is a Main Frontend Class */

package Frontend;

import javax.swing.*;
import java.awt.*;

public class BookStore extends JFrame {

    /* Component */
   public Container container;
    public  JPanel mainPanel;
    public JScrollPane mainScrollPane;
    public JLabel mainHeading;

    /* Manual Component */
    public AddBookPanel addBookPanel;

    /* Variable */

    public BookStore(String frameTitle) {
        super(frameTitle);

        /* By default, step*/
        container = getContentPane(); /* Didn't do container.setLayout=null so if any problem occurs check this. */

        /* INFO COMMENT : Creating main 2 Container :-
         * jPanel : mainPanel
         * jScrollPane : mainScrollPane
         * -> container(jFrame) Will hold mainScrollPane , and mainScrollPane will be used for mainPanel */

        /* Step 1 : Creating JPanel - Main Panel */
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1000, 1000); /* Faulty Operation (Not correct dimension) */
        mainPanel.setVisible(true);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.cyan);

        container.add(mainPanel);

        /* Step 2 : Creating JScrollPane - Main ScrollPane */
        mainScrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainScrollPane.setBorder(BorderFactory.createEmptyBorder());

        container.add(mainScrollPane);

        /* Step 3 : Adding Main Heading */
        mainHeading = new JLabel();
        mainHeading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        mainHeading.setText("Admin Panel");
        mainHeading.setBounds(740, 0, 500, 36);

        mainPanel.add(mainHeading);

        /* Step 4 : adding Add Book  Form (Whole  Panel) */
        addBookPanel=new AddBookPanel(this);
        addBookPanel.setLayout(null);
        addBookPanel.setVisible(true);
        addBookPanel.setBounds(50,50,1500,500);
        addBookPanel.setBackground(new java.awt.Color(240, 240, 140));
        addBookPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.darkGray, java.awt.Color.black, java.awt.Color.darkGray));
        addBookPanel.setForeground(new java.awt.Color(25, 0, 0));

        mainPanel.add(addBookPanel);
        /* Temporary closing event */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class AddBookPanel extends JPanel {

    /* Classes */
    BookStore mainContainer;

      /* Component */
      public  JTextField tfBookID,tfBookName,tfBookSubject,tfAuthorName,tfPublication,tfTotalCost;
      public JLabel lbBookID,lbBookName,lbBookSubject,lbAuthorName,lbPublication,lbTotalCost;
      public JButton btnAdd,btnCancle,btnDelete;

    public AddBookPanel(BookStore mainContainer) {
        this.mainContainer=mainContainer;

        /* Step : Adding Label - TextField */

        /* Input 1 : Book ID */
        lbBookID = new JLabel();
        lbBookID.setText("ID");
        lbBookID.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookID.setBounds(50,10,50,35);
        this.add(lbBookID);

        tfBookID = new JTextField();
        tfBookID.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookID.setBounds(100,10,222,30);
        tfBookID.setToolTipText("Eg. 101");
        this.add(tfBookID);



    }
}
