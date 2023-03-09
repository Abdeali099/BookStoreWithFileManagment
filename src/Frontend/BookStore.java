/* This is a Main Frontend Class */

package Frontend;

import javax.swing.*;
import java.awt.*;

public class BookStore extends JFrame {

    /* Component */
    Container container;
    JPanel mainPanel;
    JScrollPane mainScrollPane;

    JLabel mainHeading;

    /* Variable */

    public BookStore(String frameTitle) {
        super(frameTitle);

        /* By default, step*/
        container=getContentPane();
//        container.setLayout(null);

        /* INFO COMMENT : Creating main 2 Container :-
        * jPanel
        * jScrollPan
        * -> jPanel Will hold jScrollPane */

        /* Step 1 : Creating JPanel - Main Panel */
        mainPanel =new JPanel();
        mainPanel.setBounds(0,0,1000,1000); /* Faulty Operation (Not correct dimension) */
        mainPanel.setVisible(true);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.cyan);

        container.add(mainPanel);

        /* Step 2 : Creating JScrollPane - Main ScrollPane */
        mainScrollPane=new JScrollPane(mainPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainScrollPane.setBorder(BorderFactory.createEmptyBorder());

        container.add(mainScrollPane);

        /* Step 3 : Adding Main Heading */
        mainHeading = new JLabel();
        mainHeading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        mainHeading.setText("Admin Panel");
        mainHeading.setBounds(740,0,500,36);

        mainPanel.add(mainHeading);

        /* Temporary closing event */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
