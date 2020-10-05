package com.kgc.service.impl;

import com.kgc.mapper.ProjectinfoMapper;
import com.kgc.pojo.Projectinfo;
import com.kgc.pojo.ProjectinfoExample;
import com.kgc.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {
    @Resource
    ProjectinfoMapper projectinfoMapper;

    @Override
    public List<Projectinfo> selall() {
        return projectinfoMapper.selectByExample(null);
    }

    @Override
    public List<Projectinfo> xiacha(Integer zt) {
        ProjectinfoExample example = new ProjectinfoExample();
        ProjectinfoExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(zt);
        return projectinfoMapper.selectByExample(example);
    }

    @Override
    public Projectinfo selById(Integer id) {
        return projectinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int upd(Projectinfo projectinfo, Integer id) {
        ProjectinfoExample example = new ProjectinfoExample();
        ProjectinfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return projectinfoMapper.updateByExampleSelective(projectinfo,example);
    }
}
