import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by zhitnikov.bronislav on 09.10.2015.
 */
public class Main {
    static Main  main=new Main();;
    private JFrame frame;
    private Canvas canvas;
    private Star star;
    public static void main(String[] args){


    };
    public Main(){
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(610, 640);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }

        });
        canvas=new Canvas();
        canvas.setSize(600, 600);
        canvas.setBackground(Color.black);
        canvas.setLocation(0, 0);
        frame.getContentPane().add(canvas);
        star=new Star();
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                star.GetWord(8);
                canvas.getGraphics().drawImage(star.DrawWord(canvas.getWidth(),canvas.getHeight()),0,0,null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.setVisible(true);
        System.out.print("Start");
    }


}
