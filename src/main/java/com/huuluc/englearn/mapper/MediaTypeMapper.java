package com.huuluc.englearn.mapper;

import com.huuluc.englearn.model.MediaType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MediaTypeMapper {
    @Select("SELECT media_type_id, media_type_name FROM media_type")
    List<MediaType> findAll();

    @Select("SELECT media_type_id, media_type_name FROM media_type WHERE media_type_id = #{mediaTypeId}")
    MediaType findById(short mediaTypeId);

    @Select("SELECT media_type_id, media_type_name FROM media_type WHERE media_type_name = #{mediaTypeName}")
    MediaType findByName(String mediaTypeName);

}
