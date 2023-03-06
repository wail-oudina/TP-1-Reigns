package main;

/**
 * Enumeration des différents types de jauges
 */
public enum TypeJauge {
    /**
     * Jauge du clergé
     */
    CLERGE("Clergé"),
    /**
     * Jauge du peuple
     */
    PEUPLE("Peuple"),
    /**
     * Jauge de l'armée
     */
    ARMEE("Armée"),
    /**
     * Jauge des finances
     */
    FINANCE("Finances");

    public String label;

    TypeJauge(String label) {
        this.label = label;
    }
}