package com.jett.game;

import java.util.ArrayList;

public class Blackboard {
	
	public ArrayList<Favor> favors = new ArrayList<Favor>();
	public boolean jobsComplete;
	
	public Blackboard(ArrayList<Favor> favors){
		favors = this.favors;
	}
	
	public void logic(){
		for(Favor favor : favors){
			if(favor.isDone)
				favors.remove(favor);
		}
		if(favors.size() == 0)
			jobsComplete = true;
	}
	
}
