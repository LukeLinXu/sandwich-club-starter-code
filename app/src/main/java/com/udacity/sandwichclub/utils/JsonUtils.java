package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String mainName = jsonObject.getJSONObject("name").getString("mainName");
            List<String> alsoKnownAs = new ArrayList<>();
            JSONArray ingredients0 = jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
            for(int i = 0; i < ingredients0.length(); i++){
                alsoKnownAs.add(ingredients0.getString(i));
            }
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            List<String> ingredients = new ArrayList<>();
            JSONArray ingredients1 = jsonObject.getJSONArray("ingredients");
            for(int i = 0; i < ingredients1.length(); i++){
                ingredients.add(ingredients1.getString(i));
            }
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
