package dev.beriashvili.homework.text_generator;

public class LanguageHandler {
    static final String defaultLanguage = "en";
    static final String[] validLanguages = {"en", "ge", "ru"};

    static String validateLanguage(String language) {
        boolean isValid = false;

        language = language.toLowerCase();

        for (String validLanguage : validLanguages) {
            if (language.equals(validLanguage)) {
                isValid = true;

                break;
            }
        }

        if (isValid) {
            return language;
        } else {
            return defaultLanguage;
        }
    }

    static String getLetterRange(String language) {
        switch (language) {
            case "ge":
                return "ა-ჰ";
            case "ru":
                return "а-я";
            default:
                return "a-z";
        }
    }
}
