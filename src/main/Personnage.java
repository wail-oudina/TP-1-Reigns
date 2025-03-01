package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;
    /**
     * Le genre du personnage
     */
    protected Genre genre;


    /**
     *  Tableau de jauges
     * */
    protected List<Jauge> jauges;


    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     * @param genre Le genre du personnage
     */
    public Personnage(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;
        this.jauges = new ArrayList<>();
        for ( int i = 0 ; i < TypeJauge.values().length;i++){
            Jauge j = new Jauge(TypeJauge.values()[i].label, 50 );
            j.setType(TypeJauge.values()[i]);
            this.jauges.add( j );
        }

    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void AfficheJauges() {

        for ( Jauge jauge: this.jauges) {
            afficheJauge(jauge);
        }

        System.out.println();
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu(){

        for ( Jauge jauge : jauges ) {
            if (jauge.valeurHorsLimite()){
                return true;
            }
        }
        return false;
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */
    private void afficheJauge(Jauge jauge) {
        // valeur : ####

        String resultat = "[" + "#".repeat(Math.max(0, jauge.getValeur())) +
                // on complète avec ____
                "_".repeat(Math.max(0, jauge.valeur_max - (Math.max(jauge.getValeur(), 0)))) +
                "] " +
                // affichage de la valeur de la jauge
                "[" +
                jauge.getValeur() +
                "/" +
                jauge.valeur_max +
                "] " +

                // affichage du nom
                jauge.getNom();
        System.out.println(resultat);
    }

    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retourne le genre du personnage
     * @return le genre du personnage
     */
    public Genre getGenre() {
        return genre;
    }
    /**
     * Modifie le genre du personnage
     * @param genre Le nouveau genre du personnage
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    /**
     * Retourne la jauge du clergé
     * @return la jauge du clergé
     */

    public Jauge getJauge(TypeJauge type){
        for (Jauge jauge : jauges) {
            if (jauge.type.toString().equals(type.toString())) {
                return jauge;
            }
        }
        return null;
    }

}
