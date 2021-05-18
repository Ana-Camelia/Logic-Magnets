/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Cami
 */
public interface State {
    public void deseneaza(Graphics g, int x, int y);
    public void actiune(List<StatePatternDemo> lf, int x, int y);
}
