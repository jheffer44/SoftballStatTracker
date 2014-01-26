package com.example.softballstattracker;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class PlayerDataSource {

  // Database fields
  private SQLiteDatabase database;
  private SQLiteHelper dbHelper;
  private String[] allColumns = { SQLiteHelper.ID,
		  						  SQLiteHelper.NAME };

  public PlayerDataSource(Context context) 
  {
    dbHelper = new SQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Player createPlayer(Player player) 
  {  
	String playerName = "fuckYOU";
	  
    ContentValues values = new ContentValues();
    values.put(SQLiteHelper.NAME, playerName);
    
    long insertId = database.insert(SQLiteHelper.TABLE_PLAYERS, null, values);
    Cursor cursor = database.query(SQLiteHelper.TABLE_PLAYERS,
        allColumns, SQLiteHelper.ID + " = " + insertId, null,
        null, null, null);
    
    cursor.moveToFirst();
    
    Player newPlayer = cursorToPlayer(cursor);
    cursor.close();
    return newPlayer;
  }

  public void deletePlayer(Player player) {
    long id = player.getId();
    System.out.println("Player deleted with id: " + id);
    database.delete(SQLiteHelper.TABLE_PLAYERS, SQLiteHelper.ID
        + " = " + id, null);
  }

  public List<Player> getAllPlayers() {
    List<Player> players = new ArrayList<Player>();

    Cursor cursor = database.query(SQLiteHelper.TABLE_PLAYERS,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    
    while (!cursor.isAfterLast()) {
      Player player = cursorToPlayer(cursor);
      players.add(player);
      cursor.moveToNext();
    }
    
    // make sure to close the cursor
    cursor.close();
    return players;
  }

  private Player cursorToPlayer(Cursor cursor) 
  {
    Player player = new Player();
    player.setId(cursor.getLong(0));
    player.setName(cursor.getString(1));
    return player;
  }
} 
