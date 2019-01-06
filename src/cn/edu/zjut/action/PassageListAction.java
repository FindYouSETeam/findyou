package cn.edu.zjut.action;

import cn.edu.zjut.po.Passage;
import cn.edu.zjut.service.PassageListService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class PassageListAction extends ActionSupport {
    public List<Passage> getPassageList() {
        return passageList;
    }

    public void setPassageList(List<Passage> passageList) {
        this.passageList = passageList;
    }

    List<Passage> passageList;

    public String execute(){
        PassageListService passageListService = new PassageListService();
        passageList = passageListService.query();
/*
        passageList=new ArrayList<>();
        //try to get List
        Passage u=new Passage();
        u.setTitle("99%的人都不知道！外联赞助竟然应该这么拉！");

        passageList.add(u);
        u.setId(1);
        Passage v=new Passage();
        v.setTitle("难以置信！xx理工学院学生会迎新晚会竟然获得了数十万赞助！");
        passageList.add(v);
        Passage w=new Passage();
        w.setTitle("要想得到好赞助，外联应该知道的十条秘诀。");
        passageList.add(w);
*/
        HttpServletRequest request=ServletActionContext.getRequest();
        request.getSession().setAttribute("passageList",passageList);

        return "success";
    }
}
