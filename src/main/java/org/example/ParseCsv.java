package org.example;

import org.example.entity.DetailLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Парсер таблицы CSV
 */
public class ParseCsv {
    public static List<DetailLine> ParseProductCsv(String filePath, String Splitter) throws IOException {
        //Загружаем строки из файла
        List<DetailLine> products = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(Splitter);
            DetailLine product = new DetailLine(splitedText[0], Double.parseDouble(splitedText[1]));
            products.add(product);
        }
        return products;
    }
}
