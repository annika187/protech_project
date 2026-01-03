package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MiniMe_Generator extends JFrame{
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


        //alle Werte werden gespeichert und Objekt wird erstellt
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField_name.getText();
                String gender = "";
                int age = Integer.parseInt(textField_age.getText());
                int height = Integer.parseInt(textField_height.getText());
                int weight = Integer.parseInt(textField_weight.getText());
                String hair = comboBox_hair.getSelectedItem().toString();
                String eyes = comboBox_hair.getSelectedItem().toString();
                boolean glasses;


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

                System.out.println(gender);
                System.out.println(glasses);
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


    public Person() {
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
