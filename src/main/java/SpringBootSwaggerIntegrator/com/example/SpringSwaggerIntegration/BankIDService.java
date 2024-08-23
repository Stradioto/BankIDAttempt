package SpringBootSwaggerIntegrator.com.example.SpringSwaggerIntegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankIDService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bankid.api.base-url}")
    private String baseUrl;

    @Value("${bankid.api.auth-endpoint}")
    private String authEndpoint;

    @Value("${bankid.api.sign-endpoint}")
    private String signEndpoint;

    @Value("${bankid.api.collect-endpoint}")
    private String collectEndpoint;

    @Value("${bankid.api.cancel-endpoint}")
    private String cancelEndpoint;

    public String authenticate(String userData) {
        // POST request to authenticate
        String url = baseUrl + authEndpoint;
        return restTemplate.postForObject(url, userData, String.class);
    }

    public String checkStatus(String orderId) {
        // GET request to check the status
        String url = baseUrl + collectEndpoint + "?orderRef=" + orderId;
        return restTemplate.getForObject(url, String.class);
    }

    // Additional methods for sign and cancel can be implemented similarly
}
