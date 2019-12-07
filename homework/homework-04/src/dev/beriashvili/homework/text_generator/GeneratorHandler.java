package dev.beriashvili.homework.text_generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GeneratorHandler implements Generator {
    final HashMap<String, Integer> bounds = new HashMap<>();
    final String[] extrema = {"Minimum Paragraphs", "Maximum Paragraphs", "Minimum Sentences", "Maximum Sentences", "Minimum Words", "Maximum Words", "Minimum Characters", "Maximum Characters"};
    final Random random = new Random();
    String alphabet;
    ArrayList<Integer> parsedParameters;
    Statistics statistics;
    int paragraphRange, sentenceRange, wordRange, characterRange;

    public GeneratorHandler(String language, String parameters, Statistics statistics) {
        this.statistics = statistics;
        language = LanguageHandler.validateLanguage(language);
        parameters = ParameterHandler.validateParameters(parameters);
        parsedParameters = ParameterHandler.parseParameters(parameters, ParameterHandler.currentLayer);

        alphabet = generateAlphabet(language);
    }

    String generate() {
        for (int index = 0; index < parsedParameters.size(); index++) {
            bounds.put(extrema[index], parsedParameters.get(index));
        }

        StringBuilder text = new StringBuilder();
        paragraphRange = random.nextInt(bounds.get("Maximum Paragraphs") - bounds.get("Minimum Paragraphs") + 1) + bounds.get("Minimum Paragraphs");

        for (int index = 0; index < paragraphRange; index++) {
            text.append(String.format("%s\n\n", generateParagraph(bounds.get("Minimum Sentences"), bounds.get("Maximum Sentences"))));
        }

        return text.toString().trim();
    }

    @Override
    public String generateAlphabet(String language) {
        return Alphabet.getAlphabet(language);
    }

    @Override
    public char generateCharacter(String alphabet) {
        statistics.setCharacterCount(statistics.getCharacterCount() + 1);

        return alphabet.charAt(random.nextInt(alphabet.length()));
    }

    @Override
    public String generateWord(int minimumBound, int maximumBound) {
        StringBuilder word = new StringBuilder();

        characterRange = random.nextInt(maximumBound - minimumBound + 1) + minimumBound;

        for (int index = 0; index < characterRange; index++) {
            word.append(generateCharacter(alphabet));
        }

        statistics.setWordCount(statistics.getWordCount() + 1);

        return word.toString();
    }

    @Override
    public ArrayList<String> generateSentence(int minimumBound, int maximumBound) {
        ArrayList<String> sentence = new ArrayList<>();

        wordRange = random.nextInt(maximumBound - minimumBound + 1) + minimumBound;

        for (int index = 0; index < wordRange; index++) {
            sentence.add(generateWord(bounds.get("Minimum Characters"), bounds.get("Maximum Characters")));
        }

        statistics.setSentenceCount(statistics.getSentenceCount() + 1);

        return sentence;
    }

    @Override
    public String generateParagraph(int minimumBound, int maximumBound) {
        StringBuilder paragraph = new StringBuilder();
        ArrayList<String> sentence;

        sentenceRange = random.nextInt(maximumBound - minimumBound + 1) + minimumBound;

        for (int index = 0; index < sentenceRange; index++) {
            sentence = generateSentence(bounds.get("Minimum Words"), bounds.get("Maximum Words"));

            for (String word : sentence) {
                paragraph.append(String.format("%s ", word));
            }

            paragraph.deleteCharAt(paragraph.length() - 1);
            paragraph.append(". ");
        }

        statistics.setParagraphCount(statistics.getParagraphCount() + 1);

        return paragraph.toString().stripTrailing();
    }
}
