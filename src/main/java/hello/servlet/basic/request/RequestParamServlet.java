package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //System.out.println("RequestParamServlet.service");
        System.out.println("[전체 파라미터 조회] - Start");
            request.getParameterNames().asIterator()
                            .forEachRemaining((paramName -> System.out.println(paramName+ ": "+ request.getParameter(paramName))));
        System.out.println("[전체 파라미터 조회] - Start");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - Start");

        String userName = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("userName = " + userName);
        System.out.println("age = " + age);

        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        // 파라미터 이름이 하나인데 값이 중복이면???
        // request.getParameter 의 경우는 하나의 파라미터인 경우에만 사용해야 함.
        // request.getParameterValues를 사용함.
        System.out.println("[같은 복수 파라미터 조회] - Start");

        String [] userNames = request.getParameterValues("username");

        for(String name : userNames){
            System.out.println("username = " + name);
        }

        System.out.println();

        response.getWriter().write("ok");
    }
}
