package com.intentdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class Second_Activity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);

		// Getting value via intent and storing in string
		String value = getIntent().getStringExtra("value");
		TextView text = (TextView) findViewById(R.id.textView1);

		// Setting stored intent value at text
		text.setText(value);

	}
}
