<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
ul
{
background-image: url("");
}
.top {vertical-align:text-top;}
img.bottom {vertical-align:text-bottom;}
</style>
</head>
<body>

<%@page import="p1.gain"%>
<%!gain g;%>
<%!float f[]=new float[10];%>
<%!float h[]=new float[10];%>
<%!float temp; %>
<%!static int p=1; %>
<%g=new gain();
if(p==1){
f[0]=g.gaincalculation("IBM_DETAILS");
f[1]=g.gaincalculation("Amazon_DETAILS");
f[2]=g.gaincalculation("DELL_DETAILS");
f[3]=g.gaincalculation("hp_DETAILS");
f[4]=g.gaincalculation("ORACLE_DETAILS");

h[0]=f[0];
h[1]=f[1];
h[2]=f[2];
h[3]=f[3];
h[4]=f[4];
}
int n = 5;
for (int pass=1; pass < n; pass++) {  // count how many times
    // This next loop becomes shorter and shorter
    for (int i=0; i < n-pass; i++) {
        if (f[i] > f[i+1]) {
            // exchange elements
            temp = f[i];  f[i] = f[i+1];  f[i+1] = temp;
        }
    }
}%>
<DIV style="position: absolute; top: 50px; right: 200px; width: 200px; height: 200px; ">

<h2><u><font color="green" class="top">Top Gainers</font></u></h2>
<table border="0" cellpadding="5">
<tr>
<td><font size="5" >company</font></td>
<td><font size="5" >%gain</font></td>
</tr>
<tr>
<%
System.out.println(f[0]+" "+f[1]+" "+f[2]+" "+f[3]+" "+f[4]);
 if(f[4]==h[0]){
%>
<td>IBM</td> <td><%=f[4]%></td>
<%}
 else if(f[4]==h[1]){
%>
<td>AMAZON</td>  <td><%=f[4]%></td>
<%}
 else if(f[4]==h[2]){
%>
<td>DELL</td> <td><%=f[4]%></td>
<%} 
 else if(f[4]==h[3]){
%>
<td>HP</td> <td><%=f[4]%></td>
<%}
 else if(f[4]==h[4]){
%>
<td>ORACLE</td> <td><%=f[4]%></td>
<%}%>
</tr>

<tr>
<%
if(f[3]==h[0]){
	%>
<td>IBM</td> <td><%=f[3]%></td>
	<%}
else if(f[3]==h[1]){
	%>
<td>AMAZON</td> <td><%=f[3]%></td>
	<%}
else if(f[3]==h[2]){
	%>
<td>DELL</td> <td><%=f[3]%></td>
	<%} 
else if(f[3]==h[3]){
	%>
<td>HP</td> <td><%=f[3]%></td>
	<%}
else if(f[3]==h[4]){
	%>
<td>ORACLE</td> <td><%=f[3]%></td>

<%}%>
</tr>
<tr>
<%
if(f[2]==h[0]){
%>
<td>IBM</td><td> <%=f[2]%></td>
<%}
else if(f[2]==h[1]){
%>
<td>AMAZON</td><td> <%=f[2]%></td>
<%}
else if(f[2]==h[2]){
%>
<td>DELL</td><td> <%=f[2]%></td>
<%} 
else if(f[2]==h[3]){
%>
<td>HP</td> <td><%=f[2]%></td>
<%}
else if(f[2]==h[4]){
%>
<td>ORACLE</td><td> <%=f[2]%></td>
<%}%>
</tr>
</table>
</div>
<center>
<img alt="Top Losers and Gainers" src="new.jpg" height="300" width="300">
</center>
<DIV style="position: absolute; top: 200px; left: 250px; width: 200px; height: 200px; ">

<h2><u><font color="red" class="img.bottom">Top Losers</font></u></h2>
<table border="0" cellpadding="10">
<tr>
<td><font size="5">company</font></td>
<td><font size="5">%gain</font></td>
</tr>
<tr>
<%
 if(f[1]==h[0]){
%>
<td>IBM</td> <td><%=f[1]%></td>
<%}
else if(f[1]==h[1]){
%>
<td>AMAZON</td><td> <%=f[1]%></td>
<%}
else if(f[1]==h[2]){
%>
<td>DELL</td><td> <%=f[1]%></td>
<%} 
else if(f[1]==h[3]){
%>
<td>HP</td> <td> <%=f[1]%></td>
<%}
else if(f[1]==h[4]){
%>
<td>ORACLE</td><td> <%=f[1]%></td>



<%}%>
</tr>
<tr>
<% 
if(f[0]==h[0]){
%>
<td>IBM</td> <td><%=f[0]%></td>
<%}
else if(f[0]==h[1]){
%>
<td>AMAZON</td><td> <%=f[0]%></td>
<%}
else if(f[0]==h[2]){
%>
<td>DELL</td><td> <%=f[0]%></td>
<%} 
else if(f[0]==h[3]){
%>
<td>HP</td><td> <%=f[0]%></td>
<%}
else if(f[0]==h[4]){
%>
<td>ORACLE</td><td> <%=f[0]%></td>

<%}
p++;%>
</tr>
</table>

</div>


</body>
</html>