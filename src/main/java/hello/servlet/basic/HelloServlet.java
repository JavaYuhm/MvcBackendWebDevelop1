
package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest reqeust, ServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("reqeust = " + reqeust);
        System.out.println("response = " + response);

        String userName = reqeust.getParameter("username");
        System.out.println("userName = " + userName);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + userName);
    }
}

