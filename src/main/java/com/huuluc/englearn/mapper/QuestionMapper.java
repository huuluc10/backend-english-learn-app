package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question WHERE question_id = #{questionId}")
    public List<Question> findById(short questionId);

    @Select("SELECT * FROM question WHERE lesson_id = #{lessonId} AND belong_to = 'LESSON'")
    public List<Question> findByLessonId(short lessonId);

    @Select("SELECT * FROM question WHERE exam_id = #{exam_id} AND belong_to = 'EXAM'")
    public List<Question> findByExamId(short exam_id);
}
