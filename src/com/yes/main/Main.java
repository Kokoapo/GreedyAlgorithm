package com.yes.main;

public class Main {
    //Main Method, Creates Data to be used by Greedy and calls fractionaryBackpack and showResults methods
    public static void main(String[] args) {
        String[] items = {
            "Bread", "Water", "Beer", "Meat", "Rice", "Wood", "Kerosene", "Matchbox"
        };
        //Weight in Kg
        float[] weight = {
            2, 7, 6, 3, 3, 7, 1, (float) 0.2
        };
        //Benefit = Product's Price
        float[] benefit = {
            15, 70, 40, 10, 15, 12, 3, 2
        };

        float[][] result = new float[items.length][2];
        result = fractionaryBackpack(items, weight, benefit, 16);

        showResults(items, weight, benefit, result);
    }

    /*Greedy Algorythm itself, returns a 2D Matrix with Final Weight and Price used by each element inside the Backpack
    calls chooseGreater_v method and uses it index returned value to turn the selected v into 0 (so it can't be selected again)
    Repeats the process until the Backpack is completely full*/ 
    private static float[][] fractionaryBackpack(String[] S, float[] W, float[] V, int C) {
        float[][] x = new float[S.length][2];
        float[] v = new float[S.length];
        float P = 0;

        System.out.println("Total Backpack Size: " + C + "\n");

        //Creates an Average Value (v vector) for each element to be selected
        for(int i = 0; i < S.length; i++) {
            x[i][0] = 0;
            v[i] = V[i] / W[i];
            
            System.out.println("Product: " + S[i] + " | Average Value: " + v[i]);
        }

        while(P < C) {
            int index = chooseGreater_v(v);
            v[index] = 0;

            //storage the weight to be put on the Backpack based on the remaining space inside it 
            float a = Math.min(W[index], C - P);

            //storage Final Weight (column 0) and Final Price (column 1) values on x 2D Matrix
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

    //Show Final Results on Console and Show Final Weight and Price Sum
    private static void showResults(String[] items, float[] weight, float[] price, float[][] result) {
        float totalPrice = 0, totalWeight = 0;

        for(int i = 0; i < items.length; i++) {
            totalPrice += result[i][1];
            totalWeight += result[i][0];

            System.out.println("Name: " + items[i] + " | Weight: " + weight[i] + 
                " | Price: " + price[i] + " | Final Weight: " + result[i][0] + " | Final Price: " + result[i][1]);
        }

        System.out.println("\nTotal Weight: " + totalWeight + " | Total Price: " + totalPrice);
    }
}