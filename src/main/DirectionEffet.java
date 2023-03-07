package main;

public enum DirectionEffet {
    G("Gauche"),
    D("Droite"),
    H("Haut");

    public String label;
    DirectionEffet(String label) {
        this.label = label;
    }
}
