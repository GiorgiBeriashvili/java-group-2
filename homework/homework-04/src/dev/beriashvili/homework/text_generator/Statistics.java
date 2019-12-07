package dev.beriashvili.homework.text_generator;

public class Statistics {
    public int characterCount;
    public int wordCount;
    public int sentenceCount;
    public int paragraphCount;

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    public int getParagraphCount() {
        return paragraphCount;
    }

    public void setParagraphCount(int paragraphCount) {
        this.paragraphCount = paragraphCount;
    }

    public void show() {
        System.out.println("The statistics of the resulting text generation:");
        System.out.println(String.format("Generated character count: %d", characterCount));
        System.out.println(String.format("Generated word count: %d", wordCount));
        System.out.println(String.format("Generated sentence count: %d", sentenceCount));
        System.out.println(String.format("Generated paragraph count: %d", paragraphCount));
        System.out.println(String.format("Layer: %s", ParameterHandler.currentLayer));
        System.out.println(String.format("Parsed the default parameters: %b", !ParameterHandler.isValid));
        System.out.println(String.format("Parsed parameters: %s", ParameterHandler.parsedParameters));
    }
}
