package com.jack.hospital.controller;

import com.jack.hospital.dao.DepclassDao;
import com.jack.hospital.entity.Department;
import com.jack.hospital.entity.Depclass;
import com.jack.hospital.service.DepartmentService;
import com.jack.hospital.service.DepclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepclassService depclassService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Depclass> cList = depclassService.findAll();
        request.setAttribute("CLIST",cList);
        List<Department> list = departmentService.findAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../department_list.jsp").forward(request,response);

    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Depclass> cList = depclassService.findAll();
        request.setAttribute("CLIST",cList);
        request.getRequestDispatcher("../department_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        Integer did = Integer.parseInt(request.getParameter("did"));
        Department department = new Department();
        department.setName(name);
        department.setDid(did);
        department.setCreateTime(new Date());
        department.setModifyTime(new Date());
        departmentService.insert(department);
        response.sendRedirect("list.do");
    }
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Depclass> cList = depclassService.findAll();
        request.setAttribute("CLIST",cList);
        Integer id = Integer.parseInt(request.getParameter("id"));
        Department department = departmentService.findById(id);
        request.setAttribute("department",department);
        request.getRequestDispatcher("../department_edit.jsp").forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer did = Integer.parseInt(request.getParameter("did"));
        Department department = departmentService.findById(id);
        department.setDid(did);
        department.setName(name);
        department.setModifyTime(new Date());
        departmentService.update(department);
        response.sendRedirect("list.do");

    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        departmentService.delete(id);
        response.sendRedirect("list.do");
    }
}
