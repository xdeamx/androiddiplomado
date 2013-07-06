/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.diplimadoapp;

import java.util.List;

import com.example.diplomadoapp.data.RssItem;
import com.example.diplomadoapp.listeners.ListListener;
import com.example.diplomadoapp.util.RssReader;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.VideoView;

public class SuperAwesomeCardFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;

	public static SuperAwesomeCardFragment newInstance(int position) {
		SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

		FrameLayout fl = new FrameLayout(getActivity());
		fl.setLayoutParams(params);

		final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
				.getDisplayMetrics());
		
		switch(position){
		case 0:
		
			LinearLayout ll=new LinearLayout(getActivity());
			ll.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			ll.setOrientation(LinearLayout.VERTICAL);
		    
			
			
			ImageView iv=new ImageView(getActivity());
			iv.setLayoutParams(new  LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1020));
		    //iv.setLayoutParams(new  LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
			iv.setMaxHeight(520);
			iv.setImageResource(R.drawable.contact);
			ll.addView(iv);
			
			
			TableLayout tl=new TableLayout(getActivity());
			tl.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			
			TableRow tr =new TableRow(getActivity());
			tr.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			tr.setGravity(Gravity.FILL_HORIZONTAL);
			tr.setPadding(5,5,5,5);
			
			 List<RssItem> lecturaitems=null;
			try {
				// Create RSS reader
				RssReader rssReader = new RssReader("http://www.senalradionica.gov.co/index.php/home/articulos/itemlist?format=feed");
				// Get a ListView from main view
				//ListView itcItems = (ListView) findViewById(R.id.listMainView);
				
				lecturaitems=rssReader.getItems();
				
				
				
			} catch (Exception e) {
				Log.e("Diplomado App Reader", e.getMessage());
			}

			TextView v1 = new TextView(getActivity());
			params.setMargins(margin, margin, margin, margin);
			v1.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,2));
			v1.setGravity(Gravity.CENTER);
			v1.setBackgroundResource(R.drawable.background_card);
			if(lecturaitems!=null){
				v1.setText(lecturaitems.get(0).getTitle());
				String urlnoticia=lecturaitems.get(0).getLink();
				v1.setOnClickListener(new NoticiaDestacadaOnClickListener(urlnoticia));
			}else{
			    v1.setText("No Registra nuevas noticias");
			}
			
			tr.addView(v1);
			
			ImageButton ib=new ImageButton(getActivity());
			ib.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			ib.setImageResource(R.drawable.facebook);
			
			ib.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	                myWebLink.setData(Uri.parse("http://www.facebook.com"));
	                    startActivity(myWebLink);
	             }
	        });
			
			tr.addView(ib);
			
			ImageButton ib2=new ImageButton(getActivity());
			ib2.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			ib2.setImageResource(R.drawable.twitter);
			
			ib2.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	                myWebLink.setData(Uri.parse("http://www.twitter.com"));
	                    startActivity(myWebLink);
	             }
	        });
			
			tr.addView(ib2);
			
			ImageButton ib3=new ImageButton(getActivity());
			ib3.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			ib3.setImageResource(R.drawable.youtube);
			
			ib3.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	                myWebLink.setData(Uri.parse("http://www.youtube.com"));
	                    startActivity(myWebLink);
	             }
	        });
			
			tr.addView(ib3);
			
			tl.addView(tr);
			
			ll.addView(tl);
			
			fl.addView(ll);

		break;
		
		case 1:
			
			LinearLayout ll2=new LinearLayout(getActivity());
			ll2.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			ll2.setOrientation(LinearLayout.VERTICAL);
		    
					
			TableLayout tl2=new TableLayout(getActivity());
			tl2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			
			TableRow tr2 =new TableRow(getActivity());
			tr2.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			tr2.setGravity(Gravity.FILL_HORIZONTAL);
			tr2.setPadding(5,5,5,5);
			
		
			TextView v0 = new TextView(getActivity());
			params.setMargins(margin, margin, margin, margin);
			v0.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,2));
			v0.setGravity(Gravity.CENTER);
			v0.setText("Acusticos Radionoca. Lunes a Viernes 8:00 a.m. - 9:00 a.m.");
			tr2.addView(v0);
			
			ImageButton ib20=new ImageButton(getActivity());
			ib20.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			ib20.setImageResource(R.drawable.pacusticos);
			ib20.setBackgroundDrawable(null);
			
			tr2.addView(ib20);
			
			tl2.addView(tr2);
			
			TableRow tr3 =new TableRow(getActivity());
			tr3.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			tr3.setGravity(Gravity.FILL_HORIZONTAL);
			tr3.setPadding(5,5,5,5);
			

			
			TextView v03 = new TextView(getActivity());
			params.setMargins(margin, margin, margin, margin);
			v03.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,2));
			v03.setGravity(Gravity.CENTER);
			v03.setText("Acusticos Radionoca. Lunes a Viernes 8:00 a.m. - 9:00 a.m.");
			tr3.addView(v03);
			
			ImageButton ib30=new ImageButton(getActivity());
			ib30.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			ib30.setImageResource(R.drawable.pradionica_lacarta);
			ib30.setBackgroundDrawable(null);
			
			tr3.addView(ib30);			
			
			tl2.addView(tr3);
			
			TableRow tr4 =new TableRow(getActivity());
			tr4.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			tr4.setGravity(Gravity.FILL_HORIZONTAL);
			tr4.setPadding(5,5,5,5);
			
		
			TextView v04 = new TextView(getActivity());
			params.setMargins(margin, margin, margin, margin);
			v04.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,2));
			v04.setGravity(Gravity.CENTER);
			v04.setText("Acusticos Radionoca. Lunes a Viernes 8:00 a.m. - 9:00 a.m.");
			tr4.addView(v04);
			
			tl2.addView(tr4);
			
			ImageButton ib40=new ImageButton(getActivity());
			ib40.setLayoutParams(new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT,1));
			ib40.setImageResource(R.drawable.prockeros);
			ib40.setBackgroundDrawable(null);
			
				
			
			
			tr4.addView(ib40);
			
			ll2.addView(tl2);
			

			/*
		   VideoView videoView = new VideoView(getActivity());

			Uri path = Uri.parse("rtmp://cdns840stu0010.multistream.net:80/rtvcRadionicalive/?pass=|radionica|");

			videoView.setVideoURI(path);
			videoView.start(); 
		 
		TableRow tr5 =new TableRow(getActivity());
			tr5.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			tr5.setGravity(Gravity.FILL_HORIZONTAL);
			tr5.setPadding(5,5,5,5);
			tr5.addView(videoView);
			
			ll2.addView(tr5);*/
			
			
			
			fl.addView(ll2);
		break;
		case 2:
			ListView lv = new ListView(getActivity());
			params.setMargins(margin, margin, margin, margin);
			lv.setLayoutParams(params);
			lv.setLayoutParams(params);
			lv.setBackgroundResource(R.drawable.background_card);		
			try {
				// Create RSS reader
				RssReader rssReader = new RssReader("http://www.senalradionica.gov.co/index.php/home/articulos/itemlist?format=feed");
				// Get a ListView from main view
				//ListView itcItems = (ListView) findViewById(R.id.listMainView);
				
				List<RssItem> lecturaitems2=rssReader.getItems();
				// Create a list adapter
				ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(getActivity(),android.R.layout.simple_list_item_1,lecturaitems2);
				// Set list adapter for the ListView
				lv.setAdapter(adapter);
				
				// Set list view item click listener
				lv.setOnItemClickListener(new ListListener(lecturaitems2, getActivity()));
				
			} catch (Exception e) {
				Log.e("Diplomado App Reader", e.getMessage());
			}
			fl.addView(lv);			break;
		}
		
		return fl;
	}
	
	public class NoticiaDestacadaOnClickListener implements OnClickListener
	   {

	     String urlNoticia;
	     public NoticiaDestacadaOnClickListener( String urlNoticia) {
	          this.urlNoticia = urlNoticia;
	     }
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
            myWebLink.setData(Uri.parse(this.urlNoticia));
                startActivity(myWebLink);
			
		}

	     

	  };

}