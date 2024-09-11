package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

public class WriteSymptomDataToFile implements IsymptomWriter{

    private String filePath;

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
                    System.out.println(entry.getKey() + ": " + entry.getValue());
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
