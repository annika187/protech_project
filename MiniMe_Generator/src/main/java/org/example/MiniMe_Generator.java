package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MiniMe_Generator extends JFrame {

    String name;
    String gender;
    int age;
    int height;
    int weight;
    String hair;
    String eyes;
    boolean glasses;
    String bmi_string = "-";

    private JPanel panel1;
    private JTextField textField_name;
    private JRadioButton radioButton_male;
    private JRadioButton radioButton_female;
    private JRadioButton radioButton_divers;
    private JTextField textField_age;
    private JTextField textField_height;
    private JTextField textField_weight;
    private JComboBox comboBox_hair;
    private JComboBox comboBox_eyes;
    private JRadioButton radioButton_yes;
    private JButton speichernButton;
    private JRadioButton radioButton_no;
    private JTextArea textArea1;
    private JButton berechnenButton;
    private JLabel label_bmi;
    private JComboBox fliterComboBox;

    ArrayList<Person> personen = new ArrayList<>();

    //rechnet den bmi aus und gibt ihn zurück
    public static double bmiBerechnen(int height, int weight) {
        double heightMeter = height / 100.0;
        double bmi = weight / (heightMeter * heightMeter);

        // auf 2 Nachkommastellen runden
        return Math.round(bmi * 100.0) / 100.0;
    }

    public MiniMe_Generator() {
        setTitle("MiniMe Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 650);
        setContentPane(panel1);
        setVisible(true);
        initObjekt();
        label_bmi.setText("-");

        berechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                height = Integer.parseInt(textField_height.getText());
                weight = Integer.parseInt(textField_weight.getText());

                bmi_string = Double.toString(bmiBerechnen(height,weight));

                label_bmi.setText(bmi_string);
            }
        });

        //alle Werte werden gespeichert und Objekt wird erstellt
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (textField_name.getText().trim().isEmpty() || textField_age.getText().trim().isEmpty() || textField_height.getText().trim().isEmpty() || textField_weight.getText().trim().isEmpty()) {
                        throw new Exception("Leeres Feld");
                    }



                    try {
                        name = textField_name.getText().trim();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(
                                null,
                                "Bitte einen gültigen String bei Name eingeben",
                                "Falsche Eingabe",
                                JOptionPane.ERROR_MESSAGE
                        );

                        return;
                    }




                    try {
                        age = Integer.parseInt(textField_age.getText().trim());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(
                                null,
                                "Bitte einen gültigen Integer bei Alter eingeben",
                                "Falsche Eingabe",
                                JOptionPane.ERROR_MESSAGE
                        );

                        return;
                    }

                    try {
                        height = Integer.parseInt(textField_height.getText().trim());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(
                                null,
                                "Bitte einen gültigen Integer bei Größe eingeben",
                                "Falsche Eingabe",
                                JOptionPane.ERROR_MESSAGE
                        );

                        return;
                    }

                    try {
                        weight = Integer.parseInt(textField_weight.getText().trim());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(
                                null,
                                "Bitte einen gültigen Integer bei Gewicht eingeben",
                                "Falsche Eingabe",
                                JOptionPane.ERROR_MESSAGE
                        );

                        return;
                    }




                    hair = comboBox_hair.getSelectedItem().toString().trim();
                    eyes = comboBox_eyes.getSelectedItem().toString().trim();


                    if (radioButton_male.isSelected()) {
                        gender = "männlich";
                    } else if (radioButton_female.isSelected()) {
                        gender = "weiblich";
                    } else if (radioButton_divers.isSelected()) {
                        gender = "divers";
                    }

                    if (radioButton_yes.isSelected()) {
                        glasses = true;
                    } else {
                        glasses = false;
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Bitte einen gültigen Wert eingeben",
                            "Falsche Eingabe",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }


                //Objekt wird erstellt


                Person person4 = new Person(name, gender, age, height, weight, hair, eyes, glasses, bmi_string);

                personen.add(person4);

                textArea1.setText("");

                for (Person p : personen) {
                    textArea1.append(p.toString());
                }

                textField_name.setText("");
                textField_age.setText("");
                textField_height.setText("");
                textField_weight.setText("");
                comboBox_hair.setSelectedItem("Auswählen...");
                comboBox_eyes.setSelectedItem("Auswählen...");
                bmi_string = "-";
                label_bmi.setText(bmi_string);
            }
        });

        fliterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filter = fliterComboBox.getSelectedItem().toString();
                switch (filter){
                    case "männlich":
                        maennlichFilter();
                        break;
                    case "weiblich":
                        weiblichFilter();
                        break;
                    case "divers":
                        diversFilter();
                        break;
                    default:
                        defaultFilter();
                }
            }
        });
    }

    static void main(String[] args) {
        new MiniMe_Generator();
    }

    //fügt 3 Personen der Liste hinzu und gibt sie in der TextArea aus
    public void initObjekt() {
        //erstellt jeweils ein Person Objekt
        Person person1 = new Person("Maya", "weiblich", 19, 175, 55, "dunkelbraun", "braun", false, "17.96");
        Person person2 = new Person("Pai", "weiblich", 19, 167, 50, "dunkelblond", "blau", false, "-");
        Person person3 = new Person("Flo", "männlich", 21, 203, 95, "dunkelblond", "blau", true, "-");

        //fügt die Personenobjekte der Liste hinzu
        personen.add(person1);
        personen.add(person2);
        personen.add(person3);

        //geht die Personenliste durch und schreibt sie in die Textarea
        for (Person p : personen) {
            textArea1.append(p.toString());
        }
    }

    public void defaultFilter(){
        textArea1.setText("");
        for (Person p : personen) {
            textArea1.append(p.toString());
        }
    }

    public void maennlichFilter(){
        // Neue Liste für gefilterte Personen (nur männlich)
        ArrayList<Person> maennlichListe = new ArrayList<>();

        // Personenliste durchlaufen
        for (Person p : personen) {
            // Prüfen, ob die Person männlich ist
            if (p.gender.equals("männlich")) {
                maennlichListe.add(p);
            }
        }

        // TextArea leeren
        textArea1.setText("");

        // Gefilterte Liste in der TextArea ausgeben
        for (Person p : maennlichListe) {
            textArea1.append(p.toString());
        }
    }
    public void weiblichFilter(){
        // Neue Liste für gefilterte Personen (nur weiblich)
        ArrayList<Person> weiblichListe = new ArrayList<>();

        // Personenliste durchlaufen
        for (Person p : personen) {
            // Prüfen, ob die Person weiblich ist
            if (p.gender.equals("weiblich")) {
                weiblichListe.add(p);
            }
        }

        // TextArea leeren
        textArea1.setText("");

        // Gefilterte Liste in der TextArea ausgeben
        for (Person p : weiblichListe) {
            textArea1.append(p.toString());
        }
    }
    public void diversFilter(){
        // Neue Liste für gefilterte Personen (nur divers)
        ArrayList<Person> diversListe = new ArrayList<>();

        // Personenliste durchlaufen
        for (Person p : personen) {
            // Prüfen, ob die Person divers ist
            if (p.gender.equals("divers")) {
                diversListe.add(p);
            }
        }

        // TextArea leeren
        textArea1.setText("");

        // Gefilterte Liste in der TextArea ausgeben
        for (Person p : diversListe) {
            textArea1.append(p.toString());
        }
    }
}
