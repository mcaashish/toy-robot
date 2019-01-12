package com.rea.toyrobot;

import java.util.Scanner;

import com.rea.toyrobot.logic.CommandProcessor;

public class ToyRobotSimulatorMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Toy Robot Simulator" );
        Scanner scanner = new Scanner(System.in);
        CommandProcessor processor = new CommandProcessor();
        while(true)
        {
        	
        	String input = scanner.nextLine();
        	
        	if(input.equalsIgnoreCase("Exit"))
        	{
        		System.out.println("Exiting now...");
        		System.exit(0);
        	}
        	else 
        	{
        		processor.processCommand(input);
        	}
        	
        	System.out.println("");
        }
    }
}
