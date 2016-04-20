package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen{
	
	public OrthographicCamera cam;
	public Player player;
	
	public GameScreen(){
		player = new Player(-50,0);
		cam = new OrthographicCamera(16*10,9*10);
		player.batcher.setProjectionMatrix(cam.combined);
	}

	@Override
	public void render(float delta) {
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glClearColor(0.8f, 0.8f, 1, 1);
		player.render();
		player.logic(delta);
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

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
