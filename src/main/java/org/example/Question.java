// author: Evan
package org.example;

public class Question {

    private int niveau;
    private String texte;
    private String reponse;

    public Question(int niveau, String texte, String reponse) {
        this.niveau = niveau;
        this.texte = texte;
        this.reponse = reponse;
    }

    public int getNiveau() {
        return niveau;
    }

    public String getTexte() {
        return texte;
    }

    public String getReponse() {
        return reponse;
    }

    public boolean verifier(String reponseJoueur) {
        return reponseJoueur.equalsIgnoreCase(reponse);
    }
}
