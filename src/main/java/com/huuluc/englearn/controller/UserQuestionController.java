package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.UserQuestionException;
import com.huuluc.englearn.model.request.AnswerQuestionRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.UserQuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-question")
@Tag(name = "User Question", description = "User Question API")
public class UserQuestionController {
    private final UserQuestionService userQuestionService;

    @PostMapping("/")
    @Operation(summary = "Save user answer")
    public ResponseEntity<ResponseModel> saveUserAnswer(AnswerQuestionRequest request) throws UserQuestionException {
        return userQuestionService.answerQuestion(request);
    }
}
