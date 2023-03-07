package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {
    /**
     * le personnage joué
     */
    private static Personnage personnage;

    /**
     * la banque de questions
     */
    private static ArrayList<Question> questions;

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args)  {

        // début du jeu
        System.out.println("Bienvenue sur Reigns");

        initBanqueQuestions();

        System.out.println("Création du personnage...");

        initPersonnage();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

        personnage.AfficheJauges();

        // tirage des questions
        int nbTours = 0;
        while(!personnage.finDuJeu()){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            personnage.AfficheJauges();
        }

        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question){
        Reponse reponse = new Reponse(question,personnage);
        reponse.derouler();
    }

    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    private static void initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();


        StringBuilder choixGenre = new StringBuilder();
        for (Genre genre : Genre.values()) {
            choixGenre.append(genre.label).append(" [").append((genre.ordinal()) + 1).append("] ");
        }
        System.out.println(
                "Comment faut-il vous appeler ?" + choixGenre);
        int genre = scanner.nextInt()-1;
        Genre roiReine = Genre.values()[genre];
        Reigns.personnage = new Personnage(nom, roiReine);

    }

    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    private static void initBanqueQuestions(){
        InitializerQuestions initializerQuestions = new InitializerQuestions("questions.json");
        questions = initializerQuestions.initQuestions();
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }
}