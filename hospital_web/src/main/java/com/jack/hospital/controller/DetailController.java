package com.jack.hospital.controller;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("detailController")
public class DetailController {
    @Autowired
    DepclassService depclassService;
    @Autowired
    DepartmentService departmentService;

    private String getDepclassNameById(List<Depclass> depclassList,Integer id){
        for(Depclass depclass:depclassList){
            if(depclass.getId()==id){
                return depclass.getName();
            }
        }
        return null;
    }
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Depclass> depclassList = depclassService.findAll();
        List<Department> departmentList = departmentService.findAll();
        Map<String,List<Department>> dMap = new HashMap<String, List<Department>>();
        for(Department department:departmentList){
            String className = getDepclassNameById(depclassList,department.getDid());
            System.out.println("className:"+className);
            List<Department> dList= dMap.get(className);
            if(dList==null) {
                dList = new ArrayList<Department>();
            }
                dList.add(department);
                dMap.put(className,dList);

        }
        /*Map<String,List<Department>> dMap = new HashMap<String, List<Department>>();
        for(Depclass depclass:depclassList){

        }*/
        request.setAttribute("DMAP",dMap);
        request.getRequestDispatcher("../hospital_detail.jsp").forward(request,response);

    }
}
