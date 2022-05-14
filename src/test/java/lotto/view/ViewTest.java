package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class ViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    protected void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    protected void tearDown() {
        System.setOut(standardOut);
    }

    protected final String output() {
        return outputStreamCaptor.toString().trim();
    }
}
