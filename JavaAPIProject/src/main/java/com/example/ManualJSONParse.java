package com.example;

public class ManualJSONParse {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Pikachu\",\"type\":\"Electric\",\"level\":5}";

        // Remove { } and split by commas
        jsonString = jsonString.replace("{", "").replace("}", "");
        String[] pairs = jsonString.split(",");

        String name = "", type = "";
        int level = 0;

        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replace("\"", "").trim();
            String value = keyValue[1].replace("\"", "").trim();

            switch (key) {
                case "name":
                    name = value;
                    break;
                case "type":
                    type = value;
                    break;
                case "level":
                    level = Integer.parseInt(value);
                    break;
            }
        }
        System.out.println(name + " is an " + type + " type at level " + level);
    }
}
