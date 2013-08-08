package com.example.zoompantrial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TouchImageView extends ImageView {

	Matrix matrix;


	// We can be in one of these 3 states
	static final int NONE = 0;
	static final int DRAG = 1;
	static final int ZOOM = 2;
	int mode = NONE;

	// Remember some things for zooming
	PointF last = new PointF();
	PointF start = new PointF();
	float minScale = 2f;
	float maxScale = 3f;
	float[] m;


	int viewWidth, viewHeight;
	static final int CLICK = 3;
	float saveScale = 1f;
	protected float origWidth, origHeight;
	int oldMeasuredWidth, oldMeasuredHeight;

	///temporary variables
	float mClickCoord[] = new float[2];
	Paint p;
	Bitmap bm;
	Canvas c;
	Context con;
	Toast t;
	float preTransX;
	float preTransY;
	float mPreScaleFactor;
	float preFocusX;
	float preFocusY;
	int counter = 0;
	BufferedReader br;
	///

	ScaleGestureDetector mScaleDetector;

	Context context;

	public TouchImageView(Context context) {
		super(context);
		sharedConstructing(context);

	}

	public TouchImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		sharedConstructing(context);
	}

	private void sharedConstructing(Context context) {
		super.setClickable(true);
		con = context;
		this.context = context;
		mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
		matrix = new Matrix();
		m = new float[9];
		setImageMatrix(matrix);
		setScaleType(ScaleType.MATRIX);

		//temporary

		AssetManager am = context.getAssets();
		try {
			InputStream is = am.open("NewVertices.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(is);
			br= new BufferedReader(inputStreamReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//////////////////

		setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				mScaleDetector.onTouchEvent(event);
				PointF curr = new PointF(event.getX(), event.getY());
				//

				//
				getCanvasCoords(v, event);
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					last.set(curr);
					start.set(last);
					if(counter!=0){
						t.makeText(con, "X:"+((int)mClickCoord[0])+" Y:"+((int)mClickCoord[1]), Toast.LENGTH_SHORT).show();
						
					}

					mode = DRAG;
					break;

				case MotionEvent.ACTION_MOVE:
					if (mode == DRAG) {
						//
						counter++;
						//
						float deltaX = curr.x - last.x;
						float deltaY = curr.y - last.y;
						float fixTransX = getFixDragTrans(deltaX, viewWidth, origWidth * saveScale);
						float fixTransY = getFixDragTrans(deltaY, viewHeight, origHeight * saveScale);
						matrix.postTranslate(fixTransX, fixTransY);

						fixTrans();

						last.set(curr.x, curr.y);
					}
					break;

				case MotionEvent.ACTION_UP:
					mode = NONE;
					int xDiff = (int) Math.abs(curr.x - start.x);
					int yDiff = (int) Math.abs(curr.y - start.y);
					if (xDiff < CLICK && yDiff < CLICK)
						performClick();
					break;

				case MotionEvent.ACTION_POINTER_UP:
					mode = NONE;
					break;
				}

				setImageMatrix(matrix);
				invalidate();
				return true; // indicate event was handled
			}

		});
	}

	public void setMaxZoom(float x) {
		maxScale = x;
	}

	private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
		@Override
		public boolean onScaleBegin(ScaleGestureDetector detector) {
			mode = ZOOM;
			return true;
		}

		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			float mScaleFactor = detector.getScaleFactor();
			float origScale = saveScale;
			saveScale *= mScaleFactor;
			if (saveScale > maxScale) {
				saveScale = maxScale;
				mScaleFactor = maxScale / origScale;
			} else if (saveScale < minScale) {
				saveScale = minScale;
				mScaleFactor = minScale / origScale;
			}

			if (origWidth * saveScale <= viewWidth || origHeight * saveScale <= viewHeight){
				matrix.postScale(mScaleFactor, mScaleFactor, viewWidth / 2, viewHeight / 2);

			}
			else{
				matrix.postScale(mScaleFactor, mScaleFactor, detector.getFocusX(), detector.getFocusY());


			}
			mPreScaleFactor = mScaleFactor;
			fixTrans();
			return true;
		}
	}

	void fixTrans() {
		matrix.getValues(m);
		float transX = m[Matrix.MTRANS_X];
		float transY = m[Matrix.MTRANS_Y];
		//
		float posX = m[Matrix.MSCALE_X];
		float posY = m[Matrix.MSCALE_Y];
		//
		float fixTransX = getFixTrans(transX, viewWidth, origWidth * saveScale);
		float fixTransY = getFixTrans(transY, viewHeight, origHeight * saveScale);

		if (fixTransX != 0 || fixTransY != 0)
			matrix.postTranslate(fixTransX, fixTransY);
		preTransX = transX;
		preTransY = transY;
		preFocusX = posX;
		preFocusY = posY;


	}

	float getFixTrans(float trans, float viewSize, float contentSize) {
		float minTrans, maxTrans;

		if (contentSize <= viewSize) {
			minTrans = 0;
			maxTrans = viewSize - contentSize;
		} else {
			minTrans = viewSize - contentSize;
			maxTrans = 0;
		}

		if (trans < minTrans)
			return -trans + minTrans;
		if (trans > maxTrans)
			return -trans + maxTrans;
		return 0;
	}

	float getFixDragTrans(float delta, float viewSize, float contentSize) {
		if (contentSize <= viewSize) {
			return 0;
		}
		return delta;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		viewWidth = MeasureSpec.getSize(widthMeasureSpec);
		viewHeight = MeasureSpec.getSize(heightMeasureSpec);

		//
		// Rescales image on rotation
		//
		if (oldMeasuredHeight == viewWidth && oldMeasuredHeight == viewHeight
				|| viewWidth == 0 || viewHeight == 0)
			return;
		oldMeasuredHeight = viewHeight;
		oldMeasuredWidth = viewWidth;

		if (saveScale == 1) {
			//Fit to screen.
			float scale;

			Drawable drawable = getDrawable();
			if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0)
				return;
			int bmWidth = drawable.getIntrinsicWidth();
			int bmHeight = drawable.getIntrinsicHeight();

			Log.d("bmSize", "bmWidth: " + bmWidth + " bmHeight : " + bmHeight);

			float scaleX = (float) viewWidth / (float) bmWidth;
			float scaleY = (float) viewHeight / (float) bmHeight;
			scale = Math.min(scaleX, scaleY);
			matrix.setScale(scale, scale);

			// Center the image
			float redundantYSpace = (float) viewHeight - (scale * (float) bmHeight);
			float redundantXSpace = (float) viewWidth - (scale * (float) bmWidth);
			redundantYSpace /= (float) 2;
			redundantXSpace /= (float) 2;

			matrix.postTranslate(redundantXSpace, redundantYSpace);

			origWidth = viewWidth - 2 * redundantXSpace;
			origHeight = viewHeight - 2 * redundantYSpace;
			setImageMatrix(matrix);
		}
		fixTrans();
	}

	@Override
	public void setImageBitmap(Bitmap bitmap){
		super.setImageBitmap(bitmap);
		bm = bitmap;
		c = new Canvas(bm);
		p = new Paint();

	}
	boolean tuloy = true;
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas = c;
		canvas.save();
		p.setColor(Color.RED);
		p.setStrokeWidth(4);

		try {
			while(tuloy){
				String line ="";
				String temp1 ="",temp2="";
				if((line = br.readLine())!=null)
					temp1 = line;

				if((line = br.readLine())!=null){
					temp2 = line;
					canvas.drawPoint(Integer.parseInt(temp1), Integer.parseInt(temp2), p);
				}
				else
					tuloy=false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}

		canvas.restore();
	}

	//temporary method
	public float[] getCanvasCoords(View view, MotionEvent e){
		mClickCoord[0] = e.getX();
		mClickCoord[1] = e.getY();
		Matrix mx = new Matrix(getMatrix());
		mx.preTranslate(preTransX, preTransY);
		mx.preScale(mPreScaleFactor, mPreScaleFactor, preFocusX, preFocusY);
		mx.invert(mx);
		mx.mapPoints(mClickCoord);
		return mClickCoord;
	}
	//

	
	//Movable methods
	///Calculate Distance, can be move to a new class
	public int calculateDistance(int x1,int y1,int x2,int y2){
		int X = (x2-x1)*(x2-x1);
		int Y = (y2-y1)*(y2-y1);
		return (int)Math.sqrt(X+Y);
	}

}