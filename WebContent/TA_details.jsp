<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>
  $(function() {
    $( "#from" ).datepicker();
  });
  
  $(function() {
	    $( "#to" ).datepicker();
	  });
	  
	  
  </script>
</head>
<body bgcolor="#E09662">
<img src="logo.jpg" align="left" height="400" width="500"></img>
<center>
<br></br>
<br></br>
<h1>TECHNICAL ANALYSIS</h1>
<h4>Date Format:DD-MMM-YY(ex:11-Mar-15)</h4>
<a:form action="plane" >
<br></br>
<a:select list="{'IBM','Amazon','Dell','hp','Oracle'}" label="Select the Company" name="company"></a:select>
<a:textfield label="From" id="from" name="from"></a:textfield>

<a:textfield label="To" id="to" name="to" ></a:textfield>
<br>
<a:submit type="submit" label="GetChart"></a:submit>
</a:form>
</center>
</body>
</html>