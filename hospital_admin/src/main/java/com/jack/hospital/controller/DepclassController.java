package com.jack.hospital.controller;

import com.jack.hospital.entity.Depclass;
import com.jack.hospital.service.DepclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller("depclassController")
public class DepclassController {

    @Autowired
    DepclassService depclassService;

    //   /Depclass/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Depclass> list = depclassService.findAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../depclass_list.jsp").forward(request,response);

    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("../depclass_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        Depclass depclass = new Depclass();
        depclass.setName(name);
        depclass.setCreateTime(new Date());
        depclass.setModifyTime(new Date());
        depclassService.insert(depclass);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        Depclass depclass = depclassService.findById(id);
        request.setAttribute("depclass",depclass);
        request.getRequestDispatcher("../depclass_edit.jsp").forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Depclass depclass = depclassService.findById(id);
        depclass.setName(name);
        depclass.setModifyTime(new Date());
        depclassService.update(depclass);
        response.sendRedirect("list.do");

    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        depclassService.delete(id);
        response.sendRedirect("list.do");
    }
}
