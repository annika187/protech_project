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
    private JComboBox comboBox1;

    ArrayList<Person> personen = new ArrayList<>();


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

                double bmi = weight / ((height / 100) * (height / 100));

                bmi_string = Double.toString(bmi);

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


    }

    static void main(String[] args) {
        new MiniMe_Generator();

    }

    public void initObjekt() {
        Person person1 = new Person("Maya", "weiblich", 19, 175, 55, "dunkelbraun", "braun", false, "18.0");
        Person person2 = new Person("Pai", "weiblich", 19, 167, 50, "dunkelblond", "blau", false, "-");
        Person person3 = new Person("Flo", "männlich", 21, 203, 95, "dunkelblond", "blau", true, "-");

        personen.add(person1);
        personen.add(person2);
        personen.add(person3);

        for (Person p : personen) {
            textArea1.append(p.toString());
        }
    }

}


class Person {
    String name;
    String gender;
    int age;
    int height;
    int weight;
    String hair;
    String eyes;
    boolean glasses;
    String bmi;


    @Override
    public String toString() {
        return "Name: " + name +
                "\nGeschlecht: " + gender +
                "\nAlter: " + age +
                "\nGröße: " + height + "cm" +
                "\nGewicht: " + weight + "kg" +
                "\nHaare: " + hair +
                "\nAugen: " + eyes +
                "\nBrille: " + (glasses ? "Ja" : "Nein") +
                "\nBMI: " + bmi +
                "\n----------------------\n";
    }


    public Person(String name, String gender, int age, int height, int weight, String hair, String eyes, boolean glasses, String bmi) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hair = hair;
        this.eyes = eyes;
        this.glasses = glasses;
        this.bmi = bmi;
    }
}
