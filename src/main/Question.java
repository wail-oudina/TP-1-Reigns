package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    protected Map<DirectionEffet,String> textesEffets;
    protected List<List<Effet>> effetsParDirection;


    /**
     * Construit une nouvelle question avec les informations données
     *
     * @param nomPersonnage Le nom du personnage associé à la question
     * @param question La question à poser

     */
    public Question(String nomPersonnage,
                    String question) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.textesEffets = new TreeMap<>();
        this.effetsParDirection = new ArrayList<>();

        for ( DirectionEffet direction : DirectionEffet.values() ) {
            effetsParDirection.add(new ArrayList<>());
        }

    }

    public void ajouteTexteEffet(DirectionEffet directionEffet,String texteEffet) {
        textesEffets.put(directionEffet,texteEffet);
    }
    public void ajouteEffet(Effet effet){
        effetsParDirection.get(effet.directionEffet.ordinal()).add(effet);
    }
    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question + "\n";

        for ( DirectionEffet direction : DirectionEffet.values() ) {
            if ( effetsParDirection.get(direction.ordinal()).size() > 0){
                result += "["+ direction.toString() +"] "  + textesEffets.get(direction)+" : "+ afficheEffets(direction)+"\n";
            }

        }

        System.out.println(result);
        System.out.flush();
    }

    /**
     * Retourne une chaîne de caractères représentant les effets d'une jauge.
     *

     * @return la chaîne de caractères représentant les effets de la jauge
     */
    private String afficheEffets(DirectionEffet directionEffet) {
        StringBuilder result = new StringBuilder();
        for ( Effet effet : effetsParDirection.get(directionEffet.ordinal()) ) {
            result.append(effet.afficheEffet());
        }

        return result.toString();

    }


    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *

     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    protected void appliqueEffets(Personnage personnage,String reponse){
        for (Effet effet : this.effetsParDirection.get(DirectionEffet.valueOf(reponse).ordinal())) {
            effet.appliqueEffet(personnage);
        }

    }







}
