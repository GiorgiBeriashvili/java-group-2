package dev.beriashvili.homework.sentence_generator;

import java.util.Arrays;

public class TextGenerator {
    /*
     * 1) მომხარებელს უთითებს წინადადებების მინიმალური და მაქსიმალური მნიშვნელობა
     *    (პროგრამა აგანერირებს შემთხვევითი რაოდენობის წინადადებებს მინიმალურსა და
     *    მაქსიმალურს შორის, ახალი წინადადების იწყება 4 ცარიელი სიმბოლოთი (სპეისით)). (1
     *    ქულა)
     *
     * 2) მომხარებელს უთითებს წინადადებაში სიტყვების მინიმალური და მაქსიმალური
     *    მნიშვნელობა (პროგრამა აგანერირებს წინადადებას, რომელიც შეგდება შემთხვევითი
     *    რაოდენობის სიტყვებისგან მინიმალურსა და მაქსიმალურს შორის, სიტყვაში
     *    იგულისხმება ნებისმიერი არაზრობრივი სიმბოლოების კრებული). (1 ქულა)
     *
     * 3) მომხარებელს უთითებს სიტყვაში სიმბოლოების მინიმალური და მაქსიმალური
     *    მნიშვნელობა (პროგრამა აგანერირებს სიტყვებს, რომელიც შეგდება შემთხვევითი
     *    რაოდენობის სიმბოლოებისგან მინიმალურსა და მაქსიმალურს შორის, სიმბოლოში
     *    იგულისხმება ნებისმიერი სიმბოლო). (1 ქულა)
     *
     * 4) მომხარებელს ირჩევს სამი ენიდან ერთ ერთს („en”, “ge”, “ru”). (1 ქულა)
     *
     * 5) სამივე ენისთვის ანბანი დააგენერირეთ პროგრამულად. (1 ქულა)
     *
     * 6) პროგრამის დაწერის დროს გამოიყენეთ ინტერფე(ისი)სები. (1 ქულა)
     *
     * 7) პარამეტრების შეტანა ხორციელდება სტრიქონის საშუალებით შემდეგი მაგალითის
     *    მიხედვით
     *    Input language: “en”
     *    Input parameters: „p-2-s-5-7-w-7-9“,
     *    გულისხმობს რომ უნდა აიგოს ინგლისურენოვანი 2 წინადადება, თითეულ
     *    წინადადებაში 5-დან 7 სიტყვამდე, თითეულ სიტყვაში 7-დან 9 სიმბოლომდე,
     *    (შესაძლოა მომხარებელმა პარამეტრები საერთოდ არ შეიტანოს, ან შეტანის დროს
     *    გამორჩეს რომელიმე პარამეტრი, გაითვალისწინეთ მომხარებლის მიერ შესაძლო
     *    დაშვებული შეცდომები). (ბონუს 5 ქულა, სტუდენტს რომელსაც დაგროვებული აქვს
     *    მაქსიმალური ქულა და არ გააკეთებს დავალებას გამოაკლდებათ 5 ქულა ქულათა
     *    ჯამიდან).
     * */
    GeneratorHandler generatorHandler;
    InputHandler inputHandler;
    Statistics statistics;
    String language;
    String parameters;
    String text;

    static void introduction() {
        System.out.println("This program serves as a text generator. Please read the instructions below.\n");

        System.out.println(String.format("Valid languages - %s", Arrays.toString(LanguageHandler.validLanguages)));
        System.out.println(String.format("The default language is: %s\n", LanguageHandler.defaultLanguage));

        System.out.println("An example of valid parameters - p-d-d-s-d-d-w-d-d-c-d-d");
        System.out.println("p = paragraph range; s = sentence range; w = word range; c = character range");
        System.out.println("d = decimal, - the minimum and the maximum range is based on these values");
        System.out.println(String.format("The default parameters: %s\n", ParameterHandler.defaultParameters));

        System.out.println("Valid parameters are determined after being pattern matched via the following regular expressions:");
        ParameterHandler.validators.forEach((key, value) -> System.out.println(String.format("%s layer: %s", key, value)));
        System.out.println("\nTo summarize, - only the quantity of the provided numeric values are taken into the account.");
        System.out.println("Thus, per available pattern matchers, provide either: 8, 4, 2 or 1 separate numeric values in any form you desire.");
        System.out.println("If pattern matchers fail to identify valid parameters, - the default parameters are parsed instead.\n");
    }

    public void main() {
        introduction();

        inputHandler = new InputHandler();

        language = inputHandler.getLanguage();
        parameters = inputHandler.getParameters();

        statistics = new Statistics();
        generatorHandler = new GeneratorHandler(language, parameters, statistics);

        try {
            System.out.print("\nGenerating the text... ");
            text = generatorHandler.generate();

            System.out.println("the text has been generated!\n");

            System.out.println(String.format("%s\n", text));
            statistics.show();
        } catch (Exception error) {
            System.out.println("the operation failed!\n");
        }
    }
}
