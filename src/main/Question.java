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
    /**
     * l'effet de la réponse de gauche
     */
    protected String effetGauche;
    /**
     * l'effet de la réponse de droite
     */
    protected String effetDroite;
    /**
     * les effets sur les jauges pour la réponse de gauche
     */
    protected List<Effet> effetJaugeGauche;
    /**
     * les effets sur les jauges pour la réponse de droite
     */
    protected List<Effet> effetJaugeDroite;

    protected List<Effet> effets;


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
        this.effets = new ArrayList<>();
        this.effetJaugeDroite = new ArrayList<>();
        this.effetJaugeGauche = new ArrayList<>();
    }

    public void ajouteTexteEffet(DirectionEffet directionEffet,String texteEffet) {
        textesEffets.put(directionEffet,texteEffet);
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question;
        for ( Map.Entry<DirectionEffet,String> rep : textesEffets.entrySet()) {
            result += "["+rep.getKey()+": "+rep.getValue()+"]";
        }

        result += "\n";

        for ( DirectionEffet direction : DirectionEffet.values() ) {
            result += "Effet "+direction.toString()+" : "+ afficheEffets(direction)+"\n";
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
        for (Effet effet : this.effets) {
            if ( effet.directionEffet == directionEffet ){
                result.append(effet.afficheEffet());
            }
        }
        return result.toString();

    }


    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *

     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    protected void appliqueEffets(Personnage personnage,String reponse){
        for (Effet effet : this.effets) {
            if ( effet.directionEffet.toString().equals(reponse)){
                effet.appliqueEffet(personnage);
            }

        }
    }



    public void ajouteEffet(Effet effet){
        effets.add(effet);
    }

    /**
     * Retourne le nom du personnage associé à la question.
     *
     * @return le nom du personnage associé à la question
     */
    public String getNomPersonnage() {
        return nomPersonnage;
    }

    /**
     * Modifie le nom du personnage associé à la question.
     *
     * @param nomPersonnage le nouveau nom du personnage associé à la question
     */
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    /**
     * Retourne la question.
     *
     * @return la question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Modifie la question.
     *
     * @param question la nouvelle question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retourne l'effet gauche de la question.
     *
     * @return l'effet gauche de la question.
     */
    public String getEffetGauche() {
        return effetGauche;
    }

    /**
     * Modifie l'effet gauche de la question.
     *
     * @param effetGauche le nouvel effet gauche de la question
     */
    public void setEffetGauche(String effetGauche) {
        this.effetGauche = effetGauche;
    }

    /**
     * Retourne l'effet droit de la question.
     *
     * @return l'effet droit de la question.
     */
    public String getEffetDroite() {
        return effetDroite;
    }

    /**
     * Modifie l'effet droit de la question.
     *
     * @param effetDroite le nouvel effet droit de la question
     */
    public void setEffetDroite(String effetDroite) {
        this.effetDroite = effetDroite;
    }

}
