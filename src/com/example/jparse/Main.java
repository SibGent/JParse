package com.example.jparse;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main extends Activity {
	String[] imagesURL;
	LinearLayout layout;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		layout = (LinearLayout) findViewById(R.id.list);
		
		Jason jason = new Jason(this);
		imagesURL = jason.parseJSON("images.json", "images");
		
		/* добавление imageview на layout */
		for (int i = 0; i < jason.getSize(); i++) {
			img = new ImageView(this);
			img.setPadding(5, 5, 5, 5);
			//img.setImageBitmap(ImageLoader.load(images[i]));
			new ImageLoader(img).execute(imagesURL[i]);
			layout.addView(img);
		}
	}
}
