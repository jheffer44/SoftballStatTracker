package com.example.softballstattracker;
 
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AddPlayerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_player);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_player, menu);
		return true;
	}
	
	public void SavePlayer(View view){
		Intent intent = new Intent(this, AddGameActivity.class);
	    startActivity(intent);
	}
	
	public void Back(View view){
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
}
