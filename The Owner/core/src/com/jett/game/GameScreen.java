package com.jett.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen{
	
	public OrthographicCamera cam;
	public Player player;
	
	public SpriteBatch mainBatch;
	
	public Array<Sprite> fireSprites;
	public Sprite bartableSprite;
	public Texture choiceBanner;
	public Sprite blackboard;
	
	public boolean paymentChoice;
	
	public FreeTypeFontGenerator fontGenerator;
	public FreeTypeFontParameter fontParameter;
	public BitmapFont font;
	
	public int shopMoney = 3000;
	public float dayTime;
	public float fireSpriteIndex;
	
	public boolean blackboardOpen;
	
	public Customer customer;

	public ArrayList<Favor> favors;
	
	public GameScreen(){
		favors = new ArrayList<Favor>();
		favors.add(new Favor("Get 50 logs of birch wood", 50));
		favors.add(new Favor("Find a hammer", 1));
		blackboard = new Sprite(new Texture(Gdx.files.internal("Blackboard.png")));
		blackboard.setPosition(-blackboard.getWidth()/2, -blackboard.getHeight()/2);
		blackboard.setScale(0.09f);
		blackboard.rotate(-0.3f);
		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Coolville.ttf"));
		fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 9;
		font = fontGenerator.generateFont(fontParameter);
		mainBatch = new SpriteBatch();
		player = new Player(-50,0);
		cam = new OrthographicCamera(16*10,9*10);
		player.batcher.setProjectionMatrix(cam.combined);
		choiceBanner = new Texture(Gdx.files.internal("ChoiceBanner.png"));
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
		if(Gdx.input.isKeyJustPressed(Keys.B))
			blackboardOpen = !blackboardOpen;
		if(customer != null){
			if(customer.CURRENT_STATE == customer.TALKING){
				paymentChoice = true;
			}
			customer.delta = delta;
			if(customer.hasPayed){
				paymentChoice = false;
				customer = null;
			}
		}
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glClearColor(0.5f, 0.5f, 0.5f, 1f);
		player.render();
		player.logic(delta);
		fireSpriteIndex += delta*5;
		mainBatch.begin();
		// Background
		mainBatch.draw(bartableSprite, -48, 0);
		mainBatch.draw(fireSprites.get((int)fireSpriteIndex), 0, 0);
		mainBatch.end();
		// People
		if(customer != null){
			customer.render();
			customer.logic();
		}
		// UI
		mainBatch.begin();
		font.draw(mainBatch, "Gold: " + shopMoney, -80, 44);
		if(paymentChoice){
			mainBatch.draw(choiceBanner, -16,-16);
			if(Gdx.input.isKeyJustPressed(Keys.G)){
				// Gold
				if(customer.isCheap){
					shopMoney += customer.money/4;
				}	
				else{
					shopMoney += customer.money;
				}
				customer.hasPayed = true;
			}
			if(Gdx.input.isKeyJustPressed(Keys.H)){
				// Help
				if(favors.size() > 0){
					if(paymentChoice){
						favors.remove(MathUtils.round((float)Math.random() * favors.size()));
					}
				}
				customer.hasPayed = true;
			}
		}
		Gdx.app.log("Randomized: ",""+MathUtils.round((float)Math.random() * favors.size()));
		if(blackboardOpen){
			blackboard.draw(mainBatch);
			font.draw(mainBatch, "To-Do", -70, 40);
		}
		for(int i = 0; i < favors.size(); i++){
			if(blackboardOpen)
				font.draw(mainBatch, favors.get(i).name, -70, 25-i*10);
			if(favors.get(i).quantity <= 0){
				favors.remove(i);
			}
		}
		mainBatch.end();
		if(fireSpriteIndex >= 6.5f){
			fireSpriteIndex = 0;
		}
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
