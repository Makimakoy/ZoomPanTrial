package com.example.zoompantrial;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class MyRoundCornerDrawable extends Drawable {
	private Paint paint;
	Paint p;
	public MyRoundCornerDrawable(Bitmap bitmap){
		BitmapShader shader;
		shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
		paint = new Paint();
		//paint.setAntiAlias(true);
		paint.setShader(shader);
		p = new Paint();
	}

	@Override
	public void draw(Canvas canvas) {
		int height = getBounds().height();
		int width = getBounds().width();
		
		canvas.drawPaint(paint);
		
		p.setColor(Color.RED);
		p.setStrokeWidth(3f);
		canvas.drawLine(10, 10, 100, 100, p);
		
		canvas.restore();

	}

	@Override
	public int getOpacity() {
		// TODO Auto-generated method stub
		return 255;
	}

	@Override
	public void setAlpha(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColorFilter(ColorFilter arg0) {
		// TODO Auto-generated method stub

	}


}

