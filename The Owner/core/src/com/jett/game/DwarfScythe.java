package com.jett.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class DwarfScythe extends Customer{
	
	public DwarfScythe(float x, float y) {
		super(x, y);
	}
	
	@Override
	public void init(){
		money = (float) (Math.random()*300);
		isCheap = Math.random() < 0.5f;
		textures.add(new Texture(Gdx.files.internal("Scythe1.png")));
		textures.add(new Texture(Gdx.files.internal("Scythe2.png")));
		textures.add(new Texture(Gdx.files.internal("Scythe3.png")));
		textures.add(new Texture(Gdx.files.internal("Scythe4.png")));
		textures.add(new Texture(Gdx.files.internal("Scythe5.png")));
		textures.add(new Texture(Gdx.files.internal("Scythe6.png")));
	}
	
}
