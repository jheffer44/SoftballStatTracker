package com.example.softballstattracker;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;

public class ChoosePlayersActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_players);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_players, menu);
		return true;
	}

}
