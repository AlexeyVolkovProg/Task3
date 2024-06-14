package org.example;

import org.example.entity.DetailLine;
import org.example.ParseCsv;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void Input() {
        DetailLine.setPrice(10d);
        if (true) return;

        //Этот код оставил, если захотите ,с другим ценником на единицу товара протестировать
        Scanner scanner = new Scanner(System.in);

        Double number = null;
        while (number == null) {
            System.out.print("Введите цену за единицу товара:");
            String input = scanner.nextLine();
            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }

        System.out.println("Вы ввели число: " + number);
        DetailLine.setPrice(number);

        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        Input();
        String filePath = "data.csv";
        String Splitter = ",";
        List<DetailLine> detail = ParseCsv.ParseProductCsv(filePath, Splitter);

        //Тут вызов метода или прямая обработка полученных продуктов



        double sumReal = 0;
        double sumRound = 0;
        double amount = 0;

        for (DetailLine line : detail) {
            sumReal += line.getAmount() * DetailLine.getPrice();
            sumRound += line.getRoundCost();
            amount += line.getAmount();
        }

        //Расхождение по копейкам. Вычисление общего кол-ва копеек, которые будем распределять
        double kopeckDistribution = MyMath.roundTwoSigns(sumReal - sumRound);
        double kopeckLeft = kopeckDistribution;

        //Распределяем копейки
        for (DetailLine line : detail) {
            double k = line.getAmount() / amount;
            double kopeck = Math.min(kopeckLeft, MyMath.ceilTwoSigns(k * kopeckDistribution));
            line.setKopeckDistribution(kopeck);
            kopeckLeft = MyMath.ceilTwoSigns(kopeckLeft - kopeck);
        }

        double sum = 0;

        for (DetailLine line : detail) {
            sum += line.getSum();
        }

        sum = MyMath.roundTwoSigns(sum);


        for (DetailLine line : detail) {
            System.out.println(line);
        }
        System.out.println("totalSum=" + sum);
    }
}