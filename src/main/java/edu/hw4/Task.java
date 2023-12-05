package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings({"LambdaParameterName", "MagicNumber"})
public class Task {
    private Task() {
    }

    public static List<Animal> sortHeight(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> sortWeight(List<Animal> animalList, int count) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(count).toList();
    }

    public static Map<Animal.Type, Integer> howAnimals(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        Map<Animal.Type, Integer> animalMap = new HashMap<>();
        for (Animal animal : animalList) {
            if (animalMap.containsKey(animal.type())) {
                animalMap.put(animal.type(), animalMap.get(animal.type()) + 1);
            } else {
                animalMap.put(animal.type(), 1);
            }
        }
        return animalMap;
    }

    public static Animal longestName(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream().sorted(Comparator.comparing(animal -> animal.name().length())).toList().reversed()
            .get(0);
    }

    public static Animal.Sex maxSex(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        int countM = 0;
        int countF = 0;
        for (Animal animal : animalList) {
            if (animal.sex() == Animal.Sex.M) {
                ++countM;
            } else {
                ++countF;
            }
        }
        return countM > countF ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> mostWeightAnimal(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        Map<Animal.Type, Animal> animalMap = new HashMap<>();
        for (Animal animal : animalList) {
            Animal.Type type = animal.type();
            if (!animalMap.containsKey(type) || animal.weight() > animalMap.get(type).weight()) {
                animalMap.put(type, animal);
            }
        }

        return animalMap;
    }

    public static Animal oldestAnimal(List<Animal> animalList, int number) {
        if (number < 0 || animalList.isEmpty()) {
            return null;
        }
        return animalList.stream().sorted(Comparator.comparing(Animal::age)).toList().reversed().get(number - 1);
    }

    public static Optional<Animal> weightAndHeightAnimal(List<Animal> animalList, int size) {
        if (animalList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(animalList.stream().filter(Animal -> Animal.height() < size)
            .sorted(Comparator.comparing(Animal::weight)).toList().reversed().get(0));
    }

    public static Integer counterPaws(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        int counter = 0;
        for (Animal animal : animalList) {
            counter += animal.paws();
        }
        return counter;
    }

    public static List<Animal> pawsNotAge(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream().filter(Animal -> Animal.age() != Animal.paws()).toList();
    }

    public static List<Animal> bitesAndHeight(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream().filter(Animal -> Animal.height() > 100 && Animal.bites()).toList();
    }

    public static Integer weightMoreHeight(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        int counter = 0;
        for (Animal animal : animalList) {
            if (animal.weight() > animal.height()) {
                ++counter;
            }
        }
        return counter;
    }

    public static List<Animal> nameMoreTwoWord(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream().filter(Animal -> Animal.name().split(" ").length > 2).toList();
    }

    public static Boolean dogMoreHeight(List<Animal> animalList, int height) {
        if (animalList.isEmpty()) {
            return null;
        }
        for (Animal animal : animalList) {
            if (animal.type() == Animal.Type.DOG && animal.height() > height) {
                return true;
            }
        }
        return false;
    }

    public static Integer sumWeightAge(List<Animal> animalList, int age1, int age2) {
        if (animalList.isEmpty()) {
            return null;
        }
        int counter = 0;
        for (Animal animal : animalList) {
            if (animal.age() < age2 && animal.age() > age1) {
                counter += animal.weight();
            }
        }
        return counter;
    }

    public static List<Animal> fullSorted(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    public static Boolean spiderBitesMoreDog(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        int counterSpider = 0;
        int counterDog = 0;
        for (Animal animal : animalList) {
            if (animal.type() == Animal.Type.DOG && animal.bites()) {
                ++counterDog;
            } else if (animal.type() == Animal.Type.SPIDER && animal.bites()) {
                ++counterSpider;
            }
        }
        if (counterSpider == counterDog) {
            return false;
        }
        return counterSpider > counterDog;
    }

    public static Animal findHeavestFish(List<List<Animal>> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        Animal fish = null;
        int maxWeight = 0;
        for (List<Animal> list : animalList) {
            for (Animal animal : list) {
                if (animal.type() == Animal.Type.FISH) {
                    if (maxWeight < animal.weight()) {
                        maxWeight = animal.weight();
                        fish = animal;
                    }
                }
            }
        }
        return fish;
    }

    public static Map<String, String> findAnimalErrors(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        Map<String, String> animalErrorStrings = new LinkedHashMap<>();
        for (Animal animal : animalList) {
            Set<ValidationError> errors = new HashSet<>();
            if (animal.age() < 0 || animal.age() > 1000) {
                errors.add(ValidationError.INCORRECT_AGE);
            }
            if (animal.type() == null) {
                errors.add(ValidationError.INCORRECT_TYPE);
            }
            if (animal.name() == null) {
                errors.add(ValidationError.INCORRECT_NAME);
            }
            if (animal.weight() <= 0 || animal.weight() > 1000) {
                errors.add(ValidationError.INCORRECT_WEIGHT);
            }
            if (animal.height() <= 0 || animal.height() > 1000) {
                errors.add(ValidationError.INCORRECT_HEIGHT);
            }
            StringBuilder errorString = new StringBuilder();
            if (!errors.isEmpty()) {
                for (ValidationError error : errors) {
                    if (!errorString.isEmpty()) {
                        errorString.append(", ");
                    }
                    errorString.append(error.name());
                }
                animalErrorStrings.put(animal.name(), errorString.toString());
            } else {
                animalErrorStrings.put(animal.name(), "ALL_CLEAR");
            }
        }
        return animalErrorStrings;
    }

}
