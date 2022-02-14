package com.company;

import java.util.Scanner;

public class Matrix {

    public int[][] matrix;
    public int n ,m ;

    public Matrix(int n, int m){
        this.n = n;
        this.m = m;
        this.matrix = new int[this.n][this.m];
    }



    public Matrix(int[][] paraMatrix){
        this.matrix = paraMatrix;
        this.n = paraMatrix.length;
        this.m = paraMatrix[0].length;
    }


    public Matrix(){
        this.n = 2;
        this.m = 2;
        this.matrix = new int[n][m];
    }




    public void setM(int m) {this.m = m;}
    public void setN(int n) {this.n = n;}
    public int getN() {
        return this.n;
    }
    public int getM() {return this.m;}

    public int getMatrix(int n,int m) {
        return this.matrix[n][m];
    }

    public void setMatrix(int n, int m, int value) {
        this.matrix[n][m] = value;
    }
    public int getVerticalLength(){
        return this.matrix.length;
    }
    public int getHorizontalLength(){
        return this.matrix[0].length;
    }


    //ВВод матрицы
    public void input(){
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i < this.n;i++){
            for(int j = 0; j < this.m; j++){
                System.out.println("Введите элемент массива :");
                this.matrix[i][j] = scan.nextInt();
            }
        }
    }
    public static Matrix transpone(Matrix matrix){
        Matrix tmpMatrix = new Matrix(matrix.n, matrix.m);
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                tmpMatrix.setMatrix(i,j, matrix.getMatrix(j,i));

            }

        }
        return tmpMatrix;
    }



    // Вывод матрицы
    public void read(){
        for(int i = 0; i < this.n;i++){
            for(int j = 0; j < this.m;j++ ){
                System.out.println(this.matrix[i][j] + "\t");
            }
        }
        System.out.println();
    }

    // Сложение
    public static Matrix addition(Matrix first, Matrix second) {

        if(first.getVerticalLength() != second.getHorizontalLength() || first.getHorizontalLength() != second.getVerticalLength()){
            return null;
        }
        else{
            Matrix tmpMatrix = new Matrix(first.getVerticalLength(), second.getHorizontalLength());
            for(int i = 0; i < tmpMatrix.getVerticalLength();i++){
                for(int j = 0; j < tmpMatrix.getHorizontalLength();j++){
                    tmpMatrix.setMatrix(i,j, first.getMatrix(i,j) + second.getMatrix(i,j));
                }
            }
            return tmpMatrix;
        }
    }
    // Вычитание
    public static Matrix subtraction(Matrix first, Matrix second){
        if(first.getVerticalLength() != second.getHorizontalLength() || first.getHorizontalLength() != second.getVerticalLength()){
            return null;
        }
        else{
            Matrix tmpMatrix = new Matrix(first.getVerticalLength(), second.getHorizontalLength());
            for(int i = 0; i < tmpMatrix.getVerticalLength();i++){
                for(int j = 0; j < tmpMatrix.getHorizontalLength();j++){
                    tmpMatrix.setMatrix(i,j, first.getMatrix(i,j) - second.getMatrix(i,j));
                }
            }
            return tmpMatrix;
        }

    }
    // Умножение матрицы на число
    public static Matrix oneMultiplication(Matrix first, int ch){

        Matrix tmMatrix = new Matrix(first.matrix);
        for(int i = 0; i < tmMatrix.getVerticalLength();i++ ){
            for(int j = 0; j < tmMatrix.getHorizontalLength(); j++){
                tmMatrix.matrix[i][j] = tmMatrix.matrix[i][j] * ch;
            }

        }

        return tmMatrix;
    }

    public static Matrix twoMultiplication(Matrix first, Matrix second){
        if(first.getVerticalLength() != second.getHorizontalLength()){
            return null;
        }
        else{
            Matrix tmpMatrix ;
            int n = first.getVerticalLength();
            int m = second.getHorizontalLength();
            int o = second.getHorizontalLength();
            int[][] tmpArr = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m ; j++){
                    for(int k = 0; k < o; k++){
                        tmpArr[i][j] += first.getMatrix(i,k) * second.getMatrix(k,j);
                    }

                }

            }
            tmpMatrix = new Matrix(tmpArr);
            return tmpMatrix;
        }
    }

}
