package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main( String args[] ) throws Exception {

        // 1. Instancie des objets qui implémentent les interfaces ISymptomReader et ISymptomWriter
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("/Users/kara/Documents/dev-env/open-c/projet/Magassa-Kardigu--debug-Java/Project02Eclipse/symptoms.txt");
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile("/Users/kara/Documents/dev-env/open-c/projet/Magassa-Kardigu--debug-Java/Project02Eclipse/result.out");

        // 2. Crée un objet AnalyticsCounter avec les readers et writers
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);

        //
        List<String> getSymptoms = analyticsCounter.getSymptoms();

        // 3. Compte les occurrences des symptômes
        Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(getSymptoms);

        // Trie les symptômes par nom
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);

        // Écrit les résultats dans un fichier
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}
