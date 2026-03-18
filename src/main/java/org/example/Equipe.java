// author: Evan
package org.example;
import java.util.ArrayList;
import java.util.List;

public class Equipe {

    private String nom;
    private List<Joueur> joueurs;
    private int position;

    public Equipe(String nom) {
        this.nom = nom;
        this.joueurs = new ArrayList<>();
        this.position = 0;
    }

    public void ajouterJoueur(Joueur joueur) {
        joueurs.add(joueur);
    }

    public void jouerTour() {
        // Géré dans Main
    }

    public void avancer(int nbCases) {
        position += nbCases;
        if (position > 19) position = 19;
    }

    public String getNom() {
        return nom;
    }

    public int getPosition() {
        return position;
    }
}
