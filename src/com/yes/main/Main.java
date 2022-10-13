package com.yes.main;

public class Main {
    //Main Method, Creates Data to be used by Greedy and calls fractionaryBackpack and showResults methods
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
        result = fractionaryBackpack(items, weight, price, 16);

        showResults(items, weight, price, result);
    }

    /*Greedy Algorythm itself, returns a 2D Matrix with Final Weight and Price used by each element inside the Backpack
    Creates an Average Value (v vector) for each element to be selected, then it calls chooseGreater_v method and uses it index 
    returned value to turn the selected v into 0 (so it can't be selected again), storage the weight to be put on the Backpack
    based on the remaining space inside it and storage Final Weight (column 0) and Final Price (column 1) values on x 2D Matrix
    Repeats the process until the Backpack is completely full*/ 
    private static float[][] fractionaryBackpack(String[] S, float[] W, float[] V, int C) {
        float[][] x = new float[3][2];
        float[] v = new float[3];
        int P = 0;

        System.out.println("Total Backpack Size: " + C + "\n");

        for(int i = 0; i < S.length; i++) {
            x[i][0] = 0;
            v[i] = V[i] / W[i];
        }

        while(P < C) {
            int index = chooseGreater_v(v);
            v[index] = 0;

            float a = Math.min(W[index], C - P);
            x[index][0] = a;
            x[index][1] = V[index] * (a / W[index]);

            P += a;
        }

        return x;
    }

    //Choose the Greater v (V / W) value to be selected and returns it index
    private static int chooseGreater_v(float[] v) {
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

    //Show Final Results on Console
    private static void showResults(String[] items, float[] weight, float[] price, float[][] result) {
        for(int i = 0; i < items.length; i++) {
            System.out.println("Name: " + items[i] + " | Weight: " + weight[i] + 
                " | Price: " + price[i] + " | Final Weight: " + result[i][0] + " | Final Price: " + result[i][1]);
        }
    }
}