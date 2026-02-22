package mini.codereview.response;

import lombok.Data;
import mini.codereview.dto.Choice;

import java.util.List;

@Data
public class OpenAIResponse {

    private List<Choice> choices;

}
