/* This Class Wake up main frontend page.*/

import Frontend.BookStore;

public class HomePage {

    public static void main(String[] args) {

        BookStore bs = new BookStore("BookStore");

        bs.setVisible(true);
        bs.setLocation(350, 100);
        bs.setSize(1000, 600);

    }

}