package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
	
	public SpriteBatch batcher;
	public Sprite sprite;
	
	public Vector2 pos;
	public Vector2 spd;
	
	public Player(float x, float y){
		batcher = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("SpriteSheet1.png")));
		sprite.flip(true, false);
		pos = new Vector2(x, y);
		spd = new Vector2();
	}
	
	public void logic(float delta){
		pos.add(spd);
	}
	
	public void render(){
		batcher.begin();
		batcher.draw(sprite, pos.x, pos.y);
		batcher.end();
	}
	
}
