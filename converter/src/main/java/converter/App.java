package converter;

import main.java.view;
import main.java.view.View;

import javax.swing.JFrame;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        View mainView = new View();

        mainView.setVisible(true);

        System.out.println("Hello World!");
    }
}
