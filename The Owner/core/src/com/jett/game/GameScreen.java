package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen{
	
	public OrthographicCamera cam;
	public Player player;
	
	public SpriteBatch mainBatch;
	
	public Array<Sprite> fireSprites;
	
	public float fireSpriteIndex;
	
	public GameScreen(){
		mainBatch = new SpriteBatch();
		player = new Player(-50,0);
		cam = new OrthographicCamera(16*10,9*10);
		player.batcher.setProjectionMatrix(cam.combined);
		fireSprites = new Array<Sprite>();
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire1.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire2.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire3.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire4.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire5.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire6.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire7.png"))));
		mainBatch.setProjectionMatrix(cam.combined);
	}

	@Override
	public void render(float delta) {
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glClearColor(0.8f, 0.8f, 1, 1);
		player.render();
		player.logic(delta);
		fireSpriteIndex += delta*5;
		mainBatch.begin();
		mainBatch.draw(fireSprites.get((int)fireSpriteIndex), 0, 0);
		mainBatch.end();
		if(fireSpriteIndex >= 6.5f)
			fireSpriteIndex = 0;
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
