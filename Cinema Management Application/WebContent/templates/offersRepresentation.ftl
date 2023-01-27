<#include "header.ftl">

<b>Welcome to our little demonstration on the CinemaManagement Webapp</b>

<table id="availablePs">
	<tr>
		<th>#</th>
		<th>Title</th>
		<th>Duration</th>
		<th>Time</th>
		<th>Available Seats</th>
		<th>Book Now!</th>
	</tr>
	<#list availableP as p>
	<tr>
		<td>${p.ID}</td>
		<td>${p.title}</td>
		<td>${p.duration}</td>
		<td>${p.time}</td>
		<td>${p.availableSeats}</td>
		<td><a href="rcustomergui?action=selectPerformance&amp;hid=${p.ID}" title="Make Booking">Book</a></td>
	</tr>
	</#list>
</table>
<#include "footer.ftl">