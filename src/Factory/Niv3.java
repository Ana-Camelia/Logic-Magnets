/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Mediator.MediatorC;
import State.StatePatternDemo;

/**
 *
 * @author Cami
 */
public class Niv3 extends JPanel implements Fabrica {

    JLabel id = new JLabel("Al treilea nivel");
    public static JLabel psel = new JLabel("Piesa selectata: ");
    int x, y;
    public static int xM, yM;
    List<StatePatternDemo> listaForme = new ArrayList<>();
    //0-liber ; 1-block ; 2-tinta ; 3-piesa normala ; 4-piesa respingere ; 5-piesa atractie
    public static int[][] labirint
            = {{1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 2, 3, 0, 1},
            {1, 0, 0, 4, 0, 2, 1},
            {1, 0, 0, 5, 0, 2, 1},
            {1, 1, 1, 1, 1, 1, 1}};

    @Override
    public void afiseazaPanou(Container c) {
        listaForme.clear();
        id.setForeground(Color.white);
        psel.setForeground(Color.white);
        this.add(id);
        this.setBackground(new Color(178, 49, 75));
        System.out.println("Al treilea nivel");
        for (x = 0; x < labirint.length; x++) {
            for (y = 0; y < labirint[0].length; y++) {
                StatePatternDemo spd = new StatePatternDemo(labirint[x][y], x, y);
                listaForme.add(spd);
            }
        }
            System.out.print('\n');
        MediatorC help = new MediatorC();
        help.adaugaMouse(this);
        this.add(psel);
        c.add(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        //Paint a filled rectangle at user's chosen point.
        super.paintComponent(g);
        for (StatePatternDemo f : listaForme) {
            f.ctrl.getDesen(g, f.x, f.y);
            //System.out.print(f.x + " " + f.y + " " + f.p + " ; ");
            if (f.y == 6) {
                System.out.print('\n');
            }
        }
    }

    @Override
    public void stergePanou(Container c) {
        System.out.println("Niv3 sters");
        this.removeAll();
        c.remove(this);
    }
}
