package org.example; // klasse woraus wir das objekt erstellen

/**
 * Die Klasse Person beschreibt eine Person mit
 * verschiedenen persönlichen Eigenschaften.
 */
public class Person {
    String name;
    String gender;
    int age;
    int height;
    int weight;
    String hair;
    String eyes;
    boolean glasses;
    String bmi;

    /*
      Überschreibt die toString()-Methode.
      Gibt alle Informationen der Person formatiert
      als Text zurück.
     */
    @Override
    public String toString() {
        return "Name: " + name +
                "\nGeschlecht: " + gender + // zeilen umbruch
                "\nAlter: " + age +
                "\nGröße: " + height + "cm" +
                "\nGewicht: " + weight + "kg" +
                "\nHaare: " + hair +
                "\nAugen: " + eyes +
                "\nBrille: " + (glasses ? "Ja" : "Nein") +
                "\nBMI: " + bmi +
                "\n----------------------\n";
    }

    //alle Variablen werden der Klasse übergeben // construktor für das objekt
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
