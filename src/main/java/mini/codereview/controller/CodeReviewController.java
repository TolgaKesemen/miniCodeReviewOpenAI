package mini.codereview.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mini.codereview.request.CodeGenerationRequest;
import mini.codereview.request.CodeReviewRequest;
import mini.codereview.service.CodeReviewService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CodeReviewController {

    private final CodeReviewService codeReviewService;

    @PostMapping(value = "/review", produces = MediaType.TEXT_PLAIN_VALUE)
    @Operation(summary = "review", description = "review")
    public String review(@Valid @RequestBody CodeReviewRequest request) {
        return codeReviewService.review(request.getCode()).getReview();
    }

    @PostMapping(value = "/codeGeneration", produces = MediaType.TEXT_PLAIN_VALUE)
    @Operation(summary = "codeGeneration", description = "codeGeneration")
    public String codeGeneration(@Valid @RequestBody CodeGenerationRequest request) {
        return codeReviewService.codeGeneration(request.getText()).getCode();
    }

}