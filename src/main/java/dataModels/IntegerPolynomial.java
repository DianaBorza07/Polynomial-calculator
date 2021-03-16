package dataModels;

import dataModels.IntegerMonomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerPolynomial {
    private List<IntegerMonomial> polinom;

    public IntegerPolynomial() {
        this.polinom = new ArrayList<IntegerMonomial>();
    }

    public List<IntegerMonomial> getPolinom(){ return this.polinom; }

    public void addValue(IntegerMonomial val){
        this.polinom.add(val);
    }

    public String getPolynomialString(){
        Collections.sort(polinom);
        String s= this.polinom.get(0).toString();
        this.polinom.get(0).setMarked(true);
        for (IntegerMonomial m : this.polinom)
        {
            if(!m.isMarked())
                if(m.getCoefficient() > 0)
                    s=s+" + "+m.toString();
                else
                    s=s+" "+m.toString();
        }
        return s;
    }

    public void clearMarks(){
        for(IntegerMonomial m : this.polinom)
            m.setMarked(false);
    }

    public List<IntegerMonomial> sortPolynomial(){
        Collections.sort(this.polinom);
        return this.polinom;
    }

    public IntegerMonomial getFirstMonom(){
        sortPolynomial();
        for(IntegerMonomial m : this.polinom)
            if(m.getCoefficient() != 0)
                return m;
        return null;
    }
}
