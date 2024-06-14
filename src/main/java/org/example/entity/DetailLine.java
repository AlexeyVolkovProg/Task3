package org.example.entity;

import org.example.MyMath;

public class DetailLine {
    private String name;
    private double amount;
    private double roundCost;
    private double kopeckDistribution;
    private static double price;


    public DetailLine() {

    }

    public DetailLine(String name, double amount) {
        this.name = name;
        this.amount = MyMath.roundTenSigns(amount);
        setRoundCost();
    }


    public double getRoundCost() {
        return roundCost;
    }

    private void setRoundCost() {
        double cost = price * amount;
        roundCost = MyMath.roundTwoSigns(cost);
    }


    public void setKopeckDistribution(double kopeckDistribution) {
        this.kopeckDistribution = kopeckDistribution;
    }

    public static void setPrice(double setPrice) {
        price = setPrice;
    }

    public static double getPrice() {
        return price;
    }


    public double getAmount() {
        return amount;
    }

    public double getSum() {
        return roundCost + kopeckDistribution;
    }


    @Override
    public String toString() {
        return "DetailLine{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", roundCost=" + roundCost +
                ", kopeckDistribution=" + kopeckDistribution +
                ", sum=" + getSum() +
                '}';
    }
}
