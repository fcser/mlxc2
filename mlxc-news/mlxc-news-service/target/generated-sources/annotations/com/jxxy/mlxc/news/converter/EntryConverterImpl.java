package com.jxxy.mlxc.news.converter;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.jxxy.mlxc.news.api.dto.EntryDto;
import com.jxxy.mlxc.news.api.model.EntryDO;
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-25T15:03:00+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class EntryConverterImpl implements EntryConverter {

    @Override
    public EntryDO fromEntryDto(EntryDto dto) {
        if ( dto == null ) {
            return null;
        }

        EntryDO entryDO = new EntryDO();

        entryDO.setId( dto.getId() );
        entryDO.setCreateTime( dto.getCreateTime() );
        entryDO.setUpdateTime( dto.getUpdateTime() );
        entryDO.setEntryUserId( dto.getEntryUserId() );
        entryDO.setActiveId( dto.getActiveId() );
        entryDO.setDecription( dto.getDecription() );

        return entryDO;
    }
}
