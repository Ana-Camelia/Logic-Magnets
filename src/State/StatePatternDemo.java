/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author Cami
 */
public class StatePatternDemo {
        public Controller ctrl;
        public int x,y,p;
        public StatePatternDemo(int p, int x, int y) {
            ctrl = new Controller();
            this.x=x;
            this.y=y;
            this.p=p;
            switch (p) {
                    case 0:
                        ctrl.setLiberTip();
                        break;
                    case 1:
                        ctrl.setBlockTip();
                        break;
                    case 2:
                        ctrl.setTintaTip();
                        break;
                    case 3:
                        ctrl.setNormalTip();
                        break;
                    case 4:
                        ctrl.setRespingereTip();
                        break;
                    case 5:
                        ctrl.setAtractieTip();
                        break;
                    default:
                        System.out.println("Labirint negasit");
                }
        }
            

    }

