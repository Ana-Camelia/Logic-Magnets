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
public class PiesaRespingere implements State{

    @Override
    public void deseneaza(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillOval(90 * y + 15, 90 * x + 15, 60, 60);
    }

    @Override
    public void actiune(List<StatePatternDemo> lf, int x, int y) {
        
    }
    
}
