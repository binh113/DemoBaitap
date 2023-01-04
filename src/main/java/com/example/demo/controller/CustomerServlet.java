package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "view":
                viewDetail(request, response);
                break;
            case "search":
                seach(request, response);
                break;
            default:
                viewCustomers(request, response);
                break;
        }
    }

    private void seach(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("searchName");
        List<Customer> customers = customerService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        request.setAttribute("customers", customers);
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/viewDetail.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(id);
        request.setAttribute("message", "sucefully delete");
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException ioException) {
            ioException.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException ioException) {
            ioException.printStackTrace();
        }
    }

    private void viewCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                saveCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String image = request.getParameter("image");

        Customer customer = new Customer(id, name, email, address, image);
        customerService.edit(customer);
        request.setAttribute("message", "Successful updated");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException ioException) {
            ioException.printStackTrace();
        }
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String image = request.getParameter("image");

        Customer customer = new Customer(id, name, email, address, image);
        customerService.save(customer);
        request.setAttribute("message", "Successful added");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException ioException) {
            ioException.printStackTrace();
        }
    }
}
