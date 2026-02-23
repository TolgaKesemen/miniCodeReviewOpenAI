package mini.codereview.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CodeGenerationRequest {

    @NotBlank(message = "explanation text is required")
    private String text;

}
