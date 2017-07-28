package com.youedata.cd.harambase.web;

import com.youedata.cd.harambase.pojo.Admin;
import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.pojo.Overall;
import com.youedata.cd.harambase.pojo.Sales;
import com.youedata.cd.harambase.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/6/28.
 */
@Controller
public class AdminController {
    @Autowired
    private InsertService adminService;

    @Autowired
    private ListNPService listNPService;

    @Autowired
    private ValueNPService valueNPService;

    @Autowired
    private PojoService pojoService;

    @RequestMapping("Login_action")
    public String login(HttpServletRequest request, HttpSession session) {

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("password");

        if (pojoService.login(uname, pwd) != null) {
            Admin admin = pojoService.login(uname, pwd);
            session.setAttribute("admin", admin);
            return "WelcomeAdmin";
        } else if (pojoService.login(uname, pwd) != null) {
            Member member = memberService.login(uname, pwd);
            session.setAttribute("member", member);
            return "WelcomeMember";
        }

        return "index";
    }

    @RequestMapping("Logout_action")
    public String logout(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("admin");
        session.removeAttribute("member");
        try {
            request.logout();
        } catch (ServletException e) {
            System.out.println("MLogout_action");
        }
        session.invalidate();
        return "index";
    }

    @RequestMapping("OverallComm")
    public String overallComm(HttpSession session) {
        List<Overall> overallComm = listNPService.overallComm();
        Double total = valueNPService.total();
        session.setAttribute("overallComm", overallComm);
        session.setAttribute("total", total);
        return "AdminFunctions/OverallComm";
    }

    @RequestMapping("WelcomeAdmin")
    public String welcomeAdmin() {
        return "WelcomeAdmin";
    }

    @RequestMapping("SalesReport")
    public String salesReport(HttpSession session) {
        List<Sales> sales = adminService.sales();
        Map<String, Double> totalMap  = new HashMap<>();
        Map<String, Double> commMap   = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        List<String> sumItemCategory  = adminService.sumItemCategory();

        //Add subcount, subtotal, subcommission by itemCategory
        for(int i = 0; i<sumItemCategory.size(); i++){
            String curCate = sumItemCategory.get(i);

            totalMap.put(curCate, adminService.subTotal(curCate));
            commMap.put(curCate, adminService.subComm(curCate));
            countMap.put(curCate, adminService.subCount(curCate));
        }

        totalMap.put("sumTotal", adminService.sumTotal());
        commMap.put("sumComm", adminService.sumComm());

        session.setAttribute("totalMap", totalMap);
        session.setAttribute("commMap",commMap);
        session.setAttribute("sales", sales);
        session.setAttribute("countMap",countMap);
        session.setAttribute("sumItemCategory",sumItemCategory);

        return "AdminFunctions/SalesReport";
    }

    @RequestMapping("ViewUsers")
    public String viewUsers(HttpSession session) {
        List<Member> memberMap = memberService.memberMap();
        session.setAttribute("memberMap", memberMap);
        return "AdminFunctions/ViewUsers";
    }

    @RequestMapping("AddUsers_action")
    public String addUser(HttpServletRequest request, HttpSession session){

        String pass   = request.getParameter("password");
        String uname  = request.getParameter("uname");
        String fname  = request.getParameter("fname");
        String lname  = request.getParameter("lname");
        String email  = request.getParameter("email");

        if(pass!="" && uname!="" && fname !="" && lname != "" && pass != "")
            memberService.insert(new Member(-1, uname, fname, lname, email, pass,0,1,1));

        List<Member> memberMap = memberService.memberMap();
        session.setAttribute("memberMap", memberMap);

        return "AdminFunctions/ViewUsers";
    }
}