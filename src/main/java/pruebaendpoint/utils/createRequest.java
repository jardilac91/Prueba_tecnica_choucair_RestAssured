package pruebaendpoint.utils;

import org.json.JSONObject;

public class createRequest {

    private createRequest() {
        throw new IllegalStateException("Utility class");
    }
    public static String createJson(String name, String salary, String age){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("salary", salary);
        jsonObject.put("age", age );
        return jsonObject.toString();
    }
}
