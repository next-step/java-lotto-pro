package camp.nextstep.edu.step3;

public enum IssuedMode {
    Auto("자동"), Manual("수동");

    final String mode;

    IssuedMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return mode;
    }
}
