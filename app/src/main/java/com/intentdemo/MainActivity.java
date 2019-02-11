package com.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	Button nextactivity, show_url, call;
	EditText simple_text, url_text, number_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nextactivity = (Button) findViewById(R.id.second_activity);
		show_url = (Button) findViewById(R.id.go_url);
		call = (Button) findViewById(R.id.call_number);

		simple_text = (EditText) findViewById(R.id.text);
		url_text = (EditText) findViewById(R.id.url);
		number_text = (EditText) findViewById(R.id.phone);

		// Implementing Click Listeners to buttons

		nextactivity.setOnClickListener(this);
		show_url.setOnClickListener(this);
		call.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId(); // Getting ids of buttons
		switch (id) {
		// Explicit Intent
		case R.id.second_activity:

			// Starting second activity via Intent
			Intent in = new Intent(MainActivity.this, Second_Activity.class);
			in.putExtra("value", simple_text.getText().toString()); // Passing
																	// values
																	// from one
																	// activity
																	// to
																	// another
			startActivity(in);

			break;

		// Implicit Intent
		case R.id.go_url:

			// Opening url into browser
			Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse(url_text
					.getText().toString()));
			startActivity(url);
			break;
		case R.id.call_number:

			// Calling entered number
			Intent call = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"
					+ number_text.getText().toString()));
			startActivity(call);
			break;
		}

	}

	@Override
	protected void onResume() {
		// Whenever activity resumes all the edittexts become empty
		simple_text.setText("");
		url_text.setText("");
		number_text.setText("");
		super.onResume();
	}

}
