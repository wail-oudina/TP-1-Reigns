package main;

import java.io.File;

import java.io.FileNotFoundException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.Reader;


public class InitializerQuestions {
    public InitializerQuestions(String NomFichier) {
        try {
            Reader reader = new FileReader("test.json");
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);

            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String name = jsonObject.get("Name").getAsString();
            int age = jsonObject.get("Age").getAsInt();

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé");
        }

    }

}
