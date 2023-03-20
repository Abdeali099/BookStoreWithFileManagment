package Frontend.BooksPanel.AddBookPanel;

import Backend.Listener.BookActionListener;
import Frontend.BookStore;
import com.raven.datechooser.DateChooser;

import javax.swing.*;
import java.awt.*;

/* It is a Form (Operation)  Frame */
public class AddBookPanel extends JPanel {

    /* Classes */
    BookStore mainContainer;

    /*Action Listener clas*/
    BookActionListener bookActionListener;

    /* Component */
    public JLabel lbBookID, lbBookName, lbBookSubject, lbAuthorName, lbPublication, lbDatePublication, lbBookPrice, lbBookQuantity, lbTotalCost;
    public JTextField tfBookID, tfBookName, tfBookSubject, tfAuthorName, tfPublication, tfDatePublication, tfTotalCost;
    public JSpinner spBookPrice, spBookQuantity;
    SpinnerModel valueOfPrice, valueOfQuantity;
    public ImageIcon calenderIcon;
    public JButton btnCalender;

    /* Button Panel*/
    public OperationButtonPanel operationButtonPanel;
    /* Image Panel*/
    public BookCover bookCover;

    public AddBookPanel(BookStore mainContainer) {
        this.mainContainer = mainContainer;


        /* Intialize Listener */
        bookActionListener = new BookActionListener(mainContainer);

        /* Step : Adding Label - TextField */

        /* Input 1 : Book ID */
        lbBookID = new JLabel();
        lbBookID.setText("Book ID");
        lbBookID.setFont(new java.awt.Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookID.setBounds(80, 20, 100, 35);
        this.add(lbBookID);

        tfBookID = new JTextField();
        tfBookID.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookID.setBounds(190, 20, 320, 30);
        tfBookID.setToolTipText("Eg. 101");
        this.add(tfBookID);

        /* Input 2 : Book Name */

        lbBookName = new JLabel();
        lbBookName.setText("Book Name");
        lbBookName.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookName.setBounds(580, 20, 150, 35);
        this.add(lbBookName);

        tfBookName = new JTextField();
        tfBookName.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookName.setBounds(710, 20, 320, 30);
        tfBookName.setToolTipText("Eg. Modern Operating System");
        this.add(tfBookName);

        /* Input 3 : Book Subject */
        lbBookSubject = new JLabel();
        lbBookSubject.setText("Book Subject");
        lbBookSubject.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookSubject.setBounds(50, 90, 250, 35);
        this.add(lbBookSubject);

        tfBookSubject = new JTextField();
        tfBookSubject.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfBookSubject.setBounds(190, 90, 320, 30);
        tfBookSubject.setToolTipText("Eg. Operating System");
        this.add(tfBookSubject);


        /* Input 4 : Author Name */
        lbAuthorName = new JLabel();
        lbAuthorName.setText("Author Name");
        lbAuthorName.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbAuthorName.setBounds(570, 90, 150, 35);
        this.add(lbAuthorName);

        tfAuthorName = new JTextField();
        tfAuthorName.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfAuthorName.setBounds(710, 90, 320, 30);
        tfAuthorName.setToolTipText("Eg. Andrew Tanenbum");
        this.add(tfAuthorName);

        /* Input 5 : publication */
        lbPublication = new JLabel();
        lbPublication.setText("Publication");
        lbPublication.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbPublication.setBounds(50, 160, 250, 35);
        this.add(lbPublication);

        tfPublication = new JTextField();
        tfPublication.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfPublication.setBounds(190, 160, 320, 30);
        tfPublication.setToolTipText("Eg. Matrix ");
        this.add(tfPublication);

        /* Input 6 : Date of Publication */
        lbDatePublication = new JLabel();
        lbDatePublication.setText("Date Publication");
        lbDatePublication.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbDatePublication.setBounds(550, 160, 150, 35);
        this.add(lbDatePublication);

        tfDatePublication = new JTextField();
        tfDatePublication.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfDatePublication.setBounds(710, 160, 285, 30);
        tfDatePublication.setToolTipText("Eg. 30-01-2002");
        this.add(tfDatePublication);

        calenderIcon = new ImageIcon("src\\assets\\calenderIcon.png");
        btnCalender = new JButton(calenderIcon);
        btnCalender.setBounds(1000, 160, 32, 32);
        this.add(btnCalender);

        DateChooser dateChooser = new DateChooser();
        dateChooser.setTextRefernce(tfDatePublication);
        dateChooser.setForeground(new Color(0, 103, 184));

        btnCalender.addActionListener(event -> {
            dateChooser.showPopup();
        });

        /* Input 7 : Price Of Book */
        lbBookPrice = new JLabel();
        lbBookPrice.setText("Book Price");
        lbBookPrice.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookPrice.setBounds(50, 240, 250, 35);
        this.add(lbBookPrice);

        valueOfPrice = new SpinnerNumberModel(200, 200, 1500, 1);
        spBookPrice = new JSpinner(valueOfPrice);
        spBookPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        spBookPrice.setBounds(150, 240, 100, 30);
        this.add(spBookPrice);

        /* Input 8 : Quantity Of Book */
        lbBookQuantity = new JLabel();
        lbBookQuantity.setText("Book Quantity");
        lbBookQuantity.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbBookQuantity.setBounds(280, 240, 250, 35);
        this.add(lbBookQuantity);

        valueOfQuantity = new SpinnerNumberModel(1, 0, 250, 1);
        spBookQuantity = new JSpinner(valueOfQuantity);
        spBookQuantity.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        spBookQuantity.setBounds(420, 240, 100, 30);
        this.add(spBookQuantity);

        /* Input 8 : Total Cost Of Book ( TotalCost = Price * Quantity) */
        lbTotalCost = new JLabel();
        lbTotalCost.setText("Total Cost");
        lbTotalCost.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        lbTotalCost.setBounds(585, 240, 250, 35);
        this.add(lbTotalCost);

        tfTotalCost = new JTextField();
        tfTotalCost.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        tfTotalCost.setBounds(710, 240, 320, 30);
        tfTotalCost.setEditable(false);
        this.add(tfTotalCost);

        /* Adding Button Panel */
        operationButtonPanel = new OperationButtonPanel(mainContainer);
        operationButtonPanel.setBackground(new Color(174, 202, 153, 255));
        operationButtonPanel.setBounds(40, 320, 1000, 40);
        operationButtonPanel.setLayout(new GridLayout(1, 4, 20, 25));
        this.add(operationButtonPanel);

        /* Book cover Panel */
        bookCover = new BookCover(mainContainer);
        bookCover.setBounds(1090, 20, 350, 350);
        bookCover.setBackground(new Color(177, 190, 132, 255));
        bookCover.setLayout(null);
        this.add(bookCover);


    }
}
