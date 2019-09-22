package top.xiaowuya.web.servlet;

import net.sf.json.JSONObject;
import top.xiaowuya.dao.UserInfoDao;
import top.xiaowuya.domain.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        ServletInputStream servletInputStream = request.getInputStream();
        StringBuilder content = new StringBuilder();
        byte[] b = new byte[1024];
        int lens;
        while ((lens = servletInputStream.read(b)) > 0){
            content.append(new String(b,0,lens));
        }
        String strContent = content.toString(); //获取的用户json数据

        System.out.println(strContent);

        JSONObject jsonObject = JSONObject.fromObject(strContent);
        String temp = jsonObject.getString("userInfo");
        String temp1 = jsonObject.getString("id");
        JSONObject userInfo = JSONObject.fromObject(temp);
        JSONObject id = JSONObject.fromObject(temp1);

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

//        System.out.println(userInfo.toString());
//        System.out.println(id.toString());
        UserInfo ui = (UserInfo) JSONObject.toBean(userInfo,UserInfo.class);
        ui.setId(id.getInt("id") );
        ui.setCreate_time(dateFormat.format(date));
        System.out.println(ui);

        UserInfoDao dao = new UserInfoDao();
        dao.setUserInfo(ui);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
