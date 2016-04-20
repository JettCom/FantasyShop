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
	public static Sprite bartableSprite;
	
	public float fireSpriteIndex;
	
	public Customer customer;
	
	public GameScreen(){
		mainBatch = new SpriteBatch();
		player = new Player(-50,0);
		cam = new OrthographicCamera(16*10,9*10);
		player.batcher.setProjectionMatrix(cam.combined);
		bartableSprite = new Sprite(new Texture(Gdx.files.internal("Bartable.png")));
		fireSprites = new Array<Sprite>();
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire1.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire2.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire3.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire4.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire5.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire6.png"))));
		fireSprites.add(new Sprite(new Texture(Gdx.files.internal("Fire7.png"))));
		mainBatch.setProjectionMatrix(cam.combined);
		customer = new DwarfScythe(80, 0);
		customer.batcher.setProjectionMatrix(cam.combined);
	}

	@Override
	public void render(float delta) {
		Gdx.app.log("Customer position.x: ", ""+customer.pos.x);
		Gdx.app.log("Current customer state: ", ""+customer.CURRENT_STATE);
		Gdx.app.log("Current customer paying status: ", ""+customer.hasPayed);
		Gdx.app.log("Current customer frameIndex: ", ""+customer.frameIndex);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glClearColor(0.1f, 0.1f, 0.05f, 1);
		player.render();
		player.logic(delta);
		fireSpriteIndex += delta*5;
		customer.delta = delta;
		customer.render();
		customer.logic();
		mainBatch.begin();
		mainBatch.draw(bartableSprite, -48, 0);
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
