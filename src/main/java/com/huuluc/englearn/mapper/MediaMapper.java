package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.Media;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MediaMapper {
    @Select("SELECT media_id, media_name, media_type_id, url FROM media")
    List<Media> findAll();

    @Select("SELECT media_id, media_name, media_type_id, url FROM media WHERE media_id = #{mediaId}")
    Media findById(short mediaId);

    @Select("SELECT media_id, media_name, media_type_id, url FROM media WHERE media_name = #{mediaName}")
    Media findByName(String mediaName);
}
