package graphicalUserInterface;

import graphicalUserInterface.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JFrame frame;
    private JTextField fistPolinom;
    private JTextField secondPolinom;
    private JTextField resultPolinom;
    private JButton addBtn;
    private JButton subtractBtn;
    private JButton divideBtn;
    private JButton multiplyBtn;
    private JButton integrationBtn;
    private JButton derivativeBtn;
    private JButton clearBtn;
    private Model model;
    View(Model model){
        this.model=model;

        frame = new JFrame("Polynomial Calculator");
        frame.setBounds(100, 100, 650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 2, 5, 10));

        JLabel titleLabel = new JLabel("Polynomial ");
        titleLabel.setFont(new Font("Tacoma", Font.PLAIN, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(titleLabel);

        JLabel titleLabel2 = new JLabel("Calculator");
        titleLabel2.setFont(new Font("Tacoma", Font.PLAIN, 20));
        frame.getContentPane().add(titleLabel2);

        JLabel firstPolinomLbl = new JLabel("First polynomial");
        firstPolinomLbl.setFont(new Font("Tacoma", Font.PLAIN, 15));
        frame.getContentPane().add(firstPolinomLbl);

        fistPolinom = new JTextField();
        fistPolinom.setFont(new Font("Tacoma", Font.PLAIN, 15));
        frame.getContentPane().add(fistPolinom);

        JLabel secondPolinomLbl = new JLabel("Second polynomial");
        secondPolinomLbl.setFont(new Font("Tacoma", Font.PLAIN, 15));
        frame.getContentPane().add(secondPolinomLbl);

        secondPolinom = new JTextField();
        secondPolinom.setFont(new Font("Tacoma", Font.PLAIN, 15));
        secondPolinom.setText("");
        frame.getContentPane().add(secondPolinom);

        JLabel resultPolinomLbl = new JLabel("Result polynomial");
        resultPolinomLbl.setFont(new Font("Tacoma", Font.PLAIN, 15));
        frame.getContentPane().add(resultPolinomLbl);

        resultPolinom = new JTextField();
        resultPolinom.setFont(new Font("Tacoma", Font.PLAIN, 15));
        resultPolinom.setEditable(false);
        frame.getContentPane().add(resultPolinom);

        addBtn = new JButton("Add");
        frame.getContentPane().add( addBtn);

        subtractBtn = new JButton("Subtract");
        frame.getContentPane().add(subtractBtn);

        divideBtn = new JButton("Divide");
        frame.getContentPane().add(divideBtn);

        multiplyBtn = new JButton("Multiply");
        frame.getContentPane().add(multiplyBtn);

        integrationBtn = new JButton("Integration");
        frame.getContentPane().add(integrationBtn);

        derivativeBtn = new JButton("Derivative");
        frame.getContentPane().add(derivativeBtn);

        JLabel infoLbl = new JLabel("<html>*NOTE:Derivation and integration operations will be performed on the first polynomial</html> ");
        frame.getContentPane().add(infoLbl);

        clearBtn = new JButton("Clear");
        frame.getContentPane().add(clearBtn);

        frame.setVisible(true);

    }
    public String getFistPolinom() {
        return fistPolinom.getText();
    }
    public String getSecondPolinom() {
        return secondPolinom.getText();
    }
    public void setResultPolinom(String resultPolinom) {
        this.resultPolinom.setText(resultPolinom);
    }
    public void setFistPolinom(String fistPolinom) {
        this.fistPolinom.setText(fistPolinom);
    }
    public void setSecondPolinom(String secondPolinom) {
        this.secondPolinom.setText(secondPolinom);
    }

    public void clear(){
        this.resultPolinom.setText("");
        this.fistPolinom.setText("");
        this.secondPolinom.setText("");
    }
    void addAddListener(ActionListener a){
        this.addBtn.addActionListener(a);
    }
    void addSubtractListener(ActionListener a){
        this.subtractBtn.addActionListener(a);
    }
    void addMultiplyListener(ActionListener a){
        this.multiplyBtn.addActionListener(a);
    }
    void addDivideListener(ActionListener a){
        this.divideBtn.addActionListener(a);
    }
    void addIntegrationListener(ActionListener a){
        this.integrationBtn.addActionListener(a);
    }
    void addDerivativeListener(ActionListener a){
        this.derivativeBtn.addActionListener(a);
    }
    void addClearListener(ActionListener a){
        this.clearBtn.addActionListener(a);
    }
}
