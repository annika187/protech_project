package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MiniMe_Generator extends JFrame{

    String name;
    String gender;
    int age;
    int height;
    int weight;
    String hair;
    String eyes;
    boolean glasses;

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

    public MiniMe_Generator(){
        setTitle("MiniMe Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 650);
        setContentPane(panel1);
        setVisible(true);


        ArrayList<Person> personen = new ArrayList<>();




        //alle Werte werden gespeichert und Objekt wird erstellt
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textField_name.getText();
                age = Integer.parseInt(textField_age.getText());
                height = Integer.parseInt(textField_height.getText());
                weight = Integer.parseInt(textField_weight.getText());
                hair = comboBox_hair.getSelectedItem().toString();
                eyes = comboBox_eyes.getSelectedItem().toString();



                if(radioButton_male.isSelected()){
                    gender = "männlich";
                } else if (radioButton_female.isSelected()) {
                    gender = "weiblich";
                } else if (radioButton_divers.isSelected()){
                    gender = "divers";
                }

                if (radioButton_yes.isSelected()){
                    glasses = true;
                }else{
                    glasses = false;
                }


                //Objekt wird erstellt
                Person person1 = new Person(name, gender, age, height, weight, hair, eyes, glasses);
                personen.add(person1);


                textArea1.setText("");

                for (Person p : personen) {
                    textArea1.append(p.toString());
                }


            }


        });
    }

    static void main(String[] args) {
        new MiniMe_Generator();

    }


}


class Person{
    String name;
    String gender;
    int age;
    int height;
    int weight;
    String hair;
    String eyes;
    boolean glasses;


    @Override
    public String toString() {
        return "Name: " + name +
                "\nGeschlecht: " + gender +
                "\nAlter: " + age +
                "\nGröße: " + height +
                "\nGewicht: " + weight +
                "\nHaare: " + hair +
                "\nAugen: " + eyes +
                "\nBrille: " + (glasses ? "Ja" : "Nein") +
                "\n----------------------\n";
    }


    public Person(String name, String gender, int age, int height, int weight, String hair, String eyes, boolean glasses) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hair = hair;
        this.eyes = eyes;
        this.glasses = glasses;
    }
}
