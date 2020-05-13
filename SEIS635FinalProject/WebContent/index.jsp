<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.skunk.counter" %>
<!DOCTYPE html>
<html>
<head>
<script type ="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>SKUNK GAME</title>

<script type = "text/javascript">


$(document).ready(function(){
	
	$('#startButton').click(function(){
		
		var button = 1;
		var playerOneName = $('#playerOneName').val();
		var playerTwoName = $('#playerTwoName').val();
		var playerThreeName = $('#playerThreeName').val();
		var playerFourName = $('#playerFourName').val();
		var playerFiveName = $('#playerFiveName').val();
		var playerSixName = $('#playerSixName').val();
		var playerSevenName = $('#playerSevenName').val();
		var playerEightName = $('#playerEightName').val();
		
		if (playerOneName == "" || playerTwoName ==""){
			$('#turnresult').html(result);
			$('#scoreboard').html("");
		}
		else{
			$.ajax({
				type: 'Post',
				data: {
					button: button,
					playerOneName: playerOneName,
					playerTwoName: playerTwoName,
					playerThreeName: playerThreeName,
					playerFourName: playerFourName,
					playerFiveName: playerFiveName,
					playerSixName: playerSixName,
					playerSevenName: playerSevenName,
					playerEightName: playerEightName
						},
				url: 'skunkservlet',
				success: function(result){
				
					$('#scoreboard').html(result);
					$('#turnresult').html("");
				}
			});
		}
	});
	
	
	
	$('#rollButton').click(function(){
		var button = 2;
		var playerOneName = $('#playerOneName').val();
		var playerTwoName = $('#playerTwoName').val();
		
		if (playerOneName == "" || playerTwoName ==""){
			$('#turnresult').html(result);
			$('#scoreboard').html("");
		}
		else{
			$.ajax({
				type: 'Post',
				data: {
					button: button
						},
				url: 'skunkservlet',
				success: function(result){
					$('#turnresult').html(result);
					$('#scoreboard').html("");
				}
			});
		}	
	});
	
	
	
	$('#skipButton').click(function(){
		var button = 3;
		var playerOneName = $('#playerOneName').val();
		var playerTwoName = $('#playerTwoName').val();
		
		if (playerOneName == "" || playerTwoName ==""){
			$('#turnresult').html(result);
			$('#scoreboard').html("");
		}
		else{
			$.ajax({
				type: 'Post',
				data: {
					button: button
						},
				url: 'skunkservlet',
				success: function(result){
					$('#turnresult').html(result);
				}
			});
		}
	});
	
	$('#resetButton').click(function(){
		var button = 4;
		
		$.ajax({
			type: 'Post',
			data: {
				button: button
					},
			url: 'skunkservlet',
			success: function(result){
				$('#turnresult').html(result);
				$('#scoreboard').html("");
			}
		});
		
	});
	
});


</script>

<style>

#appdiv{
margin-left: 10%;
margin-top: 30px;
border: 3px solid purple;
width: 25%;
min-width: 80%;
padding: 10px;
border-radius: 20px;
display:inline-block;
text-align: center;
position: absolute;

}


#calcdiv{

width: 100%;
float: left;
text-align: left;
padding-left: 10px;
}
button {

  background-color: purple;
  color: white; 
  border: 2px solid purple;
  width: 80px;
  height: 50px;
  border-radius: 12px;
  font-size: 20px;

}
p{

color: purple;
}

#startButton{
 width: 200px;
}

button:hover {
  background-color: white; 
  color: purple;
}

input{
border-radius: 5px;
}

</style>
</head>
<body>




<div id = "appdiv">
<h1>Let's Play Skunk!</h1>
<div id = "calcdiv">




<form id = "calcform" onsubmit="return false;">

<h2>Player Names</h2>
<input type="text" id = "playerOneName" placeholder ="Player 1 Name..." required>
<input type="text" id = "playerTwoName" placeholder ="Player 2 Name..." required>
<input type="text" id = "playerThreeName" placeholder ="Player 3 Name...">
<input type="text" id = "playerFourName" placeholder ="Player 4 Name...">
<input type="text" id = "playerFiveName" placeholder ="Player 5 Name...">
<input type="text" id = "playerSixName" placeholder ="Player 6 Name...">
<input type="text" id = "playerSevenName" placeholder ="Player 7 Name...">
<input type="text" id = "playerEightName" placeholder ="Player 8 Name...">
<br><br>
<button type = "submit" value = "Start" id="startButton">Start Game!</button>
<h3>Choose an Action!</h3>
<button type = "submit" value = "Roll" id="rollButton">Roll</button>
<button type = "submit" value = "Skip" id="skipButton">Skip</button>
<div id="turnresult"></div>
<div id="scoreboard"></div>




<br>
<button type = "reset" value = "Clear" id="resetButton">Reset</button>
</form>
</div>



</div>

</body>
</html>