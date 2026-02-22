package mini.codereview.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CodeReviewRequest {

    @NotBlank(message = "code text is required")
    private String code;

}
