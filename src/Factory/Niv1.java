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
public class Niv1 extends JPanel implements Fabrica {

    JLabel id = new JLabel("Primul nivel");
    int x, y;
    public static int xM, yM;
    //0-liber ; 1-block ; 2-tinta ; 3-piesa normala ; 4-piesa respingere ; 5-piesa atractie
    public static int[][] labirint
            = {{1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {1, 0, 2, 3, 2, 1},
            {1, 4, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}};
    List<StatePatternDemo> listaForme = new ArrayList<>();

    @Override
    public void afiseazaPanou(Container c) {
        listaForme.clear();
        id.setForeground(Color.white);
        this.add(id);
        this.setBackground(new Color(178, 49, 75));
        System.out.println("Primul nivel");
        for (x = 0; x < labirint.length; x++) {
            for (y = 0; y < labirint[0].length; y++) {
                StatePatternDemo spd = new StatePatternDemo(labirint[x][y], x, y);
                listaForme.add(spd);
            }
        }
        System.out.print('\n');
        MediatorC help = new MediatorC();
        help.adaugaMouse(this);
        c.add(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        //Paint a filled rectangle at user's chosen point.
        super.paintComponent(g);
        for (StatePatternDemo f : listaForme) {
            if (f.p == 4) {
                xM = f.x;
                yM = f.y;
            }
            f.ctrl.getDesen(g, f.x, f.y);
            //System.out.print(f.x + " " + f.y + " " + f.p + " ; ");
            if (f.y == 5) {
                System.out.print('\n');
            }
        }
    }

    @Override
    public void stergePanou(Container c) {
        System.out.println("Niv1 sters");
        this.removeAll();
        c.remove(this);
    }
}
