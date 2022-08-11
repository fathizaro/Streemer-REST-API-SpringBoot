package zaru.fathi.APIREST.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record LiveStream(

        String id,
        @NotEmpty
        String title,
        String description,
        String url, LocalDateTime startDate,
        LocalDateTime endDate) {


}
