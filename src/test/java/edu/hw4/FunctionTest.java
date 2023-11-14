package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static edu.hw4.Task.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FunctionTest {
    @Test
    void test1() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 1, 10, 1, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 20, 1, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 1, 6, 1, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer =
            "[Animal[name=c, type=SPIDER, sex=F, age=1, height=1, weight=1, bites=true], Animal[name=d, type=DOG, sex=M, age=1, height=6, weight=1, bites=true], Animal[name=a, type=DOG, sex=F, age=1, height=10, weight=1, bites=true], Animal[name=b, type=CAT, sex=F, age=1, height=20, weight=1, bites=true]]";
        assertThat(answer).isEqualTo(sortHeight(animalList).toString());
    }

    @Test
    void test2() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 1, 1, 10, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 1, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 1, 1, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer =
            "[Animal[name=b, type=CAT, sex=F, age=1, height=1, weight=20, bites=true], Animal[name=a, type=DOG, sex=F, age=1, height=1, weight=10, bites=true]]";
        assertThat(answer).isEqualTo(sortWeight(animalList, 2).toString());
    }

    @Test
    void test3() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 1, 1, 10, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 1, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 1, 1, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        Map<Animal.Type, Integer> expected = new LinkedHashMap<>();
        expected.put(Animal.Type.CAT, 1);
        expected.put(Animal.Type.DOG, 2);
        expected.put(Animal.Type.SPIDER, 1);
        assertThat(expected).isEqualTo(howAnimals(animalList));
    }

    @Test
    void test4() {
        Animal a = new Animal("aaa", Animal.Type.DOG, Animal.Sex.F, 1, 1, 10, true);
        Animal b = new Animal("bb", Animal.Type.CAT, Animal.Sex.F, 1, 1, 20, true);
        Animal c = new Animal("cccc", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true);
        Animal d = new Animal("ddddd", Animal.Type.DOG, Animal.Sex.M, 1, 1, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer = "ddddd";
        assertThat(answer).isEqualTo(longestName(animalList).name());
    }

    @Test
    void test5() {
        Animal a = new Animal("aaa", Animal.Type.DOG, Animal.Sex.F, 1, 1, 10, true);
        Animal b = new Animal("bb", Animal.Type.CAT, Animal.Sex.F, 1, 1, 20, true);
        Animal c = new Animal("cccc", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true);
        Animal d = new Animal("ddddd", Animal.Type.DOG, Animal.Sex.M, 1, 1, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer = "F";
        assertThat(answer).isEqualTo(maxSex(animalList).toString());
    }

    @Test
    void test6() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 1, 1, 10, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 1, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 1, 1, 6, true);
        Animal e = new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 6, true);
        Animal f = new Animal("f", Animal.Type.CAT, Animal.Sex.M, 1, 1, 80, true);
        List<Animal> animalList = List.of(a, b, c, d, e, f);
        Map<Animal.Type, Animal> expected = new LinkedHashMap<>();
        expected.put(Animal.Type.SPIDER, e);
        expected.put(Animal.Type.CAT, f);
        expected.put(Animal.Type.DOG, a);
        assertThat(mostWeightAnimal(animalList)).isEqualTo(expected);
    }

    @Test
    void test7() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 119, 1, 10, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 1, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 10, 1, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 13, 1, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer = "c";
        assertThat(answer).isEqualTo(oldestAnimal(animalList, 3).name());
    }

    @Test
    void test8() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 119, 15, 10, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 25, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 10, 12, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 13, 14, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer = "Optional[Animal[name=a, type=DOG, sex=F, age=119, height=15, weight=10, bites=true]]";
        assertThat(answer).isEqualTo(weightAndHeightAnimal(animalList, 19).toString());
    }

    @Test
    void test9() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 119, 15, 10, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 25, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 10, 12, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 13, 14, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        int answer = 20;
        assertThat(answer).isEqualTo(counterPaws(animalList));
    }

    @Test
    void test10() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 19, 15, 10, true);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 25, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 12, 1, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 4, 14, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer =
            "[Animal[name=a, type=DOG, sex=F, age=19, height=15, weight=10, bites=true], Animal[name=b, type=CAT, sex=F, age=1, height=25, weight=20, bites=true]]";
        assertThat(answer).isEqualTo(pawsNotAge(animalList).toString());
    }

    @Test
    void test11() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 20, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 1, false);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 4, 120, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer = "[Animal[name=d, type=DOG, sex=M, age=4, height=120, weight=6, bites=true]]";
        assertThat(answer).isEqualTo(bitesAndHeight(animalList).toString());
    }

    @Test
    void test12() {
        Animal a = new Animal("a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 4, 120, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        int answer = 2;
        assertThat(answer).isEqualTo(weightMoreHeight(animalList));
    }

    @Test
    void test13() {
        Animal a = new Animal("a a a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 4, 120, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer = "[Animal[name=a a a, type=DOG, sex=F, age=19, height=101, weight=10, bites=false]]";
        assertThat(answer).isEqualTo(nameMoreTwoWord(animalList).toString());
    }

    @Test
    void test14() {
        Animal a = new Animal("a a a", Animal.Type.DOG, Animal.Sex.F, 19, 15, 10, false);
        Animal b = new Animal("b b", Animal.Type.CAT, Animal.Sex.F, 1, 44, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 4, 4, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        Boolean answer = false;
        assertThat(answer).isEqualTo(dogMoreHeight(animalList, 20));
    }

    @Test
    void test15() {
        Animal a = new Animal("a a a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 7, 120, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        int answer = 156;
        assertThat(answer).isEqualTo(sumWeightAge(animalList, 5, 15));
    }

    @Test
    void test16() {
        Animal a = new Animal("a a a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 7, 120, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        int answer = 156;
        assertThat(answer).isEqualTo(sumWeightAge(animalList, 5, 15));
    }

    @Test
    void test17_1() {
        Animal a = new Animal("a a a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 7, 120, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        Boolean answer = false;
        assertThat(answer).isEqualTo(spiderBitesMoreDog(animalList));
    }

    @Test
    void test17_2() {
        Animal a = new Animal("a a a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, true);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 7, 120, 6, false);
        List<Animal> animalList = List.of(a, b, c, d);
        Boolean answer = true;
        assertThat(answer).isEqualTo(spiderBitesMoreDog(animalList));
    }

    @Test
    void test17_3() {
        Animal a = new Animal("a a a", Animal.Type.DOG, Animal.Sex.F, 19, 101, 10, false);
        Animal b = new Animal("b b", Animal.Type.CAT, Animal.Sex.F, 1, 100, 200, true);
        Animal c = new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d = new Animal("d", Animal.Type.DOG, Animal.Sex.M, 7, 120, 6, false);
        List<Animal> animalList = List.of(a, b, c, d);
        Boolean answer = false;
        assertThat(answer).isEqualTo(spiderBitesMoreDog(animalList));
    }

    @Test
    void test18() {
        Animal a = new Animal("Dori", Animal.Type.FISH, Animal.Sex.F, 19, 32, 10, false);
        Animal b = new Animal("Nemo", Animal.Type.CAT, Animal.Sex.F, 1, 11, 200, true);
        Animal c = new Animal("Venom", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d = new Animal("Scooby", Animal.Type.DOG, Animal.Sex.M, 7, 120, 6, true);
        List<Animal> animalList = List.of(a, b, c, d);
        Animal a2 = new Animal("Oscar", Animal.Type.FISH, Animal.Sex.F, 19, 101, 10, false);
        Animal b2 = new Animal("Lola", Animal.Type.CAT, Animal.Sex.F, 1, 55, 200, true);
        Animal c2 = new Animal("Man", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, 150, false);
        Animal d2 = new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 7, 120, 6, true);
        List<Animal> animalList1 = List.of(a2, b2, c2, d2);
        List<List<Animal>> animalLists = new ArrayList<>();
        animalLists.add(animalList1);
        animalLists.add(animalList);
        assertThat(a2).isEqualTo(findHeavestFish(animalLists));
    }

    @Test
    void test19() {
        Animal a = new Animal("Dori", Animal.Type.FISH, Animal.Sex.F, -5, 32, 10, false);
        Animal b = new Animal("Nemo", null, Animal.Sex.F, 1, 11, 20, true);
        Animal c = new Animal("Venom", Animal.Type.SPIDER, Animal.Sex.F, 8, 123, -150, false);
        Animal d = new Animal("Scooby", Animal.Type.DOG, Animal.Sex.M, 7, 120, 4, true);
        List<Animal> animalList = List.of(a, b, c, d);
        String answer = "{Dori=INCORRECT_AGE, Nemo=INCORRECT_TYPE, Venom=INCORRECT_WEIGHT, Scooby=ALL_CLEAR}";
        assertThat(answer).isEqualTo(findAnimalErrors(animalList).toString());
    }
}
