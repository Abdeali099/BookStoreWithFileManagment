/* This is a Main Frontend Class */

package Frontend;

import javax.swing.*;
import java.awt.*;

/* It is a Main Frame */
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
        mainHeading.setBounds(740, 20, 500, 36);

        mainPanel.add(mainHeading);

        /* Step 4 : adding Add Book  Form (Whole  Panel) */
        addBookPanel=new AddBookPanel(this);
        addBookPanel.setLayout(null);
        addBookPanel.setVisible(true);
        addBookPanel.setBounds(50,70,1500,500);
        addBookPanel.setBackground(new java.awt.Color(240, 240, 140));
        addBookPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.darkGray, java.awt.Color.black, java.awt.Color.darkGray));
        addBookPanel.setForeground(new java.awt.Color(25, 0, 0));

        mainPanel.add(addBookPanel);
        /* Temporary closing event */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

/* It is a Form (Operation)  Frame */
class AddBookPanel extends JPanel {

    /* Classes */
    BookStore mainContainer;

      /* Component */
      public JLabel lbBookID,lbBookName,lbBookSubject,lbAuthorName,lbPublication,lbDatePublication,lbBookPrice,lbBookQuantity,lbTotalCost;
      public  JTextField tfBookID,tfBookName,tfBookSubject,tfAuthorName,tfPublication,tfDatePublication,tfTotalCost;
      public JSpinner spBookPrice,spBookQuantity;
      SpinnerModel valueOfPrice,valueOfQuantity;
      public JButton btnAdd,btnCancle,btnDelete;


    public AddBookPanel(BookStore mainContainer) {
        this.mainContainer=mainContainer;

        /* Step : Adding Label - TextField */

        /* Input 1 : Book ID */
        lbBookID = new JLabel();
        lbBookID.setText("Book ID");
        lbBookID.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookID.setBounds(80,20,100,35);
        this.add(lbBookID);

        tfBookID = new JTextField();
        tfBookID.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookID.setBounds(190,20,320,30);
        tfBookID.setToolTipText("Eg. 101");
        this.add(tfBookID);

        /* Input 2 : Book Name */
        lbBookName = new JLabel();
        lbBookName.setText("Book Name");
        lbBookName.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookName.setBounds(580,20,150,35);
        this.add(lbBookName);

        tfBookName = new JTextField();
        tfBookName.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookName.setBounds(710,20,320,30);
        tfBookName.setToolTipText("Eg. Modern Operating System");
        this.add(tfBookName);

        /* Input 3 : Book Subject */
        lbBookSubject = new JLabel();
        lbBookSubject.setText("Book Subject");
        lbBookSubject.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookSubject.setBounds(50,90,250,35);
        this.add(lbBookSubject);

        tfBookSubject = new JTextField();
        tfBookSubject.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookSubject.setBounds(190,90,320,30);
        tfBookSubject.setToolTipText("Eg. Operating System");
        this.add(tfBookSubject);


        /* Input 4 : Author Name */
        lbAuthorName = new JLabel();
        lbAuthorName.setText("Author Name");
        lbAuthorName.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbAuthorName.setBounds(570,90,150,35);
        this.add(lbAuthorName);

        tfAuthorName = new JTextField();
        tfAuthorName.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfAuthorName.setBounds(710,90,320,30);
        tfAuthorName.setToolTipText("Eg. Andrew Tanenbum");
        this.add(tfAuthorName);

        /* Input 5 : publication */
        lbPublication = new JLabel();
        lbPublication.setText("Publication");
        lbPublication.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbPublication.setBounds(50,160,250,35);
        this.add(lbPublication);

        tfPublication = new JTextField();
        tfPublication.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfPublication.setBounds(190,160,320,30);
        tfPublication.setToolTipText("Eg. Matrix ");
        this.add(tfPublication);

        /* Input 6 : Date of Publication */
        lbDatePublication = new JLabel();
        lbDatePublication.setText("Date Publication");
        lbDatePublication.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbDatePublication.setBounds(550,160,150,35);
        this.add(lbDatePublication);

        tfDatePublication = new JTextField();
        tfDatePublication.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfDatePublication.setBounds(710,160,320,30);
        tfDatePublication.setToolTipText("Eg. 30/01/2002");
        this.add(tfDatePublication);

        /* Input 7 : Price Of Book */
        lbBookPrice = new JLabel();
        lbBookPrice.setText("Book Price");
        lbBookPrice.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookPrice.setBounds(50,240,250,35);
        this.add(lbBookPrice);

        valueOfPrice = new SpinnerNumberModel(200, 200, 1500, 1);
        spBookPrice = new JSpinner(valueOfPrice);
        spBookPrice.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        spBookPrice.setBounds(150,240,100,30);
        this.add(spBookPrice);

        /* Input 8 : Quantity Of Book */
        lbBookQuantity = new JLabel();
        lbBookQuantity.setText("Book Quantity");
        lbBookQuantity.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookQuantity.setBounds(280,240,250,35);
        this.add(lbBookQuantity);

        valueOfQuantity = new SpinnerNumberModel(1, 0, 250, 1);
        spBookQuantity = new JSpinner(valueOfQuantity);
        spBookQuantity.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        spBookQuantity.setBounds(420,240,100,30);
        this.add(spBookQuantity);

        /* Input 8 : Total Cost Of Book ( TotalCost = Price * Quantity) */
        lbTotalCost = new JLabel();
        lbTotalCost.setText("Total Cost");
        lbTotalCost.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbTotalCost.setBounds(585,240,250,35);
        this.add(lbTotalCost);

        tfTotalCost = new JTextField();
        tfTotalCost.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfTotalCost.setBounds(710,240,320,30);
        tfTotalCost.setEditable(false);
        this.add(tfTotalCost);


    }
}

class operationButtonPanel extends JPanel {

}

class LabelsInBookStore extends JLabel {

}