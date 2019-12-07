package dev.beriashvili.homework.text_generator;

import java.util.ArrayList;

public interface Generator {
    String generateAlphabet(String language);

    char generateCharacter(String alphabet);

    String generateWord(int minimumBound, int maximumBound);

    ArrayList<String> generateSentence(int minimumBound, int maximumBound);

    String generateParagraph(int minimumBound, int maximumBound);
}
