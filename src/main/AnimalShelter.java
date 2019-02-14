package main;

import java.util.LinkedList;

/**
 * Animal Shelter which works as FIFO. People can adopt either oldest cat or oldest dog or oldest of either
 * given built in linked list
 */
public class AnimalShelter {

    private LinkedList<Animal> cats = new LinkedList<>();
    private LinkedList<Animal> dogs = new LinkedList<>();
    private int order;

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal.getType().equalsIgnoreCase("cat")) {
            cats.add(animal);
        } else if (animal.getType().equalsIgnoreCase("dog")) {
            dogs.add(animal);
        }
    }

    public Animal deQueueAny() {

        if (cats.size() == 0) {
            return deQueueDog();
        }
        if (dogs.size() == 0) {
            return deQueueCat();
        }

        Animal cat = cats.peekFirst();
        Animal dog = dogs.peekFirst();

        if (cat.getOrder() < dog.getOrder()) {
            // cat is older
            return deQueueCat();
        } else {
            // dog is older - order will never be same for 2 animals
            return deQueueDog();
        }
    }

    public Animal deQueueCat() {
        return cats.pollFirst();
    }

    public Animal deQueueDog() {
        return dogs.pollFirst();
    }
}
