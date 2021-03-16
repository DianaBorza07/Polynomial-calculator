package dataModels;

import dataModels.DoubleMonomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoublePolynomial {
    private List<DoubleMonomial> polinom;

    public DoublePolynomial() {
        this.polinom = new ArrayList<DoubleMonomial>();
    }

    public List<DoubleMonomial> getPolinom(){
        return this.polinom;
    }

    public void addValue(DoubleMonomial val){
        this.polinom.add(val);
    }

    public String getPolynomialString(){
        Collections.sort(polinom);
        String s= this.polinom.get(0).toString();
        this.polinom.get(0).setMarked(true);
        for (DoubleMonomial m : this.polinom)
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
        for(DoubleMonomial m : this.polinom)
            m.setMarked(false);
    }

    public List<DoubleMonomial> sortPolynomial(){
        Collections.sort(this.polinom);
        return this.polinom;
    }

    public DoubleMonomial getFirstMonom(){
        sortPolynomial();
        for(DoubleMonomial m : this.polinom)
            if(m.getCoefficient() != 0)
                return m;
        return null;
    }
}

