package dadi;


import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author kali_rwrk
 */
public class Thread1 extends Thread {
    JTextArea tarea = new JTextArea();
    boolean v = false;
    
    public void run() {
        
        Icon dice = new ImageIcon("rolling-dice-gif-4.gif");
        JLabel img = new JLabel(dice);
        JFrame f = new JFrame("Dado 1 Thread 1");
        f.setLayout(new GridLayout(2,1));
        f.setSize(480, 600);
        f.add(img);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(100,0);
        f.setVisible(true);
        tarea.setEditable(false);
        Random ran = new Random();
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(2,1));
        int num = ran.nextInt(6)+1;
        JLabel res = new JLabel(String.valueOf(num));
        res.setFont(new Font("Courier New", Font.BOLD, 24));
        
        Thread.yield();
        do {
        num = ran.nextInt(6)+1;
        res.setText(String.valueOf(num));
        pan.remove(res);
        pan.add(res);
        String tmp = tarea.getText()+"Numero uscito: "+String.valueOf(num)+"\n";
        pan.remove(tarea);
        pan.add(tarea);
        tarea.setText(tmp);
        f.remove(pan);
        f.add(pan);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while(!v);
    }
    
    public void Verify() {
        v = true;
    }
}

