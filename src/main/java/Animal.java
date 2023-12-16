import java.util.ArrayList;
import java.util.Random;



// creating animal class abstract because no object of this class will be created
public abstract class Animal {
    protected String name;
    protected boolean isHealthy;
    protected final Size size;

    //animal class constructor
    public Animal(String name, Size size) {
        this.name = name;
        this.size = size;
        this.isHealthy = true;
    }

    // share animal name
    public String getName() {
        return this.name;
    }

    // set animal healthy or unhealthy
    public void setHealthy(boolean input) {
        this.isHealthy = input;
    }

    // print, animal sleeping
    public void sleep() {
        System.out.println(name + " of " + size + " size is tired now and " + " is sleeping.");
        System.out.println("\n");
    }

    //eat method will be common for every animals
    public void eat() {
        //https://www.geeksforgeeks.org/generating-random-numbers-in-java/
        //generating random number from 0-9, the higher the value the probability to eat more
        Random rand = new Random();
        int prob = rand.nextInt(10);
        if (prob == 0) {// 10% chance that the animal eats nothing
            System.out.println(name + " of " + size + " size ate 0 food units.");
        } else if (prob == 9) {//10% chance that the animal eats too much
            System.out.println(name + " of " + size + " size ate too much!");
            //isHealthy = false;
        } else {
            System.out.println(name + " of " + size + " size is eating.");
        }
    }

    // makesound is abstract because every animal has differnt sound
    abstract public void makeSound();

    public void roam() {
        System.out.println(name + " of " + size + " is roaming happily.");
    }

}


// creating this class abstract because no object of this class will be created
//this is an example of inheritance
abstract class Pachyderm extends Animal {
    public Pachyderm(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    ///roam method is differnt for the pachyderm
    public void roam() {
        Random rand = new Random();
        //https://www.geeksforgeeks.org/generating-random-numbers-in-java/
        //generating random number from 0-7, the higher the value the probability to roam more
        int prob = rand.nextInt(8);
        if (prob == 0 || prob == 1) {
            System.out.println("According to 25% probabilty " + name + " of " + size + " size is charging!");
        } else {
            System.out.println(name + " of " + size + "  size is charged now and " + " is roaming.");
        }
    }
}

//this is an example of inheritance
class Rhino extends Pachyderm {

    public Rhino(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        System.out.println(name + " of " + size + " size is Screammmingggggggg!!!!!");
    }

}

//this is an example of inheritance
class Elephant extends Pachyderm {

    public Elephant(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        System.out.println(name + " of " + size + " size is trumpetttttingggggg!!!!!");
    }

}

//this is an example of inheritance
class Hippo extends Pachyderm {

    public Hippo(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        System.out.println(name + " of " + size + " size is growlllllinggggggggg!!!!!!");
    }

}

// creating this class abstract because no object of this class will be created
//this is an example of inheritance
abstract class Feline extends Animal {
    public Feline(String name, Size size) {
        super(name, size);
    }

    //roam method is different for the feline class
    //this is an example of runtime polymorphism
    @Override
    public void roam() {
        Random rand = new Random();
        //https://www.geeksforgeeks.org/generating-random-numbers-in-java/
        //generating random number from 0-9, the higher the value the probability to roam more
        int prob = rand.nextInt(10);
        if (prob == 0) {
            System.out.println("According to 10% probability " + name + " of " + size + " size is charging!");
        } else {
            System.out.println(name + " of " + size + " size is charged now and is roaming.");
        }
    }

}

//this is an example of inheritance
class Tiger extends Feline {

    public Tiger(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        System.out.println(name + " of " + size + " size is Growlllingggggggg!!!!!");
    }

}

//this is an example of inheritance
class Lion extends Feline {

    public Lion(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        System.out.println(name + " of " + size + " size is Roarrrrrringggggg!!!!!");
    }

}

//this is an example of inheritance
class Cheetah extends Feline {

    public Cheetah(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        System.out.println(name + " of " + size + " size is Chirrrrphhinggggggggg!!!!!!");
    }

}

// creating this class abstract because no object of this class will be created
abstract class Birds extends Animal {
    public Birds(String name, Size size) {
        super(name, size);
    }
}

//this is an example of inheritance
class Parrot extends Birds {
    private ArrayList<String> sound;

    public Parrot(String name, Size size, ArrayList<String> sound) {
        super(name, size);
        this.sound = sound;
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        ///roam method is differnt for the pachyderm
        Random rand = new Random();
        //generating random number from 0-7, the higher the value the probability to roam more
        int prob = rand.nextInt(5);
        System.out.println(name + " of " + size + "  size is charged now and " + "saying : " + sound.get(prob));
    }

}

//this is an example of inheritance
class Falcon extends Birds {

    public Falcon(String name, Size size) {
        super(name, size);
    }

    @Override
    //this is an example of runtime polymorphism
    public void makeSound() {
        System.out.println(name + " of " + size + " size is Shrillllingggggg!!!!!");
    }

}

//this is an example of inheritance
class Owl extends Birds {

    public Owl(String name, Size size) {
        super(name, size);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " of " + size + " size is cooooooinggggggggg!!!!!!");
    }

}

// Abstract class representing a Mammal, which is a type of Animal
abstract class Mammal extends Animal {
    // Constructor for a Mammal with a given name and size
    public Mammal(String name, Size size) {
        super(name, size);
    }
}

// Class representing a Zebra, which is a specific type of Mammal
class Zebra extends Mammal {
    // Constructor for a Zebra with a given name and size
    public Zebra(String name, Size size) {
        super(name, size);
    }

    @Override
    // Override the makeSound method to provide a specific sound for a Zebra
    // This is an example of runtime polymorphism, where the behavior of the
    // method is determined at runtime based on the actual object's type
    public void makeSound() {
        System.out.println(name + " of " + size + " size is Barkkkkingggggggg!!!!!");
    }
}

// Class representing a Horse, which is a specific type of Mammal
class Horse extends Mammal {
    // Constructor for a Horse with a given name and size
    public Horse(String name, Size size) {
        super(name, size);
    }

    @Override
    // Override the makeSound method to provide a specific sound for a Horse
    public void makeSound() {
        System.out.println(name + " of " + size + " size is squealliingggggg!!!!!");
    }
}

// Class representing a Deer, which is a specific type of Mammal
class Deer extends Mammal {
    // Constructor for a Deer with a given name and size
    public Deer(String name, Size size) {
        super(name, size); // Call the constructor of the parent class (Mammal)
    }

    @Override
    // Override the makeSound method to provide a specific sound for a Deer
    public void makeSound() {
        System.out.println(name + " of " + size + " size is grunttttinggggggggg!!!!!!");
    }
}




// Factory Pattern
// AnimalFactory - Abstract Creator
abstract class AnimalFactory {
    public abstract Animal createAnimal(String type, String name, Size size);
}


// PachydermFactory - Concrete Creator
class PachydermFactory extends AnimalFactory {
    public Animal createAnimal(String type, String name, Size size) {
        if (type.equalsIgnoreCase("Rhino")) {
            return new Rhino(name, size);
        } else if (type.equalsIgnoreCase("Elephant")) {
            return new Elephant(name, size);
        } else if (type.equalsIgnoreCase("Hippo")) {
            return new Hippo(name, size);
        }
        return null;
    }
}


// FelineFactory - Concrete Creator
class FelineFactory extends AnimalFactory {
    public Animal createAnimal(String type, String name, Size size) {
        if (type.equalsIgnoreCase("Tiger")) {
            return new Tiger(name, size);
        } else if (type.equalsIgnoreCase("Lion")) {
            return new Lion(name, size);
        } else if (type.equalsIgnoreCase("Cheetah")) {
            return new Cheetah(name, size);
        }
        return null;
    }
}


// BirdFactory - Concrete Creator
class BirdFactory extends AnimalFactory {
    public Animal createAnimal(String type, String name, Size size) {
        // Create Parrots using the birdFactory
        ArrayList<String> phrases = new ArrayList<>();
        phrases.add("Hello!");
        phrases.add("Hi there!");
        phrases.add("Good bird!");
        phrases.add("Pretty bird!");
        phrases.add("Yum, yum!");

        if (type.equalsIgnoreCase("Parrot")) {
            return new Parrot(name, size, phrases);
        } else if (type.equalsIgnoreCase("Falcon")) {
            return new Falcon(name, size);
        } else if (type.equalsIgnoreCase("Owl")) {
            return new Owl(name, size);
        }
        return null;
    }
}



// MammalFactory - Concrete Creator
class MammalFactory extends AnimalFactory {
    public Animal createAnimal(String type, String name, Size size) {
        if (type.equalsIgnoreCase("Horse")) {
            return new Horse(name, size);
        } else if (type.equalsIgnoreCase("Deer")) {
            return new Deer(name, size);
        } else if (type.equalsIgnoreCase("Zebra")) {
            return new Zebra(name, size);
        }
        return null;
    }
}