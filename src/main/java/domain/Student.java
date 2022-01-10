package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private Tuple<String, Integer>[] exams;
    private final int PASS_LOWER_BOUND = 3;
    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonStudentObj =  super.toJsonObject();
        JsonObject []examsObj = new JsonObject[exams.length];

        int counter = 0;
        for (Tuple<String, Integer> exam: exams) {
            JsonPair course = new JsonPair("course", new JsonString(exam.key));
            JsonPair mark = new JsonPair("mark", new JsonNumber(exam.value));
            JsonPair passed = new JsonPair("passed", new JsonBoolean(exam.value >= PASS_LOWER_BOUND));

            JsonObject currentObj = new JsonObject(course, mark, passed);
            examsObj[counter] = currentObj;

            counter++;
        }
        JsonPair examsRes = new JsonPair("exams", new JsonArray(examsObj));
        jsonStudentObj.add(examsRes);
        return jsonStudentObj;
    }
}