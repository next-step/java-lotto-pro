package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

public class SplitStrings {

    public static final SplitStrings EMPTY = new SplitStrings(emptyList());

    private final List<String> splitStrings;

    public SplitStrings(List<String> splitStrings) {
        this.splitStrings = splitStrings;
    }

    public SplitStrings(String[] splitStrings) {
        this(Arrays.asList(splitStrings));
    }

    public static SplitStrings of(String ...strings) {
        return new SplitStrings(strings);
    }


    public Stream<String> stream() {
        return splitStrings.stream();
    }

    public boolean isEmpty() {
        return splitStrings.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SplitStrings that = (SplitStrings) o;

        return splitStrings.equals(that.splitStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(splitStrings);
    }
}
