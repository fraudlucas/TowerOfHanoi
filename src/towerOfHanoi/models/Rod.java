package towerOfHanoi.models;

import java.util.LinkedList;

public class Rod extends LinkedList<Integer> {

    public boolean canReceive(Integer disk) {
        if (this.isEmpty()) {
            return true;
        } else {
            return disk < this.getLast();
        }
    }
}