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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

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
			
			List<RssItem> lecturaitems=rssReader.getItems();
			// Create a list adapter
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(getActivity(),android.R.layout.simple_list_item_1,lecturaitems);
			// Set list adapter for the ListView
			lv.setAdapter(adapter);
			
			// Set list view item click listener
			lv.setOnItemClickListener(new ListListener(lecturaitems, getActivity()));
			
		} catch (Exception e) {
			Log.e("Diplomado App Reader", e.getMessage());
		}
		fl.addView(lv);
		
		
		break;
		
		case 1:
			TextView v0 = new TextView(getActivity());
			params.setMargins(margin, margin, margin, margin);
			v0.setLayoutParams(params);
			v0.setLayoutParams(params);
			v0.setGravity(Gravity.CENTER);
			v0.setBackgroundResource(R.drawable.background_card);
			v0.setText("Esto es programas");

			fl.addView(v0);
		break;
		case 2:
			TextView v1 = new TextView(getActivity());
			params.setMargins(margin, margin, margin, margin);
			v1.setLayoutParams(params);
			v1.setLayoutParams(params);
			v1.setGravity(Gravity.CENTER);
			v1.setBackgroundResource(R.drawable.background_card);
			v1.setText("Esto es noticias");

			fl.addView(v1);
			break;
		}
		
		return fl;
	}

}