/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.calculator;

/**
 *
 * @author ducnh
 */
public class CalculatorModel {
    public CalculatorModel() {
        reset();
    }

    private String op1, op, op2, res;

    public String getResult() {
        return res;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp() {
        return op;
    }

    public String getOp2() {
        return op2;
    }

    public void insertNumber(int n) {
        if (op != "") {
            op2 += n;
            return;
        }
        op1 += n;
    }

    public void selectOperator(char op) {
        this.op = String.valueOf(op);
    }

    public void calculate() {
        double o1 = Double.parseDouble(op1);
        double o2 = Double.parseDouble(op2);
        switch (op.charAt(0)) {
            case '+':
                res = String.valueOf(o1 + o2);
                break;
            case '-':
                res = String.valueOf(o1 - o2);
                break;
            case 'x':
                res = String.valueOf(o1 * o2);
                break;
            case '/':
                if (o2 == 0.0) {
                    res = "Error";
                } else {
                    res = String.valueOf(Math.round(o1 / o2 * 100.0) / 100.0);
                }
                break;
        }
    }

    public void reset() {
        op = "";
        op1 = "";
        op2 = "";
        res = "";
    }
}
