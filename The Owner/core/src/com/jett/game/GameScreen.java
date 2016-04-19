package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{
	
	public Texture[] testAnim;
	public SpriteBatch batcher;
	
	public OrthographicCamera cam;
	
	public float frameIndex;
	
	public GameScreen(){
		batcher = new SpriteBatch();
		testAnim = new Texture[5];
		testAnim[0] = (new Texture(Gdx.files.internal("SpriteSheet1.png")));
		testAnim[1]  = (new Texture(Gdx.files.internal("SpriteSheet2.png")));
		testAnim[2] = (new Texture(Gdx.files.internal("SpriteSheet3.png")));
		testAnim[3] = (new Texture(Gdx.files.internal("SpriteSheet4.png")));
		testAnim[4] = (new Texture(Gdx.files.internal("SpriteSheet5.png")));
		cam = new OrthographicCamera(16*10,9*10);
		batcher.setProjectionMatrix(cam.combined);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glClearColor(0.8f, 0.8f, 1, 1);
		frameIndex += delta;
		batcher.begin();
		batcher.draw(testAnim[(int)frameIndex],0,0);
		batcher.end();
		if((int)frameIndex >= 4)
			frameIndex = 0;
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
