package com.huuluc.englearn.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/v1/manage/question")
@Tag(name = "Admin Manage Question", description = "Admin Manage Question API")
public class AdminManageQuestionController {
}
