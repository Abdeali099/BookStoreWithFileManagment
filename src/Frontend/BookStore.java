/* This is a Main Frontend Class */

package Frontend;

import javax.swing.*;
import java.awt.*;

/* It is a Main Frame */
public class BookStore extends JFrame {

    /* Component */
    public  JPanel mainPanel;
    public JScrollPane mainScrollPane;
    public JLabel mainHeading,miniHeadingMaintain;

    /* Manual Component */
    public AddBookPanel addBookPanel;

    /* Variable */

    public BookStore(String frameTitle) {
        super(frameTitle);

        this.setLayout(null);

        /* Step 1 : Creating JPanel - Main Panel */
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new java.awt.Color(0, 103, 184));
        mainPanel.setPreferredSize(new Dimension(1500,1500)); /* Very Important : from this We get ScrollBar */
        this.add(mainPanel);

        /* Step 2 : Creating JScrollPane - Main ScrollPane */
        mainScrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainScrollPane.setBounds(0, 0, 1600, 838); /* Faulty Operation (Not correct dimension) */
        mainScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(mainScrollPane);

        /* Step 3 : Adding Main Heading */
        mainHeading = new JLabel();
        mainHeading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        mainHeading.setText("Admin Panel");
        mainHeading.setForeground(new java.awt.Color(255, 255, 255));
        mainHeading.setBounds(700, 20, 500, 36);
        mainPanel.add(mainHeading);

        /* Step : adding a mini heading : Maintain */
        miniHeadingMaintain = new JLabel();
        miniHeadingMaintain.setText("--- Maintain Book ---");
        miniHeadingMaintain.setFont(new java.awt.Font("Yu Gothic UI Bold", Font.BOLD, 18)); // NOI18N
        miniHeadingMaintain.setForeground(new java.awt.Color(255, 255, 255));
        miniHeadingMaintain.setBounds(45,45,200,35);
        mainPanel.add(miniHeadingMaintain);

        /* Step 4 : adding Add Book  Form (Whole  Panel) */
        addBookPanel=new AddBookPanel(this);
        addBookPanel.setLayout(null);
        addBookPanel.setVisible(true);
        addBookPanel.setBounds(40,90,1500,400);
        addBookPanel.setBackground(new java.awt.Color(240, 240, 140, 185));
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
    public JLabel lbBookID, lbBookName, lbBookSubject, lbAuthorName, lbPublication, lbDatePublication, lbBookPrice, lbBookQuantity, lbTotalCost;
    public JTextField tfBookID, tfBookName, tfBookSubject, tfAuthorName, tfPublication, tfDatePublication, tfTotalCost;
    public JSpinner spBookPrice, spBookQuantity;
    SpinnerModel valueOfPrice, valueOfQuantity;

    /* Button Panel*/
    OperationButtonPanel operationButtonPanel;
    /* Image Panel*/
    BookCover bookCover;

    public AddBookPanel(BookStore mainContainer) {
        this.mainContainer = mainContainer;

        /* Step : Adding Label - TextField */

        /* Input 1 : Book ID */
        lbBookID = new JLabel();
        lbBookID.setText("Book ID");
        lbBookID.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookID.setBounds(80, 20, 100, 35);
        this.add(lbBookID);

        tfBookID = new JTextField();
        tfBookID.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookID.setBounds(190, 20, 320, 30);
        tfBookID.setToolTipText("Eg. 101");
        this.add(tfBookID);

        /* Input 2 : Book Name */
        lbBookName = new JLabel();
        lbBookName.setText("Book Name");
        lbBookName.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookName.setBounds(580, 20, 150, 35);
        this.add(lbBookName);

        tfBookName = new JTextField();
        tfBookName.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookName.setBounds(710, 20, 320, 30);
        tfBookName.setToolTipText("Eg. Modern Operating System");
        this.add(tfBookName);

        /* Input 3 : Book Subject */
        lbBookSubject = new JLabel();
        lbBookSubject.setText("Book Subject");
        lbBookSubject.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookSubject.setBounds(50, 90, 250, 35);
        this.add(lbBookSubject);

        tfBookSubject = new JTextField();
        tfBookSubject.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookSubject.setBounds(190, 90, 320, 30);
        tfBookSubject.setToolTipText("Eg. Operating System");
        this.add(tfBookSubject);


        /* Input 4 : Author Name */
        lbAuthorName = new JLabel();
        lbAuthorName.setText("Author Name");
        lbAuthorName.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbAuthorName.setBounds(570, 90, 150, 35);
        this.add(lbAuthorName);

        tfAuthorName = new JTextField();
        tfAuthorName.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfAuthorName.setBounds(710, 90, 320, 30);
        tfAuthorName.setToolTipText("Eg. Andrew Tanenbum");
        this.add(tfAuthorName);

        /* Input 5 : publication */
        lbPublication = new JLabel();
        lbPublication.setText("Publication");
        lbPublication.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbPublication.setBounds(50, 160, 250, 35);
        this.add(lbPublication);

        tfPublication = new JTextField();
        tfPublication.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfPublication.setBounds(190, 160, 320, 30);
        tfPublication.setToolTipText("Eg. Matrix ");
        this.add(tfPublication);

        /* Input 6 : Date of Publication */
        lbDatePublication = new JLabel();
        lbDatePublication.setText("Date Publication");
        lbDatePublication.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbDatePublication.setBounds(550, 160, 150, 35);
        this.add(lbDatePublication);

        tfDatePublication = new JTextField();
        tfDatePublication.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfDatePublication.setBounds(710, 160, 320, 30);
        tfDatePublication.setToolTipText("Eg. 30/01/2002");
        this.add(tfDatePublication);

        /* Input 7 : Price Of Book */
        lbBookPrice = new JLabel();
        lbBookPrice.setText("Book Price");
        lbBookPrice.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookPrice.setBounds(50, 240, 250, 35);
        this.add(lbBookPrice);

        valueOfPrice = new SpinnerNumberModel(200, 200, 1500, 1);
        spBookPrice = new JSpinner(valueOfPrice);
        spBookPrice.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        spBookPrice.setBounds(150, 240, 100, 30);
        this.add(spBookPrice);

        /* Input 8 : Quantity Of Book */
        lbBookQuantity = new JLabel();
        lbBookQuantity.setText("Book Quantity");
        lbBookQuantity.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookQuantity.setBounds(280, 240, 250, 35);
        this.add(lbBookQuantity);

        valueOfQuantity = new SpinnerNumberModel(1, 0, 250, 1);
        spBookQuantity = new JSpinner(valueOfQuantity);
        spBookQuantity.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        spBookQuantity.setBounds(420, 240, 100, 30);
        this.add(spBookQuantity);

        /* Input 8 : Total Cost Of Book ( TotalCost = Price * Quantity) */
        lbTotalCost = new JLabel();
        lbTotalCost.setText("Total Cost");
        lbTotalCost.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbTotalCost.setBounds(585, 240, 250, 35);
        this.add(lbTotalCost);

        tfTotalCost = new JTextField();
        tfTotalCost.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfTotalCost.setBounds(710, 240, 320, 30);
        tfTotalCost.setEditable(false);
        this.add(tfTotalCost);

        /* Adding Button Panel */
        operationButtonPanel=new OperationButtonPanel(mainContainer);
        operationButtonPanel.setBackground(new java.awt.Color(174, 202, 153, 255));
        operationButtonPanel.setBounds(40,320,1000,40);
        operationButtonPanel.setLayout(new GridLayout(1, 4, 20, 25));
        this.add(operationButtonPanel);

        /* Book cover Panel */
        bookCover=new BookCover(mainContainer);
        bookCover.setBounds(1090,20,350,350);
        bookCover.setBackground(new java.awt.Color(174, 202, 153, 255));
        bookCover.setLayout(null);
        this.add(bookCover);


    }
}

/* It contains Operational Button */
class OperationButtonPanel extends JPanel {

    /* Main frame */
    BookStore mainContainer;

    /* Component */
    public JButton btnAdd,btnCancel,btnDelete,btnUpdate;
    ImageIcon addIcon,updateIcon, cancelIcon,deleteIcon;

    OperationButtonPanel(BookStore mainContainer) {
        this.mainContainer=mainContainer;

        /* Button 1 : Add */
        addIcon=new ImageIcon("src\\assets\\addIcon.png");
        btnAdd=new JButton("Add",addIcon);
        btnAdd.setFont(new Font("Arial Rounded MT", Font.PLAIN, 22));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setBackground(new java.awt.Color(0, 103, 184));
//        btnAdd.setBounds(50,50,200,30);
        this.add(btnAdd);

        /* Button 2 : Update */
        updateIcon=new ImageIcon("src\\assets\\updateIcon.png");
        btnUpdate=new JButton("Update",updateIcon);
        btnUpdate.setFont(new Font("Arial Rounded MT", Font.PLAIN, 22));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setBackground(new java.awt.Color(0, 103, 184));
//        btnUpdate.setBounds(50,50,200,30);
        this.add(btnUpdate);

        /* Button 3 : Delete */
        deleteIcon=new ImageIcon("src\\assets\\deleteIcon.png");
        btnDelete=new JButton("Delete",deleteIcon);
        btnDelete.setFont(new Font("Arial Rounded MT", Font.PLAIN, 22));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setBackground(new java.awt.Color(0, 103, 184));
//        btnDelete.setBounds(50,50,200,30);
        this.add(btnDelete);

        /* Button 4 : Clear */
        cancelIcon=new ImageIcon("src\\assets\\cancelIcon.png");
        btnCancel=new JButton("Cancel",cancelIcon);
        btnCancel.setFont(new Font("Arial Rounded MT", Font.PLAIN, 22));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setBackground(new java.awt.Color(0, 103, 184));
//        btnCancel.setBounds(50,50,200,30);
        this.add(btnCancel);


    }


}

/* Book cover panel */
class BookCover extends JPanel {

    /* Main container */
    BookStore mainContainer;

    /* Component */
    JLabel bookCoverImage;
    JButton btnBrowseImage;


    BookCover(BookStore mainContainer) {
        this.mainContainer=mainContainer;


        bookCoverImage=new JLabel();
        bookCoverImage.setBounds(80,20,200,250);
        ImageIcon test=new ImageIcon("src\\assets\\bookCover.png");
        Image img=test.getImage().getScaledInstance(bookCoverImage.getWidth(),bookCoverImage.getHeight(),Image.SCALE_SMOOTH);
        bookCoverImage.setIcon(new ImageIcon(img));
        this.add(bookCoverImage);

        ImageIcon browseIcon=new ImageIcon("src\\assets\\browseIcon.png");
        btnBrowseImage=new JButton("Cover",browseIcon);
        btnBrowseImage.setBounds(100,290,150,35);
        btnBrowseImage.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
        btnBrowseImage.setForeground(new java.awt.Color(255, 255, 255));
        btnBrowseImage.setBackground(new java.awt.Color(0, 103, 184));
        this.add(btnBrowseImage);
    }


}