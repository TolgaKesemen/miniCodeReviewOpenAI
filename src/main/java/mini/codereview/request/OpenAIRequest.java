package mini.codereview.request;

import lombok.Data;
import mini.codereview.dto.Message;

import java.util.List;

@Data
public class OpenAIRequest {

    private final String model;
    private final List<Message> messages;
    private final double temperature;

}
