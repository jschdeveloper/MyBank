package js.controller;

import js.context.Application;
import js.model.Transaction;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MyBankController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getRequestURI();

        System.out.printf("path : %s", path);

        if ("/health".equalsIgnoreCase(path)) {

            String name = request.getParameter("name");

            response.getWriter().write(String.format("Hola %s ", name == null ? "" : name));

        } else if ("/transactions".equalsIgnoreCase(path)) {
            List<Transaction> transactions = Application.transactionService.findAll();

            response.setContentType("application/json; charset=UTF-8");

            String json = Application.objectMapper.writeValueAsString(transactions);

            response.getWriter().write(json);

        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getRequestURI();

        if ("/create".equalsIgnoreCase(path)) {

            if (request.getParameter("amount") == null || request.getParameter("date") == null || request.getParameter("references") == null) {
                System.err.println("bad request");
                response.getWriter().write("bad parameters");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            Integer amount = Integer.parseInt(request.getParameter("amount"));
            String references = request.getParameter("references");
            String stringDate = request.getParameter("date");
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // you can change format of date
            Date currentDate = formatter.parse(stringDate);
            Timestamp date = Timestamp.valueOf(stringDate);


            Transaction transaction = Application.transactionService.create(amount, date, references);

            String json = Application.objectMapper.writeValueAsString(transaction);

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(json);


        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
