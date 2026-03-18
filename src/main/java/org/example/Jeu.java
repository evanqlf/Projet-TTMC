// author: Evan
package org.example;
import java.util.List;
import java.util.Random;

public class Jeu {

    private List<Equipe> equipes;
    private Plateau plateau;
    private List<Carte> cartes;
    private Joueur joueurActuel;
    private int indexEquipe = 0;

    public Jeu(List<Equipe> equipes, Plateau plateau, List<Carte> cartes) {
        this.equipes = equipes;
        this.plateau = plateau;
        this.cartes = cartes;
        //= objet jeu
    }

    public void demarrerPartie() {
        System.out.println("La partie commence !");
    }

    //méthode
    public Carte piocher(String theme) {
        Random r = new Random();
        List<Carte> filtrées = cartes.stream()
                .filter(c -> c.getTheme().equalsIgnoreCase(theme))
                .toList();
        return filtrées.get(r.nextInt(filtrées.size()));
    }

    public void chargerDepuisFichiers() {
        // Déjà géré par GestionFichier dans mon projet
    }

    public void tourDeJeu() {
        // Géré dans mon Main
    }

    public void passerEquipeSuivante() {
        indexEquipe = (indexEquipe + 1) % equipes.size();
    }

    public void finDePartie() {
        System.out.println("Partie terminée !");
    }
}
