
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
      	<td style="vertical-align: top;">TRANS DATE<br> 
      	</td>
      	<td style="vertical-align: top;">TRANS NUMBER<br>
      	</td>
     	 <td style="vertical-align:top;">TOTAL<br>
      	</td>
      	<td style="vertical-align: top;"><br>
      	</td>
   </tr>

    <% try{
    ResultSet rs = customer.getAllTransactions(); 
    while (rs.next()) {
	%>
	<tr>
     	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
     		<input type="text" readonly name = "trans_date" value="<%=rs.getString("TRANS_DATE").substring(0, 10)%>"><br>
     	</td>
     	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
     		<input type="text" readonly name = "trans_number" value="<%=rs.getString("TRANS_NUMBER")%>"><br>
     	</td>
    	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
    		<input type="text" readonly name = "trans_date" value="<%=customer.getTransactionTotalValue(rs.getString("TRANS_NUMBER"))%>"><br>
    	</td>
    		<td style="vertical-align: top; text-align: center;">	
                        <form method="post" action="ViewTransParts.jsp">
                            <input name="trans_number" type="hidden" value ="<%=rs.getString("TRANS_NUMBER")%>">
                            <input value="View" type="submit">
                        </form>
                        <br>
       	  	</td>
    </tr>
    <%} rs.close();}

    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }

	%>
    
  </tbody>
</table>
<form method="post" action="../Welcome.jsp">
	<input name="Submit" value="Back To Menu" type="submit"><br>
</form>

</body>
</html>