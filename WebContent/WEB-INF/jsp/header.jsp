<div style="clear: none; position: relative; height: 20px;">
	<div style="float: left; clear: both;">
		<table>
			<tr>
				<td><a href="<%= request.getContextPath()%>/AvailableCalendars.html">Select Calendar</a></td>		
			</tr>
		</table>
	</div>
	
	<div style="float: right;">
		<table>
			<tr>
				<td>Logged-in user:</td>
				<td>
					<span class="loggedInUser">${USER_INFO.userName}</span>
				</td>
				<td>|</td>
				<td>
					<a href="<%= request.getContextPath()%>/Logout.html">Sign out</a>
				</td>
			</tr>
		</table>
	</div>
</div>
<hr color="sienna">