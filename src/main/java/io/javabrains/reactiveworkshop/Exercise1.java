package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream()
                .forEach(number -> System.out.println(number)); // .forEach(System.out::println);

        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(number -> System.out.println(number));

        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println(number));

        System.out.println(
                "Print the first number in intNumbersStream that's greater than 5.\nIf nothing is found, print -1");
        Integer result = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(result);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(user -> System.out.println(user));
        // .forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> id == user.getId()))
                .forEach(System.out::println);

//        StreamSources.intNumbersStream()
//                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
//                .map(user -> user.getFirstName())
//                .forEach(userName -> System.out.println(userName));
    }

}
