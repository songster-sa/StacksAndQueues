package turtleStackOne;

public class Turtle {
    private int weight;
    private int capacity;

    public Turtle(int weight, int capacity) {
        this.weight = weight;
        this.capacity = capacity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String print() {
        return String.format("(%d, %d)", weight, capacity);
    }
}
