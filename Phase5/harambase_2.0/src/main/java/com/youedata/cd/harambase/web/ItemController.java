package com.youedata.cd.harambase.web;

import com.youedata.cd.harambase.pojo.Item;
import com.youedata.cd.harambase.pojo.ListOfItems;
import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.service.InsertService;
import com.youedata.cd.harambase.service.ListNPService;
import com.youedata.cd.harambase.service.ListWPService;
import com.youedata.cd.harambase.service.PojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sky on 2017/7/5.
 */
@Controller
public class ItemController {
    @Autowired
    private PojoService pojoService;

    @Autowired
    private ListWPService listWPService;

    @Autowired
    private InsertService insertService;

    @RequestMapping("ItemInfo")
    public String itemInfo(HttpSession session, HttpServletRequest request){
        Item item =  pojoService.selectByPrimaryKey(
                Integer.parseInt(request.getParameter("ITEMID")));
        session.setAttribute("item",item);
        return "MemberFunctions/ItemInfo";
    }

    @RequestMapping("ListItem")
    private String listItem(HttpSession session){
        Member member = (Member)session.getAttribute("member");
        Integer userid = member.getUserid();
        List<ListOfItems> itemList = listWPService.itemList(userid);
        session.setAttribute("itemList",itemList);
        return "MemberFunctions/ListItem";
    }

    @RequestMapping("AddItem_action")
    public String addItem(HttpSession session, HttpServletRequest request) throws ParseException {

        Integer[] succ = new Integer[]{0,0};
        Item item = new Item();

        Double starPric = 0.0;
        if(request.getParameter("StartPrice") !="")
            starPric = Double.parseDouble(request.getParameter("StartPrice"));
        if(starPric > 0.0)
            item.setStartprice(starPric);
        else
            succ[0] = -2;

        if(request.getParameter("itemName") != "")
            item.setItemname(request.getParameter("itemName"));
        else
            succ[0] = -2;

        if(request.getParameter("itemCategory") != "")
            item.setItemcategory(request.getParameter("itemCategory"));
        else
            succ[0] = -2;

        item.setDescription(request.getParameter("itemDescription"));

        Member member = (Member)session.getAttribute("member");
        Integer sellerid = member.getUserid();
        item.setSellerid(sellerid);

        //'2016-06-30 12:00:00'
        String startTimeStr = request.getParameter("StartYear")+"-"
                + request.getParameter("StartMonth")+"-"
                + request.getParameter("StartDay") +" "
                + request.getParameter("TimeStart");
        String endTimeStr  = request.getParameter("EndYear")+"-"
                + request.getParameter("EndMonth")+"-"
                + request.getParameter("EndDay") +" "
                + request.getParameter("TimeEnd");

        DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = format.parse(startTimeStr);
        Date endTime   = format.parse(endTimeStr);
        Date date = new Date();

        if(date.compareTo(startTime)<0 && startTime.compareTo(endTime)<0) {
            item.setAuctionendtime(endTime);
            item.setAuctionstarttime(startTime);
        }
        else
            succ[1] = -1;

        if (succ[0] == 0 && succ[1] == 0){
            item.setItemid(-1);
            insertService.insert(item);
        }

        session.setAttribute("succ",succ);
        return "MemberFunctions/AddItem_action";

    }
}
