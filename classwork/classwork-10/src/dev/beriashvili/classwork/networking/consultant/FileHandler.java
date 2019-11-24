package dev.beriashvili.classwork.networking.consultant;

import dev.beriashvili.classwork.Utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class FileHandler {
    private File directory = Utils.getDirectory("data");
    private final File file = new File(String.format("%s/%s", directory.getPath(), "info.txt"));

    void generateData() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            HashMap<String, String> commandHashMap = new HashMap<>();

            commandHashMap.put("help", "Help is on the way.");
            commandHashMap.put("date", String.format("%s", simpleDateFormat.format(date)));
            commandHashMap.put("name", "An apology is in order due to the absence of my name.");
            commandHashMap.put("error", "Could you please elaborate?");

            for (Map.Entry<String, String> entry : commandHashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                bufferedWriter.write(String.format("%s ---- %s\n", key, value));
            }

            bufferedWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    String getData(String command) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(command)) {
                    command = line.substring(line.lastIndexOf("-")).substring(2);
                }
            }

            bufferedReader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }

        return command;
    }
}
