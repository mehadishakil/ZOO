import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

// A base class representing staff members
class Staff {
    String name;

    // Constructor to initialize the staff member's name
    public Staff(String name) {
        this.name = name;
    }

    // Getter method to get the name of the staff member
    public String getName() {
        return name;
    }

    // Setter method to set the name of the staff member
    public void setName(String name) {
        this.name = name;
    }

    // Method to wake up animals (to be implemented by subclasses)
    public void wakeAnimals(ArrayList<Animal> animals, String name) {
        // Implementation specific to subclasses
    }

    // Method to feed animals (to be implemented by subclasses)
    public void feedAnimals(ArrayList<Animal> animals, Enclosure theEnclosure, Hospital theHospital, Veterinarian theVet, String name) {
        // Implementation specific to subclasses
    }

    // Method to exercise animals (to be implemented by subclasses)
    public void exerciseAnimals(ArrayList<Animal> animals, Enclosure theEnclosure, Hospital theHospital, Veterinarian theVet, String name) {
        // Implementation specific to subclasses
    }

    // Method to put animals to bed (to be implemented by subclasses)
    public void bedAnimals(ArrayList<Animal> animals, String name) {
        // Implementation specific to subclasses
    }

    // Method to treat animals (to be implemented by subclasses)
    public void treatAnimals() {
        // Implementation specific to subclasses
    }
}


//this is an example of inheritance
class Handler extends Staff {

    public Handler(String name) {
        super(name);
    }


    // handlers will make the animals awake
    public void wakeAnimals(ArrayList<Animal> animals, String name) {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(name + " the handler has make " + animals.get(i).name + " awake.");
            animals.get(i).makeSound();
        }
        System.out.println();
    }

    // handlers will feed the animals
    public void feedAnimals(ArrayList<Animal> animals, Enclosure theEnclosure, Hospital theHospital, Veterinarian theVet, String name) {
        Random rand = new Random();
        int prob;

        Animal removed_animal;
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(name + " the handler has feed the " + animals.get(i).name);
            prob = rand.nextInt(5);
            removed_animal = animals.get(i);
            if (prob == 0) {
                removed_animal.setHealthy(false);
                System.out.println("According to 20% probability " + animals.get(i).name + " is sick due to overeating or undereating.");
                boolean b = theVet.treatAnimal(removed_animal, theEnclosure);
                if (removed_animal.isHealthy) {
                    System.out.println(removed_animal.getName() + " has been treated and is healthy now.");
                    System.out.println(removed_animal.name + " is moved to the enclosure.");
                } else {
                    //removing an animal from enclosure
                    theEnclosure.removeAnimal(removed_animal);
                    // add the sick animal to the hospital
                    theHospital.addAnimal(removed_animal, theEnclosure);
                }
            } else {
                System.out.println(animals.get(i).name + " has been fed and is healthy and in the enclosure.");
            }
        }

    }


    // the handlers will make the animals do exercise
    public void exerciseAnimals(ArrayList<Animal> animals, Enclosure theEnclosure, Hospital theHospital, Veterinarian theVet, String name) {
        Random rand = new Random();
        int prob;

        Animal removed_animal;
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(name + " the handler has feed the " + animals.get(i).name);
            prob = rand.nextInt(5);
            removed_animal = animals.get(i);
            if (prob == 0) {
                removed_animal.setHealthy(false);
                System.out.println("According to 20% probability " + animals.get(i).name + " is sick due to overeating or undereating.");
                //removing an animal from enclosure
                theEnclosure.removeAnimal(removed_animal);
                // add the sick animal to the hospital
                theHospital.addAnimal(removed_animal, theEnclosure);
                theVet.treatAnimal(removed_animal, theEnclosure);
                if (removed_animal.isHealthy) {
                    System.out.println(removed_animal.name + " is moved to the enclosure.");
                }
            } else {
                System.out.println(animals.get(i).name + " has been fed and is healthy and in the enclosure.");
            }
        }



    }

    // sleep the animals
    public void bedAnimals(ArrayList<Animal> animals, String name) {
        System.out.println();
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(name + " has make the " + animals.get(i).name + " slept");
        }
        System.out.println();
    }


    public void zooStatus(Hospital hospital, Veterinarian veterinarian, ArrayList<ArrayList<Enclosure>> allEnclosures) {

        Map<Animal, Enclosure> animalsInHospital = hospital.getAnimalFromHospital();

        // printing header for enclosure
        System.out.println("\nEnclosure Status:");
        System.out.println("|----------------------------------|-------------------------|-----------------------|");
        System.out.println("|              Animal              |        Enclosure        |        Handler        |");
        System.out.println("|----------------------------------|-------------------------|-----------------------|");

        for (ArrayList<Enclosure> enclosureList : allEnclosures) {
            // Iterate through the inner ArrayList (which contains Enclosure objects)
            for (Enclosure enclosure : enclosureList) {
                ArrayList<Animal> animals_enclosure = enclosure.getAnimals();

                if (animals_enclosure.size() != 0) {
                    for (Animal animal : animals_enclosure) {
                        // Using String.format to achieve accurate indentation
                        String formattedString = String.format("| %1$-32s | %2$-23s | %3$-21s |",
                                animal.getName(), enclosure.getName(), enclosure.getHandler().getName());
                        System.out.println(formattedString);
                    }
                } else {
                    // Print a message indicating no animals in the enclosure
                    String noAnimalsMessage = String.format("| No animals in %1$-18s | %2$-21s | %3$-21s |",
                            enclosure.getName(), "N/A", "N/A");
                    System.out.println(noAnimalsMessage);
                }
            }
        }
        System.out.println("|----------------------------------|-------------------------|-----------------------|");


        //printing hospital status:
        if (animalsInHospital.size() != 0) {
            System.out.println("\n\nHospital Status:");
            System.out.println("|----------------------------------|----------------------------|");
            System.out.println("|              Animal              |        Veterinarian        |");
            System.out.println("|----------------------------------|----------------------------|");
            for (Animal animal : animalsInHospital.keySet()) {
                // Using String.format to achieve accurate indentation
                String formattedString = String.format("| %1$-32s | %2$-26s |",
                        animal.getName(), veterinarian.getName());
                System.out.println(formattedString);
            }
            System.out.println("|----------------------------------|----------------------------|\n\n");

        } else {

            System.out.println("\n\n|----------------------------------|----------------------------|");
            System.out.println("|              Animal              |        Veterinarian        |");
            System.out.println("|----------------------------------|----------------------------|");
            String formattedString = String.format("| %1$-61s |", "Hospital Status: No animals present in the hospital.");
            System.out.println(formattedString);
            System.out.println("|---------------------------------------------------------------|\n\n");
        }

        veterinarian.treatAllAnimal();
    }
}


// Example of inheritance
// Class representing a Veterinarian, a type of staff member
class Veterinarian extends Staff {

    // Constructor for creating a Veterinarian with a name
    public Veterinarian(String name) {
        super(name);
    }

    // Getter method to retrieve the name of the Veterinarian
    public String getName() {
        return name;
    }


    // This method simulates the treatment process and returns true if the animal is cured, false otherwise
    public boolean treatAnimal(Animal animal, Enclosure theEnclosure) {
            boolean treated = false;
            // Print a message indicating that the animal is receiving treatment
            System.out.println(animal.getName() + " is getting treatment now.");

            // Generate a random probability (0 or 1) to simulate the outcome of treatment
            Random rand = new Random();
            int prob = rand.nextInt(2);

            if (prob == 0) {
                // If the probability is 0, the animal is marked as healthy (cured)
                treated = true;
            }else {
                // add the sick animal to the hospital
                Hospital.getInstance().addAnimal(animal, theEnclosure);
                //removing an animal from enclosure
                theEnclosure.removeAnimal(animal);
            }
            return  treated;
    }


    public void treatAllAnimal() {
        Hospital hospital = Hospital.getInstance();
        Map<Animal, Enclosure> animalsInHospital = hospital.getAnimalFromHospital();
        List<Animal> animalsToTreat = new ArrayList<>(animalsInHospital.keySet());

        for (Animal animal : animalsToTreat) {
            // Print a message indicating that the animal is receiving treatment
            System.out.println(animal.getName() + " is getting treatment now.");

            // Generate a random probability (0 or 1) to simulate the outcome of treatment
            Random rand = new Random();
            int prob = rand.nextInt(2);

            if (prob == 1) {
                // If the probability is 0, the animal is marked as healthy (cured)
                System.out.println(animal.getName() + " has been treated and is healthy now.");
                animalsInHospital.get(animal).addAnimal(animal);
                animal.setHealthy(true);
                hospital.removeAnimal(animal, animalsInHospital.get(animal));
            }
        }
    }
}



// A class representing a vendor, which is a type of staff member
class Vendor extends Staff {
    private SalesBehavior salesBehavior;

    // Constructor to create a vendor with a name and set its sales behavior
    public Vendor(String name) {
        super(name);
        setSalesBehavior(salesBehavior);
    }

    public void PrepareShop(Shop shop){
        shop.inventory += 100;
    }

    // Method to set the sales behavior of the vendor
    public void setSalesBehavior(SalesBehavior salesBehavior) {
        Random random = new Random();
        int choice = random.nextInt(4); // Generate a random number between 0 and 3
        switch (choice) {
            case 0:
                this.salesBehavior = new NoSell();
                break; // Add break statement to terminate the switch
            case 1:
                this.salesBehavior = new SoftSell();
                break;
            case 2:
                this.salesBehavior = new NormalSell();
                break;
            case 3:
                this.salesBehavior = new HardSell();
                break;
        }
    }

    // Method to get the likelihood of making a sale based on the sales behavior
    public double getSaleLikelihood() {
        return salesBehavior.getSaleLikelihood();
    }

    // Method to get the likelihood of a visitor exiting based on the sales behavior
    public double getExitLikelihood() {
        return salesBehavior.getExitLikelihood();
    }
}

