import java.util.Scanner;

public class Schulnoten {
    
    int schueler;
    double schnitt;
    int[] noten;

    public void eingabe() {

        try {
            int i = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Wie viele Schüler wurden bewertet?");
            i = sc.nextInt();
            noten = new int[i];
            System.out.println("Einzelne Notenpunkte eingeben");
            for (int j = 0; j < noten.length; j++) {
            noten[j] = sc.nextInt(); 
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Fehler bei der eingabe wiederhole Methode!");
            eingabe();
        }

        
    }

    public void notendurchschnitt() {
        for (int i = 0; i < noten.length; i++) {
            schnitt = noten[i] + schnitt;
        }
        schnitt = schnitt / noten.length;
        System.out.println("Der Notendurchschnitt liegt bei: "+schnitt);
    }

    public void notenspiegel() {
        int h;
        int j;
        int i;
        System.out.println("-----------------");
        System.out.println("|Schüler | Noten|");
        System.out.println("-----------------");
        for ( i = 0; i <= 15; i++) {
            h = 0;
            for (j = 0; j < noten.length; j++) {
                if (noten[j] == i) {
                    h++;
                }
            }
            if (h > 0) {
                // System.out.printf("%-10s%-10s%-10s\n","|"+ h, "|" , i+"|");
                System.out.printf("|  %2d  |  %3d   |\n", h, i);
            }
        }
    }

    public static void main(String[] args) {
        Schulnoten sn = new Schulnoten();

        sn.eingabe();
        sn.notendurchschnitt();
        sn.notenspiegel();
    }
}
