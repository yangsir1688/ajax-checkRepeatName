package cn.javabs.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于IDEA开发工具 | 并使用Servlet的3.0技术、可省略web.xml中映射代码的编写
 *@author：Mr.yang
 *
 */
@WebServlet("/showUserServlet")
public class ShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 设置响应的数据格式为json并且设置编码为utf-8
        response.setContentType("application/json;charset=utf-8");

        // 2. 获取用户名
        String username = request.getParameter("username");

        // 3. 调用service层判断用户名是否存在
        Map<String,Object> map = new HashMap<String,Object>();

        if("wangcai".equals(username)){
            //若用户名为“wangcai”存在
            map.put("userExsit",true);
            map.put("msg","此用户名太受欢迎,请更换一个");
        }else{
            //若用户名为“wangcai”不存在
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }

        // 4.将map转为json，并且传递给客户端
        // 4.1 将map转为json
        ObjectMapper mapper = new ObjectMapper();
        // 4.2 并且传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用doPost方法，实现代码的复用性
        this.doPost(request, response);
    }
}