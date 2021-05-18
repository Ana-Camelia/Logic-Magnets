/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicmagnets;

import Mediator.MediatorC;
import Iterator.Nivele;
import Iterator.Iterator;
import Factory.Fabrica;
import Factory.FabricaPanouri;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Cami
 */
public class LogicMagnets extends JFrame {

    /**
     * @param args the command line arguments
     */
    JPanel buton = new JPanel();
    static JButton inainte = new JButton("Start");
    public static Container c;
    Nivele nv;
    FabricaPanouri fb;
    Iterator i;
    String numePanou;
    public static Fabrica f;

    LogicMagnets() {
        //panoul principal
        c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));
        c.setPreferredSize(new Dimension(700, 700));
        buton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buton.setPreferredSize(new Dimension(700, 50));
        buton.setMaximumSize(new Dimension(700, 50));
        buton.add(inainte);
        buton.setBackground(new Color(88, 0, 44));
        c.add(buton);

        //panoul cu nivele
        nv = new Nivele();
        fb = new FabricaPanouri();
        i = nv.getIterator();
        numePanou = (String) i.next();
        System.out.println("Name : " + numePanou);
        f = fb.getPanou(numePanou);
        f.afiseazaPanou(c);

        //tranzitia dintre panouri
        inainte.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                MediatorC.nivel++;
                if (numePanou.equals("Start")) {
                    inainte.setText("Inainte");
                } else if (numePanou.equals("Nivel 3")) {
                    inainte.setText("Inchide");
                }
                f.stergePanou(c);
                if (i.hasNext()) {
                    numePanou = (String) i.next();
                    System.out.println("Name : " + numePanou);
                    f = fb.getPanou(numePanou);
                    f.afiseazaPanou(c);
                    c.revalidate();
                    repaint();
                    MediatorC.prev=0;
                    MediatorC.prev2=0;
                } else {
                    System.exit(0);
                }
            }
        });

    }
    
    public static void main(String[] args) {
        LogicMagnets frame = new LogicMagnets();
        frame.setPreferredSize(new Dimension(700, 700));
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setTitle("Logic Magnets");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
