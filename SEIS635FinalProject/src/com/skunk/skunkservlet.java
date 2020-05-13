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
			
			if (game == null) {
				game = new Game(playerOneName, playerTwoName, playerThreeName, playerFourName, playerFiveName, playerSixName, playerSevenName, playerEightName);
			    session.setAttribute("game", game);
			}
			
			session.setAttribute("game", game);
			
			String outputString = "<table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
			int playerNum = 0;
			for (int i = 0; i < game.getPlayers().size(); i++) {
				playerNum++;
				outputString = outputString + "<td>"+game.getPlayers().get(i).getPlayerName()+"</td><td>"+game.getPlayers().get(i).getGameScore()+"</td><td>"+game.getPlayers().get(i).getChipCount()+"</td></tr>" ;
			}
			outputString = outputString + "</table>";
//			String outputString = "";
//			int playerNum = 0;
//			for (int i = 0; i < game.getPlayers().size(); i++) {
//				playerNum++;
//				outputString = outputString + "<p>Player "+ playerNum +": "+ game.getPlayers().get(i).getPlayerName() + "</p><p>Score: "+game.getPlayers().get(i).getGameScore()+"</p><p>Bank: " +game.getPlayers().get(i).getChipCount()+"</p>" ;
//			}
			out.print("<p>CURRENT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p>"); 
			out.print(outputString + "<p>Number of Players:" + game.getNumberOfPlayers());
		} 
		//Roll button pressed.
		//This should roll for the current player, and perform necessary actions to that player depending on the result of the roll.
		if(action == 2) {
			session.setAttribute("game", game);
			
			String rollOutput = game.rollTurn();


			out.print("<p>ROLL RESULT: </p><p>" + rollOutput + "</p>");
			out.print("<p>TURN SCORE: </p><p>" + game.getTurnScore() + "</p>");
			if(game.rollAgain()==false) {
				out.print("<p>NEXT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p>");
			}
			else
				out.print("<p>CURRENT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p>");
			
			String outputString = "<table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
			int playerNum = 0;
			for (int i = 0; i < game.getPlayers().size(); i++) {
				playerNum++;
				outputString = outputString + "<td>"+game.getPlayers().get(i).getPlayerName()+"</td><td>"+game.getPlayers().get(i).getGameScore()+"</td><td>"+game.getPlayers().get(i).getChipCount()+"</td></tr>" ;
			}
			
//			String outputString = "";
//			int playerNum = 0;
//			for (int i = 0; i < game.getPlayers().size(); i++) {
//				playerNum++;
//				outputString = outputString + "<p>Player "+ playerNum +": "+ game.getPlayers().get(i).getPlayerName() + "</p><p>Score: "+game.getPlayers().get(i).getGameScore() +"</p><p>Bank: " +game.getPlayers().get(i).getChipCount()+"</p>" ;
//			}
			out.print(outputString + "<p>Number of Players:" + game.getNumberOfPlayers());
			out.print("<p>Roll was pressed </p>");
			
		}
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
			
			String outputString = "<table><tr><th>Player Name</th><th>Player Score</th><th>Player Bank</th></tr><tr>";
			int playerNum = 0;
			for (int i = 0; i < game.getPlayers().size(); i++) {
				playerNum++;
				outputString = outputString + "<td>"+game.getPlayers().get(i).getPlayerName()+"</td><td>"+game.getPlayers().get(i).getGameScore()+"</td><td>"+game.getPlayers().get(i).getChipCount()+"</td></tr>" ;
			}
			
			out.print("<p>ROLL RESULT: </p><p>"+game.getPreviousPlayer().getPlayerName()+" has skipped their Roll!</p>");
			out.print("<p>TURN SCORE: </p><p>" + game.getTurnScore() + "</p>");
			out.print("<p>NEXT PLAYER: </p><p>" + game.getCurrentPlayerName() + "</p>");
			out.print(outputString + "<p>Number of Players:" + game.getNumberOfPlayers());
			out.print("<p>Skip was pressed </p>");
			
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
