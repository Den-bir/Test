import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Admin on 29.07.17.
 */
public class Game extends JPanel implements Serializable{

    public static transient Logger logger = Logger.getLogger(Game.class);

    private List<Oval> ovalList = new CopyOnWriteArrayList<>();

    public Game(){
        Init init = new Init();
        init.init();
        //run();
    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException{
        s.defaultReadObject();
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
    }

    public void run(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.add(this);
        f.setResizable(false);
        f.setVisible(true);

        f.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                try{
                    Thread.sleep(5);
                    ovalList.add(new Oval(e.getX()-4, e.getY()-25));
                }
                catch (Exception g){
                    g.printStackTrace();
                }
            }
        });

        while (true){
            try{
                Thread.sleep(70);
                printOval();
            }
            catch (InterruptedException a){
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 500, 500);

        g.setColor(Color.green);
        try {
            Iterator<Oval> i = ovalList.iterator();
            while (i.hasNext()) i.next().paintComponent(g);
        }catch (Exception d){
            d.printStackTrace();
            logger.error(d);
        }

    }

    public void printOval(){
        Iterator<Oval> i = ovalList.iterator();
        while (i.hasNext()){
            Oval o = i.next();
            if(o.count >0){
                o.a+=10;
                o.b+=10;
                o.c-=5;
                o.d-=5;
                o.count--;
            }
            if(o.count == 0){
                ovalList.remove(o);
            }
            repaint();
        }
    }

}
