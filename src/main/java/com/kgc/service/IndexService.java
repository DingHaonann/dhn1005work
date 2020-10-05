package com.kgc.service;

import com.kgc.pojo.Projectinfo;

import java.util.List;

/**
 * @author shkstart
 */
public interface IndexService {
    List<Projectinfo> selall();
    List<Projectinfo> xiacha(Integer zt);
    Projectinfo selById(Integer id);
    int upd(Projectinfo projectinfo,Integer id);
}
