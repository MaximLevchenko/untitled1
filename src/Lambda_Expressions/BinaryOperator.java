package Lambda_Expressions;

import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/**
 * Created by Dmitriy Yevtushenko on 20.06.2019.
 */

class LambdaaApp {
    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20
    }

}

class LambdaaaApp {
    public static void main(String[] args) {
        Supplier<User> userFactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };
        User user1 = userFactory.get();
        User user2 = userFactory.get();
        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
    }
}

class User extends Employee {
    private String name;

    User(String n) {
        this.name = n;
    }

    String getName() {
        return name;
    }

    static void createManyUsers(int size, Supplier<? extends Employee> s) {
        for (int i = 0; i < size; i++) {
            s.get();
            System.out.println(s.get());
        }

    }
}

