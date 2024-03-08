package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.MediaTypeException;
import com.huuluc.englearn.model.MediaType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MediaTypeMapper {
    @Select("SELECT media_type_id, media_type_name FROM media_type")
    List<MediaType> findAll() throws MediaTypeException;

    @Select("SELECT media_type_id, media_type_name FROM media_type WHERE media_type_id = #{mediaTypeId}")
    MediaType findById(short mediaTypeId)  throws MediaTypeException;

    @Select("SELECT media_type_id, media_type_name FROM media_type WHERE media_type_name = #{mediaTypeName}")
    MediaType findByName(String mediaTypeName) throws MediaTypeException;

}
