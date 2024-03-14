package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.Media;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MediaMapper {
    @Select("SELECT media_id, media_name, media_type_id, url FROM media")
    List<Media> findAll() throws MediaException;

    @Select("SELECT media_id, media_name, media_type_id, url FROM media WHERE media_id = #{mediaId}")
    Media findById(int mediaId)  throws MediaException;

    @Select("SELECT * FROM media WHERE media_name = #{mediaName}")
    Media findByName(String mediaName) throws MediaException;

    @Insert("INSERT INTO media (media_name, media_type_id, url) VALUES (#{mediaName}, #{mediaTypeId}, #{url})")
    int add(Media media) throws MediaException;
}
