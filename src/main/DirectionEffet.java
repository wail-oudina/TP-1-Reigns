package main;

public enum DirectionEffet {
    G("Gauche"),
    D("Droite");

    public String label;
    DirectionEffet(String label) {
        this.label = label;
    }
}
