package com.jett.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Customer{
	
	public ArrayList<Texture> texture;
	public SpriteBatch batcher;
	
	public float frameIndex;
	
	public static final int WALKING = 1;
	public final int TALKING = 2;
	public static final int LEAVING = 3;
	public int CURRENT_STATE;
	
	public boolean hasPayed;
	public boolean isCheap;
	
	public float money;
	
	public Vector3 pos = new Vector3();
	public Vector3 spd = new Vector3();
	
	public float delta;
	
	public ArrayList<Texture> textures = new ArrayList<Texture>();
	
	public Customer(float x, float y){
		init();
		batcher = new SpriteBatch();
		pos.x = x;
		pos.y = y;
		/*while(true){
			render();
			logic();
			if(CURRENT_STATE == LEAVING)
				break;
		}*/
	}
	
	public void init(){
		
	}
	
	public void render(){
		batcher.begin();
		batcher.draw(textures.get((int)frameIndex),pos.x,pos.y);
		batcher.end();
	}
	
	public void logic(){
		pos.add(spd);
		if(!hasPayed){
			if(pos.x >= -35){
				CURRENT_STATE = WALKING;
			}
			else{
				CURRENT_STATE = TALKING;
			}
		}
		else{
			CURRENT_STATE = LEAVING;
		}
		if(CURRENT_STATE == WALKING){
			spd.x = -0.1f;
			frameIndex += delta*3;
			if(frameIndex >= 3.8f){
				frameIndex = 0;
			}
		}else if (CURRENT_STATE == TALKING) {
			spd.x = 0;
			frameIndex += delta*2;
			if(frameIndex < 5){
				frameIndex = 5;
			}
			if(frameIndex >= 5.9){
				frameIndex = 5;
			}
		}
	}
}
