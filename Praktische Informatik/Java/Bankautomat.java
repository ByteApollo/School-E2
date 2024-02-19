import java.util.Random;
import javax.swing.JOptionPane;

public class Bankautomat {
    
    String[] IBan = {"1", "DE911", "0000", "0000", "0000", "0000", "0000", "0000"};
    String[] Konten = {"Ömer", "Random", "0000", "0000", "0000", "0000", "0000", "0000"};
    String[] Passwort = {"1","2000", "0000", "0000", "0000", "0000", "0000", "0000"};
    double[] geld = {1400.32, 280.49, 0000, 0000, 0000, 0000, 0000, 0000};

    String Eingabe;
    int pruefung = -1;
    int frager;
    double einauszahlung;

    public void automat() {
        Eingabe = JOptionPane.showInputDialog(null, "IBAN eingeben");
        pruefer();
        accountLogin();
        auswahl();
    }

    public void accountLogin() {
        Eingabe = JOptionPane.showInputDialog(null, "Passwort eingeben");
        if (Passwort[pruefung].equals(Eingabe)) {
            JOptionPane.showMessageDialog(null,"Access granted");
        } else {
            JOptionPane.showMessageDialog(null,"Access denied");
            automat();
        }
    }

    public void pruefer() {
        for (int i = 0; i < IBan.length; i++) {
            System.out.println(Eingabe);
            if (IBan[i].equals(Eingabe)) {
                System.out.println("Iban im array an der stelle " + i + " gefunden");
                pruefung = i;
                System.out.println("Pruefung: " + pruefung);
            }
            if (i + 1 == IBan.length && pruefung == -1) {
                JOptionPane.showMessageDialog(null, "Diese IBAN exisitert nicht.");
                automat();
            }
        }
    }

    public void auswahl() {
        String[] fragen = {"Geld abheben", "Geld einzahlen", "Kontostand", "Überweisung","Neues Konto", "Abbruch", "Zurück"};
        frager = JOptionPane.showOptionDialog(null, "Hallo, " + Konten[pruefung], null, 
        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE ,null, fragen, fragen);
        System.out.println("Frager: "+frager);
        switch (frager) {
            case 0:
                auszahlen();
                break;
            case 1: 
                einzahlen();
                break;
            case 2:
                kontostand();
                break;
            case 3:
                ueberweisung();
                break;
            case 4:
                neuesKonto();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Bitte die Karte nicht vergessen");
                System.exit(0);
                break;
            default:
                automat();
                break;
        }
    }

    public void einzahlen() {
        Eingabe = JOptionPane.showInputDialog(null, "Wie viel möchtest du einzahlen?");
        einauszahlung = Double.parseDouble(Eingabe);
        if (einauszahlung > 0) {
            geld[pruefung] = geld[pruefung] + einauszahlung;
            JOptionPane.showMessageDialog(null, "Du hast "+ einauszahlung+ "€ eingezahlt\n neuer Kontostand: " + geld[pruefung]+"€");
            auswahl();
        } else {
            JOptionPane.showMessageDialog(null, "Operation nicht möglich");
            auswahl();
        }
    }

    public void auszahlen() {
        Eingabe = JOptionPane.showInputDialog(null, "Wie viel möchtest du auszahlen?");
        einauszahlung = Double.parseDouble(Eingabe);
        if (einauszahlung > 0) {
            einauszahlung = -einauszahlung;
            geld[pruefung] = geld[pruefung] + einauszahlung;
            JOptionPane.showMessageDialog(null, "Du hast "+ einauszahlung+ "€ ausgezahlt\n neuer Kontostand: " + geld[pruefung]+"€");
            auswahl();
        } else {
            JOptionPane.showMessageDialog(null, "Du hast nicht genug Geld");
            auswahl();
        }
    }

    public void kontostand() {
        JOptionPane.showMessageDialog(null, "Kontostand:\n "+ geld[pruefung]);
        auswahl();
    }

    private void ueberweisung() {
        String Empfang;
        int pruefung2 = -1;
        String Versand;
        Empfang = JOptionPane.showInputDialog(null, "An wen willst du überweisen");
        for (int i = 0; i < IBan.length; i++) {
            if (IBan[i].equals(Empfang)) {
                pruefung2 = i;
                Versand = JOptionPane.showInputDialog(null, "Wie viel möchtest du versenden?");
                einauszahlung = Double.parseDouble(Versand);

                if (einauszahlung > 0) {
                    geld[pruefung2] = geld[pruefung2] + einauszahlung;
                    geld[pruefung] = geld[pruefung] - einauszahlung;
                    JOptionPane.showMessageDialog(null, "Du hast erfolgreich " + einauszahlung + "€ versendet an " + Konten[pruefung2]);
                } else {
                    JOptionPane.showMessageDialog(null,"Summe zu niedrig");
                }
                auswahl();
            } else if (i + 1 == IBan.length && pruefung2 == -1) {
                auswahl();
            } 
        }
    }

    public void neuesKonto() {
        String E1;
        int rechner = Konten.length - 1;
        if (Konten[rechner].equals("0000")) {
            E1 = JOptionPane.showInputDialog(null, "Name eingebene");
            Konten[rechner] = E1;
            E1 = JOptionPane.showInputDialog(null, "Passwort erstellen");
            Passwort[rechner] = E1;
            Random rand = new Random();
            IBan[rechner] = Integer.toString(rand.nextInt(501));
            JOptionPane.showMessageDialog(null, "Neues Konto wurde erstellt.\nName: "+ Konten[rechner]+"\nIBAN: " + IBan[rechner]);
            auswahl();
        } else {
            JOptionPane.showMessageDialog(null, "Momentan ist dieser service nicht möglich.\n Aber rufen sie uns bitte nicht an.");
            auswahl();
        }
        
    }

    public static void main(String[] args) {
        Bankautomat bk = new Bankautomat();
        bk.automat();

        System.exit(0);
    }

}
