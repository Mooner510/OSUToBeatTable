package org.mooner510;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class FileExecutor {
    public FileExecutor(String from, String to, int level) {
        File file = new File(to);
        if(file.exists()) file.delete();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(from));
                BufferedWriter writer = new BufferedWriter(new FileWriter(to))
        ) {
            String s;
            while (!reader.readLine().startsWith("[HitObjects]"));

            JSONArray jsonArray = new JSONArray();
            while ((s = reader.readLine()) != null) {
                if(s.isBlank()) continue;
                String[] split = s.split(",");
                JSONObject json = new JSONObject();
                switch (split[0]) {
                    case "64" -> json.put("key", 0);
                    case "192" -> json.put("key", 1);
                    case "320" -> json.put("key", 2);
                    case "448" -> json.put("key", 3);
                }
                json.put("offset", Long.parseLong(split[2]));
                jsonArray.put(json);
            }
            writer.write(new JSONObject().put("level", level).put("notes", jsonArray).toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
