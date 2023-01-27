<#include "header.ftl">

<b>Welcome to our little demonstration on the CinemaManagement Webapp</b><br><br>

<form method="POST" action="urcustomergui?action=requestRegister">
	<fieldset id="requestRegister">
		<legend>Required Information</legend>
		<div>
			<label>Email</label>
			<input type="text" name="email" id="email">
	    </div>

		<div>
			<label>Password</label>
			<input type="password" name="password" id="password">
	    </div>

	</fieldset>
	<button type="submit" id="RegisterWebpage" name="RegisterWebpage" value="Submit">Register!</button>
</form>
<#include "footer.ftl">