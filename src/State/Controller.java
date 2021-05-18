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
public class Controller {
    public static Block bl;
    public static Liber lb;
    public static Tinta tn;
    public static PiesaNormala nm;
    public static PiesaRespingere rs;
    public static PiesaAtractie at;
    
    private State stare;
    
    Controller() {
        bl = new Block();
        lb = new Liber();
        tn = new Tinta();
        nm = new PiesaNormala();
        rs = new PiesaRespingere();
        at = new PiesaAtractie();
    }
    public void setBlockTip() {
        stare = bl;
    }
    
    public void setLiberTip() {
        stare = lb;
    }
    
    public void setTintaTip() {
        stare = tn;
    }
    
    public void setNormalTip() {
        stare = nm;
    }
    
    public void setRespingereTip() {
        stare = rs;
    }
    
    public void setAtractieTip() {
        stare = at;
    }
    
    public void getDesen(Graphics g, int x, int y) {
        stare.deseneaza(g, x, y);
    }
    
    public void getActiune (List<StatePatternDemo> lf, int x, int y){
        stare.actiune(lf, x, y);
    }
}
