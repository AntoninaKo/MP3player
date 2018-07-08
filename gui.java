import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui extends JFrame {

    ThPlay pl;
    private JButton b1 = new JButton("prev");
    private JButton b2 = new JButton("stop");
    private JButton b3 = new JButton("play");
    private JButton b5 = new JButton("next");
    int track = 0; //default
    boolean stop = false;

    public gui(){
       super("MP3 Player");
       setLayout(new GridLayout(1,5,5,5));
       add(b1);
       add(b2);
       add(b3);
       add(b5);
       b1.setEnabled(false);

       Buttons1 but1 = new Buttons1();
       Buttons2 but2 = new Buttons2();
       Buttons3 but3 = new Buttons3();
       Buttons5 but5 = new Buttons5();

       b1.addActionListener(but1);
       b2.addActionListener(but2);
       b3.addActionListener(but3);
       b5.addActionListener(but5);
    }

    private class Buttons1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            CheckStop();
            track--;
            CheckButtons();
            StartTrack();
        }
    }

    private class Buttons2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if((stop == false)&&(pl != null)){
            pl.interrupt();
            pl.Stop();
            stop = true;}
        }
    }

    private class Buttons3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if((stop == false)&&(pl != null)){
                pl.interrupt();
                pl.Stop();
            }
            StartTrack();
        }
    }

    private class Buttons5 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            CheckStop();
            track++;
            CheckButtons();
            StartTrack();
        }
    }

    private void CheckButtons(){
        if(track==0){
            b1.setEnabled(false);
        } else {
            b1.setEnabled(true);}
        if(track==3) {
            b5.setEnabled(false);
        } else {
            b5.setEnabled(true);}
    }

    private void StartTrack(){
        pl = new ThPlay();
        pl.setFile(track);
        pl.start();
        stop = false;
    }

    private void CheckStop(){
        if(!stop){
            pl.interrupt();
            pl.Stop();
        }
    }
}