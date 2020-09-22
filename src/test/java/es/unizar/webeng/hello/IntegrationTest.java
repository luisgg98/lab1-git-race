
package es.unizar.webeng.hello;

/**
 * Performs integration test for webpage
 *
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext
public class IntegrationTest {

    @LocalServerPort
    private int port = 0;

    /**
     * Performs integration test for main webpage
     * <p>
     * This function checks that the request gives an OK response and
     *  if the response is correct(Contains the "<title>Hello" that is part of the template)
     */
    @Test
    public void testHome() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port, String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue("Wrong body (title doesn't match):\n" + entity.getBody(), entity
                .getBody().contains("<title>Hello"));
    }

    /**
     * Performs integration test for CSS
     * <p>
     * This function checks that the response status is Ok and
     *  there is a body whose media type equals "text/css"
     */
    @Test
    public void testCss() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port
                        + "/webjars/bootstrap/3.3.5/css/bootstrap.min.css", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue("Wrong body:\n" + entity.getBody(), entity.getBody().contains("body"));
        assertEquals("Wrong content type:\n" + entity.getHeaders().getContentType(),
                MediaType.valueOf("text/css"), entity.getHeaders()
                        .getContentType());
    }


}
