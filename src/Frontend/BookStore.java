/* This is a Main Frontend Class */

package Frontend;

import javax.swing.*;
import java.awt.*;

public class BookStore extends JFrame {

    /* Component */
    Container container;
    JPanel mainPanel;
    JScrollPane mainScrollPane;

    /* Variable */

    public BookStore(String frameTitle) {
        super(frameTitle);

        /* By default step*/
        container=getContentPane();
//        container.setLayout(null);

        /* INFO COMMENT : Creating main 2 Container :-
        * jPanel
        * jScrollPan
        * -> jPanel Will hold jScrollPane */

        /* Step 1 : Creating JPanel - Main Panel */
        mainPanel =new JPanel();
        mainPanel.setBounds(0,0,500,500);
        mainPanel.setVisible(true);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.cyan);

        container.add(mainPanel);

        /* Step 2 : Creating JScrollPane - Main ScrollPane */
        mainScrollPane=new JScrollPane(mainPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainPanel.setBounds(0,0,500,500);
        mainPanel.setBorder(BorderFactory.createEmptyBorder());

        container.add(mainScrollPane);


        /* Temporary closing event */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
