import java.util.Random;
import java.util.Scanner;

public class MatheTrainerOA {
    
    int ergebnis;
    int lösung;
    int[] zahlen;
    int auswahl;

    public void startTrainer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welche Grundrechenart soll Traniert werden? 1: Addition 2: Multiplikation");
        auswahl = sc.nextInt();
        System.out.println("Wie viele Zahlen möchten sie rechnen?");
        zahlen = new int[sc.nextInt()];
        zufallZahlen();
        if (auswahl == 1) {
            for (int i = 0; i < zahlen.length; i++) {
                lösung = zahlen[i] + lösung;
            }
        } else {
            lösung = zahlen[0];
            for (int i = 0; i < zahlen.length; i++) {
                if (i > 0) {
                    lösung *= zahlen[i];
                }   
            }
        }
        System.out.println("Was ist das ergebnis?");
        ergebnis = sc.nextInt();
        if (ergebnis == lösung) {
            System.out.println("Korrekt");
        } else {
            falsch();
        }
        sc.close();
    }

    public void zufallZahlen() {
        Random ra = new Random();
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = ra.nextInt(101);
            System.out.println("Zahl " + (i + 1) + ": " + zahlen[i]);
        }
    }

    public void falsch() {
        for (int i = 0; i < zahlen.length; i++) {
            if (auswahl == 2) {
                System.out.print(zahlen[i]);
                if (i < zahlen.length - 1) {
                    System.out.print("*");
                }
            } else {
                System.out.print(zahlen[i]);
                if (i < zahlen.length - 1) {
                    System.out.print("+");
                }
            }
        }
        System.out.print(" ist nicht " + ergebnis);
        System.out.println(" Sondern " + lösung);
    }

    public static void main(String[] args) {
        MatheTrainerOA mt = new MatheTrainerOA();
        mt.startTrainer();
    }

}
