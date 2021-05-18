/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicmagnets;

import Factory.FabricaPanouri;
import Iterator.Iterator;
import Iterator.Nivele;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cami
 */
public class IteratorTest {

    FabricaPanouri fb = new FabricaPanouri();
    Nivele nv = new Nivele();
    ;
    Iterator i = nv.getIterator();
    ;
    String numePanou;

    @Test
    public void PanelNivStartName() {
        numePanou = (String) i.next();
        assertEquals(numePanou, "Start");
    }

    @Test
    public void PanelNiv1Name() {
        numePanou = (String) i.next();
        numePanou = (String) i.next();
        assertEquals(numePanou, "Nivel 1");
    }

    @Test
    public void PanelNiv2Name() {
        for (int x = 0; x <= 2; x++) {
            numePanou = (String) i.next();
        }
        assertEquals(numePanou, "Nivel 2");
    }

    @Test
    public void PanelNiv3Name() {
        for (int x = 0; x <= 3; x++) {
            numePanou = (String) i.next();
        }
        assertEquals(numePanou, "Nivel 3");
    }

    @Test
    public void PanelNivFinalName() {
        for (int x = 0; x <= 4; x++) {
            numePanou = (String) i.next();
        }
        assertEquals(numePanou, "Final");
    }
}
