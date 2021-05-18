/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicmagnets;

import Factory.Niv1;
import Factory.Niv2;
import Factory.Niv3;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cami
 */
public class LevelMatrix {

    private boolean MatrixEquality(int[][] a, int[][] b) {
        int row, col;
        int rows, cols;
        rows = a.length;
        cols = a[0].length;
        for (row = 0; row < rows; row++) {
            for (col = 0; col < cols; col++) {
                if (a[row][col] != b[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void Niv1Labirint() {
        
        int[][] m1 = {{1, 1, 1, 1, 1, 1},
                      {1, 0, 0, 0, 0, 1},
                      {1, 0, 2, 3, 2, 1},
                      {1, 4, 0, 0, 0, 1},
                      {1, 1, 1, 1, 1, 1}};
        assertEquals(MatrixEquality(Niv1.labirint, m1), true);
        
    }

    @Test
    public void Niv2Labirint() {
        
        int[][] m2 = {{1, 1, 1, 1, 1, 1, 1},
                      {1, 0, 0, 2, 0, 0, 1},
                      {1, 0, 0, 3, 0, 0, 1},
                      {1, 2, 3, 2, 3, 2, 1},
                      {1, 0, 0, 3, 0, 0, 1},
                      {1, 4, 0, 2, 0, 0, 1},
                      {1, 1, 1, 1, 1, 1, 1}};
        assertEquals(MatrixEquality(Niv2.labirint, m2), true);
        
    }

    @Test
    public void Niv3Labirint() {
        
        int[][] m3 = {{1, 1, 1, 1, 1, 1, 1},
                      {1, 2, 3, 2, 3, 0, 1},
                      {1, 0, 0, 4, 0, 2, 1},
                      {1, 0, 0, 5, 0, 2, 1},
                      {1, 1, 1, 1, 1, 1, 1}};
        assertEquals(MatrixEquality(Niv3.labirint, m3), true);
        
    }
}
