/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{
      Scanner in = new Scanner(System.in);
      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
/*
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        
        play = false;
      }
*/
  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 15;
    int py = 15; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jumpright", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game
    boolean play = true;
    while (play)
    {
      String input = UserInput.getValidInput(validCommands);
      if (input.equals("right") || input.equals("r"))
      {
        score -= game.movePlayer(60, 0);
        if (!game.isTrap(px + m, py))
          px += m;
      }
      else if (input.equals("left") || input.equals("l"))
      {
        score -= game.movePlayer(-60, 0);
        if (!game.isTrap(px - m, py))
          px -= m;
      }
      else if (input.equals("up") || input.equals("u"))
      {
        score -= game.movePlayer(0, -60);
        if (!game.isTrap(px, py + 60))
          py += 60;
      }
      else if (input.equals("down") || input.equals("d"))
      {
        score -= game.movePlayer(0, 60);
        if (!game.isTrap(px, py - 60))
          py -= 60;
      }
      else if (input.equals("jump") || input.equals("jumpup") || input.equals("ju"))
      {
        score -= game.movePlayer(0, 120);
        if (!game.isTrap(px, py + 120))
          py += 120;
      }
      else if (input.equals("jumpdown") || input.equals("jd"))
      {
        score -= game.movePlayer(0, -120);
        if (!game.isTrap(px, py - 120))
          py -= 120;
      }
      else if (input.equals("jumpright") || input.equals("jr"))
      {
        score -= game.movePlayer(120, 0);
        if (!game.isTrap(px + 120, py))
          px += 120;
      }
      else if (input.equals("jumpleft") || input.equals("jl"))
      {
        score -= game.movePlayer(-120, 0);
        if (!game.isTrap(px - 120, py))
          px -= 120;
      }
      else if (input.equals("pickup") || input.equals("p"))
      {
        score += game.pickupPrize();
      }
      else if (input.equals("quit") || input.equals("q"))
      {
        play = false;
      }
      else if (input.equals("replay"))
      {
        game.replay();
      }
      else if (input.equals("help") || input.equals("?"))
      {
        System.out.print("Valid commands: ");
        for (String x : validCommands)
          System.out.print(x + ", ");
      }
     if (px > 7*m)
      {
        play = false;
      }

    }
  
   
  


  

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

        