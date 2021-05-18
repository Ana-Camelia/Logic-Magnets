/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicmagnets;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cami
 */
public class StartButtonTest {

    @Test
    public void StartButtonText() {
        
        assertEquals(LogicMagnets.inainte.getText(), "Start");
        
    }
}
