package com.youedata.cd.harambase.web;

import com.youedata.cd.harambase.pojo.*;
import com.youedata.cd.harambase.service.BidService;
import com.youedata.cd.harambase.service.FeedbackService;
import com.youedata.cd.harambase.service.ItemService;
import com.youedata.cd.harambase.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/6/29.
 */
@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private BidService bidService;

    @RequestMapping("WelcomeMember")
    private String welcomeMember(){
        return "WelcomeMember";
    }

    //Seller Options:
    @RequestMapping("ViewMyFeedback")
    private String viewMyFeedback(HttpSession session){
        Member member = (Member)session.getAttribute("member");
        Integer userid = member.getUserid();
        Integer numOfRec  = feedbackService.numOfRec(userid);
        if(numOfRec != 0) {
            List<Map<Integer, Feedback>> feedbackList = feedbackService.feedbackList(userid);
            Double totalRate = feedbackService.totalRate(userid);
            Double avgRate   = totalRate/numOfRec;
            session.setAttribute("avgRate",avgRate);
            session.setAttribute("feedbackList", feedbackList);
        }
        session.setAttribute("numOfRec", numOfRec);
        return "MemberFunctions/ViewMyFeedback";
    }

    @RequestMapping("AddItem")
    private String addItem(HttpSession session){
        Member member = (Member)session.getAttribute("member");
        Integer userid = member.getUserid();
        return "MemberFunctions/AddItem";
    }

    //User Options:
    @RequestMapping("Edit")
    private String editProfilePage(){
        return "MemberFunctions/Edit";
    }

    @RequestMapping("Edit_action")
    private String editProfileAction(HttpServletRequest request, HttpSession session){
        Member member = (Member)session.getAttribute("member");
        member.setUname(request.getParameter("uname"));
        member.setFname(request.getParameter("fname"));
        member.setLname(request.getParameter("lname"));
        member.setEmail(request.getParameter("email"));
        int succ = 0;
        String password = request.getParameter("password");
        if(request.getParameter("password")!=""){
            if(!request.getParameter("password").equals(member.getPassword()))
                succ = -2;
            else if(request.getParameter("NEWPASSWORD1")!="" &&
                    request.getParameter("NEWPASSWORD2")!="" &&
                    request.getParameter("NEWPASSWORD1").equals(request.getParameter("NEWPASSWORD2"))) {
                member.setPassword(request.getParameter("NEWPASSWORD1"));
                succ = memberService.updateByPrimaryKeySelective(member);
            }
            else
               succ = -1;
        }
        else
            succ = memberService.updateByPrimaryKeySelective(member);
        /*  1:sucess
            0:Violating rules possible
           -1:New password does not match
           -2:Wrong old password
        */
        session.setAttribute("member",member);
        session.setAttribute("succ",succ);
        return "MemberFunctions/Edit_action";
    }

    //Buyer Options:
    @RequestMapping("ListOfBidOn")
    private String listOfBidOn(HttpSession session){
        Member member = (Member)session.getAttribute("member");
        Integer userid = member.getUserid();
        List<Map<Integer, ListOfBidOn>> bidonList = itemService.bidonList(userid);
        session.setAttribute("bidonList",bidonList);
        return "MemberFunctions/ListOfBidOn";
    }

    @RequestMapping("Search")
    private String search(HttpSession session, HttpServletRequest request){
        return "MemberFunctions/Search";
    }

    @RequestMapping("SearchResult")
    private String searchResult(HttpServletRequest request, HttpSession session) throws ParseException {
        Search search = new Search();

        if(request.getParameter("itemID")!="")
            search.setTid(Integer.parseInt(request.getParameter("itemID")));

        if(request.getParameter("keyword")!="")
            search.setKeyword(request.getParameter("keyword"));

        if(request.getParameter("category")!="")
            search.setTcategory(request.getParameter("category"));

        if(request.getParameter("bidMin")!="")
            search.setCurbidmin(Double.parseDouble(request.getParameter("bidMin")));

        if(request.getParameter("bidMax")!="")
            search.setCurbidmax(Double.parseDouble(request.getParameter("bidMax")));


        String startTimeStr = request.getParameter("StartYear")+"-"
                + request.getParameter("StartMonth")+"-"
                + request.getParameter("StartDay") +" "
                + request.getParameter("TimeStart");
        String endTimeStr  = request.getParameter("EndYear")+"-"
                + request.getParameter("EndMonth")+"-"
                + request.getParameter("EndDay") +" "
                + request.getParameter("TimeEnd");

        DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(!startTimeStr.equals("-- 00:00:00")){
            Date startTime = format.parse(startTimeStr);
            search.setTauctionstarttime(startTime);
        }

        if(!endTimeStr.equals("-- 00:00:00")){
            Date endTime   = format.parse(endTimeStr);
            search.setTauctionendtime(endTime);
        }

        List<Map<Integer, SearchResult>> searchResult = memberService.search_item(search);
        session.setAttribute("searchResult",searchResult);

        return "MemberFunctions/SearchResult";
    }

    @RequestMapping("ListOfBought")
    private String listOfBought(HttpSession session){
        Member member = (Member)session.getAttribute("member");
        Integer userid = member.getUserid();
        List<Map<Integer, ListOfBought>> boughtList = itemService.boughtList(userid);
        session.setAttribute("boughtList",boughtList);
        return "MemberFunctions/ListOfBought";
    }

    @RequestMapping("Bid")
    private String bidOnItem(HttpServletRequest request, HttpSession session){
        Integer itemid = Integer.parseInt(request.getParameter("ITEMID"));
        ListOfItems itemInfo = itemService.itemListbyTid(itemid);
        Double max = bidService.maxBidOfItem(itemid);

        session.setAttribute("max",max);
        session.setAttribute("itemInfo",itemInfo);
        session.setAttribute("itemid",itemid);

        return "MemberFunctions/Bid";
    }

}
