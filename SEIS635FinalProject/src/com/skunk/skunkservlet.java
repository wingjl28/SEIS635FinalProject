package com.skunk;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;  


@WebServlet("/skunkservlet")
public class skunkservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public skunkservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Game game= (Game) session.getAttribute("game");
		boolean endGame = false;	
		int action = Integer.parseInt(request.getParameter("button"));

		if(action == 1) {
			
			String playerOneName = request.getParameter("playerOneName");
			String playerTwoName = request.getParameter("playerTwoName");
			String playerThreeName = request.getParameter("playerThreeName");
			String playerFourName = request.getParameter("playerFourName");
			String playerFiveName = request.getParameter("playerFiveName");
			String playerSixName = request.getParameter("playerSixName");
			String playerSevenName = request.getParameter("playerSevenName");
			String playerEightName = request.getParameter("playerEightName");
			
//			if (game != null) {
//				session.invalidate();
//				out.print("<p>The game has been reset!</p>");
//			}
			game = new Game(playerOneName, playerTwoName, playerThreeName, playerFourName, playerFiveName, playerSixName, playerSevenName, playerEightName);

			session.setAttribute("game", game);
			
			String outputString = "<br><div id = \"tableresult\"><table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
			int playerNum = 0;
			for (int i = 0; i < game.getPlayers().size(); i++) {
				playerNum++;
				outputString = outputString + "<td>"+game.getPlayers().get(i).getPlayerName()+"</td><td>"+game.getPlayers().get(i).getGameScore()+"</td><td>"+game.getPlayers().get(i).getChipCount()+"</td></tr>" ;
			}
			//			String outputString = "";
//			int playerNum = 0;
//			for (int i = 0; i < game.getPlayers().size(); i++) {
//				playerNum++;
//				outputString = outputString + "<p>Player "+ playerNum +": "+ game.getPlayers().get(i).getPlayerName() + "</p><p>Score: "+game.getPlayers().get(i).getGameScore()+"</p><p>Bank: " +game.getPlayers().get(i).getChipCount()+"</p>" ;
//			}
			out.print("<br>"+game.getCurrentPlayerName() + " To Start The Game!<br>"); 
			out.print(outputString + "</table><br><br></div>");
		}//-------END ACTION 1------------------------------ 
		
		
		//Roll button pressed.
		//This should roll for the current player, and perform necessary actions to that player depending on the result of the roll.
		if(action == 2) {
			session.setAttribute("game", game);
			
			if(game.getFinalTurn() == false) {
			
				String rollOutput = game.rollTurn();
				if(game.rollAgain()==false) {
					out.print("<br><table id=\\\"rollresulttable\\\"><tr><th>Current Player</th><th>");
					//out.print("<div id = \"playerresult\"><p>NEXT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p></div>");
					rollOutput = game.getPreviousPlayer().getPlayerName()+" has rolled a " + rollOutput;
				}
				else
					out.print("<br><table id=\\\"rollresulttable\\\"><tr><th>Current Player</th><th>");
//					out.print("<div id = \"playerresult\"><p>CURRENT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p></div>");
				out.print("Roll Result</th><th>Turn Score</th></tr><tr><td>" + game.getCurrentPlayerName()+"</td><td>" + rollOutput + "</td><td>" + game.getTurnScore()+ "</td></tr></table>");
				
//				out.print("<div id = \"rollresult\"><p>ROLL RESULT: </p><p>" + rollOutput + "</p></div>");
//				out.print("<div id = \"turnscore\"><p>TURN SCORE: </p><p>" + game.getTurnScore() + "</p></div>");
//	
				
				String outputString = "<div id = \"tableresult\"><br><table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
				int playerNum = 0;
				for (int i = 0; i < game.getPlayers().size(); i++) {
					playerNum++;
					outputString = outputString + "<td>"+game.getPlayerScoreOrder().get(i).getPlayerName()+"</td><td>"+game.getPlayerScoreOrder().get(i).getGameScore()+"</td><td>"+game.getPlayerScoreOrder().get(i).getChipCount()+"</td></tr>" ;
				}
				
				
	//			String outputString = "";
	//			int playerNum = 0;
	//			for (int i = 0; i < game.getPlayers().size(); i++) {
	//				playerNum++;
	//				outputString = outputString + "<p>Player "+ playerNum +": "+ game.getPlayers().get(i).getPlayerName() + "</p><p>Score: "+game.getPlayers().get(i).getGameScore() +"</p><p>Bank: " +game.getPlayers().get(i).getChipCount()+"</p>" ;
	//			}
				out.print(outputString + "</table><br><br></div><p></p>");
				//out.print("<p>Roll was pressed </p>");
			}//----END check for final turn == FALSE
			
			else if(game.getFinalTurn() && game.getVictory()==false) {
				
				if(game.getFinishedPlayers().contains(game.getCurrentPlayer()))
					game.endTurn();		
				else {
					String rollOutput = game.rollTurn();
					if(game.rollAgain()==false) {
						out.print("<br><br><table id=\\\"rollresulttable\\\"><tr><th>Current Player</th><th>");
						//out.print("<div id = \"playerresult\"><p>NEXT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p></div>");
						rollOutput = game.getPreviousPlayer().getPlayerName()+" has rolled a " + rollOutput;
					}
					else
						out.print("<br><br><table id=\\\"rollresulttable\\\"><tr><th>Current Player</th><th>");
						//out.print("<div id = \"playerresult\"><p>CURRENT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p></div>");
					//out.print("<div id = \"rollresult\"><p>ROLL RESULT: </p><p>" + rollOutput + "</p></div>");
					//out.print("<div id = \"turnscore\"><p>TURN SCORE: </p><p>" + game.getTurnScore() + "</p></div>");
					out.print("Roll Result</th><th>Turn Score</th></tr><tr><td>" + game.getCurrentPlayerName()+"</td><td>" + rollOutput + "</td><td>" + game.getTurnScore()+ "</td></tr></table><br><br>");

					
				}
				
				String outputString = "<div id = \"tableresult\"><table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
				int playerNum = 0;
				for (int i = 0; i < game.getPlayers().size(); i++) {
					playerNum++;
					outputString = outputString + "<td>"+game.getPlayerScoreOrder().get(i).getPlayerName()+"</td><td>"+game.getPlayerScoreOrder().get(i).getGameScore()+"</td><td>"+game.getPlayerScoreOrder().get(i).getChipCount()+"</td></tr>" ;
				}
				out.print(outputString + "</table></div>");
			}//end final turn
			
			else {
					out.print("<br>"+game.getWinner().getPlayerName() + " WON The Game!<br>"); 
					String outputString = "<div id = \"tableresult\"><br><table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
					int playerNum = 0;
					for (int i = 0; i < game.getPlayers().size(); i++) {
						playerNum++;
						outputString = outputString + "<td>"+game.getPlayerScoreOrder().get(i).getPlayerName()+"</td><td>"+game.getPlayerScoreOrder().get(i).getGameScore()+"</td><td>"+game.getPlayerScoreOrder().get(i).getChipCount()+"</td></tr>" ;
					}
					out.print(outputString + "</table><br><br></div>");
					
			}//end victory
		}//-----------------------END ACTION 2 ---------------------
		
		//Skip button pressed
		//This should do no further action to the current player, wrap up their turn, and move to next player.
		if(action == 3) {
			session.setAttribute("game", game);
			game.endTurn();
//			String outputString = "";
//			int playerNum = 0;
//			for (int i = 0; i < game.getPlayers().size(); i++) {
//				playerNum++;
//				outputString = outputString + "<p>Player "+ playerNum +": "+ game.getPlayers().get(i).getPlayerName() + "</p><p>Score: "+game.getPlayers().get(i).getGameScore()+"</p><p>Bank: " +game.getPlayers().get(i).getChipCount()+"</p>" ;
//			}
			
			String outputString = "<div id = \"tableresult\"><br><table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
			int playerNum = 0;
			for (int i = 0; i < game.getPlayers().size(); i++) {
				playerNum++;
				outputString = outputString + "<td>"+game.getPlayerScoreOrder().get(i).getPlayerName()+"</td><td>"+game.getPlayerScoreOrder().get(i).getGameScore()+"</td><td>"+game.getPlayerScoreOrder().get(i).getChipCount()+"</td></tr>" ;
			}
			//out.print("<div id = \"playerresult\"><p>NEXT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p></div>");
			//out.print("<div id = \"rollresult\"><p>ROLL RESULT: </p><p>"+game.getPreviousPlayer().getPlayerName()+" has skipped their Roll!</p></div>");
			//out.print("<div id = \"turnscore\"><p>TURN SCORE: </p><p>" + game.getTurnScore() + "</p></div>");
			out.print("<br><table id=\\\"rollresulttable\\\"><tr><th>Next Player</th><th>Roll Result</th><th>Turn Score</th></tr><tr><td>" + game.getCurrentPlayerName()+ "</td><td>"+ game.getPreviousPlayer().getPlayerName()+ " has skipped their Roll!</td><td>" + game.getTurnScore() + "</td></tr></table>");
			out.print(outputString + "</table><br><br></div><p></p>");
			//out.print("<p>Skip was pressed </p>");
			
		}
		
		//Reset Button pressed.
		//Clear session and inform user that the game was reset
		if(action == 4) {
			session.invalidate();
			out.print("<p>The game has been reset!</p>");
		}
			
	
	}
	
	
//	public String createTable() {
//
//		String returnTable;
//		session.setAttribute("game", game);
//		String outputString = "<table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
//		int playerNum = 0;
//		for (int i = 0; i < game.getPlayers().size(); i++) {
//			playerNum++;
//			outputString = outputString + "<td>"+game.getPlayers().get(i).getPlayerName()+"</td><td>"+game.getPlayers().get(i).getGameScore()+"</td><td>"+game.getPlayers().get(i).getChipCount()+"</td></tr></table>" ;
//		}
//		
//		return returnTable;		
//	}
	
    

}
