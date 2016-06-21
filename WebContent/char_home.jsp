<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@page import="p1.SimpleMovingAverage" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Charts_homePage</title>
</head>

<body bgcolor="#66ccff">

<center><h2><u>Technical Analysis of <s:property value="company"/></u></h2></center><br>
<%!String statmt; %>
<%!String cname; %>
<%!Object obj; %>
<%
try {

	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tatool","root","root");
	obj=session.getAttribute("name");
	cname=obj.toString();
	if(cname.equals("IBM")){
		statmt="select * from IBM_DETAILS order by id desc";
	}
	else if(cname.equals("Amazon"))
	{
		statmt="select * from Amazon_DETAILS order by id desc";
	}

	else if(cname.equals("Dell"))
	{
		statmt="select * from DELL_DETAILS order by id desc";
	}
	else if(cname.equals("hp"))
	{
		statmt="select * from hp_DETAILS order by id desc";
	}
	else if(cname.equals("Oracle"))
	{
		statmt="select * from ORACLE_DETAILS order by id desc";
	}
	PreparedStatement stmt=con.prepareStatement(statmt);
	ResultSet rs=stmt.executeQuery();
	
%>
<center>
<TABLE cellpadding="5" border="0" style="background-color: #ffffcc;">
<%
while (rs.next()) {
%>
<TR>
<Th>Open</Th>
<th>High</th>
<th>Low</th>
<th>Close</th>
<th>Volume</th>
</TR>
<TR>

<TD><%=rs.getFloat(3)%></TD>
<TD><%=rs.getFloat(4)%></TD>
<TD><%=rs.getFloat(5)%></TD>
<TD><%=rs.getFloat(6)%></TD>
<TD><%=rs.getFloat(7)%></TD>
</TR>
<%break; } %>
</TABLE>
<%
// close all the connections.
rs.close();
stmt.close();
con.close();
} catch (Exception ex) {
%>
<font size="+3" color="red">
<%
out.println("Unable to connect to database.");
}
%>
</font>
<img src="Chartdemo.jsp" height="500" width="600" align="middle"/><br>
<img src="chartdemo1.jsp" height="200" width="700" align="middle"/>
<br></br>
<font color="CC3366" size="5">
simple moving averages</font>
<%!SimpleMovingAverage sma=new SimpleMovingAverage(); %>
<TABLE cellpadding="0" border="0" style="background-color: #ffffcc;">
<TR>
<Th>Days</Th>
<th>SMA</th>
</TR>
<TR>
<TD>30</TD>
<TD><%=Math.round(sma.calculateSMA(30,cname)) %></TD>
</TR>
<TR>
<TD>50</TD>
<TD><%=Math.round(sma.calculateSMA(50,cname)) %></TD>
</TR>
<TR>
<TD>100</TD>
<TD><%=Math.round(sma.calculateSMA(100,cname)) %></TD>
</TR>
<TR>
<TD>150</TD>
<TD><%=Math.round(sma.calculateSMA(150,cname)) %></TD>
</TR>
</TABLE>
<a href="sma.jsp">click here for sma charts</a><br>
<a href="chart.jsp">click here for candle stick charts</a>
</center>
</body>
</html>