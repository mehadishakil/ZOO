import java.util.*;

// Class representing an enclosure where animals are kept
class Enclosure {
    private String name;
    private ArrayList<Animal> animals;
    private Handler handler;

    // Constructor for creating an enclosure with a name, list of animals, and a handler
    public Enclosure(String name, ArrayList<Animal> animals, Handler handler) {
        this.name = name;
        this.animals = animals;
        this.handler = handler;
    }

    // Getter method to retrieve the name of the enclosure
    public String getName() {
        return this.name;
    }

    // Getter method to retrieve the handler responsible for the enclosure
    public Handler getHandler() {
        return handler;
    }

    // Getter method to retrieve the list of animals in the enclosure
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    // Setter method to add a list of animals to the enclosure
    public void addAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    // Method to add a single animal to the enclosure
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.name + " is cured and has been added to the enclosure.");
    }

    // Method to remove a single animal from the enclosure
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        System.out.println(animal.name + " has been removed from the enclosure.");
    }
}

// Class representing a Hospital where sick animals are treated
// This one is a singleton class with eager instantiatio
class Hospital {

    private static Map<Animal, Enclosure> hospitalizedAnimal = new HashMap<>();

    // Eagerly create an instance of the Hospital class (Eager Instantiation Singleton)
    private static final Hospital instance = new Hospital();

    // Private constructor to prevent external instantiation
    private Hospital() {
    }

    // Provide a public static method to access the instance of the Hospital
    public static Hospital getInstance() {
        return instance;
    }

    // Getter method to retrieve the list of animals in the hospital
    public Map<Animal, Enclosure> getAnimalFromHospital() {
        return hospitalizedAnimal;
    }



    // Method to add a single animal to the hospital
    public void addAnimal(Animal animal, Enclosure enclosure) {
        // The Hospital is using the Animal class's object animals_hospital
        // and calling the object's add method, this is delegation
        hospitalizedAnimal.put(animal, enclosure);
    }

    // Method to remove a single animal from the hospital
    public void removeAnimal(Animal animal, Enclosure enclosure) {
        // The Hospital is using the Animal class's object animals_hospital
        // and calling the object's remove method, this is delegation
        // this.animals_hospital.remove(animal);
        hospitalizedAnimal.remove(animal);
        System.out.println("From the hospital, " + animal.name + " has been removed.");
    }
}


class ZOO {

    int days = 30;
    private static final ZOO zoo = new ZOO();

    // Private constructor to prevent external instantiation
    private ZOO() {
    }

    // Provide a public static method to access the instance of the Hospital
    public static ZOO getInstance() {
        return zoo;
    }

    public void runSimulation() {

        // Implementing Factory pattern

        // Create empty lists to store animals
        ArrayList<Animal> Tigers_list = new ArrayList<Animal>();
        ArrayList<Animal> Lions_list = new ArrayList<Animal>();
        ArrayList<Animal> Cheetahs_list = new ArrayList<Animal>();
        ArrayList<Animal> Rhinos_list = new ArrayList<Animal>();
        ArrayList<Animal> Elephants_list = new ArrayList<Animal>();
        ArrayList<Animal> Hippos_list = new ArrayList<Animal>();
        ArrayList<Animal> Parrots_list = new ArrayList<Animal>();
        ArrayList<Animal> Falcons_list = new ArrayList<Animal>();
        ArrayList<Animal> Owls_list = new ArrayList<Animal>();
        ArrayList<Animal> Deers_list = new ArrayList<Animal>();
        ArrayList<Animal> Zebras_list = new ArrayList<Animal>();
        ArrayList<Animal> Horses_list = new ArrayList<Animal>();
        // Create the animal factories
        AnimalFactory pachydermFactory = new PachydermFactory();
        AnimalFactory felineFactory = new FelineFactory();
        AnimalFactory birdFactory = new BirdFactory();
        AnimalFactory mammalFactory = new MammalFactory();

        // Create Tigers using the pachydermFactory
        Tigers_list.add(felineFactory.createAnimal("Tiger", "Tammy_the_Tiger", Size.LARGE));
        Tigers_list.add(felineFactory.createAnimal("Tiger", "Tigre_the_Tiger", Size.MEDIUM));
        Tigers_list.add(felineFactory.createAnimal("Tiger", "Tim_the_Tiger", Size.SMALL));

        // Create Lions using the felineFactory
        Lions_list.add(felineFactory.createAnimal("Lion", "Leo_the_Lion", Size.LARGE));
        Lions_list.add(felineFactory.createAnimal("Lion", "Leon_the_Lion", Size.MEDIUM));
        Lions_list.add(felineFactory.createAnimal("Lion", "Lion_the_Lion", Size.SMALL));

        // Create Cheetahs using the felineFactory
        Cheetahs_list.add(felineFactory.createAnimal("Cheetah", "Cory_the_Cheetah", Size.MEDIUM));
        Cheetahs_list.add(felineFactory.createAnimal("Cheetah", "Case_the_Cheetah", Size.MEDIUM));
        Cheetahs_list.add(felineFactory.createAnimal("Cheetah", "Chase_the_Cheetah", Size.MEDIUM));

        // Create Rhinos using the pachydermFactory
        Rhinos_list.add(pachydermFactory.createAnimal("Rhino", "Rina_the_Rhino", Size.LARGE));
        Rhinos_list.add(pachydermFactory.createAnimal("Rhino", "Rony_the_Rhino", Size.LARGE));
        Rhinos_list.add(pachydermFactory.createAnimal("Rhino", "Runa_the_Rhino", Size.LARGE));

        // Create Elephants using the pachydermFactory
        Elephants_list.add(pachydermFactory.createAnimal("Elephant", "Elly_the_Elephant", Size.LARGE));
        Elephants_list.add(pachydermFactory.createAnimal("Elephant", "Eli_the_Elephant", Size.LARGE));
        Elephants_list.add(pachydermFactory.createAnimal("Elephant", "Emily_the_Elephant", Size.LARGE));

        // Create Hippos using the pachydermFactory
        Hippos_list.add(pachydermFactory.createAnimal("Hippo", "Hippy_the_Hippo", Size.LARGE));
        Hippos_list.add(pachydermFactory.createAnimal("Hippo", "Hop_the_Hippo", Size.LARGE));
        Hippos_list.add(pachydermFactory.createAnimal("Hippo", "Hoppu_the_Hippo", Size.LARGE));


        Parrots_list.add(birdFactory.createAnimal("Parrot", "Pie_the_Parrot", Size.SMALL));
        Parrots_list.add(birdFactory.createAnimal("Parrot", "Perry_the_Parrot", Size.SMALL));
        Parrots_list.add(birdFactory.createAnimal("Parrot", "Pop_the_Parrot", Size.SMALL));

        // Create Falcons using the birdFactory
        Falcons_list.add(birdFactory.createAnimal("Falcon", "Flu_the_Falcon", Size.SMALL));
        Falcons_list.add(birdFactory.createAnimal("Falcon", "Flee_the_Falcon", Size.SMALL));
        Falcons_list.add(birdFactory.createAnimal("Falcon", "Fly_the_Falcon", Size.SMALL));

        // Create Owls using the birdFactory
        Owls_list.add(birdFactory.createAnimal("Owl", "Oll_the_Owl", Size.SMALL));
        Owls_list.add(birdFactory.createAnimal("Owl", "Olly_the_Owl", Size.SMALL));
        Owls_list.add(birdFactory.createAnimal("Owl", "Owly_the_Owl", Size.SMALL));

        // Create Deers using the mammalFactory
        Deers_list.add(mammalFactory.createAnimal("Deer", "Doc_the_Deer", Size.MEDIUM));
        Deers_list.add(mammalFactory.createAnimal("Deer", "Dre_the_Deer", Size.MEDIUM));
        Deers_list.add(mammalFactory.createAnimal("Deer", "Doe_the_Deer", Size.MEDIUM));

        // Create Zebras using the mammalFactory
        Zebras_list.add(mammalFactory.createAnimal("Zebra", "Zeer_the_Zebra", Size.LARGE));
        Zebras_list.add(mammalFactory.createAnimal("Zebra", "Ziru_the_Zebra", Size.LARGE));
        Zebras_list.add(mammalFactory.createAnimal("Zebra", "Zee_the_Zebra", Size.LARGE));

        // Create Horses using the mammalFactory
        Horses_list.add(mammalFactory.createAnimal("Horse", "Hero_the_Horse", Size.LARGE));
        Horses_list.add(mammalFactory.createAnimal("Horse", "Heer_the_Horse", Size.LARGE));
        Horses_list.add(mammalFactory.createAnimal("Horse", "Heera_the_Horse", Size.LARGE));



        ArrayList<ArrayList<Animal>> allAnimals = new ArrayList<>();
        allAnimals.add(Tigers_list);
        allAnimals.add(Lions_list);
        allAnimals.add(Cheetahs_list);
        allAnimals.add(Rhinos_list);
        allAnimals.add(Elephants_list);
        allAnimals.add(Hippos_list);
        allAnimals.add(Parrots_list);
        allAnimals.add(Falcons_list);
        allAnimals.add(Owls_list);
        allAnimals.add(Deers_list);
        allAnimals.add(Zebras_list);
        allAnimals.add(Horses_list);





        // Creating Handler
        Handler felix_handler = new Handler("Felix");
        Handler Peter_handler = new Handler("Peter");
        Handler Bill_handler = new Handler("Bill");
        Handler Moore_handler = new Handler("Moore");

        //creating different enclosures for different animals type

        // Feline
        Enclosure tiger = new Enclosure("Tiger", Tigers_list, felix_handler);
        Enclosure lion = new Enclosure("Lion", Lions_list, felix_handler);
        Enclosure cheetah = new Enclosure("Cheetah", Cheetahs_list, felix_handler);
        ArrayList<Enclosure> felineEnclosure = new ArrayList<Enclosure>();
        felineEnclosure.add(tiger);
        felineEnclosure.add(lion);
        felineEnclosure.add(cheetah);

        // Pachyderms
        Enclosure rhino = new Enclosure("Rhino", Rhinos_list, Peter_handler);
        Enclosure elephant = new Enclosure("Elephant", Elephants_list, Peter_handler);
        Enclosure hippo = new Enclosure("Hippo", Hippos_list, Peter_handler);
        ArrayList<Enclosure> pachydermEnclosure = new ArrayList<Enclosure>();
        pachydermEnclosure.add(rhino);
        pachydermEnclosure.add(elephant);
        pachydermEnclosure.add(hippo);


        // Birds
        Enclosure parrot = new Enclosure("Parrot", Parrots_list, Bill_handler);
        Enclosure falcon = new Enclosure("Falcon", Falcons_list, Bill_handler);
        Enclosure owl = new Enclosure("Owl", Owls_list, Bill_handler);
        ArrayList<Enclosure> birdEnclosure = new ArrayList<Enclosure>();
        birdEnclosure.add(parrot);
        birdEnclosure.add(falcon);
        birdEnclosure.add(owl);


        // Mammals
        Enclosure horse = new Enclosure("Horse", Horses_list, Moore_handler);
        Enclosure deer = new Enclosure("Deer", Deers_list, Moore_handler);
        Enclosure zebra = new Enclosure("Zebra", Zebras_list, Moore_handler);
        ArrayList<Enclosure> mammalEnclosure = new ArrayList<Enclosure>();
        mammalEnclosure.add(horse);
        mammalEnclosure.add(deer);
        mammalEnclosure.add(zebra);

        //using the .addAnimals method adding of ArrayList of differnt animals objects
        tiger.addAnimals(Tigers_list);
        lion.addAnimals(Lions_list);
        cheetah.addAnimals(Cheetahs_list);
        rhino.addAnimals(Rhinos_list);
        elephant.addAnimals(Elephants_list);
        hippo.addAnimals(Hippos_list);
        parrot.addAnimals(Parrots_list);
        falcon.addAnimals(Falcons_list);
        owl.addAnimals(Owls_list);
        horse.addAnimals(Horses_list);
        deer.addAnimals(Deers_list);
        zebra.addAnimals(Zebras_list);


        //creating objects of hospital and Veteranian class
        Hospital hospital = Hospital.getInstance();
        Veterinarian veterinarian = new Veterinarian("Dr. Sarah Anderson Vet");

        ArrayList<Handler> allHandlers = new ArrayList<Handler>();
        allHandlers.add(felix_handler);
        allHandlers.add(Peter_handler);
        allHandlers.add(Bill_handler);
        allHandlers.add(Moore_handler);

        // Creating a list to hold all enclosure
        ArrayList<ArrayList<Enclosure>> allEnclosures = new ArrayList<>();
        allEnclosures.add(felineEnclosure);
        allEnclosures.add(pachydermEnclosure);
        allEnclosures.add(birdEnclosure);
        allEnclosures.add(mammalEnclosure);


        // Creating an array of Shop objects
        ArrayList<Shop> allShops = new ArrayList<>();
        // Shop[] shops = new Shop[5];
        allShops.add(new Gift("Gifts", (1 + (float) (Math.random() * 9)), 0.15, new Vendor("GiftsVendor")));
        allShops.add(new Maps("Maps", (1 + (float) (Math.random() * 9)), 0.20, new Vendor("MapsVendor")));
        allShops.add(new Drinks("Drinks", (1 + (float) (Math.random() * 9)), 0.25, new Vendor("DrinksVendor")));
        allShops.add(new Food("Food", (1 + (float) (Math.random() * 9)), 0.10, new Vendor("FoodVendor")));
        allShops.add(new Toy("Toys", (1 + (float) (Math.random() * 9)), 0.18, new Vendor("ToysVendor")));





        Receiver zoo = new Receiver(allShops, allEnclosures, allAnimals, hospital);
        Command[] commands = {
                new InspectEnclosureCommand(zoo),
                new InspectShopCommand(zoo),
                new InspectHospitalCommand(zoo),
                new InspectAnimalCommand(zoo)
        };

        Inspector inspector = new Inspector(zoo);



        //--------------------------------------------------------------------------------------------------------------------
        //30 days simulation

        for (int i = 1; i <= days; i++) {

            System.out.println("\n\n======================================================================================");
            System.out.println("Day_NO:" + i);
            System.out.println("======================================================================================");







            // Zoo Status
            Handler callZooStatus = new Handler("callZooStatus");
            callZooStatus.zooStatus(hospital, veterinarian, allEnclosures);





            // using different handler objects calling the methods with different object parameters
            // felix_handler object is aggregating the Tigers_list
            System.out.println("\n\n********Felix the handler has started tending to his animals:********");
            felix_handler.wakeAnimals(Tigers_list, "felix_handler");
            felix_handler.feedAnimals(Tigers_list, tiger, hospital, veterinarian, "felix_handler");
            felix_handler.exerciseAnimals(Tigers_list, tiger, hospital, veterinarian, "felix_handler");
            felix_handler.bedAnimals(Tigers_list, "felix_handler");
            //felix_handler object is aggregating the Lions_list
            felix_handler.wakeAnimals(Lions_list, "felix_handler");
            felix_handler.feedAnimals(Lions_list, lion, hospital, veterinarian, "felix_handler");
            felix_handler.exerciseAnimals(Lions_list, lion, hospital, veterinarian, "felix_handler");
            felix_handler.bedAnimals(Lions_list, "felix_handler");
            //felix_handler object is aggregating the Cheetahs_list
            felix_handler.wakeAnimals(Cheetahs_list, "felix_handler");
            felix_handler.feedAnimals(Cheetahs_list, cheetah, hospital, veterinarian, "felix_handler");
            felix_handler.exerciseAnimals(Cheetahs_list, cheetah, hospital, veterinarian, "felix_handler");
            felix_handler.bedAnimals(Cheetahs_list, "felix_handler");


            //Peter_handler object is aggregating the Rhinos_list
            System.out.println("\n\n********Peter the handler has started tending to his animals:********");
            Peter_handler.wakeAnimals(Rhinos_list, "Peter_handler");
            Peter_handler.feedAnimals(Rhinos_list, rhino, hospital, veterinarian, "Peter_handler");
            Peter_handler.exerciseAnimals(Rhinos_list, rhino, hospital, veterinarian, "Peter_handler");
            Peter_handler.bedAnimals(Rhinos_list, "Peter_handler");
            //Peter_handler object is aggregating the Elephants_list
            Peter_handler.wakeAnimals(Elephants_list, "Peter_handler");
            Peter_handler.feedAnimals(Elephants_list, elephant, hospital, veterinarian, "Peter_handler");
            Peter_handler.exerciseAnimals(Elephants_list, elephant, hospital, veterinarian, "Peter_handler");
            Peter_handler.bedAnimals(Elephants_list, "Peter_handler");
            //Peter_handler object is aggregating the Hippos_list
            Peter_handler.wakeAnimals(Hippos_list, "Peter_handler");
            Peter_handler.feedAnimals(Hippos_list, hippo, hospital, veterinarian, "Peter_handler");
            Peter_handler.exerciseAnimals(Hippos_list, hippo, hospital, veterinarian, "Peter_handler");
            Peter_handler.bedAnimals(Hippos_list, "Peter_handler");


            //Bill_handler object is aggregating the parrots_list
            System.out.println("\n\n********Bill the handler has started tending to his animals:********");
            Bill_handler.wakeAnimals(Parrots_list, "Bill_handler");
            Bill_handler.feedAnimals(Parrots_list, parrot, hospital, veterinarian, "Bill_handler");
            Bill_handler.exerciseAnimals(Parrots_list, parrot, hospital, veterinarian, "Bill_handler");
            Bill_handler.bedAnimals(Parrots_list, "Bill_handler");
            //Bill_handler object is aggregating the Owls_list
            Bill_handler.wakeAnimals(Owls_list, "Bill_handler");
            Bill_handler.feedAnimals(Owls_list, owl, hospital, veterinarian, "Bill_handler");
            Bill_handler.exerciseAnimals(Owls_list, owl, hospital, veterinarian, "Bill_handler");
            Bill_handler.bedAnimals(Owls_list, "Bill_handler");
            //Bill_handler object is aggregating the Falcons_list
            Bill_handler.wakeAnimals(Falcons_list, "Bill_handler");
            Bill_handler.feedAnimals(Falcons_list, falcon, hospital, veterinarian, "Bill_handler");
            Bill_handler.exerciseAnimals(Falcons_list, falcon, hospital, veterinarian, "Bill_handler");
            Bill_handler.bedAnimals(Falcons_list, "Bill_handler");


            //Moore_handler object is aggregating the Zebrass_list
            System.out.println("\n\n********Moore the handler has started tending to his animals:********");
            Moore_handler.wakeAnimals(Zebras_list, "Moore_handler");
            Moore_handler.feedAnimals(Zebras_list, zebra, hospital, veterinarian, "Moore_handler");
            Moore_handler.exerciseAnimals(Zebras_list, zebra, hospital, veterinarian, "Moore_handler");
            Moore_handler.bedAnimals(Zebras_list, "Moore_handler");
            //Moore_handler object is aggregating the Deers_list
            Moore_handler.wakeAnimals(Deers_list, "Moore_handler");
            Moore_handler.feedAnimals(Deers_list, deer, hospital, veterinarian, "Moore_handler");
            Moore_handler.exerciseAnimals(Deers_list, deer, hospital, veterinarian, "Moore_handler");
            Moore_handler.bedAnimals(Deers_list, "Moore_handler");
            //Moore_handler object is aggregating the Zebras_list
            Moore_handler.wakeAnimals(Horses_list, "Moore_handler");
            Moore_handler.feedAnimals(Horses_list, horse, hospital, veterinarian, "Moore_handler");
            Moore_handler.exerciseAnimals(Horses_list, horse, hospital, veterinarian, "Moore_handler");
            Moore_handler.bedAnimals(Horses_list, "Moore_handler");






            // Generate a random number of visitors between 50 and 100
            int visitors = 50 + new Random().nextInt(51);
            System.out.println("------------------------------------------------Shop Events------------------------------------------------");
            System.out.println("Today we have " + visitors + " visitors!");


            for (int j = 0; j < visitors; j++) {
                System.out.println("Visitor " + (j + 1) + " is visiting the shops.");

                // Create a list of shops to visit and shuffle them for a random order
                List<Shop> shopsToVisit = allShops;
                Collections.shuffle(shopsToVisit);


                for (Shop shop : shopsToVisit) {
                    // Mark that the visitor has visited the shop
                    shop.visit();

                    DecoratorImplementor decoratorImplementor = new DecoratorImplementor(shop);

                    // Each visitor has a likelihood of buying an item from the shop
                    if (Math.random() < shop.likelihoodOfSale && shop.inventory > 0) {
                        // Reduce the shop's inventory, update cash, and record the sale
                        shop.inventory--;
                        if (shop.inventory < 20){
                            shop.vendor.PrepareShop(shop);
                        }
                        SalesEvent shopSummary = SalesTracker.getInstance().getShopSummary(shop);
                        shop.cash = shop.price * shopSummary.getSales();
                        System.out.println("Bought an item from " + shop.name);
                        decoratorImplementor.sale();
                    }

                    // There is a 5% chance that the visitor will exit after visiting each shop
                    if (Math.random() < 0.05) {
                        shop.exit();
                        System.out.println("Visitor " + (j + 1) + " has exited the shops.");
                        break; // Exit the loop if the visitor exits
                    }
                }

                System.out.println("Visitor " + (j + 1) + " has finished visiting the shops.");
                System.out.println();
            }

            // Print a summary of shop sales
            SalesTracker.getInstance().PrintShopStatus();


            System.out.println("\n\n");
            inspector.issueRandomInspections();
            System.out.println("\n\n");

            SalesTracker.getInstance().resetValue();


            System.out.println("======================================================================================");
            System.out.println("Day " + i + " ends");
            System.out.println("======================================================================================");


        }

        SalesChart chart = new SalesChart("Sales Chart Example", allShops);
        chart.pack();
        // RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }


}