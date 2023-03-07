package main;

import java.util.Arrays;
import java.util.Scanner;

public class Reponse {
    Question question;
    Personnage personnage;

    public Reponse(Question question, Personnage personnage) {
        this.question = question;
        this.personnage = personnage;
    }
    public void derouler(){
        this.question.afficheQuestion();
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponseValide(reponse)){
            String choixValides = "";
            for ( DirectionEffet direction : DirectionEffet.values() ) {
                if ( question.effetsParDirection.get(direction.ordinal()).size() > 0){
                    choixValides += " [" + direction.toString() + "]";
                }

            }


            System.out.println("Entrez une réponse valide :" + choixValides);

            System.out.flush();
            reponse = scanner.nextLine();
        }
        this.question.appliqueEffets(this.personnage,reponse);
    }

    public boolean reponseValide(String reponse){
        for ( DirectionEffet direction : DirectionEffet.values()){
            if (direction.toString().equals(reponse)){
                return true;
            }
        }
        return false;
    }
}
