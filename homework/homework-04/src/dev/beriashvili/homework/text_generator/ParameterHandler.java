package dev.beriashvili.homework.text_generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Layer {
    First,
    Second,
    Third,
    Fourth {
        @Override
        public Layer next() {
            return First;
        }
    };

    public Layer next() {
        return values()[ordinal() + 1];
    }
}

public class ParameterHandler {
    static boolean isValid;
    static final int defaultMinimumBound = 5;
    static final int defaultMaximumBound = 15;
    static final String defaultParameters = String.format("p-%1$d-%2$d-s-%1$d-%2$d-w-%1$d-%2$d-c-%1$d-%2$d", defaultMinimumBound, defaultMaximumBound);

    static final LinkedHashMap<Layer, String> validators = new LinkedHashMap<>() {{
        put(Layer.First, "^\\D*\\d+\\D+\\d+\\D+\\d+\\D+\\d+\\D+\\d+\\D+\\d+\\D+\\d+\\D+\\d+\\D*$");
        put(Layer.Second, "^\\D*\\d+\\D+\\d+\\D+\\d+\\D+\\d+\\D*$");
        put(Layer.Third, "^\\D*\\d+\\D+\\d+\\D*$");
        put(Layer.Fourth, "^\\D*\\d+\\D*$");
    }};

    static ArrayList<Integer> parsedParameters;
    static Layer currentLayer = Layer.First;

    public static String validateParameters(String parameters) {
        isValid = false;

        for (HashMap.Entry<Layer, String> entry : validators.entrySet()) {
            Layer layer = entry.getKey();
            String validator = entry.getValue();

            if (Pattern.matches(validator, parameters)) {
                isValid = true;

                break;
            } else {
                currentLayer = layer.next();
            }
        }

        if (isValid) {
            return parameters;
        } else {

            return defaultParameters;
        }
    }

    public static ArrayList<Integer> parseParameters(String parameters, Layer layer) {
        parsedParameters = new ArrayList<>();

        /*
         * In these conditional statements, the current layer is examined to determine the pattern to parse the parameters
         * After the examination, program handles the parameters appropriately and adds them to the parsed parameters list
         * */
        if (layer == Layer.First) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(parameters);

            while (matcher.find()) {
                try {
                    parsedParameters.add(Integer.parseInt(matcher.group()));
                } catch (Exception error) {
                    assert true;
                }
            }
        } else if (layer == Layer.Second) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(parameters);

            while (matcher.find()) {
                try {
                    for (int index = 0; index < 1; index++) {
                        parsedParameters.add(1);
                        parsedParameters.add(Integer.parseInt(matcher.group()));
                    }
                } catch (Exception error) {
                    assert true;
                }
            }
        } else if (layer == Layer.Third) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(parameters);

            int iteration = 0;

            while (matcher.find()) {
                try {
                    if (iteration == 0) {
                        for (int index = 0; index < 4; index++) {
                            parsedParameters.add(Integer.parseInt(matcher.group()));
                        }

                        iteration++;
                    } else {
                        for (int index = 0; index < 8; index += 2) {
                            parsedParameters.add(index + 1, Integer.parseInt(matcher.group()));
                        }
                    }
                } catch (Exception error) {
                    assert true;
                }
            }
        } else if (layer == Layer.Fourth) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(parameters);

            while (matcher.find()) {
                try {
                    for (int index = 0; index < 4; index++) {
                        parsedParameters.add(1);
                        parsedParameters.add(Integer.parseInt(matcher.group()));
                    }
                } catch (Exception error) {
                    assert true;
                }
            }
        }

        /*
         * If the minimum bound is smaller than the maximum bound, - swap the values
         * This is done to ensure that no error will be generated from random number generation
         * */
        for (int index = 0, ephemeral; index < parsedParameters.size(); index++) {
            if ((index & 1) == 1 && parsedParameters.get(index) < parsedParameters.get(index - 1)) {
                ephemeral = parsedParameters.get(index - 1);

                parsedParameters.set(index - 1, parsedParameters.get(index));
                parsedParameters.set(index, ephemeral);
            }
        }

        return parsedParameters;
    }
}
