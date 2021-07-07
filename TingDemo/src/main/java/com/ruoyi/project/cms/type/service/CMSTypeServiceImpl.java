package com.ruoyi.project.cms.type.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.cms.commom.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmhx335
 * @create 2021-07-05 17:04
 * @desc
 */
@Service
public class CMSTypeServiceImpl implements ICMSTypeService{

    @Autowired
    private CMSTypeMapper cmsTypeMapper;

    @Override
    public List<CMSType> selectCMSTypeList(CMSType type) {
        return cmsTypeMapper.selectCMSTypeList(type);
    }

    @Override
    public String checkTypeNameUnique(CMSType type) {
        // 当前可能是在修改公告类型，也可能在新增公告类型。 如果是修改，则需要判定主键。
        Long typeId = StringUtils.isNull(type.getTypeId()) ? -1L : type.getTypeId();
        CMSType info = cmsTypeMapper.checkTypeNameUnique(type.getTypeName());
        if (StringUtils.isNotNull(info) && info.getTypeId().longValue() != typeId.longValue())
        {
            return CMSTypeConst.TYPE_NAME_NOT_UNIQUE;
        }
        return CMSTypeConst.TYPE_NAME_UNIQUE;
    }

    @Override
    public int addCMSType(CMSType type) {
        // 将当前登录用户的登录名，赋值到createBy属性中。
        type.setCreateBy(ShiroUtils.getLoginName());

        return cmsTypeMapper.insertCMSType(type);
    }

    @Override
    public CMSType selectTypeById(Long typeId) {
        return cmsTypeMapper.selectTypeById(typeId);
    }


    @Override
    public int updateType(CMSType cmsType) {
        return cmsTypeMapper.updateType(cmsType);
    }

    @Override
    public int removeCMSTypeByIds(String ids) {
        Long[] typeIds = Convert.toLongArray(ids);
        return cmsTypeMapper.deleteCMSTypeByIds(typeIds);

    }

}

