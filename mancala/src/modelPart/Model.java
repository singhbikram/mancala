package modelPart;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Bikram Singh
 * Start Date : October 28, 2015
 *
 */

public class Model implements InterfaceModel
{
	int[] data;
	boolean finish;
	int stones; 
	ArrayList<ChangeListener> listeners;
	
	public Model()
	{
		stones = 0;
		data = new int[14];
		for(int i = 0; i < data.length-1; i++)
		{
			data[i] = stones;
			if(i == 6)
				data[i] = 0;
		}
		finish = false;
		listeners = new ArrayList<ChangeListener>();
	}
	
	 public void addChangeListener(ChangeListener listener)
	 {
	    listeners.add(listener);
	 }
	 
	
	public void setNumberOfStones(int stones){
		this.stones = stones;
	}
	
	public void move(int player)
	{
		int startIndex = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nYour move, Enter the Pit Number : ");
		startIndex = sc.nextInt();
		if((player == 1) && (startIndex > 6))
			startIndex = 6;
		if((player == 2) && (startIndex < 6))
			startIndex = 13;
		
		while((startIndex == 6 || startIndex == 13))
		{
			System.out.println("\nWrong Pit!, Enter your Pit Number : ");
			startIndex = sc.nextInt();			
			if((player == 1) && (startIndex > 6))
				startIndex = 6;
			if((player == 2) && (startIndex < 6))
				startIndex = 13;
		}
		
		int pitStones = data[startIndex];
		System.out.println("startIndex: "+startIndex+"startData: "+data[startIndex]+"modulus: "+(data.length-1));
		int endIndex = (startIndex + data[startIndex]) % (data.length-1);
		int endIndexData = data[endIndex];
		data[startIndex] = 0;
		for(int i = startIndex+1; i <= pitStones+startIndex ; i++ )
		{
			int pitNum = i; 
			if(player == 1 && pitNum == 13)
				pitNum++;
			if(player == 2 && pitNum == 6)
				pitNum++;
			if(pitNum >= data.length)
				pitNum = pitNum % (data.length);			
			data[pitNum]++;
		}
		
		//player gets another chance to play 
	    //if ending pit is his own mancala
	    if((endIndex == 6 && player ==1) || (endIndex == 13 && player ==2)){
	    	System.out.println("Got your Mancala!");
	    	move(player);
	    }
	    System.out.println("EndIndex : "+ endIndex);
	    if((endIndexData == 0 && endIndex < 6) && player == 1 ){
	    	int mancalaStones = 1 + data[12 - endIndex];
	    	System.out.println("mancalaStones : "+ mancalaStones);
	    	data[6] = data[6] + mancalaStones;
	    	data[endIndex] = 0;
	    	data[12 - endIndex] = 0;
	    }
	    if((endIndexData == 0 && endIndex > 6) && player == 2 ){
	    	int mancalaStones = 1 + data[13] + data[12 - endIndex];
	    	data[13] = data[13] + mancalaStones;
	    	data[endIndex] = 0;
	    	data[12 - endIndex] = 0;
	    }
	    
	    if(isFinish())
		{
			System.out.println("Game Over!");
			declareWinner();
		}
		
		ChangeEvent event = new ChangeEvent(this);
	    for (ChangeListener listener : listeners)
	       listener.stateChanged(event);
	    
	    
	}
	
	public void attach(ChangeListener listener)
	{
		listeners.add(listener);
	}
	
	public boolean isFinish()
	{
		boolean result = false;
		int player1Pits = 0;
		int player2Pits = 0;
		for(int i = 0; i < data.length-1; i++)
		{	
			if(i<6)
				player1Pits += data[i];
			
			if(i>6)
				player2Pits += data[i];
						
		}
		
		if(player1Pits == 0 || player2Pits == 0)
		{
			data[6] = data[6] +player1Pits;
			data[13] = data[13] + player2Pits;
			for(int i = 0; i < data.length-2; i++)
			{
				if(i == 6 );
				else
				data[i] = 0;	
			}
			result = true;
		}
		return result;
	}
	
	public void declareWinner()
	{
		if(data[6] > data[13])
			System.out.println("Player A is the Winner!");
		else
			System.out.println("Player B is the Winner!");
		System.out.println("Player A got : "+data[6]+" stones");
		System.out.println("Player B got : "+data[13]+" stones");
	}
	
	 public void display()
	   {
				System.out.println("");
				for(int i = 0; i < data.length; i++)
					System.out.printf("%02d|", data[i]);
				System.out.println("");
				for(int i = 0; i < data.length; i++)
					System.out.printf("%02d|", i);
		}
}
