package daou.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args){
        //https://velog.io/@kskim/Java-Stream-API

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println(list.stream().count());
        System.out.println();
        //

        Arrays.asList("1234", "123","12","21" ,"12345", "123")
                .stream()
                .peek(System.out::println)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println();

        Stream<String> streamOne = Arrays.asList("Hello", "World", "Test", "array", "What").stream();
        Stream<String> streamTwo = Arrays.asList("The", "Hell").stream();
        Stream.concat(streamOne, streamTwo)
                .forEach(System.out::println);

        System.out.println();

        IntStream.of(1, 2, 3, 4, 5)
                .findAny()
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println(Arrays.asList("1234", "123","12","21" ,"12345", "123")
                .stream()
                .anyMatch(it -> it.contains("1")));


    }
}
