// author: Evan
package org.example;

import java.util.List;

public class Carte {

    private String theme;
    private String sousTheme;
    private List<String> questions;
    private List<String> reponses;

    public Carte(String theme, String sousTheme, List<String> questions, List<String> reponses) {
        this.theme = theme;
        this.sousTheme = sousTheme;
        this.questions = questions;
        this.reponses = reponses;
    }

    public String toString() {
        String message = "[Carte] - " + this.theme + " | " + this.sousTheme + "\n";
        for (int i = 0; i < questions.size(); i++) {
            message += (i+1) + " Question = " + questions.get(i) +
                    " | Reponse = " + reponses.get(i) + "\n";
        }
        return message;
    }

    public boolean bonneReponse(int note, String reponse) {
        return reponse.equalsIgnoreCase(reponses.get(note-1));
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<String> getReponses() {
        return reponses;
    }

    public String getReponse(int index) {
        return reponses.get(index-1);
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public String getQuestion(int index) {
        return questions.get(index-1);
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public String getSousTheme() {
        return sousTheme;
    }

    public void setSousTheme(String sousTheme) {
        this.sousTheme = sousTheme;
    }
}
