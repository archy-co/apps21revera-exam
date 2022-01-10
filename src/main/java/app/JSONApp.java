package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        System.out.println(sessionResult().toJson());
    }

    public static JsonObject sessionResult() {
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair year = new JsonPair("year", new JsonNumber(2));

        JsonPair courseOOP = new JsonPair("course", new JsonString("OOP"));
        JsonPair markOOP = new JsonPair("mark", new JsonNumber(3));
        JsonPair passedOOP = new JsonPair("passed", new JsonBoolean(true));

        JsonPair courseEng = new JsonPair("course", new JsonString("English"));
        JsonPair markEng = new JsonPair("mark", new JsonNumber(5));
        JsonPair passedEng = new JsonPair("passed", new JsonBoolean(true));

        JsonPair courseMath = new JsonPair("course", new JsonString("Math"));
        JsonPair markMath = new JsonPair("mark", new JsonNumber(2));
        JsonPair passedMath = new JsonPair("passed", new JsonBoolean(false));

        JsonObject examOOP = new JsonObject(courseOOP, markOOP, passedOOP);
        JsonObject examEng = new JsonObject(courseEng, markEng, passedEng);
        JsonObject examMath = new JsonObject(courseMath, markMath, passedMath);

        JsonPair exams = new JsonPair("exams",
                                    new JsonArray(examOOP, examEng, examMath));

        JsonObject sessionRes = new JsonObject(name, surname, year, exams);

        return sessionRes;
    }
}
