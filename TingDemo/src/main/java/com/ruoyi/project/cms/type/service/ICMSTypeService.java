package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

import java.util.List;

public interface ICMSTypeService {
    List<CMSType> selectCMSTypeList(CMSType type);

    // 验证
    String checkTypeNameUnique(CMSType type);

    //添加
    int addCMSType(CMSType type);

    //根据类型编号查找类型公告对象
    CMSType selectTypeById(Long typeId);

    int updateType(CMSType cmsType);

    int removeCMSTypeByIds(String ids);
}
