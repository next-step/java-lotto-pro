package converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntegerListConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && List.class.isAssignableFrom(targetType)) {
            String[] numberStrings = ((String) source).split(",");
            return stringsToIntegerList(numberStrings);
        }
        throw new IllegalArgumentException("테스트 값이 올바르지 않습니다.");
    }

    private List<Integer> stringsToIntegerList(String[] strs){
        return Arrays.stream(strs).map((str)->Integer.parseInt(str)).collect(Collectors.toList());
    }
}
