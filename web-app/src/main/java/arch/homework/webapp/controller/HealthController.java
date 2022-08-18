package arch.homework.webapp.controller;

import arch.homework.webapp.controller.dto.HealthResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class HealthController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    @ResponseStatus(OK)
    public ResponseEntity<HealthResult> getStatus() {
        return ResponseEntity.ok(new HealthResult());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(OK)
    public ResponseEntity<HealthResult> getStatusFromRoot() {
        return ResponseEntity.ok(new HealthResult("Root-OK"));
    }
}
