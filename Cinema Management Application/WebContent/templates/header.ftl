<!DOCTYPE HTML>
<html lang='de' dir='ltr'>
<head>
	<meta charset="utf-8" />
	<title>Cinema Management Application - ${pagetitle}</title>
	<link type="text/css" href="css/style.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  	<script>
  		$(function() {
    		$( "#datepicker2" ).datepicker(
    		{
    			minDate:'today',
    			
    		});
 
  			$("#datepicker1").datepicker({
  				minDate:'today',
    			onSelect: function (dateValue, inst) {
        			$("#datepicker2").datepicker("option", "minDate", dateValue)
    			}
			});
		});
  	</script>
</head>
<body>
<div id="wrapper">
	<div id="logo">Cinema Managment Application<br>Software Engineering Team21 Project</div>
    <ul id="navigation">
    	<li><a href="index" title="Index">View Homesite</a></li>
	<#if navtype == "registeredcustomer">
    	<li><a href="rcustomergui?page=defaultwebpage" title="Browse Performance">Browse Performances</a></li>	
	<#elseif navtype == "urcaccount">
		<li><a href="urcustomergui?page=defaultwebpage" title="Register Account">Register Account</a></li>
	<#elseif navtype == "staffmember">
		<li><a href="staffmembergui?page=insertoffer" title="Insert Offer">Insert Performance</a></li>
	<#else>
    	<li><a href="staffmembergui" title="Staffmember">Staffmember</a></li>
		<li><a href="rcustomergui" title="registeredcustomer">Registered Customer</a></li>
		<li><a href="urcustomergui" title="unregisteredcustomer">Unregistered Customer</a></li>
	</#if>
    </ul>
	<div id="content">