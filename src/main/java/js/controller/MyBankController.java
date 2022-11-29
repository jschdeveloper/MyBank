package js.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyBankController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getRequestURI();

        System.out.printf("path : %s", path);

        if ("/".equalsIgnoreCase(path)) {
            String name = request.getParameter("name");
            response.getWriter().write(String.format("Hola %s ", name == null ? "" : name));
            System.out.println();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
