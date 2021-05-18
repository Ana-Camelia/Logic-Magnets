/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

/**
 *
 * @author Cami
 */
public class Nivele implements IterContainer{
    public String nivele[] = {"Start","Nivel 1","Nivel 2","Nivel 3","Final"};
    
    @Override
    public Iterator getIterator() {
        return new IterNivele();
    }
    
    private class IterNivele implements Iterator {
        int index;
        
        @Override
        public boolean hasNext() {
            if(index < nivele.length) {
                return true;
            }
            return false;
        }
        
        @Override
        public Object next() {
            if(this.hasNext()) {
                return nivele[index++];
            }
            return null;
        }
    }
}
