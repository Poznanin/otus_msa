package arch.homework.webapp.controller;

import arch.homework.webapp.controller.dto.HealthResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class HealthController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    @ApiOperation(value = "Возвращает статус текущего приложения",
            notes = "В результате возвращается  {\"status\": \"OK\"} "
    )
    @ResponseStatus(OK)
    public ResponseEntity<HealthResult> getStatus(){
        return ResponseEntity.ok(new HealthResult());
    }

}
