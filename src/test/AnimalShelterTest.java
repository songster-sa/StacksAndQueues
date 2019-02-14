package test;

import main.Animal;
import main.AnimalShelter;

public class AnimalShelterTest {

    public static void main(String arg[]) {
        AnimalShelter shelter = new AnimalShelter();

        // empty shelter check
        Animal adopt = shelter.deQueueCat();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());
        adopt = shelter.deQueueDog();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());
        adopt = shelter.deQueueAny();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());

        // only dogs
        shelter.enqueue(new Animal("dog"));
        shelter.enqueue(new Animal("dog"));
        shelter.enqueue(new Animal("dog"));
        adopt = shelter.deQueueCat();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());
        adopt = shelter.deQueueDog();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());
        adopt = shelter.deQueueAny();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());

        // one dog left over and cats
        shelter.enqueue(new Animal("cat"));
        shelter.enqueue(new Animal("cat"));
        shelter.enqueue(new Animal("cat"));
        shelter.enqueue(new Animal("cat"));
        adopt = shelter.deQueueCat();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());
        adopt = shelter.deQueueAny();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());
        adopt = shelter.deQueueDog();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());

        // 3 cats left over and 2 dogs
        shelter.enqueue(new Animal("dog"));
        shelter.enqueue(new Animal("dog"));
        adopt = shelter.deQueueAny();
        System.out.println(adopt == null ? null : adopt.getType() + " " + adopt.getOrder());
    }
}
