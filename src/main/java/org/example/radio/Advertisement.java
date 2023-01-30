package org.example.radio;

public class Advertisement extends Content {
    private final int price = 5;
    public String getProduct() {
        return product;
    }

    public Advertisement(String product, int time) {
        this.product = product;
        setTime(time);
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "product='" + product + '\'' +
                ", length='" + findTime() + '\'' +
                '}';
    }

    public void setProduct(String product, int time) {
        this.product = product;
        setTime(time);
    }

    String product;

    @Override
    public int getCost(){
        return getTime()*price;
    }

}
