package step2.validator;

public class PositiveNumberValidator implements Validator {

    @Override
    public boolean validate(String[] sources) {
        return parseIntFromStrings(sources);
    }

    private boolean parseIntFromStrings(String[] sources) {
        boolean validateResult = true;
        for (int i = 0; i < sources.length && validateResult; i++) {
            validateResult = Integer.parseInt(sources[i]) >= 0;
        }
        return validateResult;
    }
}
