package SpringBootSwaggerIntegrator.com.example.SpringSwaggerIntegration;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankIDController {


    //<---This is API Related(Swagger)--->
    @Operation(summary = "Get example data", description = "This method returns example data.")
    //<---This is API Related(Swagger)--->
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @Autowired
    private BankIDService bankIDService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody String userData) {
        return bankIDService.authenticate(userData);
    }

    @GetMapping("/status")
    public String checkStatus(@RequestParam String orderId) {
        return bankIDService.checkStatus(orderId);
    }
    /*Testing Flow:

    Make a request to Spring Boot application using http://localhost:8080/authenticate.
    Your Spring Boot application will then send a request to the actual BankID API using the base URL
    (https://appapi2.bankid.com/rp/v5) configured in application.properties.

    The response will be returned to your application, which will then relay the appropriate
    response to you.
*/
}

