package edu.hw4;

import java.lang.reflect.Executable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.hw4.animal.Animal;
import edu.hw4.errors.AgeError;
import edu.hw4.errors.HeightError;
import edu.hw4.errors.ValidationError;
import edu.hw4.errors.WeightError;
import edu.hw4.utils.AnimalUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static javax.swing.UIManager.put;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class AnimalUtilTest {

    @Mock
    Animal firstAnimal;
    @Mock
    Animal secondAnimal;
    @Mock
    Animal thirdAnimal;
    @Mock
    Animal fourthAnimal;
    @Mock
    Animal fifthAnimal;
    @Mock
    Animal sixthAnimal;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    private Animal createAnimal(Animal.Type type, int age) {
        return new Animal("", type, Animal.Sex.M, age, 1, 1, false);
    }

    @Test
    void testGetSortedAnimalsByHeightAscending() {
        // Arrange
        when(firstAnimal.height()).thenReturn(30);
        when(secondAnimal.height()).thenReturn(20);
        when(thirdAnimal.height()).thenReturn(10);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        List<Animal> expectedSortedAnimals = List.of(thirdAnimal, secondAnimal, firstAnimal);
        // Act
        List<Animal> result = AnimalUtil.getSortedAnimalsByHeightAscending(animals);
        // Assert
        assertThat(result).isEqualTo(expectedSortedAnimals);
    }

    @Test
    void testGetTopKAnimalsByWeight() {
        // Arrange
        when(firstAnimal.weight()).thenReturn(10);
        when(secondAnimal.weight()).thenReturn(20);
        when(thirdAnimal.weight()).thenReturn(30);
        int top = 2;
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        List<Animal> expectedTopKAnimals = List.of(thirdAnimal, secondAnimal);
        // Act
        List<Animal> result = AnimalUtil.getTopKHeaviestAnimals(animals, top);
        // Assert
        assertThat(result).isEqualTo(expectedTopKAnimals);
    }

    @Test
    void testCountAnimalsByType() {
        // Arrange
        when(firstAnimal.type()).thenReturn(Animal.Type.CAT);
        when(secondAnimal.type()).thenReturn(Animal.Type.CAT);
        when(thirdAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fourthAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fifthAnimal.type()).thenReturn(Animal.Type.FISH);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal);
        Map<Animal.Type, Long> expectedCounts = Map.of(
            Animal.Type.CAT, 2L,
            Animal.Type.DOG, 2L,
            Animal.Type.FISH, 1L
        );
        // Act
        Map<Animal.Type, Long> animalCountMap = AnimalUtil.getNumberOfAnimalsByType(animals);
        // Assert
        assertThat(animalCountMap).isEqualTo(expectedCounts);
    }

    @Test
    void testAnimalWithLongestNameWithNameMock() {
        // Arrange
        when(firstAnimal.name()).thenReturn("name1");
        when(secondAnimal.name()).thenReturn("name2");
        when(thirdAnimal.name()).thenReturn("naame3");
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        Animal expected = thirdAnimal;
        // Act
        Animal animalWithLongestName = AnimalUtil.getAnimalWithLongestName(animals);
        // Assert
        assertThat(animalWithLongestName).isNotNull();
        assertThat(animalWithLongestName).isEqualTo(expected);
    }

    @Test
    void testAnimalWithLongestNameWithSexMock() {
        // Arrange
        when(firstAnimal.sex()).thenReturn(Animal.Sex.M);
        when(secondAnimal.sex()).thenReturn(Animal.Sex.M);
        when(thirdAnimal.sex()).thenReturn(Animal.Sex.F);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        Animal.Sex expected = Animal.Sex.M;
        // Act
        Animal.Sex result = AnimalUtil.getMostCommonSex(animals);
        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testGetHeaviestAnimalPerType() {
        // Arrange
        when(firstAnimal.type()).thenReturn(Animal.Type.CAT);
        when(secondAnimal.type()).thenReturn(Animal.Type.CAT);
        when(thirdAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fourthAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fifthAnimal.type()).thenReturn(Animal.Type.FISH);
        when(sixthAnimal.type()).thenReturn(Animal.Type.FISH);
        when(firstAnimal.weight()).thenReturn(10);
        when(secondAnimal.weight()).thenReturn(15);
        when(thirdAnimal.weight()).thenReturn(20);
        when(fourthAnimal.weight()).thenReturn(25);
        when(fifthAnimal.weight()).thenReturn(5);
        when(sixthAnimal.weight()).thenReturn(30);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal, sixthAnimal);
        Map<Animal.Type, Animal> expectedHeaviestAnimalPerType = Map.of(
            Animal.Type.CAT, secondAnimal,
            Animal.Type.DOG, fourthAnimal,
            Animal.Type.FISH, sixthAnimal
        );
        // Act
        Map<Animal.Type, Animal> heaviestAnimalPerType = AnimalUtil.getHeaviestAnimalPerType(animals);
        // Assert
        assertThat(heaviestAnimalPerType).isEqualTo(expectedHeaviestAnimalPerType);
    }

    @Test
    void testGetKthOldestAnimal() {
        // Arrange
        when(firstAnimal.age()).thenReturn(1);
        when(secondAnimal.age()).thenReturn(2);
        when(thirdAnimal.age()).thenReturn(3);
        int k = 2;
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        Animal expected = secondAnimal;
        // Act
        Animal kthOldestAnimal = AnimalUtil.getKthOldestAnimal(animals, k);
        // Assert
        assertThat(kthOldestAnimal).isNotNull();
        assertThat(kthOldestAnimal).isEqualTo(expected);
    }

    @Test
    void testGetHeaviestAnimalBelowHeight() {
        // Arrange
        when(firstAnimal.height()).thenReturn(1);
        when(secondAnimal.height()).thenReturn(2);
        when(thirdAnimal.height()).thenReturn(3);
        when(fourthAnimal.height()).thenReturn(4);
        when(fifthAnimal.height()).thenReturn(5);
        when(firstAnimal.weight()).thenReturn(2);
        when(secondAnimal.weight()).thenReturn(3);
        when(thirdAnimal.weight()).thenReturn(1);
        when(fourthAnimal.weight()).thenReturn(2);
        when(fifthAnimal.weight()).thenReturn(3);
        int maxHeight = 3;
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal);
        Animal expected = secondAnimal;
        // Act
        Animal heaviestAnimal = AnimalUtil.getHeaviestAnimalBelowHeight(animals, maxHeight);
        // Assert
        assertThat(heaviestAnimal).isNotNull();
        assertThat(heaviestAnimal).isEqualTo(expected);
    }

    @Test
    void testGetSumOfAllPaws() {
        // Arrange
        when(firstAnimal.paws()).thenReturn(2);
        when(secondAnimal.paws()).thenReturn(4);
        when(thirdAnimal.paws()).thenReturn(4);
        when(fourthAnimal.paws()).thenReturn(0);
        when(fifthAnimal.paws()).thenReturn(8);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal);
        int expectedSumOfPaws = 18;
        // Act
        int sumOfPaws = AnimalUtil.getSumOfAllPaws(animals);
        // Assert
        assertThat(sumOfPaws).isEqualTo(expectedSumOfPaws);
    }

    @Test
    void testGetBitingAnimalsWithHeightOver100() {
        // Arrange
        when(firstAnimal.bites()).thenReturn(false);
        when(secondAnimal.bites()).thenReturn(true);
        when(thirdAnimal.bites()).thenReturn(true);
        when(firstAnimal.height()).thenReturn(110);
        when(secondAnimal.height()).thenReturn(90);
        when(thirdAnimal.height()).thenReturn(110);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        List<Animal> expected = List.of(thirdAnimal);
        // Act
        List<Animal> bitingAnimalsWithHeightOver100 = AnimalUtil.getBitingAnimalsWithHeightOver100(animals);
        // Assert
        assertThat(bitingAnimalsWithHeightOver100).isEqualTo(expected);
    }

    @Test
    void testGetNumberOfAnimalsWithWeightGreaterThanHeight() {
        // Arrange
        when(firstAnimal.height()).thenReturn(1);
        when(secondAnimal.height()).thenReturn(2);
        when(thirdAnimal.height()).thenReturn(3);
        when(thirdAnimal.height()).thenReturn(4);
        when(thirdAnimal.height()).thenReturn(5);
        when(firstAnimal.weight()).thenReturn(5);
        when(secondAnimal.weight()).thenReturn(4);
        when(thirdAnimal.weight()).thenReturn(3);
        when(thirdAnimal.weight()).thenReturn(2);
        when(thirdAnimal.weight()).thenReturn(1);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal);
        long expected = 2;
        // Act
        Long result = AnimalUtil.getNumberOfAnimalsWithWeightGreaterThanHeight(animals);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testGetAnimalsWithNamesMoreThanTwoWords() {
        // Arrange
        when(firstAnimal.name()).thenReturn("First animal");
        when(secondAnimal.name()).thenReturn("Second animal");
        when(thirdAnimal.name()).thenReturn("Third animal");
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        List<Animal> expected = List.of();
        // Act
        List<Animal> result = AnimalUtil.getAnimalsWithNamesMoreThanTwoWords(animals);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testHasDogTallerThanK() {
        // Arrange
        when(firstAnimal.type()).thenReturn(Animal.Type.CAT);
        when(secondAnimal.type()).thenReturn(Animal.Type.DOG);
        when(thirdAnimal.type()).thenReturn(Animal.Type.DOG);
        when(firstAnimal.height()).thenReturn(110);
        when(secondAnimal.height()).thenReturn(90);
        when(thirdAnimal.height()).thenReturn(110);
        int k = 100;
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal);
        // Act
        boolean result = AnimalUtil.hasDogTallerThanK(animals, k);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void testGetSumWeightByTypeInAgeRange() {
        // Arrange
        when(firstAnimal.type()).thenReturn(Animal.Type.CAT);
        when(secondAnimal.type()).thenReturn(Animal.Type.CAT);
        when(thirdAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fourthAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fifthAnimal.type()).thenReturn(Animal.Type.FISH);
        when(sixthAnimal.type()).thenReturn(Animal.Type.FISH);
        when(firstAnimal.weight()).thenReturn(10);
        when(secondAnimal.weight()).thenReturn(10);
        when(thirdAnimal.weight()).thenReturn(20);
        when(fourthAnimal.weight()).thenReturn(20);
        when(fifthAnimal.weight()).thenReturn(30);
        when(sixthAnimal.weight()).thenReturn(30);
        when(firstAnimal.age()).thenReturn(1);
        when(secondAnimal.age()).thenReturn(5);
        when(thirdAnimal.age()).thenReturn(1);
        when(fourthAnimal.age()).thenReturn(2);
        when(fifthAnimal.age()).thenReturn(3);
        when(sixthAnimal.age()).thenReturn(4);
        int k = 1;
        int l = 3;
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal, sixthAnimal);
        Map<Animal.Type, Integer> expected = Map.of(
            Animal.Type.CAT, 10,
            Animal.Type.DOG, 40,
            Animal.Type.FISH, 30
        );
        // Act
        Map<Animal.Type, Integer> result = AnimalUtil.getSumWeightByTypeInAgeRange(animals, k, l);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testGetSortedAnimalsByTypeSexNameAscending() {
        // Arrange
        when(firstAnimal.type()).thenReturn(Animal.Type.FISH);
        when(secondAnimal.type()).thenReturn(Animal.Type.DOG);
        when(thirdAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fourthAnimal.type()).thenReturn(Animal.Type.CAT);
        when(fifthAnimal.type()).thenReturn(Animal.Type.CAT);
        when(sixthAnimal.type()).thenReturn(Animal.Type.CAT);
        when(firstAnimal.sex()).thenReturn(Animal.Sex.M);
        when(secondAnimal.sex()).thenReturn(Animal.Sex.F);
        when(thirdAnimal.sex()).thenReturn(Animal.Sex.M);
        when(fourthAnimal.sex()).thenReturn(Animal.Sex.F);
        when(fifthAnimal.sex()).thenReturn(Animal.Sex.M);
        when(sixthAnimal.sex()).thenReturn(Animal.Sex.F);
        when(firstAnimal.name()).thenReturn("A");
        when(secondAnimal.name()).thenReturn("B");
        when(thirdAnimal.name()).thenReturn("C");
        when(fourthAnimal.name()).thenReturn("C");
        when(fifthAnimal.name()).thenReturn("B");
        when(sixthAnimal.name()).thenReturn("A");
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal, sixthAnimal);
        List<Animal> expected = List.of(fifthAnimal, sixthAnimal, fourthAnimal, thirdAnimal, secondAnimal, firstAnimal);
        // Act
        List<Animal> result = AnimalUtil.getSortedAnimalsByTypeSexNameAscending(animals);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDoSpidersBiteMoreThanDogs() {
        // Arrange
        when(firstAnimal.type()).thenReturn(Animal.Type.DOG);
        when(secondAnimal.type()).thenReturn(Animal.Type.DOG);
        when(thirdAnimal.type()).thenReturn(Animal.Type.DOG);
        when(fourthAnimal.type()).thenReturn(Animal.Type.SPIDER);
        when(fifthAnimal.type()).thenReturn(Animal.Type.SPIDER);
        when(sixthAnimal.type()).thenReturn(Animal.Type.SPIDER);
        when(firstAnimal.bites()).thenReturn(true);
        when(secondAnimal.bites()).thenReturn(false);
        when(thirdAnimal.bites()).thenReturn(false);
        when(fourthAnimal.bites()).thenReturn(true);
        when(fifthAnimal.bites()).thenReturn(true);
        when(sixthAnimal.bites()).thenReturn(false);
        List<Animal> animals = List.of(firstAnimal, secondAnimal, thirdAnimal, fourthAnimal, fifthAnimal, sixthAnimal);
        // Act
        boolean result = AnimalUtil.doSpidersBiteMoreThanDogs(animals);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void testGetHeaviestFishInLists() {
        // Arrange
        when(firstAnimal.type()).thenReturn(Animal.Type.DOG);
        when(secondAnimal.type()).thenReturn(Animal.Type.FISH);
        when(thirdAnimal.type()).thenReturn(Animal.Type.CAT);
        when(fourthAnimal.type()).thenReturn(Animal.Type.FISH);
        when(fifthAnimal.type()).thenReturn(Animal.Type.FISH);
        when(sixthAnimal.type()).thenReturn(Animal.Type.FISH);
        when(firstAnimal.weight()).thenReturn(6);
        when(secondAnimal.weight()).thenReturn(1);
        when(thirdAnimal.weight()).thenReturn(2);
        when(fourthAnimal.weight()).thenReturn(5);
        when(fifthAnimal.weight()).thenReturn(4);
        when(sixthAnimal.weight()).thenReturn(3);
        List<List<Animal>> animalLists = List.of(
            List.of(firstAnimal, secondAnimal),
            List.of(thirdAnimal, fourthAnimal),
            List.of(fifthAnimal, sixthAnimal)
        );
        // Act
        Animal result = AnimalUtil.getHeaviestFishInLists(animalLists);
        // Assert
        assertThat(result).isEqualTo(fourthAnimal);
    }

    @Test
    void testGetValidationErrors() {
        // Arrange
        when(firstAnimal.name()).thenReturn("name");
        when(firstAnimal.age()).thenReturn(1);
        when(firstAnimal.height()).thenReturn(1);
        when(firstAnimal.weight()).thenReturn(1);
        List<Animal> animals = List.of(firstAnimal, secondAnimal);
        Map<String, List<ValidationError>> expected = new HashMap<String, List<ValidationError>>() {{
            put("name", List.of());
            put(null, List.of(
                new AgeError("Age must be greater than a zero"),
                new HeightError("Height must be greater than a zero"),
                new WeightError("Weight must be greater than a zero")
            ));
        }};
        // Act
        Map<String, List<ValidationError>> result = AnimalUtil.getValidationErrors(animals);
        // Assert
        assertThat(result)
            .usingRecursiveComparison()
            .ignoringCollectionOrder()
            .isEqualTo(expected);
    }

}
