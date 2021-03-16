package dataModels;

abstract class Monomial {
    private int exponent;
    private boolean marked; // 0- element neparcurs, 1 element parcurs

    Monomial(int exponent){
        this.exponent = exponent;
        this.marked = false;
    }
    public abstract String toString();

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
