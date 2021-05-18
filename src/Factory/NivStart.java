/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cami
 */
public class NivStart extends JPanel implements Fabrica{
    JLabel id = new JLabel("Panoul de start");
    private int[][] labirint = {{-1}};
    @Override
    public void afiseazaPanou(Container c) {
        id.setForeground(Color.white);
        this.add(id);
        this.setBackground(new Color(178, 49, 75));
        System.out.println("Panoul de start");
        c.add(this);
    }
    
    @Override
    public void stergePanou(Container c) {
        System.out.println("Panoul de start sters");
        this.removeAll();
        c.remove(this);
    }
}
