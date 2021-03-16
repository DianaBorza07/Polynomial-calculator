package graphicalUserInterface;

import businessLogic.Operations;
import dataModels.DoublePolynomial;
import dataModels.IntegerMonomial;
import dataModels.IntegerPolynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    private String polinomInput1;
    private String polinomInput2;
    private String resultOutput;
    private IntegerPolynomial polinom1;
    private IntegerPolynomial polinom2;
    public Model() {
        this.polinomInput1 = null;
        this.polinomInput2 = null;
        this.resultOutput = null;
    }

    public String getPolinomInput1() {
        return polinomInput1;
    }

    public void setPolinomInput1(String polinomInput1) {
        this.polinomInput1 = polinomInput1;
    }

    public String getPolinomInput2() {
        return polinomInput2;
    }

    public void setPolinomInput2(String polinomInput2) {
        this.polinomInput2 = polinomInput2;
    }

    public String getResultOutput() {
        return resultOutput;
    }

    private IntegerPolynomial detPolynomial(String input){
        String polynomialPatternGroup = "([-+]?[0-9]*(x(\\^[0-9]+)?)?)";
        Pattern pattern = Pattern.compile(polynomialPatternGroup);
        Matcher matcher = pattern.matcher(input);
        IntegerPolynomial p = new IntegerPolynomial();
        while (matcher.find()) {
            String auxiliar = matcher.group(1);
            if (!auxiliar.isBlank()) {
                int coefficient = 0;
                int exponent = 0;
                if(auxiliar.contains("x")){
                    if(auxiliar.compareTo("x")==1) {
                        coefficient = 1;
                        exponent = 1;
                    }
                    else{    String[] aux = auxiliar.split("x");
                        coefficient = Integer.parseInt(aux[0]);
                        if(auxiliar.contains("^")) {    aux = auxiliar.split("\\^");
                            exponent = Integer.parseInt(aux[1]);
                        }
                        else exponent = 1;
                    }
                }
                else {   coefficient = Integer.parseInt(auxiliar);
                    exponent = 0;
                }
                IntegerMonomial monom= new IntegerMonomial(coefficient,exponent);
                p.addValue(monom);
            }
        }
        return p;
    }

    public void setPolynomials(){
        if(polinomInput1 != null)
            this.polinom1 = detPolynomial(polinomInput1);
        if(polinomInput2 != null)
            this.polinom2 = detPolynomial(polinomInput2);
    }

    public void addition(){
        polinom1.clearMarks();
        polinom2.clearMarks();
        IntegerPolynomial p = Operations.addition(polinom1,polinom2);
        this.resultOutput = p.getPolynomialString();
    }

    public void subtraction(){
        polinom1.clearMarks();
        polinom2.clearMarks();
        IntegerPolynomial p = Operations.subtraction(polinom1,polinom2);
        this.resultOutput = p.getPolynomialString();
    }

    public void multiplication(){
        polinom1.clearMarks();
        polinom2.clearMarks();
        IntegerPolynomial p = Operations.multiplication(polinom1,polinom2);
        this.resultOutput = p.getPolynomialString();
    }

    public void derivation(){
        polinom1.clearMarks();
        IntegerPolynomial p = Operations.derivation(polinom1);
        this.resultOutput = p.getPolynomialString();
    }

    public void integration(){
        polinom1.clearMarks();
        DoublePolynomial p = Operations.integration(polinom1);
        this.resultOutput = p.getPolynomialString();
    }

    public void division(){
        List<DoublePolynomial> p = new ArrayList<>();
        p = Operations.division(polinom1,polinom2);
        this.resultOutput = ("Quotient = "+p.get(0).getPolynomialString()+"\nRemainder = "+p.get(1).getPolynomialString());
    }

    public boolean checkGrades(){
        polinom1.sortPolynomial();
        polinom2.sortPolynomial();
        if(polinom1.getFirstMonom().getExponent() < polinom2.getFirstMonom().getExponent())
            return false;
        else return true;
    }

}

