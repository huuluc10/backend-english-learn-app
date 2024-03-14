package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question WHERE question_id = #{questionId}")
    List<Question> findById(short questionId) throws QuestionException;

    @Select("SELECT * FROM question WHERE lesson_id = #{lessonId} AND belong_to = 'LESSON'")
    List<Question> findByLessonId(short lessonId) throws QuestionException;

    @Select("SELECT * FROM question WHERE exam_id = #{examId} AND belong_to = 'EXAM'")
    List<Question> findByExamId(short examId) throws QuestionException;
}
