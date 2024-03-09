package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.UserLessonException;
import com.huuluc.englearn.model.UserLesson;
import com.huuluc.englearn.mapper.UserLessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserLessonRepository {
    private final UserLessonMapper userLessonMapper;
    public int insert(UserLesson userLesson) throws UserLessonException {
        return userLessonMapper.insert(userLesson);
    }

    public int countLessonLearnedToday(String username) throws UserLessonException {
        return userLessonMapper.countLessonLearnedToday(username);
    }
}
