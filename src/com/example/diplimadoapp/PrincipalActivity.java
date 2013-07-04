package com.example.diplimadoapp;



import java.util.List;

import com.example.diplomadoapp.data.RssItem;
import com.example.diplomadoapp.util.RssReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RssReader rssReader = new RssReader("http://www.senalradionica.gov.co/index.php/home/articulos/itemlist?format=feed");
		try {
			List<RssItem> lecturaitems=rssReader.getItems();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("Diplomado App Reader", e.getMessage());
		}
		
		 final Button btnradio = (Button) findViewById(R.id.btnradio);
          btnradio.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 Intent i = new Intent(PrincipalActivity.this,MenuCanal.class);
         		 //i.putExtra("url", urlList.get(position));
         		startActivity(i);
             }
         });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
