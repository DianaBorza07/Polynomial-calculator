package businessLogic;

import dataModels.DoubleMonomial;
import dataModels.DoublePolynomial;
import dataModels.IntegerMonomial;
import dataModels.IntegerPolynomial;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    public static IntegerPolynomial addition(IntegerPolynomial pol1, IntegerPolynomial pol2){
        IntegerPolynomial result = new IntegerPolynomial();
        for (IntegerMonomial m : pol1.getPolinom()) {
            for (IntegerMonomial n : pol2.getPolinom()) {
                if(m.getExponent() == n.getExponent()) {
                    m.setMarked(true);
                    n.setMarked(true);
                    if((m.getCoefficient()+n.getCoefficient()) != 0)
                        result.addValue(new IntegerMonomial((m.getCoefficient()+n.getCoefficient()),m.getExponent()));
                }
            }
        }
        for (IntegerMonomial m : pol1.getPolinom()) {
            if(!m.isMarked())
                result.addValue(m);
        }
        for (IntegerMonomial m : pol2.getPolinom()) {
            if(!m.isMarked())
                result.addValue(m);
        }
        return result;
    }

    public static IntegerPolynomial subtraction(IntegerPolynomial pol1,IntegerPolynomial pol2){
        IntegerPolynomial result = new IntegerPolynomial();
        for (IntegerMonomial m : pol1.getPolinom()) {
            for (IntegerMonomial n : pol2.getPolinom()) {
                if(m.getExponent() == n.getExponent()) {
                    m.setMarked(true);
                    n.setMarked(true);
                    if((m.getCoefficient()-n.getCoefficient()) != 0)
                        result.addValue(new IntegerMonomial((m.getCoefficient()-n.getCoefficient()),m.getExponent()));
                }
            }
        }
        for (IntegerMonomial m : pol1.getPolinom()) {
            if(!m.isMarked())
                result.addValue(m);
        }
        for (IntegerMonomial m : pol2.getPolinom()) {
            if(!m.isMarked()) {
                m.setCoefficient((-1)*m.getCoefficient());
                result.addValue(m);
            }
        }
        return result;
    }

    public static DoublePolynomial subtractionDouble(DoublePolynomial pol1, DoublePolynomial pol2){
        DoublePolynomial result = new DoublePolynomial();
        for (DoubleMonomial m : pol1.getPolinom()) {
            for (DoubleMonomial n : pol2.getPolinom()) {
                if(m.getExponent() == n.getExponent()) {
                    m.setMarked(true);
                    n.setMarked(true);
                    if((m.getCoefficient()-n.getCoefficient()) != 0)
                        result.addValue(new DoubleMonomial((m.getCoefficient()-n.getCoefficient()),m.getExponent()));
                }
            }
        }
        for (DoubleMonomial m : pol1.getPolinom()) {
            if(!m.isMarked())
                result.addValue(new DoubleMonomial(m.getCoefficient(),m.getExponent()));
        }
        for (DoubleMonomial m : pol2.getPolinom()) {
            if(!m.isMarked()) {
                m.setCoefficient((-1)*m.getCoefficient());
                result.addValue(new DoubleMonomial(m.getCoefficient(),m.getExponent()));
            }
        }
        return result;
    }

    public static IntegerPolynomial multiplication(IntegerPolynomial pol1, IntegerPolynomial pol2){
        IntegerPolynomial result = new IntegerPolynomial();
        IntegerPolynomial finalResult = new IntegerPolynomial();
        for (IntegerMonomial m : pol1.getPolinom()) {
            for( IntegerMonomial n: pol2.getPolinom())
                result.addValue(new IntegerMonomial(m.getCoefficient()*n.getCoefficient(),m.getExponent()+n.getExponent()));
        }
        for(IntegerMonomial m : result.getPolinom()) {
            IntegerMonomial aux = new IntegerMonomial(0,0);
            for(IntegerMonomial n : result.getPolinom()) {
                if((m.getExponent() == n.getExponent()) && (!n.isMarked()) && (!m.equals(n))) {
                    n.setMarked(true);
                    m.setMarked(true);
                    if((aux.getCoefficient()+m.getCoefficient()+n.getCoefficient()) != 0)
                        aux.setCoefficient(aux.getCoefficient()+m.getCoefficient()+n.getCoefficient());
                    aux.setExponent(m.getExponent());
                }
            }
            if(!m.isMarked()) {
                finalResult.addValue(new IntegerMonomial(m.getCoefficient(),m.getExponent()));
                m.setMarked(true);
            }
            else
            if(aux.getCoefficient() != 0)
                finalResult.addValue(aux);
        }
        return finalResult;
    }

    public static DoublePolynomial multiplicationDouble(DoublePolynomial pol1, IntegerPolynomial pol2){
        DoublePolynomial result = new DoublePolynomial();
        DoublePolynomial finalResult = new DoublePolynomial();
        for (DoubleMonomial m : pol1.getPolinom()) {
            for( IntegerMonomial n: pol2.getPolinom())
                result.addValue(new DoubleMonomial(m.getCoefficient()*n.getCoefficient(),m.getExponent()+n.getExponent()));
        }
        for(DoubleMonomial m : result.getPolinom()) {
            DoubleMonomial aux = new DoubleMonomial(0,0);
            for(DoubleMonomial n : result.getPolinom()) {
                if((m.getExponent() == n.getExponent()) && (!n.isMarked()) && (!m.equals(n))) {
                    n.setMarked(true);
                    m.setMarked(true);
                    if((aux.getCoefficient()+m.getCoefficient()+n.getCoefficient()) != 0)
                        aux.setCoefficient(aux.getCoefficient()+m.getCoefficient()+n.getCoefficient());
                    aux.setExponent(m.getExponent());
                }
            }
            if(!m.isMarked()) {
                finalResult.addValue(new DoubleMonomial(m.getCoefficient(),m.getExponent()));
                m.setMarked(true);
            }
            else
            if(aux.getCoefficient() != 0)
                finalResult.addValue(aux);
        }
        return finalResult;
    }

    public static IntegerPolynomial derivation(IntegerPolynomial pol){
        IntegerPolynomial result = new IntegerPolynomial();
        for (IntegerMonomial m : pol.getPolinom())
            if(m.getExponent() != 0)
                result.addValue(new IntegerMonomial(m.getCoefficient()*m.getExponent(),m.getExponent()-1));
        return result;
    }

    public static DoublePolynomial integration(IntegerPolynomial pol){
        DoublePolynomial result=new DoublePolynomial();
        for (IntegerMonomial m : pol.getPolinom())
        {
            if(m.getExponent() != 0)
                result.addValue(new DoubleMonomial((((double)m.getCoefficient())/(m.getExponent()+1)),m.getExponent()+1));
            else
                result.addValue(new DoubleMonomial(m.getCoefficient(),m.getExponent()+1));
        }
        return result;
    }

    public static List<DoublePolynomial> division(IntegerPolynomial pol1, IntegerPolynomial pol2) {
        pol1.sortPolynomial();
        pol2.sortPolynomial();
        DoublePolynomial r = new DoublePolynomial();
        DoublePolynomial q = new DoublePolynomial();
        DoublePolynomial t = new DoublePolynomial();
        for (IntegerMonomial m : pol1.getPolinom())
            r.addValue(new DoubleMonomial(m.getCoefficient(),m.getExponent()));
        while (!r.getPolinom().isEmpty() && (r.getFirstMonom().getExponent() >= pol2.getFirstMonom().getExponent())) {
            t.addValue(new DoubleMonomial(r.getFirstMonom().getCoefficient() / pol2.getFirstMonom().getCoefficient(), r.getFirstMonom().getExponent() - pol2.getFirstMonom().getExponent()));
            q.addValue(new DoubleMonomial(r.getFirstMonom().getCoefficient() / pol2.getFirstMonom().getCoefficient(), r.getFirstMonom().getExponent() - pol2.getFirstMonom().getExponent()));
            r = Operations.subtractionDouble(r, Operations.multiplicationDouble(t, pol2));
            t.getPolinom().clear();
        }
        List<DoublePolynomial> listPolinomial = new ArrayList<DoublePolynomial>();
        listPolinomial.add(q);
        listPolinomial.add(r);
        return listPolinomial;
    }

}

