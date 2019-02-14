package main;

/**
 * we can create Animal as super class and Dog and Cat as child classes too. Here we are simply using a property to track animal type
 */
public class Animal {

    // cat or dog
    private String type;
    // overall order of entry in the shelter - a way to rack arrival time
    private int order;


    public Animal(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
