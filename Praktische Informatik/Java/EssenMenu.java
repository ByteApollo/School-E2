import javax.swing.*;

public class EssenMenu {
    public static void main(String[] args) {
        JCheckBox check = new JCheckBox("Willst du Zahlen?");
        Object [] options = { "Doch lieber nichts","Asia Box", "Pizza", "Schwein", "Chicken", "Döner", "Hamburger Vegan(Menü)", check};
        double [] preise = {0, 3.49, 7.89, 69.42, 4.91, 6.50, 10.49};
        int x = JOptionPane.showOptionDialog(null, "Was möchtest du essen",
                "Speisekarte",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

        if (check.isSelected() && x != -1) {

            if (x == 0) {
                JOptionPane.showMessageDialog(null, "Ok, dann nicht.");
            } else if (x == 3 ) {
                JOptionPane.showMessageDialog(null, "Wir haben nur Halal essen");
            } else {
                JOptionPane.showMessageDialog(null, "Du hast ausgewählt: " + options[x] + "\nDer Preis beträgt: " + preise[x]+ "€");
            }
        
        } else {
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "Ok, dann nicht.");
            } else {
                JOptionPane.showMessageDialog(null, "Ohen Geld kein essen!");
            }
        }

    }
}
