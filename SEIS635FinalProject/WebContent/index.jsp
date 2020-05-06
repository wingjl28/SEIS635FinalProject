<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type ="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>SKUNK GAME</title>

<script type = "text/javascript">

$(document).ready(function(){
	$('#calcform').on('keyup keypress change', function(e){
		var playerOneName = $('#playerOneName').val();
		var playerTwoName = $('#playerTwoName').val();
		var playerThreeName = $('#playerThreeName').val();
		var playerFourName = $('#playerFourName').val();
		var playerFiveName = $('#playerFiveName').val();
		var playerSixName = $('#playerSixName').val();
		var playerSevenName = $('#playerSevenName').val();
		var playerEightName = $('#playerEightName').val();
		var startPlayerText = "";

	
		if (playerOneName==null ||  playerOneName=="" || playerTwoName==null ||  playerTwoName=="" )
			{
			startPlayerText = "Must have at least 2 players to start the game!"
			}

		
		
		$.ajax({
			type: 'Post',
			data: {
					playerOneName: playerOneName,
					playerTwoName: playerTwoName,
					playerThreeName: playerThreeName,
					playerFourName: playerFourName,
					playerFiveName: playerFiveName,
					playerSixName: playerSixName,
					playerSevenName: playerSevenName,
					playerEightName: playerEightName
					},
			url: 'AjaxCalc',
			success: function(result){
				$('#calcresult').html(result);
				$('#recommendation').html(downpaymenttext);
				$('#monthtext').html(monthtext);

			}
		});
		
		} <!-- End else -->
		
		
	});
	
	
	
	
	
	$('#clearbttn').click(function(){
		
		var text = "<h5>Monthly Payment:</h5>$0.00<h5>Total Payment:</h5>$0.00<h5>Total Interest Paid:</h5>$0.00";
		$.ajax({
			success: function(result){
				$('#calcresult').html(text);
	    		  $("#creditscoretext").text("");
	    		  $("#recommendation").text("");
	    		  $("#monthtext").text("");
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

#calcresult{

width: 47%;
float: right;
margin: auto;

color: purple;
font-size: 40px;
}

#calcresult h5{
color: black;
font-size: 20px;
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




<form id = "calcform">

<h2>Player Names</h2>
<input type="text" id = "playerOneName" placeholder ="Player 1 Name...">
<input type="text" id = "playerTwoName" placeholder ="Player 2 Name...">
<input type="text" id = "playerThreeName" placeholder ="Player 3 Name...">
<input type="text" id = "playerFourName" placeholder ="Player 4 Name...">
<input type="text" id = "playerFiveName" placeholder ="Player 5 Name...">
<input type="text" id = "playerSixName" placeholder ="Player 6 Name...">
<input type="text" id = "playerSevenName" placeholder ="Player 7 Name...">
<input type="text" id = "playerEightName" placeholder ="Player 8 Name...">
<br><br>
<button type = "submit" value = "Start" id="startButton">Start Game!</button>

<h3>Current Player:</h3>

<h3>Choose an Action!</h3>
<button type = "submit" value = "Roll" id="rollButton">Roll</button>
<button type = "submit" value = "Skip" id="skipButton">Skip</button>

<h3>Roll Result:</h3>





<h3>Player Scores</h3>
<p>Player 1:</p>
<p>Player 2:</p>
<p>Player 3:</p>
<p>Player 4:</p>
<p>Player 5:</p>
<p>Player 6:</p>
<p>Player 7:</p>
<p>Player 8:</p>

<button type = "reset" value = "Clear" id="clearbttn">Reset</button>
</form>
</div>



</div>

</body>
</html>