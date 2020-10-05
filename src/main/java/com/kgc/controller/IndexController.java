package com.kgc.controller;

import com.kgc.pojo.Projectinfo;
import com.kgc.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 */
@Controller
public class IndexController {
    @Resource
    IndexService indexService;

    @RequestMapping("/")
    public String sel(Model model) {
        List<Projectinfo> selall = indexService.selall();
        model.addAttribute("list", selall);
        return "index";
    }

    @RequestMapping("/xia")
    public String sel(HttpServletRequest request, Model model) {
        Integer zt = Integer.parseInt(request.getParameter("zt"));
        if (zt == 3) {
            List<Projectinfo> selall = indexService.selall();
            model.addAttribute("list", selall);
        } else {
            List<Projectinfo> xiacha = indexService.xiacha(zt);
            model.addAttribute("list", xiacha);
        }
        return "index";
    }

    @RequestMapping("/toupd/{id}")
    public String toupd(@PathVariable Integer id, Model model, HttpSession session) {
        session.setAttribute("id", id);
        Projectinfo projectinfo = indexService.selById(id);
        model.addAttribute("project", projectinfo);
        return "upd";
    }

    @RequestMapping("/upd")
    public String upd(HttpSession session, Projectinfo projectinfo, Model model) {
        Integer id = (Integer) session.getAttribute("id");
        int upd = indexService.upd(projectinfo, id);
        if (upd > 0) {
            model.addAttribute("msg", "审核成功");
        } else {
            model.addAttribute("msg", "审核失败");
        }
        return "redirect:/";
    }
}
