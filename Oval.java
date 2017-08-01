import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 29.07.17.
 */
public class Oval extends JComponent {

    public int count = 50;

    public int a = 5, b = 5, c, d;

    public Oval(int a, int b) {
        this.c = a;
        this.d = b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawOval(c,d,a,b);
    }
}
