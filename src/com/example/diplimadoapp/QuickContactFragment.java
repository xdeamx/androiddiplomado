package com.example.diplimadoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class QuickContactFragment extends Fragment {

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.fragment_quick_contact,
	        container, false);
	    return view;
	  }

	  public void setText(String item) {
	    TextView view = (TextView) getView().findViewById(R.id.detailsText);
	    view.setText(item);
	  }
	}