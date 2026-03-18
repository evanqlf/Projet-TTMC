// author: Imane Elmessaouri
package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Plateau {

    private List<Case> cases;
    private List<Carte> paquetMature;
    private List<Carte> paquetImprobable;
    private List<Carte> paquetSalaire;
    private List<Carte> paquetPlaisir;

    public Plateau() {
        cases = new ArrayList<>();
        String[] themes = {"Mature", "Plaisir", "Salaire", "Improbable"};
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            cases.add(new Case(themes[r.nextInt(themes.length)]));
        }
        paquetImprobable = lireCarte("improbable");
        Collections.shuffle(paquetImprobable);
        paquetMature = lireCarte("mature");
        Collections.shuffle(paquetMature);
        paquetPlaisir = lireCarte("plaisir");
        Collections.shuffle(paquetPlaisir);
        paquetSalaire = lireCarte("salaire");
        Collections.shuffle(paquetSalaire);

    }

    public static List<Carte> lireCarte(String theme) {
        List<Carte> cartes = new ArrayList<>();
        String filePath = "src/main/resources/" + theme + ".csv";
        System.out.println("=== LECTURE DU FICHIER : src/main/resources/" + theme + ".csv ===\n");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String ligne;

            while ((ligne = br.readLine()) != null) {
                List<String> questions = new ArrayList<>();
                List<String> reponses = new ArrayList<>();
                String sousTheme = "";

                // Lire 10 lignes pour une carte
                for (int i = 0; i < 10; i++) {
                    String[] champs = ligne.split(";");
                    sousTheme = champs[0].trim();
                    questions.add(champs[2]);
                    reponses.add(champs[3]);

                    // Lire la ligne suivante sauf si c'est la dernière du fichier
                    if (i < 9) {
                        ligne = br.readLine();
                        if (ligne == null) break;
                    }
                }

                cartes.add(new Carte(theme, sousTheme, questions, reponses));
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur : niveau invalide dans le CSV.");
        }
        return cartes;
    }

    public Carte piocher(String theme) {
        Carte carte = null;
        switch (theme) {
            case "Improbable" :
                carte = paquetImprobable.getFirst();
                break;
            case "Mature":
                carte = paquetMature.getFirst();
                break;
            case "Plaisir" :
                carte = paquetPlaisir.getFirst();
                break;
            case "Salaire" :
                carte = paquetSalaire.getFirst();
                break;
            default:
                System.out.println("Erreur aucun paquet ici.");
                break;
        }
        return carte;
    }

    public String toString() {
        String message = "[Mon Plateau]\nImprobable";
        for(Carte c : paquetImprobable) {
            message += c.toString() + "\n";
        }
        message += "Mature\n";
        for(Carte c : paquetMature) {
            message += c.toString() + "\n";
        }
        message += "Plaisir\n";
        for(Carte c : paquetPlaisir) {
            message += c.toString() + "\n";
        }
        message += "Salaire\n";
        for(Carte c : paquetSalaire) {
            message += c.toString() + "\n";
        }
        return message;
    }

    public Case getCase(int position) {
        return cases.get(position);
    }
}
