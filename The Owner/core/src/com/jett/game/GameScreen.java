package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen{
	
	private OrthographicCamera camera = new OrthographicCamera(16*10,9*10);
	private TextureAtlas exampleSpriteSheet = new TextureAtlas(Gdx.files.internal("spriteSheet.txt"));
	private Array<Sprite> playerSpriteSheet = exampleSpriteSheet.createSprites("exampleSpriteSheet");
	private SpriteBatch batcher = new SpriteBatch();
	public float frameIndex;
	
	public GameScreen(){
		for(int i = 0; i < playerSpriteSheet.size; i++){
			playerSpriteSheet.get(i).setSize(1,1);
		}
		batcher.setProjectionMatrix(camera.combined);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		frameIndex += delta;
		batcher.begin();
		batcher.draw(playerSpriteSheet.get((int)frameIndex).getTexture(), 100, 100);
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
