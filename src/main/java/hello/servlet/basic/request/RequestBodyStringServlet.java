package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        // Byte 전환 , Charset 지정 필수
        String messageStream = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageStream = " + messageStream);
        System.out.println();

        res.getWriter().write("ok");
    }
}
