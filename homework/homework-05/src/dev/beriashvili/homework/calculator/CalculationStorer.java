package dev.beriashvili.homework.calculator;

import dev.beriashvili.homework.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class CalculationStorer {
    static void store(String calculation) {
        File directory = Utils.getDirectory("data");
        final File file = new File(String.format("%s/%s", directory.getPath(), "calculations.txt"));

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            bufferedWriter.write(String.format("[%s]: %s\n", simpleDateFormat.format(date), calculation));

            bufferedWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
