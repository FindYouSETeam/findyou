package cn.edu.zjut.action;

import cn.edu.zjut.po.Passage;
import cn.edu.zjut.service.PassageService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PassageAction extends ActionSupport {
    Passage now;
    long id;

    public Passage getNow() {
        return now;
    }

    public void setNow(Passage now) {
        this.now = now;
    }

    void init(){
        /*

        final String title = "99%的人都不知道！外联赞助竟然应该这么拉！";
        now=new Passage();
        now.setTitle(title);
*/
        final String position="/passage/"+id+".txt";
        PassageService passageService = new PassageService();
        now=(Passage) passageService.query(id);
        // Read from file
        HttpServletRequest request=ServletActionContext.getRequest();
        try{
            String text= new String();
            String encoding = "UTF-8";

            File file = new File(request.getRealPath("/")+position);
            if (file.isFile()&&file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt=null;
                while((lineTxt=bufferedReader.readLine())!=null){
                    System.out.println(lineTxt);
                    text+=lineTxt+"<br>";
                }
                read.close();
            }
            now.setText(text);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR");
        }

    }

    public String execute(){
        HttpServletRequest request= ServletActionContext.getRequest();
        id=Integer.parseInt(request.getParameter("id"));
        init();

        return "success";
    }
}
