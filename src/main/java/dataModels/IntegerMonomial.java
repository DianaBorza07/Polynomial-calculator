package dataModels;

public class IntegerMonomial extends Monomial implements Comparable<IntegerMonomial>{
    private int coefficient;

    public IntegerMonomial(int coefficient,int exponent) {
        super(exponent);
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        if(this.getExponent() != 0)
            if(this.getExponent() == 1)
                return this.coefficient+"x";
            else return this.coefficient+"x^"+this.getExponent();
        else
            return Integer.toString(this.coefficient);
    }

    public int compareTo(IntegerMonomial o) {
        if(this.getExponent()> o.getExponent()) return -1;
        else if(this.getExponent()==o.getExponent()) return 0;
        else return 1;
    }

}
