package hr.rasus.microservice.aggregator;

import hr.rasus.microservice.aggregator.model.HumidityRepresentation;
import hr.rasus.microservice.aggregator.model.TemperatureRepresentation;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateImplementation {

    //private String baseURL;
    private RestTemplate restTemplate;

    public RestTemplateImplementation() {

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(new MappingJackson2HttpMessageConverter());
    }


    public TemperatureRepresentation getTemperatureRepresentation(String temperatureUri) {
        return restTemplate.getForObject(temperatureUri + "/current-reading", TemperatureRepresentation.class);
    }

    public HumidityRepresentation getHumidityRepresentation(String humidityUri) {
        return restTemplate.getForObject(humidityUri + "/current-reading", HumidityRepresentation.class);
    }
}
