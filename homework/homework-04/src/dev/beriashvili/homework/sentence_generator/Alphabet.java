package dev.beriashvili.homework.sentence_generator;

import java.util.HashMap;

public class Alphabet {
    static final HashMap<String, String> alphabetRange = new HashMap<>();
    static String alphabet;

    public static void initializeAlphabet(String language) {
        alphabetRange.put(language, LanguageHandler.getLetterRange(language));
    }

    public static String getAlphabet(String language) {
        initializeAlphabet(language);

        char firstLetter, lastLetter;

        firstLetter = alphabetRange.get(language).charAt(0);
        lastLetter = alphabetRange.get(language).charAt(2);

        StringBuilder alphabetBuilder = new StringBuilder();

        for (int letter = firstLetter; letter <= (int) lastLetter; letter++) {
            alphabetBuilder.append((char) letter);
        }

        alphabet = alphabetBuilder.toString();

        return alphabet;
    }
}
