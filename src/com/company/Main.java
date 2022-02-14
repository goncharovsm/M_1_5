package com.company;

public class Main {


    public static void main(String[] args) {
        Matrix obj = new Matrix();
        obj.input();
        obj.read();
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{1,2},{3,4}};
        Matrix x = new Matrix(A);
        Matrix y = new Matrix(B);

        Matrix nM = Matrix.addition(x,y);
        nM.read();
        int ch = 2;
        Matrix aM = Matrix.oneMultiplication(x,ch);
        aM.read();
        Matrix kM = Matrix.twoMultiplication(x,y);
        kM.read();

    }
}