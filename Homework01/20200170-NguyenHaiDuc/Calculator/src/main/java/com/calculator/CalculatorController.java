/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.calculator;

/**
 *
 * @author ducnh
 */
public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel m, CalculatorView v) {
        model = m;
        view = v;
        init();
    }

    private void init() {
        updateView();
        bindButtons();
    }

    private void updateView() {
        view.getFieldOp1().setText(model.getOp1());
        view.getFieldOp().setText(model.getOp());
        view.getFieldOp2().setText(model.getOp2());
        view.getFieldRes().setText(model.getResult());
    }

    private void bindButtons() {
        view.getBtn0().addActionListener(e -> pressNumberButton(0));
        view.getBtn1().addActionListener(e -> pressNumberButton(1));
        view.getBtn2().addActionListener(e -> pressNumberButton(2));
        view.getBtn3().addActionListener(e -> pressNumberButton(3));
        view.getBtn4().addActionListener(e -> pressNumberButton(4));
        view.getBtn5().addActionListener(e -> pressNumberButton(5));
        view.getBtn6().addActionListener(e -> pressNumberButton(6));
        view.getBtn7().addActionListener(e -> pressNumberButton(7));
        view.getBtn8().addActionListener(e -> pressNumberButton(8));
        view.getBtn9().addActionListener(e -> pressNumberButton(9));

        view.getBtnAdd().addActionListener(e -> pressOpButton('+'));
        view.getBtnSub().addActionListener(e -> pressOpButton('-'));
        view.getBtnMul().addActionListener(e -> pressOpButton('x'));
        view.getBtnDiv().addActionListener(e -> pressOpButton('/'));

        view.getBtnCalc().addActionListener(e -> calculate());
        view.getBtnClear().addActionListener(e -> clear());
    }

    private void pressNumberButton(int n) {
        model.insertNumber(n);
        updateView();
    }

    private void pressOpButton(char op) {
        model.selectOperator(op);
        updateView();
    }

    private void calculate() {
        model.calculate();
        updateView();
    }

    private void clear() {
        model.reset();
        updateView();
    }
}
