package Lambda_Expressions;

import java.util.function.UnaryOperator;

/**
 * Created by Dmitriy Yevtushenko on 20.06.2019.
 */
class Lambda {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // 25
    }
}

