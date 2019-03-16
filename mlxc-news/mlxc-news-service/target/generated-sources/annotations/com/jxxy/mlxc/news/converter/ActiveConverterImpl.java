package com.jxxy.mlxc.news.converter;

import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.model.ActiveDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-04T19:41:14+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class ActiveConverterImpl implements ActiveConverter {

    @Override
    public ActiveDO fromActiveDto(ActiveDto dto) {
        if ( dto == null ) {
            return null;
        }

        ActiveDO activeDO = new ActiveDO();

        activeDO.setId( dto.getId() );
        activeDO.setCreateTime( dto.getCreateTime() );
        activeDO.setUpdateTime( dto.getUpdateTime() );
        activeDO.setActiveName( dto.getActiveName() );
        activeDO.setPlace( dto.getPlace() );
        activeDO.setTime( dto.getTime() );
        activeDO.setIntro( dto.getIntro() );
        activeDO.setPlotter( dto.getPlotter() );
        activeDO.setDecription( dto.getDecription() );
        activeDO.setFilePath( dto.getFilePath() );
        activeDO.setCreateUserId( dto.getCreateUserId() );
        activeDO.setIsCall( dto.getIsCall() );

        return activeDO;
    }
}
