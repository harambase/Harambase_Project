
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>My Transactions</title>
</head>
<body>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="customer" class="productdeals.Customer" scope="session"/>


<table style="text-align: center; width: 100%; margin-left: auto; margin-right: auto;" border="1";cellpadding="2"; cellspacing="2">
  <tbody>
    <tr>
      	<td style="vertical-align: top;">PART NUMBER<br> 
      	</td>
      	<td style="vertical-align: top;">PART DESCRIPTION<br>
      	</td>
     	 <td style="vertical-align:top;">QUOTED PRICE<br>
      	</td>
      	<td style="vertical-align: top;">NUMBER ORDERED<br>
      	</td>
   </tr>

    <% try{
    ResultSet rs = customer.getTransactionParts(request.getParameter("trans_number")); 
    
    while (rs.next()) {
		ResultSet rp = customer.getParts(rs.getString("Part_Number")); 
		while(rp.next()){
			%>
			<tr>
		     	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
		     		<input type="text" readonly name = "part_number" value="<%=rs.getString("PART_NUMBER")%>"><br>
		     	</td>
		     	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
		     		<input type="text" readonly name = "part_description" value="<%=rp.getString("PART_DESCRIPTION")%>"><br>
		     	</td>
		    	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
		    		<input type="text" readonly name = "quoted_price" value="<%=rs.getString("QUOTED_PRICE")%>"><br>
		    	</td>
		    	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
		    		<input type="text" readonly name = "number_ordered" value="<%=rs.getString("NUMBER_ORDERED")%>"><br>
		    	</td>	
		    </tr>
		<%} 
		rp.close();
    }
   	rs.close();
    }

    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }

	%>
    
  </tbody>
</table>
<form method="post" action="MyTransactions.jsp">
	<input name="Submit" value="Back To Transactions" type="submit"><br>
</form>

</body>
</html>