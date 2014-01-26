package com.example.softballstattracker;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void AddPlayer(View view)
	{     
		Intent intent = new Intent(this, AddPlayerActivity.class);
	    startActivity(intent);
	}
	
	public void AddGame(View view)
	{     
		Intent intent = new Intent(this, AddGameActivity.class);
	    startActivity(intent);
	}
}
