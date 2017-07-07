
<%@ page language="java" import="java.sql.*"%>

<jsp:useBean id="member" class="s1lin.harambaseCore.Member" scope="session"/>
<jsp:useBean id="item" class="s1lin.harambaseCore.Item" scope="session"/>

<jsp:setProperty name="item" property="*"/> 

<% 
    try{
    	String startTime = request.getParameter("StartYear") + "-" +
				   request.getParameter("StartMonth")+ "-" +
				   request.getParameter("StartDay")+ " "+request.getParameter("TimeStart");

		String endTime = request.getParameter("EndYear")+ "-" +
				 request.getParameter("EndMonth")+ "-" + 
				 request.getParameter("EndDay")+ " "+request.getParameter("TimeEnd");
		item.setAuctionStartTime(startTime);
		item.setAuctionEndTime(endTime);
    	System.out.println(item.getItemId());
    	System.out.println(item.getItemName());
    	System.out.println(item.getItemCategory());
    	System.out.println(item.getItemStartPrice());
    	System.out.println(item.getItemDescription());
    	System.out.println(item.getSellerID());
    	System.out.println(item.getAuctionStartTime());
    	System.out.println(item.getAuctionEndTime());
		item.addItemWithoutPram();
    	response.sendRedirect("AddItem.jsp");
    }
    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }
    
%>