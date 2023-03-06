package main;

import java.io.File;

import java.io.FileNotFoundException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.Reader;
import java.util.Map;


public class InitializerQuestions {
    public InitializerQuestions(String NomFichier) {
        try {
            Reader reader = new FileReader("test.json");
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);

            JsonObject jsonObject = jsonElement.getAsJsonObject();
            int age = jsonObject.get("Personne").getAsJsonObject().get("Info").getAsJsonObject().get("Age").getAsInt();


            System.out.println("Age: " + age);
        }
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé");
        }

    }
    public String getNomPersonnage(JsonObject jsonQuestion ){
        return jsonQuestion.get("NomPersonnage").getAsString();
    }
    public String getQuestion(JsonObject jsonQuestion){
        return jsonQuestion.get("Question").getAsString();
    }
    public Map<DirectionEffet,String> getTexteEffets(JsonObject jsonQuestion){}

}
