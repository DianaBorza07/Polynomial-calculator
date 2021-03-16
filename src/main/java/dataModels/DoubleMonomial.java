package dataModels;

public class DoubleMonomial extends Monomial implements Comparable<DoubleMonomial>{
    private double coefficient;

    public DoubleMonomial(double coefficient ,int exponent) {
        super(exponent);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        if(this.getExponent() != 0)
        {
            if(this.getExponent() == 1) {
                if (this.coefficient - ((int) this.coefficient) != 0)
                    return String.format("%.2f", this.coefficient) + "x";
                else
                    return String.format("%.0f", this.coefficient) + "x";
            }
            else {
                if (this.coefficient - ((int) this.coefficient) != 0)
                    return String.format("%.2f", this.coefficient) + "x^" + this.getExponent();
                else
                    return String.format("%.0f", this.coefficient) + "x^" + this.getExponent();
            }
        }
        else
        {   if(this.coefficient - ((int)this.coefficient) != 0)
            return String.format("%.2f",this.coefficient );
        else  return String.format("%.0f",this.coefficient );
        }

    }
    public int compareTo(DoubleMonomial o) {
        if(this.getExponent()> o.getExponent()) return -1;
        else if(this.getExponent()==o.getExponent()) return 0;
        else return 1;
    }
}
