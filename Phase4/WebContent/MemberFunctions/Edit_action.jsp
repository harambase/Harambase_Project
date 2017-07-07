<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="member" class="s1lin.harambaseCore.Member" scope="session"/>
<jsp:setProperty name="member" property="*"/> 

<% 

    try{
    	member.updateProfile(request.getParameter("NEWPASSWORD1"),request.getParameter("NEWPASSWORD2"));
    }
    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }
    response.sendRedirect("Edit.jsp");
%>

