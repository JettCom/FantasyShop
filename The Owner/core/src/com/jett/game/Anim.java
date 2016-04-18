package com.jett.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Anim {
	
	public Texture referenceRegion;
	public TextureRegion[] resultRegion;
	public int ROWS;
	public int COLUMNS;
	
	public Anim(Texture reference, int ROWS, int COLUMNS){
		ROWS = this.ROWS;
		COLUMNS = this.COLUMNS;
		referenceRegion = reference;
		resultRegion = referenceRegion.split(referenceRegion, referenceRegion.getWidth()/ROWS, referenceRegion.getHeight()/COLUMNS);
	}
	
}
