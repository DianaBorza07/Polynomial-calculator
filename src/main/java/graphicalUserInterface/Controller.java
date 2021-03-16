package graphicalUserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addAddListener(new AddListener());
        this.view.addClearListener(new ClearListener());
        this.view.addSubtractListener(new SubstractListener());
        this.view.addDerivativeListener(new DerivativeListener());
        this.view.addIntegrationListener(new IntegrationListener());
        this.view.addMultiplyListener(new MultiplyListener());
        this.view.addDivideListener(new DivideListener());
    }
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String polinomInput1 = view.getFistPolinom();
            String polinomInput2 = view.getSecondPolinom();
            if(polinomInput2.isEmpty() || polinomInput1.isEmpty())
                JOptionPane.showMessageDialog(null,"The polynomials fields cannot be empty");
            String polynomialPattern = "^([-+]?[0-9]*(x(\\^[0-9]+)?)?)+";
            Pattern pattern = Pattern.compile(polynomialPattern);
            Matcher matcher = pattern.matcher(polinomInput1);
            Matcher matcher1 = pattern.matcher(polinomInput2);
            if(!matcher.matches())
                JOptionPane.showMessageDialog(null,"The first polynomial is not valid");
            else
            if(!matcher1.matches())
                JOptionPane.showMessageDialog(null,"The second polynomial is not valid");
            else {
                model.setPolinomInput1(polinomInput1);
                model.setPolinomInput2(polinomInput2);
                model.setPolynomials();
                model.addition();
                view.setResultPolinom(model.getResultOutput());
            }
        }
    }

    class SubstractListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String polinomInput1 = view.getFistPolinom();
            String polinomInput2 = view.getSecondPolinom();
            if(polinomInput2.isEmpty() || polinomInput1.isEmpty())
                JOptionPane.showMessageDialog(null,"The polynomials fields cannot be empty");
            String polynomialPattern = "^([-+]?[0-9]*(x(\\^[0-9]+)?)?)+";
            Pattern pattern = Pattern.compile(polynomialPattern);
            Matcher matcher = pattern.matcher(polinomInput1);
            Matcher matcher1 = pattern.matcher(polinomInput2);
            if(!matcher.matches())
                JOptionPane.showMessageDialog(null,"The first polynomial is not valid");
            else
            if(!matcher1.matches())
                JOptionPane.showMessageDialog(null,"The second polynomial is not valid");
            else {
                model.setPolinomInput1(polinomInput1);
                model.setPolinomInput2(polinomInput2);
                model.setPolynomials();
                model.subtraction();
                view.setResultPolinom(model.getResultOutput());
            }
        }
    }

    class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            view.setResultPolinom("");
            view.setFistPolinom("");
            view.setSecondPolinom("");
        }
    }

    class DerivativeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String polinomInput1 = view.getFistPolinom();
            if(polinomInput1.isEmpty())
                JOptionPane.showMessageDialog(null,"The first polynomial field cannot be empty");
            String polynomialPattern = "^([-+]?[0-9]*(x(\\^[0-9]+)?)?)+";
            Pattern pattern = Pattern.compile(polynomialPattern);
            Matcher matcher = pattern.matcher(polinomInput1);
            if(!matcher.matches())
                JOptionPane.showMessageDialog(null,"The first polynomial is not valid");
            else {
                model.setPolinomInput1(polinomInput1);
                model.setPolynomials();
                model.derivation();
                view.setResultPolinom(model.getResultOutput());
            }
        }
    }

    class IntegrationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String polinomInput1 = view.getFistPolinom();
            if(polinomInput1.isEmpty())
                JOptionPane.showMessageDialog(null,"The first polynomial field cannot be empty");
            String polynomialPattern = "^([-+]?[0-9]*(x(\\^[0-9]+)?)?)+";
            Pattern pattern = Pattern.compile(polynomialPattern);
            Matcher matcher = pattern.matcher(polinomInput1);
            if(!matcher.matches())
                JOptionPane.showMessageDialog(null,"The first polynomial is not valid");
            else {
                model.setPolinomInput1(polinomInput1);
                model.setPolynomials();
                model.integration();
                view.setResultPolinom(model.getResultOutput());
            }
        }
    }

    class MultiplyListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String polinomInput1 = view.getFistPolinom();
            String polinomInput2 = view.getSecondPolinom();
            if(polinomInput2.isEmpty() || polinomInput1.isEmpty())
                JOptionPane.showMessageDialog(null,"The polynomials fields cannot be empty");
            String polynomialPattern = "^([-+]?[0-9]*(x(\\^[0-9]+)?)?)+";
            Pattern pattern = Pattern.compile(polynomialPattern);
            Matcher matcher = pattern.matcher(polinomInput1);
            Matcher matcher1 = pattern.matcher(polinomInput2);
            if(!matcher.matches())
                JOptionPane.showMessageDialog(null,"The first polynomial is not valid");
            else
            if(!matcher1.matches())
                JOptionPane.showMessageDialog(null,"The second polynomial is not valid");
            else {
                model.setPolinomInput1(polinomInput1);
                model.setPolinomInput2(polinomInput2);
                model.setPolynomials();
                model.multiplication();
                view.setResultPolinom(model.getResultOutput());
            }
        }
    }

    class DivideListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String polinomInput1 = view.getFistPolinom();
            String polinomInput2 = view.getSecondPolinom();
            if(polinomInput2.isEmpty() || polinomInput1.isEmpty())
                JOptionPane.showMessageDialog(null,"The polynomials fields cannot be empty");
            String polynomialPattern = "^([-+]?[0-9]*(x(\\^[0-9]+)?)?)+";
            Pattern pattern = Pattern.compile(polynomialPattern);
            Matcher matcher = pattern.matcher(polinomInput1);
            Matcher matcher1 = pattern.matcher(polinomInput2);
            if(!matcher.matches())
                JOptionPane.showMessageDialog(null,"The first polynomial is not valid");
            else
            if(!matcher1.matches())
                JOptionPane.showMessageDialog(null,"The second polynomial is not valid");
            else {
                model.setPolinomInput1(polinomInput1);
                model.setPolinomInput2(polinomInput2);
                model.setPolynomials();
                if(model.checkGrades()){
                    model.division();
                    view.setResultPolinom(model.getResultOutput());
                }
                else JOptionPane.showMessageDialog(null, "The first polynomial must have a higher degree than the second polynomial in order to perform the division");
            }
        }
    }
}

