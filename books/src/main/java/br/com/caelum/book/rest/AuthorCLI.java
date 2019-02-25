package br.com.caelum.book.rest;

import br.com.caelum.book.rest.response.AuthorResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthorCLI {
    private final RestTemplate rest;
    private final String ENDPOINT = "http://authors/{id}";

    public AuthorCLI(RestTemplate rest) {
        this.rest = rest;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public AuthorResponse findById(Long id) {
        return rest.getForObject(ENDPOINT, AuthorResponse.class, id);
    }

    public AuthorResponse fallback(Long id) {

        try {
            return rest.getForObject(ENDPOINT, AuthorResponse.class, id);
        } catch (Exception e) {
            AuthorResponse authorResponse = new AuthorResponse();
            authorResponse.setName("Unknown");

            return authorResponse;
        }
    }
}
