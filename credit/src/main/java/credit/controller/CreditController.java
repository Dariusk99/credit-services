package credit.controller;

import credit.model.*;
import credit.service.CreditServiceImpl;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CreditController {

    private final CreditServiceImpl creditService;
    private final RestTemplate restTemplate;
    private final String productApi = "http://product:9595/products";
    private final String customerApi = "http://customer:9696/customers";
    private final HttpHeaders headers = new HttpHeaders();

    public CreditController(CreditServiceImpl creditService, RestTemplate restTemplate) {
        this.creditService = creditService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/credits")
    public void CreateCredit(@RequestBody EntityWrapper entityWrapper) {
        Credit credit = entityWrapper.getCredit();
        Product product = entityWrapper.getProduct();
        Customer customer = entityWrapper.getCustomer();

        credit.setID(creditService.generateID());
        product.setCreditID(credit.getID());
        customer.setCreditID(credit.getID());


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(product, headers);
        ResponseEntity productResponse = restTemplate.exchange(productApi, HttpMethod.POST, productHttpEntity, String.class);

        if (productResponse.getStatusCode() == HttpStatus.OK) {

            HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(customer, headers);
            ResponseEntity customerResponse = restTemplate.exchange(customerApi, HttpMethod.POST, customerHttpEntity, String.class);

            if (customerResponse.getStatusCode() == HttpStatus.OK) {
                creditService.addCredit(credit);
            }
        }
    }

    @GetMapping("/credits")
    public List<Integer> GetCredits() {
        List<Credit> listCredit = creditService.getAll();
        List<Integer> listID = listCredit.stream().map(Credit::getID).collect(Collectors.toList());
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<List<Integer>> listIDEntity = new HttpEntity<>(listID, headers);

        restTemplate.exchange(customerApi, HttpMethod.GET, listIDEntity, String.class);
        return null;
    }
}

