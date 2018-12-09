package com.mvc.testing;

import java.util.Scanner;

import com.mvc.utilities.U;

public final class Counter {
	
	
    public static void main(String[] args) throws InterruptedException {
    	{
    		double average = 0.0;
    		int numAtBats = 0;
    		int numOfHits = 0;
    		String inputStr, strAvg;
    		Scanner in = new Scanner(System.in);
    		System.out.println("Please enter number of at-bats for batter and number of of hits ");
    		numAtBats=in.nextInt();
    		U.p(numAtBats);
    		numOfHits =in.nextInt();
    		U.p(numOfHits);
    		average = (double)numOfHits/numAtBats;
    		if(average>300)
    		System.out.println("Player is eligible for the All Stars Game");
    		else
    			System.out.println("Player is not eligible for the All Stars Game");
    		
    }
}
}