<#include "header.ftl">

<b>Welcome to our little demonstration on the CinemaManagement Webapp</b><br><br>

<form method="POST" action="staffmembergui?action=insertPerformance">
	<fieldset id="insertPerformance">
		<legend>Required Information</legend>
		<div>
			<label>Title</label>
			<input type="text" name="title">
	    </div>

		<div>
			<label>Duration</label>
			<input type="text" name="duration">
	    </div>

		<div>
			<label>Time</label>
			<input type="datetime-local" name="time" id="datepicker1">
	    </div>
	    
	    <div>
			<label>AssignedHall ID</label>
			<input type="text" name="assignedHall_ID">
	    </div>
	    
	    <div>
			<label>AssignedHall Rows</label>
			<input type="text" name="assignedHall_row">
	    </div>
	    
	    <div>
			<label>AssignedHall SeatsinRow</label>
			<input type="text" name="assignedHall_seatsInRow">
	    </div>
	    
		<div>
			<label>Available Seats</label>
			<input type="text" name="availableSeats">
	    </div>

	</fieldset>
	<button type="submit" id="submit">Submit</button>
</form>
<#include "footer.ftl">