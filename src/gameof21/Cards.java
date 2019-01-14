package gameof21;

import java.awt.Color;
import java.util.Random;

import TurtleGraphics.StandardPen;

public class Cards 
{
	public int DrawCard(StandardPen pen, boolean[][] usedCards)
	{
		Random generator = new Random();
		
		int number, suit, trueValue = 0;
		String cardValue = "";
		
		do
		{
			number = generator.nextInt(13) + 1;
			suit = generator.nextInt(4) + 1;
		} 
		while (usedCards[suit-1][number-1]);
		
		//Card Values
		if (number == 1)
		{
			trueValue = 11;
			cardValue = cardValue + "A";
		}
		else if (number >= 2 && number <= 10)
		{
			trueValue = number;
			cardValue = cardValue + number;
		}
		else if (number == 11)
		{
			trueValue = 10;
			cardValue = cardValue + "J";
		}
		else if (number == 12)
		{
			trueValue = 10;
			cardValue = cardValue + "Q";
		}
		else if (number == 13)
		{
			trueValue = 10;
			cardValue = cardValue + "K";
		}

		pen.down();
		
		pen.setWidth(5);
		pen.setColor(Color.gray);
		pen.setDirection(90);
		pen.move(250);
		pen.setDirection(180);
		pen.move(150);
		pen.setDirection(270);
		pen.move(250);
		pen.setDirection(0);
		pen.move(150);
		
		pen.up();
		pen.setDirection(180);
		pen.move(25);
		pen.setDirection(90);
		pen.move(10);
		
		if (suit == 1 || suit == 3)
		{
			pen.setColor(Color.red);
		}
		else if (suit == 2 || suit == 4)
		{
			pen.setColor(Color.black);
		}
		
		if (number == 1)
		{
			Ace(pen);
		}
		else if (number == 11)
		{
			Jack(pen);
		}
		else if (number == 12)
		{
			Queen(pen);
		}
		else if (number == 13)
		{
			King(pen);
		}
		else
		{
			pen.drawString(cardValue);
			
			pen.move(220);
			pen.setDirection(180);
			pen.move(115);
			pen.drawString(cardValue);
			
			pen.setDirection(270);
			pen.move(95);
			pen.setDirection(0);
			pen.move(65);
		}
		
		//Suits
		if (suit == 1)
		{
			Diamond(pen);
		}
		else if (suit == 2)
		{
			Spade(pen);
		}
		else if (suit == 3)
		{
			Heart(pen);
		}
		else if (suit == 4)
		{
			Club(pen);
		}
		
		//Add this unique card as being used
		usedCards[suit-1][number-1] = true;
		
		return(trueValue);
	}
	
	public void Diamond(StandardPen pen)
	{
		pen.setColor(Color.red);
		pen.setWidth(65);
		pen.down();
		pen.setDirection(225);
		pen.move(6);
		pen.up();
		pen.setWidth(5);
		pen.setDirection(270);
		pen.move(131);
		pen.setDirection(0);
		pen.move(80);
		pen.move(200);
	}
	
	public void Heart(StandardPen pen)
	{
		pen.setDirection(180);
		pen.move(2);
		pen.setDirection(90);
		pen.move(16);
		pen.setColor(Color.red);
		pen.setWidth(10);
		pen.down();
		pen.setDirection(90);
		for (int count = 0; count <= 180; count++)
		{
			pen.move(0.3);
			pen.turn(1);
		}
		pen.setDirection(270);
		for (int count = 0; count <= 20; count++)
		{
			pen.move(3.5);
			pen.turn(3);
		}
		pen.setDirection(30);
		for (int count = 0; count <= 20; count++)
		{
			pen.move(3.5);
			pen.turn(3);
		}
		pen.setDirection(90);
		for (int count = 0;count <= 180; count++)
		{
			pen.move(0.3);
			pen.turn(1);
		}
		pen.up();
		pen.setDirection(90);
		pen.move(7);
		pen.setDirection(180);
		pen.move(33);
		pen.down();
		pen.setWidth(10);
		pen.setDirection(0);
		pen.move(55);
		pen.setWidth(20);
		pen.setDirection(270);
		pen.move(15);
		pen.setDirection(180);
		pen.move(45);
		pen.setDirection(270);
		pen.move(15);
		pen.setDirection(0);
		pen.move(42);
		pen.setDirection(180);
		pen.move(5);
		pen.setDirection(270);
		pen.move(15);
		pen.setDirection(180);
		pen.move(30);
		pen.setDirection(0);
		pen.move(16);
		pen.setDirection(270);
		pen.move(15);
		
		pen.up();
		pen.setWidth(5);
		pen.setDirection(270);
		pen.move(98);
		pen.setDirection(0);
		pen.move(78);
		pen.move(200);
	}
	
	public void Club(StandardPen pen)
	{
		pen.setDirection(0);
		pen.move(18);
		pen.setDirection(90);
		pen.move(10);
		pen.setColor(Color.black);
		pen.setWidth(6);
		pen.setDirection(60);
		pen.down();
		for (int count = 0; count <= 230; count++)
		{
			pen.move(0.3);
			pen.turn(1);
		}
		pen.setDirection(180);
		for (int count = 0; count <= 270; count++)
		{
			pen.move(0.25);
			pen.turn(1);
		}
		pen.setDirection(270);
		for (int count = 0; count <= 270; count++)
		{
			pen.move(0.25);
			pen.turn(1);
		}
		pen.setWidth(10);
		pen.setDirection(180);
		pen.move(15);
		pen.setDirection(270);
		pen.move(30);
		pen.setWidth(5);
		pen.setDirection(0);
		pen.move(5);
		pen.setDirection(270);
		for (int count = 0; count <= 15; count++)
		{
			pen.move(2);
			pen.turn(1);
		}
		pen.setDirection(180);
		pen.move(20);
		pen.setDirection(75);
		for (int count = 0; count <= 15; count++)
		{
			pen.move(2);
			pen.turn(1);
		}
		pen.setDirection(270);
		pen.move(30);
		pen.setDirection(0);
		pen.move(10);
		pen.setDirection(90);
		pen.move(30);
		pen.setDirection(180);
		pen.move(5);
		pen.setDirection(270);
		pen.move(30);
		pen.setDirection(90);
		pen.move(75);
		pen.setWidth(15);
		pen.setDirection(180);
		pen.move(5);
		pen.setDirection(0);
		pen.move(18);
		pen.setDirection(270);
		pen.move(10);
		pen.setDirection(180);
		pen.move(20);
		pen.setDirection(270);
		pen.move(10);
		pen.setDirection(180);
		pen.move(8);
		pen.setDirection(0);
		pen.move(35);
		pen.setDirection(270);
		pen.move(10);
		pen.setDirection(180);
		pen.move(36);
		pen.setDirection(270);
		pen.move(6);
		pen.setDirection(0);
		pen.move(36);
		
		pen.up();
		pen.setWidth(5);
		pen.setDirection(270);
		pen.move(126);
		pen.setDirection(0);
		pen.move(55);
		pen.move(200);
	}

	public void Spade(StandardPen pen)
	{
		pen.setColor(Color.black);
		pen.setWidth(6);
		pen.setDirection(90);
		pen.move(30);
		pen.down();
		pen.setDirection(225);
		pen.move(35);
		for (int count = 0; count <= 180; count++)
		{
			pen.move(0.3);
			pen.turn(1);
		}
		pen.setDirection(315);
		for (int count = 0; count <= 180; count++)
		{
			pen.move(0.3);
			pen.turn(1);
		}
		pen.setDirection(135);
		pen.move(35);
		pen.setDirection(270);
		pen.move(50);
		for (int count = 0; count <= 20; count++)
		{
			pen.move(1.5);
			pen.turn(2);
		}
		pen.setDirection(180);
		pen.move(25);
		pen.setDirection(50);
		for (int count = 0; count <= 20; count++)
		{
			pen.move(1.5);
			pen.turn(2);
		}
		pen.setDirection(90);
		pen.move(45);
		pen.setDirection(0);
		pen.move(8);
		pen.setDirection(270);
		pen.move(10);
		pen.setWidth(10);
		pen.setDirection(180);
		pen.move(13);
		pen.setDirection(0);
		pen.move(18);
		pen.setDirection(270);
		pen.move(10);
		pen.setDirection(180);
		pen.move(30);
		pen.setDirection(0);
		pen.move(40);
		pen.setDirection(270);
		pen.move(10);
		pen.setDirection(180);
		pen.move(40);
		pen.setDirection(0);
		pen.move(45);
		pen.setDirection(270);
		pen.move(10);
		pen.setWidth(12);
		pen.setDirection(180);
		pen.move(45);
		pen.setDirection(0);
		pen.move(20);
		pen.setDirection(270);
		pen.move(25);
		pen.up();
		
		pen.move(95);
		pen.setDirection(0);
		pen.move(76);
		pen.move(200);
	}
	
	public void DrawBlank(StandardPen pen)
	{
		Random generator = new Random();
		
		pen.down();
		
		pen.setWidth(5);
		pen.setColor(Color.gray);
		pen.setDirection(90);
		pen.move(250);
		pen.setDirection(180);
		pen.move(150);
		pen.setDirection(270);
		pen.move(250);
		pen.setDirection(0);
		pen.move(150);
		
		pen.up();
		pen.setDirection(90);
		pen.move(246);
		pen.setDirection(180);
		pen.move(150);
		
		for (int count = 0; count <= 28; count++)
		{
			int color;
			color = generator.nextInt(6) + 1;
			
			if (color == 1)
			{
				pen.setColor(Color.green);
			}
			else if (color == 2)
			{
				pen.setColor(Color.blue);
			}
			else if (color == 3)
			{
				pen.setColor(Color.red);
			}
			else if (color == 4)
			{
				pen.setColor(Color.cyan);
			}
			else if (color == 5)
			{
				pen.setColor(Color.yellow);
			}
			else if (color == 6)
			{
				pen.setColor(Color.magenta);
			}
			
			pen.setWidth(2);
			pen.setDirection(0);
			pen.move(5);
			pen.down();
			pen.setDirection(270);
			pen.move(243);
			pen.up();
			pen.setDirection(90);
			pen.move(243);
		}
		
		pen.setWidth(5);
		pen.setDirection(270);
		pen.move(246);
		pen.up();
		pen.setDirection(0);
		pen.move(207);
		
	}
	public void Jack(StandardPen pen)
	{
		pen.setWidth(5);
		pen.setDirection(0);
		pen.move(5);
		pen.setDirection(90);
		pen.move(42);
		pen.down();

		//J
		pen.setDirection(0);
		pen.move(10);
		pen.setDirection(180);
		pen.move(20);
		pen.setDirection(0);
		pen.move(10);
		pen.setDirection(270);
		pen.move(30);
		for (int count = 0; count <= 180; count++)
		{
			pen.move(0.15);
			pen.turn(-1);
		}
		
		pen.up();
		pen.setDirection(90);
		pen.move(222);
		pen.setDirection(180);
		pen.move(87);

		//J
		pen.down();
		pen.setDirection(0);
		pen.move(10);
		pen.setDirection(180);
		pen.move(20);
		pen.setDirection(0);
		pen.move(10);
		pen.setDirection(270);
		pen.move(30);
		for (int count = 0; count <= 180; count++)
		{
			pen.move(0.15);
			pen.turn(-1);
		}
		pen.up();
		pen.setDirection(270);
		pen.move(80);
		pen.setDirection(0);
		pen.move(65);
	}
	
	public void Queen(StandardPen pen)
	{
		pen.setWidth(5);
		pen.setDirection(0);
		pen.move(10);
		
		pen.down();
		pen.setDirection(135);
		pen.move(14);
		pen.setDirection(315);
		pen.move(7);
		pen.up();
		pen.setDirection(90);
		pen.move(10);
		pen.down();
		pen.setDirection(90);
		for (int count = 0; count <= 360; count++)
		{
			pen.move(0.25);
			pen.turn(1);
		}
		pen.up();
		pen.setDirection(90);
		pen.move(185);
		pen.setDirection(180);
		pen.move(84);

		//Q
		pen.down();
		pen.setDirection(135);
		pen.move(14);
		pen.setDirection(315);
		pen.move(7);
		pen.up();
		pen.setDirection(90);
		pen.move(10);
		pen.down();
		pen.setDirection(90);
		for (int count = 0; count <= 360; count++)
		{
			pen.move(0.25);
			pen.turn(1);
		}
		pen.up();
		pen.setDirection(270);
		pen.move(90);
		pen.setDirection(0);
		pen.move(35);
	}

	public void King(StandardPen pen)
	{
		pen.setWidth(5);
		pen.setDirection(180);
		pen.move(10);
		pen.setDirection(270);
		pen.move(0);
		
		//K
		pen.down();
		pen.setDirection(90);
		pen.move(40);
		pen.setDirection(270);
		pen.move(20);
		pen.setDirection(45);
		pen.move(27);
		pen.setDirection(225);
		pen.move(27);
		pen.setDirection(315);
		pen.move(27);
		pen.setDirection(135);
		pen.move(27);
		pen.up();
		
		pen.setDirection(90);
		pen.move(170);
		pen.setDirection(180);
		pen.move(100);
		
		//K
		pen.down();
		pen.setDirection(90);
		pen.move(40);
		pen.setDirection(270);
		pen.move(20);
		pen.setDirection(45);
		pen.move(27);
		pen.setDirection(225);
		pen.move(27);
		pen.setDirection(315);
		pen.move(27);
		pen.setDirection(135);
		pen.move(27);
		
		pen.up();
		pen.setDirection(270);
		pen.move(85);
		pen.setDirection(0);
		pen.move(60);
	}

	public void Ace(StandardPen pen)
	{
		pen.setWidth(5);
		pen.setDirection(0);
		pen.move(10);
		pen.setDirection(90);
		pen.move(0);
		//A
		pen.down();
		pen.setDirection(115);
		pen.move(30);
		pen.setDirection(245);
		pen.move(30);
		pen.setDirection(65);
		pen.move(15);
		pen.setDirection(0);
		pen.move(10);
		
		pen.up();
		pen.setDirection(90);
		pen.move(190);
		pen.setDirection(180);
		pen.move(90);
		//A
		pen.down();
		pen.setDirection(115);
		pen.move(30);
		pen.setDirection(245);
		pen.move(30);
		pen.setDirection(65);
		pen.move(15);
		pen.setDirection(0);
		pen.move(10);
		
		pen.up();
		pen.setDirection(270);
		pen.move(90);
		pen.setDirection(0);
		pen.move(50);
	}
}