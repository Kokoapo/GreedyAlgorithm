package com.yes.main;

public class Main {
    public static void main(String[] args) {
        String[] items = {
            "Rádio", "Notebook", "Violão"
        };
        float[] weight = {
            11, 9, 6
        };
        float[] price = {
            3000, 2000, 1500
        };

        float[][] result = new float[3][2];
        result = fracionaryBackpack(items, weight, price, 16);

        showResults(items, weight, price, result);
    }

    private static float[][] fracionaryBackpack(String[] S, float[] W, float[] V, int C) {
        float[][] x = new float[3][2];
        float[] v = new float[3];
        int P = 0;

        System.out.println("Total Backpack Size: " + C + "\n");

        for(int i = 0; i < S.length; i++) {
            x[i][0] = 0;
            v[i] = V[i] / W[i];
        }

        while(P < C) {
            int index = chooseGreaterVi(v);
            v[index] = 0;

            float a = Math.min(W[index], C - P);
            x[index][0] = a;
            x[index][1] = V[index] * (a / W[index]);

            P += a;
        }

        return x;
    }

    private static int chooseGreaterVi(float[] v) {
        float greater = 0;
        int index = 0;

        for(int i = 0; i < v.length; i++) {
            if(v[i] > greater) {
                greater = v[i];
                index = i;
            }
        }

        return index;
    }

    private static void showResults(String[] items, float[] weight, float[] price, float[][] result) {
        for(int i = 0; i < items.length; i++) {
            System.out.println("Name: " + items[i] + " | Weight: " + weight[i] + 
                " | Price: " + price[i] + " | Final Weight: " + result[i][0] + " | Final Price: " + result[i][1]);
        }
    }
}