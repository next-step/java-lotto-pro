package step2.validator;

public class NotNumberValidator implements Validator {

    @Override
    public boolean validate(String[] sources) {
        try {
            checkParseInt(sources);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void checkParseInt(String[] sources) {
        for (String source : sources) {
            Integer.parseInt(source);
        }
    }


}
