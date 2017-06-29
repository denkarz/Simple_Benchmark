/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.denkarz.benchmarktest.TestComponents.entities;

import static com.denkarz.benchmarktest.GUI.MainWindow.jBasicTable;

/**
 *
 * @author Denis
 * @e-mail karzdenis@gmail.com
 * @nickname DenKarz
 */
public class KramerSystem {
    
    long finalTimeout=0;
         
    final int N = 20;
    double[] X = new double[N];
    double[][] T = new double [N][N];

    double detA;
    int n;
    int i, j;

    double[][] A={
        {17,4,10,8,14,12,2,11,7,3,20,13,6,4,11,20,15,5,11,2},
        {3,12,11,12,9,13,11,9,3,8,11,19,1,5,18,18,6,6,17,4},
        {12,1,8,14,13,19,19,1,11,3,6,12,3,19,12,2,11,14,16,13},
        {7,4,18,1,9,19,16,8,12,12,13,11,19,12,14,17,8,16,10,20},
        {11,8,12,4,10,9,18,8,17,7,17,19,16,15,5,5,12,14,13,17},
        {17,19,16,15,5,5,12,14,13,17,11,8,12,4,10,9,18,8,17,7},
        {13,11,19,12,14,17,8,16,10,20,7,4,18,1,9,19,16,8,12,12},
        {6,12,3,19,12,2,11,14,16,13,12,1,8,14,13,19,19,1,11,3},
        {11,19,1,5,18,18,6,6,17,4,3,12,11,12,9,13,11,9,3,8},
        {20,13,6,4,11,20,15,5,11,2,17,4,10,8,14,12,2,11,7,3},
        {17,4,10,8,14,12,2,11,7,3,20,13,6,4,11,20,15,5,11,2},
        {3,12,11,12,9,13,11,9,3,8,15,5,5,12,14,13,17,11,8,12},
        {12,1,8,14,13,19,19,1,11,3,9,18,8,17,7,17,19,16,15,5},
        {7,4,18,1,9,19,16,8,12,12,1,1,5,7,18,9,12,5,5,10},
        {11,8,12,4,10,9,18,8,17,7,5,15,20,4,3,2,1,0,1,20},
        {17,19,16,15,5,5,12,14,13,17,1,1,1,1,1,5,8,1,1,0},
        {13,11,19,12,14,17,8,16,10,20,7,4,18,1,9,19,16,8,12,12},
        {6,12,3,19,12,2,11,14,16,13,12,1,8,14,13,19,19,1,11,3},
        {11,19,1,5,18,18,6,6,17,4,3,12,11,12,9,13,11,9,3,8},
        {20,13,6,4,11,20,15,5,11,2,17,4,10,8,14,12,2,11,7,3}
        };

    double[] B ={
        5,
        1,
        14,
        19,
        5,
        2,
        20,
        7,
        12,
        9,
        9,
        18,
        12,
        5,
        5,
        0,
        7,
        4,
        8,
        10
    };
        //рекурсивная функция - вычисляет значение определителя. Если на входе определитель 2х2 - просто вычисляем (крест-на-крест), иначе раскладываем на миноры. Для каждого минора вычисляем ЕГО определитель, рекурсивно вызывая ту же функцию..
    public double CalculateMatrix(double[][] matrix){
        double calcResult=0.0;
        if (matrix.length==2){
            calcResult=matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
        }
        else{
            int koeff=1;
            for( i=0; i<matrix.length; i++){
                if(i%2==1){  //я решил не возводить в степень, а просто поставить условие - это быстрее. Т.к. я раскладываю всегда по первой (читай - "нулевой") строке, то фактически я проверяю на четность значение i+0.
                    koeff=-1;
                }
                else{
                    koeff=1;
                }
      //собственно разложение:                
                calcResult += koeff*matrix[0][i]*this.CalculateMatrix(this.GetMinor(matrix,0,i)); 
            }
        }
        
    //возвращаем ответ
        return calcResult;
    }
    
    //функция, к-я возвращает нужный нам минор. На входе - определитель, из к-го надо достать минор и номера строк-столбцов, к-е надо вычеркнуть.
    private double[][] GetMinor(double[][] matrix, int row, int column){
        int minorLength = matrix.length-1;
        double[][] minor = new double[minorLength][minorLength];
        int dI=0;//эти переменные для того, чтобы "пропускать" ненужные нам строку и столбец
        int dJ=0;
        for(i=0; i<=minorLength; i++){
            dJ=0;
            for( j=0; j<=minorLength; j++){
                if(i==row){
                    dI=1;
                }
                else{
                    if(j==column){
                        dJ=1;
                    }
                    else{
                        minor[i-dI][j-dJ] = matrix[i][j];
                    }
                }
            }
        }  
        return minor;
    }
    
public void solutionOfKramerSystem(){
    for (int k=0; k<2000;k++){
        long timeout= System.currentTimeMillis(); 
    detA = CalculateMatrix(A);
    for (n = 0; n < N; n++){
        for (i = 0; i < N; i++)   //первая матрица
            for (j = 0; j < N; j++)
                T[i][j] = A[i][j];
        for (j = 0; j < N; j++)
            T[j][n] = B[j];
        X[n] = CalculateMatrix(T) / detA;
        }    
    timeout = System.currentTimeMillis() - timeout;
    finalTimeout+=timeout;
    }
        jBasicTable.setValueAt(getTimeout(), 2, 1);
    }
    public long getTimeout(){
        return finalTimeout;
    }
}
