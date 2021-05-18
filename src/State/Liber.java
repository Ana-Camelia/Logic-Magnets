/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Cami
 */
public class Liber implements State{

    @Override
    public void deseneaza(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.drawOval(90 * y + 32, 90 * x + 32, 26, 26);
    }

    @Override
    public void actiune(List<StatePatternDemo> lf, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
