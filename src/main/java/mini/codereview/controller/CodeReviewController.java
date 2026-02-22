package mini.codereview.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mini.codereview.request.CodeReviewRequest;
import mini.codereview.response.CodeReviewResponse;
import mini.codereview.service.CodeReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CodeReviewController {

    private final CodeReviewService codeReviewService;

    @PostMapping("/review")
    @Operation(summary = "review", description = "review")
    public ResponseEntity<CodeReviewResponse> review(@Valid @RequestBody CodeReviewRequest request) {
        return new ResponseEntity<>(codeReviewService.review(request.getCode()), HttpStatus.OK);
    }

}