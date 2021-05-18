/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediator;

import Factory.Niv3;
import Factory.Niv2;
import Factory.Niv1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import static logicmagnets.LogicMagnets.c;
import static logicmagnets.LogicMagnets.f;

/**
 *
 * @author Cami
 */
public class MediatorC {

    public static int nivel = 0;
    public static int prev = 0, prev2 = 0;

    public void adaugaMouse(JPanel jp) {

        jp.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                int coordX = evt.getY() / 90;
                int coordY = evt.getX() / 90;
                switch (nivel) {
                    case 1:
                        if (Niv1.labirint[coordX][coordY] == 0 || Niv1.labirint[coordX][coordY] == 2) {
                            f.stergePanou(c);
                            Niv1.labirint[Niv1.xM][Niv1.yM] = prev;
                            prev = Niv1.labirint[coordX][coordY];
                            Niv1.labirint[coordX][coordY] = 4;
                            respinge(Niv1.labirint, coordX, coordY);
                            f.afiseazaPanou(c);
                            c.revalidate();
                            c.repaint();
                        }
                        break;

                    case 2:
                        if (Niv2.labirint[coordX][coordY] == 0 || Niv2.labirint[coordX][coordY] == 2) {
                            f.stergePanou(c);
                            Niv2.labirint[Niv2.xM][Niv2.yM] = prev;
                            prev = Niv2.labirint[coordX][coordY];
                            Niv2.labirint[coordX][coordY] = 4;
                            respinge(Niv2.labirint, coordX, coordY);
                            f.afiseazaPanou(c);
                            c.revalidate();
                            c.repaint();
                        }
                        break;
                    case 3:
                        if (Niv3.labirint[coordX][coordY] == 4) {
                            Niv3.xM = coordX;
                            Niv3.yM = coordY;
                            Niv3.psel.setText("Piesa selectata: Piesa de respingere");
                        } else if (Niv3.labirint[coordX][coordY] == 5) {
                            Niv3.xM = coordX;
                            Niv3.yM = coordY;
                            Niv3.psel.setText("Piesa selectata: Piesa de atractie");
                        } else if ((Niv3.labirint[coordX][coordY] == 0 || Niv3.labirint[coordX][coordY] == 2) && Niv3.psel.getText().equals("Piesa selectata: Piesa de respingere")) {
                            f.stergePanou(c);
                            Niv3.labirint[Niv3.xM][Niv3.yM] = prev;
                            prev = Niv3.labirint[coordX][coordY];
                            Niv3.labirint[coordX][coordY] = 4;
                            respinge(Niv3.labirint, coordX, coordY);
                            Niv3.xM = coordX;
                            Niv3.yM = coordY;
                            f.afiseazaPanou(c);
                            c.revalidate();
                            c.repaint();
                        } else if ((Niv3.labirint[coordX][coordY] == 0 || Niv3.labirint[coordX][coordY] == 2) && Niv3.psel.getText().equals("Piesa selectata: Piesa de atractie")) {
                            f.stergePanou(c);
                            Niv3.labirint[Niv3.xM][Niv3.yM] = prev2;
                            prev2 = Niv3.labirint[coordX][coordY];
                            Niv3.labirint[coordX][coordY] = 5;
                            atrage(Niv3.labirint, coordX, coordY);
                            Niv3.xM = coordX;
                            Niv3.yM = coordY;
                            f.afiseazaPanou(c);
                            c.revalidate();
                            c.repaint();
                        } else {
                            System.out.println("Eroare, nicio piesa nu este selectata.");
                        }
                        break;
                    default:
                        System.out.println("Nivel invalid");
                }

                System.out.println("Click la x=" + coordX + ", y=" + coordY);
            }
        });
    }

    public static void respinge(int[][] l, int x, int y) {
        if (x - 2 >= 1) {
            if ((l[x - 2][y] == 0 || l[x - 2][y] == 2) && l[x - 1][y] == 3) {
                l[x - 1][y] = 0;
                l[x - 2][y] = 3;
            }
        }

        if (x + 2 <= l.length - 1) {
            if ((l[x + 2][y] == 0 || l[x + 2][y] == 2) && l[x + 1][y] == 3) {
                l[x + 1][y] = 0;
                l[x + 2][y] = 3;
            }
        }

        if (y - 2 >= 1) {
            if ((l[x][y - 2] == 0 || l[x][y - 2] == 2) && l[x][y - 1] == 3) {
                l[x][y - 1] = 0;
                l[x][y - 2] = 3;
            }
        }

        if (y + 2 <= l[0].length - 1) {
            if ((l[x][y + 2] == 0 || l[x][y + 2] == 2) && l[x][y + 1] == 3) {
                l[x][y + 1] = 0;
                l[x][y + 2] = 3;
            }
        }

        if (nivel == 1) {
            Niv1.labirint = l;
        } else if (nivel == 2) {
            Niv2.labirint = l;
        } else if (nivel == 3) {
            Niv3.labirint = l;
        }
    }

    public static void atrage(int[][] l, int x, int y) {
        if (x - 2 >= 1) {
            if ((l[x - 1][y] == 0 || l[x - 1][y] == 2) && l[x - 2][y] == 3) {
                l[x - 2][y] = 0;
                l[x - 1][y] = 3;
            }
        }

        if (x + 2 <= l.length - 1) {
            if ((l[x + 1][y] == 0 || l[x + 1][y] == 2) && l[x + 2][y] == 3) {
                l[x + 2][y] = 0;
                l[x + 1][y] = 3;
            }
        }

        if (y - 2 >= 1) {
            if ((l[x][y - 1] == 0 || l[x][y - 1] == 2) && l[x][y - 2] == 3) {
                l[x][y - 2] = 0;
                l[x][y - 1] = 3;
            }
        }

        if (y + 2 <= l[0].length - 1) {
            if ((l[x][y + 1] == 0 || l[x][y + 1] == 2) && l[x][y + 2] == 3) {
                l[x][y + 2] = 0;
                l[x][y + 1] = 3;
            }
        }

        if (nivel == 1) {
            Niv1.labirint = l;
        } else if (nivel == 2) {
            Niv2.labirint = l;
        } else if (nivel == 3) {
            Niv3.labirint = l;
        }
    }
}
