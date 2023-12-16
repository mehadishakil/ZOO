import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void shouldCreateLion(){
        AnimalFactory felineFactory = new FelineFactory();
        Assertions.assertNotNull(felineFactory.createAnimal("Lion", "Leo_the_Lion", Size.LARGE));
    }


    @Test
    public void shouldCreateTiger() {
        AnimalFactory felineFactory = new FelineFactory();
        Assertions.assertNotNull(felineFactory.createAnimal("Tiger", "Tammy_the_Tiger", Size.LARGE));
    }

    @Test
    public void shouldCreateRhino() {
        AnimalFactory pachydermFactory = new PachydermFactory();
        Assertions.assertNotNull(pachydermFactory.createAnimal("Rhino", "Rina_the_Rhino", Size.LARGE));
    }

    @Test
    public void shouldCreateElephant() {
        AnimalFactory pachydermFactory = new PachydermFactory();
        Assertions.assertNotNull(pachydermFactory.createAnimal("Elephant", "Elly_the_Elephant", Size.LARGE));
    }

    @Test
    public void shouldCreateParrot() {
        AnimalFactory birdFactory = new BirdFactory();
        Assertions.assertNotNull(birdFactory.createAnimal("Parrot", "Pie_the_Parrot", Size.SMALL));
    }

    @Test
    public void shouldCreateFalcon() {
        AnimalFactory birdFactory = new BirdFactory();
        Assertions.assertNotNull(birdFactory.createAnimal("Falcon", "Flu_the_Falcon", Size.SMALL));
    }

    @Test
    public void shouldCreateDeer() {
        AnimalFactory mammalFactory = new MammalFactory();
        Assertions.assertNotNull(mammalFactory.createAnimal("Deer", "Doc_the_Deer", Size.MEDIUM));
    }

    @Test
    public void shouldCreateHorse() {
        AnimalFactory mammalFactory = new MammalFactory();
        Assertions.assertNotNull(mammalFactory.createAnimal("Horse", "Hero_the_Horse", Size.LARGE));
    }


}