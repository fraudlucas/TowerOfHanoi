package towerOfHanoi;

import towerOfHanoi.models.Rod;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Rod target = new Rod();
    static Rod auxiliary = new Rod();
    static Rod initial = new Rod();
    static ArrayList<String> steps = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("How many disks?  ");
        Scanner scanner = new Scanner(System.in);
        int disksAmount = scanner.nextInt();

        pushingDisksOnInitialRod(disksAmount);
        movingDisks(disksAmount, initial, target, auxiliary);
        printSteps();
    }

    public static void pushingDisksOnInitialRod(int disks) {
        while(disks > 0) {
            initial.push(disks--);
        }
    }

    public static void movingDisks(int n, Rod source, Rod destination, Rod aux) {
        if (n > 0) {
            movingDisks(n-1, source, aux, destination);

            destination.push(source.pop());
            steps.add("INITIAL: " + initial + " TARGET: " + target + " AUXILIARY: " + auxiliary);

            movingDisks(n-1, aux, destination, source);
        }
    }

    public static void printSteps() {
        for (String step: steps) {
            System.out.println(step);
        }
    }

}