package com.formationandroid.databinding;

import android.os.Bundle;

import org.parceler.Parcels;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity
{
	
	// Constantes :
	public static final String EXTRA_MEMO = "EXTRA_MEMO";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		// argument :
		Memo memo = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_MEMO));
		
		// fragment :
		DetailFragment fragment = new DetailFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelable(DetailFragment.EXTRA_MEMO, Parcels.wrap(memo));
		fragment.setArguments(bundle);
		
		// ajout / remplacement fragment :
		getSupportFragmentManager().beginTransaction().replace(R.id.layout_detail, fragment).commit();
	}
	
}
