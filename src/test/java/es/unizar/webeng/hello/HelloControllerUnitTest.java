package es.unizar.webeng.hello;

/**
 * Performs unit test to the Wellcome JSP template
 *
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerUnitTest {

    @Value("${app.message:Press F5 to roll the dice}")
    private String message;

    @Autowired
    private HelloController controller;

    /**
     * Testing doesn't make much sense in this web service, but we'll do a dumb test
     */

    /**
     * Performs static unit content test to the
     * main JSP template wellcome (message)
     * <p>
     * This function tests whether the welcome function sets the message info and the message is correct
     */
    @Test
    public void testMessage() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        controller.rollTheDice(map);
        assertTrue(map.containsKey("dice"));
        assertTrue(map.containsKey("message"));
        assertTrue(map.containsKey("host"));
        assertTrue(map.containsKey("ip"));
        assertTrue(map.containsKey("java"));
        assertEquals(map.get("message"), message);
    }

    /**
     * Test for the message returned when calling the welcomeName function.
     * <p>
     * This function tests whether the welcomeName function sets the message info 
     *  and the message corresponds with the name sent to the function
     */
    @Test
    public void testName() throws Exception {
        String name = "user";
        HashMap<String, Object> map = new HashMap<>();
        String view = controller.welcomeName(map, name);
        assertThat(view, is("wellcome"));

        assertThat(map.containsKey("message"), is(true));
        assertThat(map.get("message"), is("Hola " + name));
    }
}
