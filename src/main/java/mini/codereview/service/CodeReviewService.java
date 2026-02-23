package mini.codereview.service;

import mini.codereview.response.CodeGenerationResponse;
import mini.codereview.response.CodeReviewResponse;

public interface CodeReviewService {

    CodeReviewResponse review(String code);

    CodeGenerationResponse codeGeneration(String text);

}
