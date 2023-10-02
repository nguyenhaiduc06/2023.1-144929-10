import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    private JFrame frame;
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;

    public CalculatorView() {
        // Create the main frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // Create the input field
        inputField = new JTextField();
        frame.add(inputField, BorderLayout.NORTH);

        // Create number buttons
        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberPanel.add(numberButtons[i]);
        }
        frame.add(numberPanel, BorderLayout.CENTER);

        // Create operation buttons
        JPanel operationPanel = new JPanel(new GridLayout(4, 1));
        operationButtons = new JButton[]{
                new JButton("+"),
                new JButton("-"),
                new JButton("*"),
                new JButton("/")
        };
        for (JButton button : operationButtons) {
            operationPanel.add(button);
        }
        equalsButton = new JButton("=");
        operationPanel.add(equalsButton);
        frame.add(operationPanel, BorderLayout.EAST);

        // Set up frame
        frame.setVisible(true);
    }

    public void addNumberButtonListener(int index, ActionListener listener) {
        numberButtons[index].addActionListener(listener);
    }

    public void addOperationButtonListener(ActionListener listener) {
        for (JButton button : operationButtons) {
            button.addActionListener(listener);
        }
        equalsButton.addActionListener(listener);
    }

    public String getInput() {
        return inputField.getText();
    }

    public void setInput(String input) {
        inputField.setText(input);
    }

    public void clearInput() {
        inputField.setText("");
    }
}
