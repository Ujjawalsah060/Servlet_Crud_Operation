package udSah.practice.Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/hello"})
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        System.out.println("HelloServlet Constructor called");
    }

    public void init() {
        System.out.println("init() method called");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setContentType("text/plain");
        response.getWriter().write("Hello");
    }

    public void destroy() {
        System.out.println("Destroy method called");
    }
}
