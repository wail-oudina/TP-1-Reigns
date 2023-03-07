package main;

import java.io.File;

import java.io.FileNotFoundException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class InitializerQuestions {
    String nomFichier;
    public InitializerQuestions(String NomFichier) {

        this.nomFichier = NomFichier;
    }
    public ArrayList<Question> initQuestions(){
        JsonArray jsonQuestions = getJsonQuestions();

        ArrayList<Question> questions = new ArrayList<>();

        for ( int i=0 ; i<jsonQuestions.size() ; i++){
            JsonObject jsonQuestion = jsonQuestions.get(i).getAsJsonObject();
            String nomPersonnage = getNomPersonnage(jsonQuestion);
            String questiontxt = getQuestion(jsonQuestion);


            Map<DirectionEffet,String> texteEffets = getTexteEffets(jsonQuestion);
            ArrayList<Effet> effets = getEffets(jsonQuestion);


            Question question = new Question(nomPersonnage,questiontxt);

            for (Map.Entry<DirectionEffet,String> rep : texteEffets.entrySet()) {
                question.ajouteTexteEffet(rep.getKey(),rep.getValue());
            }




            for ( Effet effet : effets){
                question.ajouteEffet(effet);
            }

            questions.add(question);
       }
        return questions;
    }

    public JsonArray getJsonQuestions(){
        try {
            Reader reader = new FileReader(this.nomFichier);
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            JsonArray jsonQuestions = jsonElement.getAsJsonArray();
            return jsonQuestions;
        }
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé");
        }
        return null;
    }
    public String getNomPersonnage(JsonObject jsonQuestion ){
        return jsonQuestion.get("NomPersonnage").getAsString();
    }
    public String getQuestion(JsonObject jsonQuestion){
        return jsonQuestion.get("Question").getAsString();
    }
    public Map<DirectionEffet,String> getTexteEffets(JsonObject jsonQuestion){
        Map<DirectionEffet,String> texteEffets = new TreeMap<>();
        JsonArray jsonReponsesArray = jsonQuestion.getAsJsonArray("Reponse");
        for ( int i=0 ; i<jsonReponsesArray.size() ; i++){
            JsonObject jsonReponse = jsonReponsesArray.get(i).getAsJsonObject();
            String texteEffet = jsonReponse.get("TexteEffet").getAsString();
            String directionEffet = jsonReponse.get("DirectionEffet").getAsString();
            DirectionEffet direction = DirectionEffet.valueOf(directionEffet);
            texteEffets.put(direction,texteEffet);
        }
        return texteEffets;

    }
    public ArrayList<Effet> getEffets(JsonObject jsonQuestion){

        ArrayList<Effet> finalList = new ArrayList<>();
        JsonArray jsonEffetsArray = jsonQuestion.get("Effets").getAsJsonArray();
        for (int i=0 ; i<jsonEffetsArray.size() ; i++){

        JsonObject jsonEffet = jsonEffetsArray.get(i).getAsJsonObject();
        TypeJauge typeJauge = TypeJauge.valueOf(jsonEffet.get("TypeJauge").getAsString());
        int valeur = jsonEffet.get("Valeur").getAsInt();
        DirectionEffet directionEffet = DirectionEffet.valueOf(jsonEffet.get("Direction").getAsString());
        Effet effet = new Effet(typeJauge,valeur,directionEffet);
        finalList.add(effet);
        }
        return finalList;



    }


}
