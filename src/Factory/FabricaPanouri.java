/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

/**
 *
 * @author Cami
 */
public class FabricaPanouri {
   
    public Fabrica getPanou(String tip) {
        if(tip==null) {
            return null;
        }
        if(tip.equals("Start")) {
            return new NivStart();
        }
        else if(tip.equals("Nivel 1")) {
            return new Niv1();
        }
        else if(tip.equals("Nivel 2")) {
            return new Niv2();
        }
        else if(tip.equals("Nivel 3")) {
            return new Niv3();
        }
        else if(tip.equals("Final")) {
            return new NivFinal();
        }
        return null;
    }
}
