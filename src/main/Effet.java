package main;


public class Effet {
    /**
     * Le type de la jauge
     */
    protected TypeJauge type;
    /**
     * La valeur de l'effet
     */
    protected int valeur;

    DirectionEffet directionEffet;

    /**
     * Crée un nouvel effet avec le type et la valeur spécifiés.
     *
     * @param type Le type de la jauge
     * @param valeur La valeur de l'effet
     */
    public Effet(TypeJauge type, int valeur, DirectionEffet directionEffet){
        this.type = type;
        this.valeur = valeur;
        this.directionEffet = directionEffet;

    }

    /**
     * Retourne le type de la jauge.
     *
     * @return le type de la jauge
     */
    public TypeJauge getType() {
        return type;
    }

    /**
     * Modifie le type de la jauge.
     *
     * @param type Le nouveau type de la jauge
     */
    public void setType(TypeJauge type) {
        this.type = type;
    }

    /**
     * Retourne la valeur de l'effet.
     *
     * @return la valeur de l'effet
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de l'effet.
     *
     * @param valeur La nouvelle valeur de l'effet
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    protected String afficheEffet() {
        String result = "Jauge "+"'"+type.label+"'"+" : ";
        result += (valeur>0) ? "+" : "";
        result += valeur;
        result += " ; ";
        return result;
    }
    protected void appliqueEffet(Personnage personnage){
        Jauge jauge = personnage.getJauge(type);
        jauge.setValeur(jauge.getValeur() + valeur);
        return;
    }



}
