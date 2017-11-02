import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingServiceTest {

    @Test
    public void it_greets_people() {
        GreetingService service = new GreetingService();

        String message = service.greet("Ivo");

        assertEquals("Hello Ivo!", message);
    }

    @Test
    public void name_should_be_present() {
        GreetingService service = new GreetingService();

        String message = service.greet("");

        assertEquals("Hey! Who are you?", message);
    }
}
