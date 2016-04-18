package com.jett.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Anim {
	
	public TextureRegion referenceRegion;
	public TextureRegion[] resultRegion;
	public int ROWS;
	public int COLUMNS;
	
	public Anim(TextureRegion reference, int ROWS, int COLUMNS){
		ROWS = this.ROWS;
		COLUMNS = this.COLUMNS;
		referenceRegion = reference;
	}
	
}
