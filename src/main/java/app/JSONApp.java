package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {

        // System.out.println(sessionRes.toJson());

        System.out.println(sessionResult().toJson());

        /*
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}
        */
    }

    public static JsonObject sessionResult() {
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair year = new JsonPair("year", new JsonNumber(2));

        JsonPair course1 = new JsonPair("course", new JsonString("OOP"));
        JsonPair mark1 = new JsonPair("mark", new JsonNumber(3));
        JsonPair passed1 = new JsonPair("passed", new JsonBoolean(true));

        JsonPair course2 = new JsonPair("course", new JsonString("English"));
        JsonPair mark2 = new JsonPair("mark", new JsonNumber(5));
        JsonPair passed2 = new JsonPair("passed", new JsonBoolean(true));

        JsonPair course3 = new JsonPair("course", new JsonString("Math"));
        JsonPair mark3 = new JsonPair("mark", new JsonNumber(2));
        JsonPair passed3 = new JsonPair("passed", new JsonBoolean(false));

        JsonObject exam1 = new JsonObject(course1, mark1, passed1);
        JsonObject exam2 = new JsonObject(course2, mark2, passed2);
        JsonObject exam3 = new JsonObject(course3, mark3, passed3);

        JsonPair exams = new JsonPair("exams", new JsonArray(exam1, exam2, exam3));

        JsonObject sessionRes = new JsonObject(name, surname, year, exams);

        return sessionRes;
    }
}
