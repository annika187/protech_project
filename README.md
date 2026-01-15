# protech_project
# 🧍‍♂️ MiniMe Generator – Java Swing Projekt

## 📘 Projektbeschreibung

Der **MiniMe Generator** ist eine Java-Desktopanwendung mit grafischer Benutzeroberfläche (GUI), die im Rahmen einer Projektarbeit an der Hochschule entwickelt wurde.  
Ziel des Projekts ist die praktische Anwendung objektorientierter Programmierung sowie der GUI-Entwicklung mit **Java Swing**.

Die Anwendung ermöglicht das Erstellen und Verwalten von Personenprofilen („MiniMes“) und berechnet automatisch den **Body-Mass-Index (BMI)** anhand von Körpergröße und Gewicht.  
Alle Personen werden während der Laufzeit in einer Liste gespeichert und angezeigt.

---

## 🧩 Projektstruktur

- **`MiniMe_Generator.java`**  
  Hauptklasse der Anwendung mit GUI, Event-Handling, BMI-Berechnung und Personenverwaltung.

- **`Person.java`**  
  Datenmodell zur Speicherung aller personenbezogenen Attribute sowie einer formatierten `toString()`-Ausgabe.

- **`MiniMe_Generator.form`**  
  Layout-Datei des IntelliJ GUI Designers zur Definition der Benutzeroberfläche.

---

## 🖱️ Nutzung

1. Eingabe von Name, Alter, Größe und Gewicht  
2. Auswahl von Haarfarbe, Augenfarbe, Geschlecht und Brille  
3. BMI-Berechnung über den Button **„Berechnen“**  
4. Speicherung der Person über **„Speichern“**  
5. Anzeige und Filterung der Personenliste nach Geschlecht

---

## ⚠️ Validierung

Ungültige oder leere Eingaben werden abgefangen und dem Benutzer über Dialogfenster verständlich angezeigt.

---

## 🎯 Fazit

Der **MiniMe Generator** vereint zentrale Konzepte der Java-Programmierung, GUI-Entwicklung und Datenverarbeitung  
und eignet sich als solide Grundlage für weitere Erweiterungen wie:

- Persistente Speicherung (Datei / Datenbank)
- Erweiterte Filterfunktionen
- Statistische Auswertungen
- Modernisierung der GUI
