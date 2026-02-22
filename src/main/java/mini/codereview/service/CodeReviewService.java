package mini.codereview.service;

import mini.codereview.response.CodeReviewResponse;

public interface CodeReviewService {

    CodeReviewResponse review(String code);

}
