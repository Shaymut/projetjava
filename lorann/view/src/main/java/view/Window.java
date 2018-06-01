package view;

import model.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class Window extends JFrame {
    private static final long serialVersionUID = 1L;

    public Window(String name, int x, int y, Element[][] mapNiveau) {
        super(name);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new Panel(x, y, mapNiveau), BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
}