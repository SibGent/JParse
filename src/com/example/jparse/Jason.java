package com.example.jparse;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class Jason {
	private String json = null;
	private Context context = null;
	private String[] images = null;
	
	Jason(Context context) {
		this.context = context;
	}
	/* ������� ���������� ���� */
	private String loadJSON(String path) {
		try {
			InputStream is = context.getAssets().open(path.toString());
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer);
		} catch (IOException e) {
			Log.d("MSG", "can't read json file");
			e.printStackTrace();
		} 
		return json;
	}
	/* ������� ���� path, �� ����������� value */
	public String[] parseJSON(String path, String value) {
		try {
			JSONObject jsonObject = new JSONObject(loadJSON(path));
			JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray(value);
			images = new String[jsonArray.length()];
			
			for (int i = 0; i < jsonArray.length(); i++) {
				images[i] = (String) jsonArray.getString(i);
				//Log.d("TAG", images[i]);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		/* ������� ������ ����� � url */
		return images;
	}
	/* ���������� ��������� url */
	public int getSize() {
		return images.length;
	}
}
