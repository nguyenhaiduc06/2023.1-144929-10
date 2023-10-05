package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private String currentInput;
    private String currentOperator;
    private double firstOperand;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        currentInput = "";
        currentOperator = "";
        firstOperand = 0.0;

        // Add listeners
        view.addNumberButtonListener(0, new NumberButtonListener());
        view.addNumberButtonListener(1, new NumberButtonListener());
        // Add listeners for other number buttons similarly
        view.addOperationButtonListener(new OperationButtonListener());
    }

    class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String digit = e.getActionCommand();
            currentInput += digit;
            view.setInput(currentInput);
        }
    }

    class OperationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operator = e.getActionCommand();
            if (!currentInput.isEmpty()) {
                if (!currentOperator.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    model.performOperation(firstOperand, secondOperand, currentOperator);
                    firstOperand = model.getResult();
                    view.setInput(String.valueOf(firstOperand));
                } else {
                    firstOperand = Double.parseDouble(currentInput);
                }
                currentInput = "";
                currentOperator = operator;
                view.clearInput();
            }
        }
    }
}