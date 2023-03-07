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
    ROI("Roi","au Roi"),
    /**
     * Genre féminin
     */
    REINE("Reine","à la Reine"),
    /**
     * Pas de genres
     */
    AUTRE("Non genré","à la Royauté");

    public String label;
    public String pronom;
    Genre(String label,String pronom){
        this.label = label;
        this.pronom = pronom;
    }

    /**
     * Retourne une chaîne de caractères indiquant "Long règne au roi" ou "Long règne à la reine"
     *
     * @return une chaîne de caractères indiquant "Long règne au roi" ou "Long règne à la reine"
     */
    public String longRegne(){
        return "Long règne "+pronom;
    }
}