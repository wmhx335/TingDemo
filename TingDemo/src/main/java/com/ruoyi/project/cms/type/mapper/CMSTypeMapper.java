package com.ruoyi.project.cms.type.mapper;

import com.ruoyi.project.cms.type.domain.CMSType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CMSTypeMapper {
    List<CMSType> selectCMSTypeList(CMSType type);

    CMSType checkTypeNameUnique(String typeName);

    int insertCMSType(CMSType type);

    CMSType selectTypeById(Long typeId);

    int updateType(CMSType cmsType);

    int deleteCMSTypeByIds(@Param("typeIds")Long[] typeIds);
}
