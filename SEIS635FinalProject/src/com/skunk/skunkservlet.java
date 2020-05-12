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
		//HttpSession session = request.getSession();
		
		int action = Integer.parseInt(request.getParameter("button"));
		
//		Player playerOneName = new Player(request.getParameter("playerOneName"));
//		Player playerTwoName = new Player(request.getParameter("playerTwoName"));
//		Player playerThreeName = new Player(request.getParameter("playerThreeName"));
//		Player playerFourName = new Player(request.getParameter("playerFourName"));
//		Player playerFiveName = new Player(request.getParameter("playerFiveName"));
//		Player playerSixName = new Player(request.getParameter("playerSixName"));
//		Player playerSevenName = new Player(request.getParameter("playerSevenName"));
//		Player playerEightName = new Player(request.getParameter("playerEightName"));
		
//		Player[] tempPlayers = new Player[8];
//		tempPlayers[0] = playerOneName;
//		tempPlayers[1] = playerTwoName;
//		tempPlayers[2] = playerThreeName;
//		tempPlayers[3] = playerFourName;
//		tempPlayers[4] = playerFiveName;
//		tempPlayers[5] = playerSixName;
//		tempPlayers[6] = playerSevenName;
//		tempPlayers[7] = playerEightName;
//			
//		ArrayList<Player> players = new ArrayList<Player>();
//		
//		for (int i = 0; i < tempPlayers.length; i++) {
//			if (!tempPlayers[i].getPlayerName().isEmpty()) {
//				players.add(tempPlayers[i]);
//			}
//		}
		
		
		//out.print(playerOneName.getPlayerName());	

		//Game newGame = new Game(players,players.size(), fairDice);
		
		//newGame.startGame();
		
		if(action == 1) {
			
			
			out.print("<p>Start was pressed </p>");
			
			
			
		//out.print("<h3>Current Player:</h3><h3>Roll Result:</h3><h3>Player Scores</h3><p>Player 1:</p>"+ playerOneName.getPlayerName()+ "<p>Player 2:</p>"+playerTwoName.getPlayerName()+"<p>Player 3:</p>"+playerThreeName.getPlayerName()+"<p>Player 4:</p><p>Player 5:</p><p>Player 6:</p><p>Player 7:</p><p>Player 8:</p>");
		} 
		if(action == 2) {
			
			
			out.print("<p>Roll was pressed </p>");
			
			
			
		//out.print("<h3>Current Player:</h3><h3>Roll Result:</h3><h3>Player Scores</h3><p>Player 1:</p>"+ playerOneName.getPlayerName()+ "<p>Player 2:</p>"+playerTwoName.getPlayerName()+"<p>Player 3:</p>"+playerThreeName.getPlayerName()+"<p>Player 4:</p><p>Player 5:</p><p>Player 6:</p><p>Player 7:</p><p>Player 8:</p>");
		}
		
		if(action == 3) {
			
			
			out.print("<p>Skip was pressed </p>");
			
			
			
		//out.print("<h3>Current Player:</h3><h3>Roll Result:</h3><h3>Player Scores</h3><p>Player 1:</p>"+ playerOneName.getPlayerName()+ "<p>Player 2:</p>"+playerTwoName.getPlayerName()+"<p>Player 3:</p>"+playerThreeName.getPlayerName()+"<p>Player 4:</p><p>Player 5:</p><p>Player 6:</p><p>Player 7:</p><p>Player 8:</p>");
		}
		
		if(action == 4) {
			
			out.print("<p>Reset was pressed </p>");
		}
			
			//tempCounter = (counter) request.getSession().getAttribute("counter");
			//(counter) session.getAttribute("counter");
			//counter.removeCount();
			//out.print("The counter is </p>" + counter.getValue());
		//out.print("Player 7:</p><p>Player 8:</p>");
		
		//out.print("<h5>Monthly Payment:</h5> " + monthlyPayment + "<h5>Total Payment is:</h5> " + totalPayment + "<h5>Total Interest Paid is:</h5> " + interestPayment);
		
		
	
	}

}
