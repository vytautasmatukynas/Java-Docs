import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/samples")
public class SampleController {

    SampleService<Book> sampleService;

    public SampleController(SampleService<Book> sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/getall")
    public List<Sample> getAll() {
        List<Sample> samples = sampleService.getAll();

        if (samples == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Error occurred when fetching Samples data.");

        return samples;
    }

}
