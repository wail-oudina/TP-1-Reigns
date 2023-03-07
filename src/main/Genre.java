package main;

/**
 * Représente les différents genres possibles.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public enum Genre {
    /**
     * Genre masculin
     */
    ROI("au Roi"),
    /**
     * Genre féminin
     */
    REINE("à la Reine"),
    /**
     * Pas de genres
     */
    AUTRE("à la Royauté");

    private String label;
    Genre(String label){
        this.label = label;
    }

    /**
     * Retourne une chaîne de caractères indiquant "Long règne au roi" ou "Long règne à la reine"
     *
     * @return une chaîne de caractères indiquant "Long règne au roi" ou "Long règne à la reine"
     */
    public String longRegne(){
        return "Long règne "+label;
    }
}