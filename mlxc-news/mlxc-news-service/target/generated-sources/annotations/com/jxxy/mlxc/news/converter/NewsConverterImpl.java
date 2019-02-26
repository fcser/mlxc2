package com.jxxy.mlxc.news.converter;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-25T15:02:59+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class NewsConverterImpl implements NewsConverter {

    @Override
    public NewsDO fromNewsDto(NewsDto dto) {
        if ( dto == null ) {
            return null;
        }

        NewsDO newsDO = new NewsDO();

        newsDO.setId( dto.getId() );
        newsDO.setTitle( dto.getTitle() );
        newsDO.setContent( dto.getContent() );
        newsDO.setIntro( dto.getIntro() );
        newsDO.setCreateTime( dto.getCreateTime() );
        newsDO.setUpdateTime( dto.getUpdateTime() );
        newsDO.setCreateUserId( dto.getCreateUserId() );
        newsDO.setUpdateUserId( dto.getUpdateUserId() );
        newsDO.setActiveId( dto.getActiveId() );
        newsDO.setGrade( dto.getGrade() );
        newsDO.setType( dto.getType() );

        return newsDO;
    }
}
