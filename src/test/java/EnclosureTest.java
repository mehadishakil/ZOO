import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EnclosureTest {

    @Test
    void testEnclosure(){
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        Handler handler = new Handler("FelineHandler");
        AnimalFactory felineFactory = new FelineFactory();
        animalList.add(felineFactory.createAnimal("Tiger", "Tammy_the_Tiger", Size.LARGE));
        animalList.add(felineFactory.createAnimal("Tiger", "Tigre_the_Tiger", Size.MEDIUM));
        animalList.add(felineFactory.createAnimal("Tiger", "Tim_the_Tiger", Size.SMALL));
        Enclosure enclosure = new Enclosure("TigerEnclosure", animalList, handler);
        assertArrayEquals(animalList.toArray(), enclosure.getAnimals().toArray());
    }
}
