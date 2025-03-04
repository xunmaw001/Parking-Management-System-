package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ShangbaoDao;
import com.entity.ShangbaoEntity;
import com.entity.view.ShangbaoView;
import com.service.ShangbaoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 上报 服务实现类
 */
@Service("shangbaoService")
@Transactional
public class ShangbaoServiceImpl extends ServiceImpl<ShangbaoDao, ShangbaoEntity> implements ShangbaoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShangbaoView> page =new Query<ShangbaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
