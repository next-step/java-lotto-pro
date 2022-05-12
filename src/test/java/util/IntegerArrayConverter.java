package util;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;


public class IntegerArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && Integer[].class.isAssignableFrom(targetType)) {
            String[] split = ((String) source).split("\\s*#\\s*");
            Integer[] numbers = new Integer[split.length];
            for (int i = 0; i < split.length; i++) {
                numbers[i] = Integer.valueOf(split[i]);
            }
            return numbers;
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}
