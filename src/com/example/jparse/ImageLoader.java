package com.example.jparse;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageLoader extends AsyncTask<String, Void, Bitmap>{
	ImageView imageView;
	
	public ImageLoader(ImageView imageView) {
		this.imageView = imageView;
	}
	
	@Override
	/* получение в фоне картинки из url */
	protected Bitmap doInBackground(String... urls) {
		String url = urls[0];
        Bitmap bmp = null;
        
        try {
            InputStream in = new java.net.URL(url).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
	}
	/* установка загруженной картинки в imageview */
	@Override
	protected void onPostExecute(Bitmap result) {
		imageView.setImageBitmap(result);
	}
}
