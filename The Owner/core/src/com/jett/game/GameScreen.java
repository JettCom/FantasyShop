package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{
	
	public Sprite[] testAnim;
	public SpriteBatch batcher;
	
	public float frameIndex;
	
	public GameScreen(){
		batcher = new SpriteBatch();
		testAnim = new Sprite[4];
		for(int i = 0; i < 4; i++){
			testAnim[i].setTexture(new Texture(Gdx.files.internal("SpriteSheet"+(i+1)+".png")));
		}
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		frameIndex += delta;
		batcher.begin();
		batcher.draw(testAnim[(int)frameIndex],0,0);
		batcher.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
