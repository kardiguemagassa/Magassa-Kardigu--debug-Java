package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filePath = "/Users/kara/Documents/dev-env/open-c/projet/Magassa-Kardigu--debug-Java/Project02Eclipse/result.out";

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filePath != null) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid file path.");
        }
    }

}
