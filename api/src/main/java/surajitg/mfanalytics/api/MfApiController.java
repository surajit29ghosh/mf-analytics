package surajitg.mfanalytics.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MfApiController {
    
    private final RestTemplate restTemplate;

    private String mfApiBaseUrl = "https://api.mfapi.in/mf";

    public MfApiController(RestTemplateBuilder rTemplateBuilder) {
        this.restTemplate = rTemplateBuilder.build();

    }

    @GetMapping("/mf/getall")
    public String GetAllFunds() {
        return this.restTemplate.getForObject(this.mfApiBaseUrl, String.class);
    }

    @GetMapping("/mf/fund/{fundId}")
    public String GetFund(@PathVariable("fundId") String fundId) {
        return this.restTemplate.getForObject(this.mfApiBaseUrl + "/" + fundId, String.class);
    }

    
}
