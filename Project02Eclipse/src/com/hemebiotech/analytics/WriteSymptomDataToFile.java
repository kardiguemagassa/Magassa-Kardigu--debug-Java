package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            //Création d'un fileWriter pour écrire dans un fichier
            FileWriter fileWriter = new FileWriter("/Users/kara/Documents/dev-env/open-c/projet/Magassa-Kardigu--debug-Java/Project02Eclipse/result.out");

            // Création d'un bufferedWriter qui utilise le fileWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // ajout d'un texte à notre fichier
            bufferedWriter.write("headache: " + headacheCount );
            bufferedWriter.newLine();
            bufferedWriter.write("rash: " + rashCount);
            bufferedWriter.newLine();
            bufferedWriter.write("dialated pupil: " + pupilCount);

            // Retour à la ligne
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
