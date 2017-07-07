<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="member" class="s1lin.harambaseCore.Member" scope="session"/>
<jsp:useBean id="item" class="s1lin.harambaseCore.Item" scope="session"/>
<jsp:useBean id="search" class="s1lin.harambaseCore.Search" scope="session"/>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../Harambase.css">
	<link rel="stylesheet" type="text/css" href="../DropdownMenu.css">
	<link rel="stylesheet" type="text/css" href="Member.css">
	<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
	<title>Bid</title>
</head>
<body>
   	<div id="header">
			<div class="logo">
				<img src="../Images/HaramBaseICON.png">
			</div>	
	    </div>
	<ul>
	
	<li class="active">
	  	<a href="../WelcomeMember.jsp">Welcome</a>
		<%
			if(member.getIsBuyer()==1){
		%>
	  <li class="dropdown">
	  	<a href="javascript:void(0)" class="dropbtn">Buying Management Tools</a>
	    <div class="dropdown-content">
			<a href="ListOfBidOn.jsp">List Of Bids</a>
			<a href="Search.jsp">Search</a>
			<a href="ListOfBought.jsp">List of Bought</a>
	    </div>
	    
		<%  }
		
			if(member.getIsSeller()==1){
		%>
	  <li class="dropdown">
	  <a href="javascript:void(0)" class="dropbtn">Selling management Tools</a>
	    <div class="dropdown-content">
		  	<a href="AddItem.jsp">Add an Item</a>
			<a href="ListItem.jsp">List of Selling</a>
			<a href="ViewMyFeedback.jsp">View my Rating</a>
	    </div>
	     <%
			}if(member.isLoggedIn()){
		%>
	  <li class="dropdown">
	    <a href="javascript:void(0)" class="dropbtn">Member Management Tool</a>
	    <div class="dropdown-content">
	      <a href="Edit.jsp">Update Profiles</a>
	    </div>
	  </li>
	  
	  <li class="dropdown", style="float:down">
	  	<form method="post" action="../Logout_action_member.jsp">  
			<input class = "btnlogout" name="Submit" value="Logout" type="submit"><br>
		</form>
	  </li>
  
	  <li class="dropdown", style="float:down">
	 	 <form method="post" action="Search.jsp">
		<input name="Submit" class = "btnsearch" value="Back To Search" type="submit"><br>
		</form>
	  </li>
	
	<li class="dropdown", style="float:down">
	 	 <form method="post" action="SearchResult.jsp">
		<input name="Submit" class = "btnsearch" value="Search Result" type="submit"><br>
		</form>
	  </li>
	</ul>
	
	   <%} %>
	<h1>Bid this Item</h1>



<% try{
	item.setMember(member);
	item.setItemId(Integer.parseInt(request.getParameter("ITEMID")));
    ResultSet rs = item.getBidItemInfo(item.getItemId());
    ResultSet rd = item.getMaxBid();
    if(rs.next()) {
%>

<form method="post" action="Bid_action.jsp" name="EditForm">
<div id="table">
<table>
<tbody>
	<tr>
    	<td>Item ID</td>
    	<td> <input readonly="readonly" name="itemID" value="<%=item.getItemId()%>"></td>
    </tr><tr>
   		
   		<td>Item Name</td>
   		<td> <input readonly="readonly" name="itemName" value="<%=rs.getString("ITEMNAME")%>"></td>
    </tr><tr>
    
    	<td>Selling Price </td>
    	<td><input readonly="readonly" name="last" value="$<%=rs.getDouble("CURRENTBID")%>"></td>
    </tr>
    <%if(rd.next()){%>
    <tr>	
    	<td>Max Bid </td>
    	<td><input readonly="readonly" name="last" value="$<%=rd.getDouble("MaxBid")%>"></td>
    </tr>
    <%} %>
    <tr>	
    	<td>Min Bidding Price </td>
    	<td><input readonly="readonly" name="last" value="$<%=rs.getDouble("STARTPRICE")+1%>"></td>
    </tr><tr>	
   		<td> Max Bid Limit</td>
   		<td> <input name="maxBidLimit" value=""></td>
    </tr>

</tbody>
</table>
</div>
<input name="Submit" class="btn" style="margin-right: 55%" value="Bid On Item" type="submit"><br>
<input name="userID" class="btn" type="hidden" value="<%=member.getUserID()%>">
<input name="biddingTime" type="hidden" value="<%=new Timestamp(System.currentTimeMillis())%>">
</form>

<%} rs.close();}

    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }

%>
</body>
</html>

