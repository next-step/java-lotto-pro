package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> List<T> shuffle(final List<T> list) {
        final List<T> copyList = new ArrayList<>(list);
        Collections.shuffle(copyList);
        return copyList;
    }

    public static <T> List<T> randomPickCount(final List<T> list, final int count) {
        return pickCount(shuffle(new ArrayList<>(list)), count);
    }

    public static <T> List<T> pickCount(final List<T> list, final int count) {
        return new ArrayList<>(list)
                .subList(0, count);
    }

    public static <T> List<T> sort(final List<T> list, Comparator<? super T> comparator) {
        final ArrayList<T> copyList = new ArrayList<>(list);
        copyList.sort(comparator);
        return copyList;
    }

    public static <T> List<T> distinct(final List<T> list) {
        return new ArrayList<>(list).stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
