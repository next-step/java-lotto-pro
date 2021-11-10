package study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Numbers {

    private static final List<Number> numbers = new ArrayList<>();
    private static int result;

    public static void makeNumberGroup(String[] strings) {
        for(String string : strings) {
            numbers.add(new Number(string));
        }
    }

    public static int sumAllNumbers() {
        Iterator<Number> iterator = numbers.iterator();
        while(iterator.hasNext()) {
            result += iterator.next().getNumber();
        }
        return result;
    }

    public static void cleanUp() {
        numbers.clear();
        result = 0;
    }
}