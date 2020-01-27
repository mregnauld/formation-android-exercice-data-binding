package com.formationandroid.databinding;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.formationandroid.databinding.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity implements TextWatcher
{
	
	// Vues :
	private EditText editText1 = null;
	private EditText editText2 = null;
	
	// Opération :
	private MainPresenter mainPresenter = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		
		// binding :
		mainPresenter = new MainPresenter();
		activityMainBinding.setPresenter(mainPresenter);
		
		// vues :
		editText1 = findViewById(R.id.nombre1);
		editText2 = findViewById(R.id.nombre2);
		
		// ajout listeners :
		editText1.addTextChangedListener(this);
		editText2.addTextChangedListener(this);
	}
	
	@Override
	public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
	
	@Override
	public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
	
	@Override
	public void afterTextChanged(Editable editable)
	{
		if (editText1.isFocused() && editText1.getText().toString().length() > 0)
		{
			mainPresenter.setNombre1(Long.parseLong(editText1.getText().toString()));
		}
		else if (editText2.isFocused() && editText2.getText().toString().length() > 0)
		{
			mainPresenter.setNombre2(Long.parseLong(editText2.getText().toString()));
		}
	}
	
}
