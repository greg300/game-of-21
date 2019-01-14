package gameof21;

import java.awt.Color;

import TurtleGraphics.KeyboardReader;
import TurtleGraphics.StandardPen;

public class GameOf21 
{
	public static void main(String[] args) 
	{
		KeyboardReader reader = new KeyboardReader();
		StandardPen pen = new StandardPen();
		Cards object = new Cards();
		
		int chips = 100;
		char replay;
		
		boolean[][] cardsUsed;
		
		System.out.println("----------WELCOME TO GAME OF 21----------");
		
		do
		{
			pen.move(1000,-1000);
			pen.down();
			pen.setWidth(10000);
			pen.setColor(Color.white);
			pen.setDirection(90);
			pen.move(800);
			pen.setDirection(270);
			pen.move(800);
			pen.home();
			
			char rules, hit;
			int hits = 0, dealerTotal = 0, playerTotal = 0;
			int dealerCard1, dealerCard2, playerCard1, playerCard2, hitCard, dealerHitCard;
			int wager, playerAces = 0, dealerAces = 0;
			boolean playerWin = false, dealerWin = false;
			cardsUsed = new boolean[4][13];
			
			System.out.println("\nWould you like to hear the rules before playing? (Y or N)");
			rules = reader.readChar();

			if (rules == 'Y')
			{
				System.out.println("----------RULES----------");
				System.out.println("\nObjective:");
				System.out.println("The aim of the game is to accumulate a higher point total than the dealer, but without going over 21.");
				System.out.println("Totals are computed by adding together the values of your individual cards.");
				System.out.println("\nCard Values:");
				System.out.println("2 through 10 have their face value.");
				System.out.println("J, Q, and K are worth 10 points each.");
				System.out.println("Ace is worth either 1 or 11 points.");
				System.out.println("\nPlayer's Turns:");
				System.out.println("The player is dealt two cards face up, and their value is added together.");
				System.out.println("If the player does not think they have enough points to top the dealer's total, they may 'hit' to obtain another card.");
				System.out.println("If the player's total surpasses 21, they automatically lose that round.");
				System.out.println("If the player's total surpasses 21 while one or more of their cards is an ace, one of these cards may become worth 1 instead of 11.");
				System.out.println("\nDealer's Turns:");
				System.out.println("The dealer is dealt two cards, one face down and one facing up, and the player only sees the value of the visible card.");
				System.out.println("The dealer hits in a similar way as the player, taking cards until he reaches or surpasses 21.");
				System.out.println("The same rules apply to the dealer for aces.");
				System.out.println("\nWagering:");
				System.out.println("Before each round, the player must choose an amount to wager for that game.");
				System.out.println("If the player loses the round, their wager will be lost.");
				System.out.println("If the player wins the round, their wager will effectively be doubled.");
				System.out.println("If the player and the dealer tie for the round, the player will receive their wager back.");
				
				System.out.println("\nTo begin wagering, press Enter.");
				reader.readLine();
			}
			else if (rules == 'N')
			{
				System.out.println("\nTo begin wagering, press Enter.");
				reader.readLine();
			}
			
			System.out.println("You have: " + chips + " chips.");
			System.out.println("How much would you like to wager for this round?");
			wager = reader.readInt();
			
			while (wager > chips || wager <= 0)
			{
				System.out.println("That is not a valid wager.");
				System.out.println("Enter a valid wager:");
				wager = reader.readInt();
			}
			chips = chips - wager;
			
			System.out.println("You have wagered " + wager + " chips. If you win, you will receive " + 2 * wager + " chips.");
			System.out.println("\nTo begin playing, press Enter.");
			reader.readLine();
			
			object.DrawBlank(pen);
			dealerCard1 = object.DrawCard(pen, cardsUsed);
			if (dealerCard1 == 11)
			{
				dealerAces++;
			}
			dealerTotal = dealerTotal + dealerCard1;
			
			pen.up();
			
			pen.setDirection(180);
			pen.move(400);
			pen.setDirection(270);
			pen.move(300);
			
			playerCard1 = object.DrawCard(pen, cardsUsed);
			if (playerCard1 == 11)
			{
				playerAces++;
			}
			playerCard2 = object.DrawCard(pen, cardsUsed);
			if (playerCard2==11)
			{
				playerAces++;
			}
			playerTotal = playerCard1 + playerCard2;
			if (playerAces >= 1 && playerTotal > 21)
			{
				playerTotal = playerTotal - 10;
				playerAces--;
			}
			
			
			System.out.println("Dealer has " + dealerTotal + " showing.");
			System.out.println("You have " + playerTotal + ".");
			
			System.out.println("Would you like to Hit (H) or Stay (S)?");
			hit = reader.readChar();
			
			while (hit!='S')
			{
				hitCard = object.DrawCard(pen, cardsUsed);
				if (hitCard==11)
				{
					playerAces++;
				}
				playerTotal = playerTotal + hitCard;
				if (playerAces >= 1 && playerTotal > 21)
				{
					playerTotal = playerTotal - 10;
					playerAces--;
				}
				
				System.out.println("Dealer has " + dealerTotal + " showing.");
				System.out.println("You have " + playerTotal + ".");
				hits++;
				if (playerTotal > 21)
				{
					System.out.println("Sorry, you have busted. \n");
					break;
				}
				else if (playerTotal <= 21)
				{
					System.out.println("Would you like to Hit (H) or Stay (S)?");
					hit = reader.readChar();
				}
			}
			
			if (hits == 1)
			{
				pen.setDirection(180);
				pen.move(0);
			}
			else if (hits == 0)
			{
				pen.setDirection(180);
				pen.move(0);
			}

			//White out
			pen.setWidth(200);
			pen.setColor(Color.white);
			pen.setDirection(180);
			pen.move(150*hits+50*hits+480);
			pen.setDirection(90);
			pen.move(380);
			pen.down();
			pen.setDirection(90);
			pen.move(150);
			pen.up();

			//Go back
			pen.setDirection(270);
			pen.move(230);
			pen.setDirection(0);
			pen.move(80);
			dealerCard2=object.DrawCard(pen, cardsUsed);

			if (dealerCard1 == 11)
			{
				dealerAces++;
			}
			dealerTotal = dealerTotal + dealerCard2;
			if (dealerAces >= 1 && dealerTotal > 21)
			{
				dealerTotal = dealerTotal - 10;
				dealerAces--;
			}
			System.out.println("Dealer's hidden card is " + dealerCard2 + ".");
			
			pen.setWidth(5);
			
			pen.setDirection(0);
			pen.move(200);

			while (dealerTotal <= 16)
			{
				dealerHitCard = object.DrawCard(pen, cardsUsed);
				if (dealerHitCard == 11)
				{
					dealerAces++;
				}
				dealerTotal = dealerTotal + dealerHitCard;
				if (dealerAces >= 1 && dealerTotal > 21)
				{
					dealerTotal = dealerTotal - 10;
					dealerAces--;
				}
				System.out.println("Dealer hits: the card is " + dealerHitCard + ".");
				
			}
			System.out.println("\nDealer has " + dealerTotal + ".");
			System.out.println("You have " + playerTotal + ".");
			
			if (dealerTotal > 21 && playerTotal <= 21)
			{
				System.out.println("Dealer has busted. You win!");
				dealerWin = false;
				playerWin = true;
			}
			else if (playerTotal > 21 && dealerTotal <= 21)
			{
				System.out.println("You have busted. You lose!");
				dealerWin = true;
				playerWin = false;
			}
			else if(dealerTotal > 21 && playerTotal > 21)
			{
				System.out.println("You and the Dealer have busted. It's a push!");
				dealerWin = false;
				playerWin = false;
			}
			else if (dealerTotal == playerTotal && dealerTotal <= 21 && playerTotal <= 21)
			{
				System.out.println("You and the Dealer have tied!");
				dealerWin = true;
				playerWin = true;
			}
			else if (dealerTotal > playerTotal && dealerTotal <= 21)
			{
				System.out.println("You lose!");
				dealerWin = true;
				playerWin = false;
			}
			else if (dealerTotal < playerTotal && playerTotal <= 21)
			{
				System.out.println("You win!");
				dealerWin = false;
				playerWin = true;
			}
			
			if (dealerWin && playerWin)
			{
				System.out.println("You receive your bet back.");
				chips = chips + wager;
			}
			else if (playerWin)
			{
				System.out.println("You receive two times your bet!");
				chips = chips + (wager * 2);
			}
			else if (dealerWin)
			{
				System.out.println("You lose all of your bet.");
			}
			else
			{
				System.out.println("You receive your bet back.");
				chips = chips + wager;
			}
			
			if (chips == 0)
			{
				System.out.println("\nSorry, you have no more chips. Game over!");
				break;
			}
			else
			{
				System.out.println("\nWould you like to play again? (Y or N)");
				replay = reader.readChar();
			}
		}
		while (replay == 'Y');
		
		System.out.println("\nThanks for playing!");
		System.out.println("You ended with: " + chips + " chips.");
	}
}