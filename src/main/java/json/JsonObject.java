package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    JsonPair[] jsonPairs;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = jsonPairs;
    }

    @Override
    public String toJson() {
        String res = "{";
        res += getObjBody();
        res += "}";
        return res;
    }

    private String getObjBody() {
        String objBody = "";
        int len = jsonPairs.length;
        int counter = 0;
        for (JsonPair cuJPair: jsonPairs) {
            objBody += cuJPair.toJson();

            if (counter != len-1) {
                objBody += ", ";
            }
            counter++;
        }
        return objBody;
    }

    public void add(JsonPair jsonPair) {
        int newSize = jsonPairs.length;
        if (!contains(jsonPair.key)) {
            newSize = jsonPairs.length + 1;
        }
        JsonPair[] newJsonPairs = new JsonPair[newSize];
        newJsonPairs[0] = jsonPair;
        int counter = 0;
        for (JsonPair cuJPair: jsonPairs) {
            if (cuJPair.key != jsonPair.key) {
                counter++;
                newJsonPairs[counter] = cuJPair;
            }
        }
        jsonPairs = newJsonPairs;
    }

    public Json find(String name) {
        for (JsonPair cuJPair: jsonPairs) {
            if (cuJPair.key == name) {
                return cuJPair.value;
            }
        }
        return null;
    }

    public boolean contains(String name) {
        return find(name) != null;
    }

    public JsonObject projection(String... names) {
        JsonObject projected = new JsonObject();
        for (String name : names) {
            for (JsonPair cuJPair : jsonPairs) {
                if (cuJPair.key == name) {
                    projected.add(cuJPair);
                }
            }
        }

        return projected;
    }
}
