package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	
	public SpriteBatch batcher; 
	public Sprite[] playerSprites;
	
	public int frameIndex;
	
	public Player(){
		batcher = new SpriteBatch();
		playerSprites = new Sprite[5];
		playerSprites[0] = new Sprite(); playerSprites[0].setTexture(new Texture(Gdx.files.internal("SpriteSheet1.png")));
		playerSprites[1] = new Sprite(); playerSprites[1].setTexture(new Texture(Gdx.files.internal("SpriteSheet2.png")));
		playerSprites[2] = new Sprite(); playerSprites[2].setTexture(new Texture(Gdx.files.internal("SpriteSheet3.png")));
		playerSprites[3] = new Sprite(); playerSprites[3].setTexture(new Texture(Gdx.files.internal("SpriteSheet4.png")));
		playerSprites[4] = new Sprite(); playerSprites[4].setTexture(new Texture(Gdx.files.internal("SpriteSheet5.png")));
		
	}
	
	public void logic(){
		
	}
	
	public void render(){
		
	}
	
}
