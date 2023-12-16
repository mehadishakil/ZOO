import java.util.ArrayList;
import java.util.Random;

// Command interface
interface Command {
    void execute();
}

// Concrete Command for inspecting an enclosure
class InspectEnclosureCommand implements Command {
    private Receiver receiver;

    public InspectEnclosureCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        Enclosure enclosure = receiver.getRandomEnclosure();
        int animalCount = enclosure.getAnimals().size();
        System.out.println("The Inspector finds there are " + animalCount + " animals in the " + enclosure.getName() + " enclosure.");
    }
}

// Concrete Command for inspecting a shop
class InspectShopCommand implements Command {
    private Receiver receiver;

    public InspectShopCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
         Shop shop = receiver.getRandomShop();
         int sales = shop.shopSummary.getSales();
         double sold = (double) sales * (double) shop.price;
         String sells = String.format("%.2f", sold);
         System.out.println("The Inspector finds the " + shop.name + " shop has sold $" + sells + " today.");
    }
}

// Concrete Command for inspecting the hospital
class InspectHospitalCommand implements Command {
    private Receiver zoo;

    public InspectHospitalCommand(Receiver zoo) {
        this.zoo = zoo;
    }

    public void execute() {
        int animalCount = zoo.getAnimalsInHospital();
        System.out.println("The Inspector finds there are " + animalCount + " animals in the hospital at present.");
    }
}

// Concrete Command for inspecting an animal
class InspectAnimalCommand implements Command {
    private Receiver zoo;

    public InspectAnimalCommand(Receiver zoo) {
        this.zoo = zoo;
    }

    public void execute() {
        Enclosure enclosure = zoo.getRandomEnclosure();
        while (enclosure.getAnimals().isEmpty()){
            enclosure = zoo.getRandomEnclosure();
        }
        ArrayList<Animal> animals = enclosure.getAnimals();
        Random random = new Random();
            // Check if the ArrayList is not empty
            if (!animals.isEmpty()) {
                // Generate a random index within the bounds of the ArrayList
                int randomIndex = random.nextInt(animals.size());
                // Retrieve the randomly selected Animal object
                Animal randomAnimal = animals.get(randomIndex);
                System.out.println("The Inspector finds " + randomAnimal.getName() + " is " + randomAnimal.getName() + " sized, healthy, and in the " + enclosure.getName() + " enclosure.");
            } else {
                System.out.println("The ArrayList is empty.");
            }




    }
}


// Receiver classes
class Receiver {
    // Methods to get random objects, e.g., getRandomEnclosure, getRandomShop, getRandomAnimal, etc.

    private ArrayList<Shop> allShops = new ArrayList<>();
    private ArrayList<ArrayList<Enclosure>> allEnclosures = new ArrayList<>();
    private ArrayList<ArrayList<Animal>> allAnimals = new ArrayList<>();
    private Hospital hospital;

    public Receiver(ArrayList<Shop> allShops, ArrayList<ArrayList<Enclosure>> allEnclosures, ArrayList<ArrayList<Animal>> allAnimals, Hospital hospital) {
        this.allShops = allShops;
        this.allEnclosures = allEnclosures;
        this.allAnimals = allAnimals;
        this.hospital = hospital;
    }

    public Enclosure getRandomEnclosure() {
        // Generate a random index for selecting an enclosure list
        Random random = new Random();
        int enclosureListIndex = random.nextInt(allEnclosures.size());

        // Get the selected enclosure list
        ArrayList<Enclosure> selectedEnclosureList = allEnclosures.get(enclosureListIndex);

        // Generate a random index for selecting an enclosure from the list
        int enclosureIndex = random.nextInt(selectedEnclosureList.size());

        // Return the randomly selected enclosure
        return selectedEnclosureList.get(enclosureIndex);
    }

    public Shop getRandomShop() {
        // Generate a random index for selecting a shop
        Random random = new Random();
        int shopIndex = random.nextInt(allShops.size());

        // Return the randomly selected shop
        return allShops.get(shopIndex);
    }

    public int getAnimalsInHospital() {
        // Implement logic to get the number of animals in the hospital
        // In this example, we'll assume that the hospital object provides a method to get the number of animals in it.
        if (hospital != null) {
            return hospital.getAnimalFromHospital().size();
        } else {
            return 0; // Return 0 if the hospital is not initialized
        }
    }

    public Animal getRandomAnimal() {
        // Generate a random index for selecting an animal list
        Random random = new Random();
        int animalListIndex = random.nextInt(allAnimals.size());

        // Get the selected animal list
        ArrayList<Animal> selectedAnimalList = allAnimals.get(animalListIndex);

        // Generate a random index for selecting an animal from the list
        int animalIndex = random.nextInt(selectedAnimalList.size());

        // Return the randomly selected animal
        return selectedAnimalList.get(animalIndex);
    }
}


class Inspector {
    private Command[] commands;
    private Random random;

    public Inspector(Receiver zoo) {
        commands = new Command[] {
                new InspectEnclosureCommand(zoo),
                new InspectShopCommand(zoo),
                new InspectHospitalCommand(zoo),
                new InspectAnimalCommand(zoo)
        };
        random = new Random();
    }

    public void issueRandomInspections() {


            int commandCount = random.nextInt(4)+1;
            for (int i = 0; i < commandCount; i++) {

                commands[i].execute();
            }


    }
}