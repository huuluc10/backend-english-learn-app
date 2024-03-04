package com.huuluc.englearn.controller;

import com.huuluc.englearn.entity.Lesson;
import com.huuluc.englearn.service.LessonService;
import com.huuluc.englearn.service.impl.LessonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/")
    public List<Lesson> findAll() {
        return lessonService.findAll();
    }

    @GetMapping("/{lessonId}")
    public Lesson findById(@PathVariable short lessonId) {
        return lessonService.findById(lessonId);
    }

    @GetMapping("/topic/{topicId}")
    public List<Lesson> findByTopicId(@PathVariable short topicId) {
        return lessonService.findByTopicId(topicId);
    }
}
