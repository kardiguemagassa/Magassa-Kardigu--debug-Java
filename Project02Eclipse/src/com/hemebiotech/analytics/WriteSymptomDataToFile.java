package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

/**
 * La classe WriteSymptomDataToFile pour écrire des symptômes et de leurs occurrences
 * dans un fichier. Elle implémente l'interface IsymptomWriter.
 * * Les symptômes sont fournis sous forme de Map où les clés sont les noms des symptômes et les valeurs sont
 * * leurs nombres d'occurrences respectifs.
 */
public class WriteSymptomDataToFile implements IsymptomWriter{

    private String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filePath == null) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

                //// Iteration avec le Stream
                symptoms.forEach((key, value) -> {
                    try {
                        bufferedWriter.write(key + " : " + value);
                        bufferedWriter.newLine();
                        System.out.println(key + " : " + value);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid file path.");

        }
    }

}
