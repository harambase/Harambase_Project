<%@ page language="java" import="java.sql.*"%>

<jsp:useBean id="member" class="harambase.Core.Member" scope="session"/>
<jsp:useBean id="admin" class="harambase.Core.Admin" scope="session"/>

<jsp:setProperty name="admin" property="*"/> 

<% 

    try{
    	System.out.println(member.getUserID());
    	System.out.println(member.getUname());
    	System.out.println(member.getLname());
    	System.out.println(member.getFname());
    	System.out.println(member.getPassword());
    	System.out.println(member.getEmail());
    	System.out.println(member.getCreatorId());
    }
    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }
    
%>