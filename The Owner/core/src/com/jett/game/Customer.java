package com.jett.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Customer {
	
	public ArrayList<Texture> texture;
	public SpriteBatch batcher;
	
	public float frameIndex;
	
	public static final int WALKING = 1;
	public static final int TALKING = 2;
	public static final int LEAVING = 3;
	public static int CURRENT_FRAME;
	
	public Vector3 pos;
	public Vector3 spd;
	
	public Customer(Texture[] textures, float x, float y){
		batcher = new SpriteBatch();
		pos.x = x;
		pos.y = y;
		for(int j = 0; j < textures.length; j++){
			texture.add(textures[j]);
		}
	}
	
	public void render(){
		batcher.begin();
		batcher.draw(texture.get((int)frameIndex),pos.x,pos.y);
		batcher.end();
	}
	
	public void logic(float delta){
		pos.add(spd);
		if(pos.x >= 60){
			
		}
	}
}
