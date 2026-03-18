// author: Imane Elmessaouri
package org.example;

import java.io.BufferedReader;import java.io.FileReader;import java.io.IOException;import java.util.ArrayList;import java.util.List;import java.util.Random;import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Lire un CSV
    public static void lireCSVBrut(String chemin) {
        try {
            FileReader fr = new FileReader(chemin);
            BufferedReader br = new BufferedReader(fr);

            List<String> lignes = br.lines().toList();

            for (String ligne : lignes) {
                System.out.println("Ligne : " + ligne);
                String[] champs = ligne.split(";");
                for (String c : champs) {
                    System.out.println(" → " + c);
                }
                System.out.println();
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Erreur lecture CSV : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // PARTIE ADMIN
        //GestionFichier gestion = new GestionFichier("data");
        //List<Carte> cartes = gestion.chargerCartes();

        System.out.println("=== MINI PROJET TTMC ===");
        System.out.println("Chargement des cartes terminé.\n");

        // Création des équipes
        System.out.print("Combien d'équipes ? (2 recommandé) : ");
        int nbEquipes = sc.nextInt();
        sc.nextLine();

        List<Equipe> equipes = new ArrayList<>();
        int[] positions = new int[nbEquipes];

        for (int i = 0; i < nbEquipes; i++) {
            equipes.add(new Equipe("Équipe " + (i + 1)));
            positions[i] = 0;
        }

        // Plateau de 20 cases
        Plateau plateau = new Plateau();

        boolean partieEnCours = true;
        int equipeActive = 0;

        // BOUCLE DE JEU
        while (partieEnCours) {

            Equipe eq = equipes.get(equipeActive);
            int pos = positions[equipeActive];

            System.out.println("\n--------------------------------");
            System.out.println("Tour de " + eq.getNom());
            System.out.println("Position actuelle : case " + pos);
            System.out.println("--------------------------------");

            // 1) Déterminer le thème selon la case
            String theme = plateau.getCase(pos).getTheme();
            System.out.println("Thème de la case : " + theme);

            // 2) Tirer une carte (sous-thème)

            Carte carteChoisie = plateau.piocher(theme);
            System.out.println("Sous-thème tiré : " + carteChoisie.getSousTheme());

            // 3) Choisir difficulté
            int niveau;
            do {
                System.out.print("Choisissez une difficulté (1 à 10) : ");
                niveau = sc.nextInt();
            } while (niveau < 1 || niveau > 10);

            sc.nextLine();

            // 4) Récupérer la question
            String question = carteChoisie.getQuestion(niveau);

            if (question == null) {
                System.out.println("Erreur : question introuvable !");
                continue;
            }

            System.out.println("\nQUESTION : " + question);
            System.out.print("Votre réponse : ");
            String rep = sc.nextLine();

            // 5) Vérification
            if (carteChoisie.bonneReponse(niveau, rep)) {
                System.out.println("Bonne réponse !");
                positions[equipeActive] += niveau;
            } else {
                System.out.println("Mauvaise réponse !");
                System.out.println("La bonne réponse était : " + carteChoisie.getReponse(niveau));
            }

            // 6) Condition de victoire
            if (positions[equipeActive] >= 19) {
                System.out.println("\n🎉 VICTOIRE de " + eq.getNom() + " !!!");
                partieEnCours = false;
                break;
            }

            // 7) Tour suivant
            equipeActive = (equipeActive + 1) % nbEquipes;
        }

        System.out.println("\n=== FIN DE PARTIE ===");
    }
}