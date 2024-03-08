package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.StorageException;
import com.huuluc.englearn.model.Media;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MediaMapper {
    @Select("SELECT media_id, media_name, media_type_id, url FROM media")
    List<Media> findAll();

    @Select("SELECT media_id, media_name, media_type_id, url FROM media WHERE media_id = #{mediaId}")
    Media findById(int mediaId);

    @Select("SELECT * FROM media WHERE media_name = #{mediaName}")
    Media findByName(String mediaName) throws StorageException;

    @Insert("INSERT INTO media (media_name, media_type_id, url) VALUES (#{mediaName}, #{mediaTypeId}, #{url})")
    int add(Media media) throws StorageException;
}
