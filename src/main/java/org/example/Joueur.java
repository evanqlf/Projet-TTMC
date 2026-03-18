// author: Evan
package org.example;

import java.util.Scanner;

public class Joueur {

    private String nom;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public int choisirNiveau() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choisissez un niveau (1 à 10) : ");
        return sc.nextInt();
    }

    public String proposerReponse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Votre réponse : ");
        return sc.nextLine();
    }

    public String getNom() {
        return nom;
    }
}
