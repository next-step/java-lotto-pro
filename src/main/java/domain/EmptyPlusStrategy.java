package domain;

public class EmptyPlusStrategy implements PlusStrategy {

    @Override
    public int result(String expressionStr) {
        return 0;
    }
}
