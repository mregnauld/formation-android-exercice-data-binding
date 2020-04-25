package com.formationandroid.databinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


public class DetailFragment extends Fragment
{
	
	// Constantes :
	public static final String EXTRA_MEMO = "EXTRA_MEMO";
	
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// binding :
		ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
		
		// argument :
		if (getArguments() != null)
		{
			Memo memo = Parcels.unwrap(getArguments().getParcelable(EXTRA_MEMO));
			binding.setVariable(BR.memo, memo);
		}
		return binding.getRoot();
	}
	
}
