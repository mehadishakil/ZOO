import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.sun.imageio.plugins.jpeg.JPEG.vendor;
import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {

    private Staff staff;
    private Veterinarian veterinarian;

    @BeforeEach
    void setUp() {
        staff = new Handler("John");
    }

    @Test
    void getName() {
        assertEquals("John", staff.getName());
    }

    @Test
    void setHandler() {
        staff = new Handler("John");
        staff.setName("Alice");
        assertEquals("Alice", staff.getName());
    }

    @Test
    void wakeAnimals() {
        // Redirect the standard output to capture printed messages
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create empty lists to store animals
        ArrayList<Animal> animalList = new ArrayList<Animal>();

        // Creating the animal factories
        AnimalFactory pachydermFactory = new PachydermFactory();
        AnimalFactory felineFactory = new FelineFactory();
        AnimalFactory birdFactory = new BirdFactory();
        AnimalFactory mammalFactory = new MammalFactory();

        // Creating animals using their facctory
        animalList.add(felineFactory.createAnimal("Tiger", "Tammy_the_Tiger", Size.LARGE));
        animalList.add(pachydermFactory.createAnimal("Rhino", "Rina_the_Rhino", Size.LARGE));
        animalList.add(birdFactory.createAnimal("Falcon", "Flu_the_Falcon", Size.SMALL));
        animalList.add(mammalFactory.createAnimal("Deer", "Doc_the_Deer", Size.MEDIUM));


        staff.wakeAnimals(animalList, staff.getName());

        // Check if the wakeAnimals method prints the expected messages
        String expectedOutput = "John the handler has make Tammy_the_Tiger awake." + System.lineSeparator() +
                "Tammy_the_Tiger of LARGE size is Growlllingggggggg!!!!!" + System.lineSeparator() +
                "John the handler has make Rina_the_Rhino awake." + System.lineSeparator() +
                "Rina_the_Rhino of LARGE size is Screammmingggggggg!!!!!" + System.lineSeparator() +
                "John the handler has make Flu_the_Falcon awake." + System.lineSeparator() +
                "Flu_the_Falcon of SMALL size is Shrillllingggggg!!!!!" + System.lineSeparator() +
                "John the handler has make Doc_the_Deer awake." + System.lineSeparator() +
                "Doc_the_Deer of MEDIUM size is grunttttinggggggggg!!!!!!" + System.lineSeparator() +
                System.lineSeparator() ;
        assertEquals(expectedOutput, outContent.toString());

        // Reset the standard output
        System.setOut(System.out);
    }



    @Test
    void bedAnimals() {
        // Redirect the standard output to capture printed messages
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create empty lists to store animals
        ArrayList<Animal> animalList = new ArrayList<Animal>();

        // Creating the animal factories
        AnimalFactory pachydermFactory = new PachydermFactory();
        AnimalFactory felineFactory = new FelineFactory();

        // Creating animals using their facctory
        animalList.add(felineFactory.createAnimal("Tiger", "Tammy_the_Tiger", Size.LARGE));
        animalList.add(pachydermFactory.createAnimal("Rhino", "Rina_the_Rhino", Size.LARGE));

        staff.bedAnimals(animalList, staff.getName());

        // Check if the bedAnimals method prints the expected messages
        String expectedOutput =  System.lineSeparator() +
                "John has make the Tammy_the_Tiger slept" + System.lineSeparator() +
                "John has make the Rina_the_Rhino slept" + System.lineSeparator() +
                System.lineSeparator();
                assertAll("Multiple Conditions",
                () -> assertEquals(expectedOutput, outContent.toString()),
                () -> assertNull(veterinarian));

        // Reset the standard output
        System.setOut(System.out);
    }

    @Test
    void treatAnimals(){
        Animal animal;
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        ArrayList<Handler> handlerList = new ArrayList<Handler>();
        Handler handler = new Handler("FelineHandler");
        AnimalFactory felineFactory = new FelineFactory();
        animal = felineFactory.createAnimal("Tiger", "Tammy_the_Tiger", Size.LARGE);
        animalList.add(animal);
        handlerList.add(handler);
        Enclosure enclosure = new Enclosure("TigerEnclosure", animalList, handler);




        // using assertAll assertion
        assertAll("Multiple Conditions",
                () -> Assertions.assertNotNull(veterinarian = new Veterinarian("Dr John"))
        );
    }
}
