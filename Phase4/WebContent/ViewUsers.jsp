
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="admin" class="harambase.Core.Admin" scope="session"/>

<html>
<head>
	<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
	<link rel="stylesheet" type="text/css" href="Admin.css">
	<title>View All Users</title>
</head>
<body>
	<h1>View All Users</h1>

	<table style="text-align: center; width: 100%; margin-left: auto; margin-right: auto; border="1";cellpadding="2"; cellspacing="2"">
	  <tbody>
	    <tr>
	      	<td style="vertical-align: top;"><b>UserID</b><br> 
	      	</td>
	      	<td style="vertical-align: top;"><b>User Name</b><br> 
	      	</td>
	      	<td style="vertical-align: top;"><b>First Name</b><br>
	      	</td>
	     	 <td style="vertical-align:top;"><b>Last Name</b><br>
	      	</td>
	      	<td style="vertical-align: top;"><b>Email</b><br>
	      	</td>
	      	<td style="vertical-align: top;"><b>Password</b><br>
	   </tr>
	
	    <% try{
	    	ResultSet rs = admin.getMemberInfo();
	   	   while (rs.next()) {
		%>
	    <tr>		
			<td style="vertical-align: top; text-align:center;" contenteditable='false'>
	     		<%=rs.getString("USERID")%><br>
	     	</td>
	     	
	     	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
	     		<%=rs.getString("UNAME")%><br>
	     	</td>
	     	
	     	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
	     		<%=rs.getString("FNAME")%><br>
	     	</td>
	     	
	    	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
	    		<%=rs.getString("LNAME")%><br>
	    	</td>
	    	
	    	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
	    		<%=rs.getString("EMAIL")%><br>
	    	</td>
	    	
	    	<td style="vertical-align: top; text-align:center;" contenteditable='false'>
	    		<%=rs.getString("PASSWORD")%><br>
	   	</td>
	    	</tr>
	    
	    <%} rs.close();}
	
	    catch(IllegalStateException ise){
	        out.println(ise.getMessage());
	    }
	
		%>
	</tbody>
	</table>

<h2>Add User (Not supported right now)</h2>

<table style="text-align: left; width: 20%;" >	
  <tbody>
    <tr>
      	<td style="vertical-align: top;">UserID<br> 
      	</td>
      	<td style="vertical-align: top; text-align:center;">
	     		<input type="text" readonly name = "USERID" value="-1"><br>
	    </td>	
    </tr> <tr>
      	<td style="vertical-align: top;">User Name<br> 
      	</td>
      	<td style="vertical-align: top; text-align:center;">
	     		<input type="text" name = "Username" value=""><br>
	     </td>
    </tr> <tr>
      	<td style="vertical-align: top;">First Name<br>
      	</td>
      	<td style="vertical-align: top; text-align:center;">
	     		<input type="text" name = "First_Name" value=""><br>
	    </td>
    </tr> <tr>
     	 <td style="vertical-align:top;">Last Name<br>
      	</td>
      	<td style="vertical-align: top; text-align:center;">
	    		<input type="text" name = "Last_Name" value=""><br>
	    </td>
    </tr> <tr>
      	<td style="vertical-align: top;">Email<br>
      	</td>
      	<td style="vertical-align: top; text-align:center;">
	    		<input type="text" name = "EMAIL" value=""><br>
	    </td>
    </tr> <tr>
      	<td style="vertical-align: top;">Password<br>
      	</td>
      	<td style="vertical-align: top; text-align:center;">
	    		<input type="text" name = "PASSWORD" value=""><br>
	    </td>
    </tr>
  
</table>
<form method="post" action="AddUsers_action.jsp">
	<input name="Submit" value="Add User" type="submit"><br>
</form>

<form method="post" action="../WelcomeAdmin.jsp">
	<input name="Submit" value="Back To Menu" type="submit"><br>
</form>
<%} rs.close();}

    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }
%>
</body>
</html>