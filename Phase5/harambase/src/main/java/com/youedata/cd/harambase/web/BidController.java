package com.youedata.cd.harambase.web;

import com.youedata.cd.harambase.pojo.*;
import com.youedata.cd.harambase.service.BidService;
import com.youedata.cd.harambase.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/5.
 */
@Controller
public class BidController {
    @Autowired
    private BidService bidService;

    @Autowired
    private ItemService itemService;

    @RequestMapping("BidderList")
    public String bidderList(HttpServletRequest request, HttpSession session){
        Integer itemid = Integer.parseInt(request.getParameter("ITEMID"));
        List<Map<Integer, ListOfBidders>> bidderList = bidService.listofbidders(itemid);
        Item item = itemService.selectByPrimaryKey(itemid);

        session.setAttribute("bidderList",bidderList);
        session.setAttribute("item",item);
        return "MemberFunctions/BidderList";
    }

    @RequestMapping("Bid_action")
    public String bidAction(HttpServletRequest request, HttpSession session){
        Integer userid = ((Member)session.getAttribute("member")).getUserid();
        Integer itemid = Integer.parseInt(request.getParameter("itemid"));
        Integer seller = Integer.parseInt(request.getParameter("sellerid"));
        Integer winner = Integer.parseInt(request.getParameter("winner"));
        Integer succ   = 0;
        /** @return int status
         *  1: success
         * 	2: item has been sold --THIS WILL NOT HAPPEN
         * 	-1: Auction has not started --THIS WILLNOT HAPPEN
         * 	3: The MAXBIDLIMIT is smaller than the start price or empty
         * 	4: The user is the seller.
         * 	5: The user is the winner
         * 	0: The SQL is not executed
         */
        Bid bid = new Bid();
        bid.setItemid(itemid);
        bid.setUserid(userid);
        bid.setBiddingtime(new Date());

        if(userid == seller)
            succ = 4;
        else if(userid == winner)
            succ = 5;
        else if(request.getParameter("maxBidLimit") == "")
            succ = -1;
        else if(Double.parseDouble(request.getParameter("maxBidLimit"))<
                Double.parseDouble(request.getParameter("minBid")))
            succ = 3;
        else
            bid.setMaxbidlimit(
                    Double.parseDouble(
                            request.getParameter("maxBidLimit")));
        if(succ == 0)
            bidService.insert(bid);

        session.setAttribute("succ",succ);
        return "MemberFunctions/Bid_action";

    }
}
