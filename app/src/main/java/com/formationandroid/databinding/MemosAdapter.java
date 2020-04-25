package com.formationandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class MemosAdapter extends RecyclerView.Adapter<MemosAdapter.MemoViewHolder>
{
	
	// Activité :
	private MainActivity mainActivity;
	
	// Liste d'objets métier :
	private List<Memo> listeMemos;
	
	
	/**
	 * Constructeur.
	 * @param mainActivity MainActivity
	 * @param listeMemos Liste de mémos
	 */
	public MemosAdapter(MainActivity mainActivity, List<Memo> listeMemos)
	{
		this.mainActivity = mainActivity;
		this.listeMemos = listeMemos;
	}
	
	@Override
	@NonNull
	public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_memo, parent, false);
		return new MemoViewHolder(binding);
	}
	
	@Override
	public void onBindViewHolder(MemoViewHolder holder, int position)
	{
		holder.bind(listeMemos.get(position));
	}
	
	@Override
	public int getItemCount()
	{
		return listeMemos.size();
	}
	
	/**
	 * Ajout d'un mémo à la liste.
	 * @param memo Mémo
	 */
	public void ajouterMemo(Memo memo)
	{
		listeMemos.add(0, memo);
		notifyItemInserted(0);
	}
	
	/**
	 * Retourne le mémo à la position voulue.
	 * @param position Position
	 * @return Mémo
	 */
	public Memo getItemParPosition(int position)
	{
		return listeMemos.get(position);
	}
	
	
	/**
	 * ViewHolder.
	 */
	class MemoViewHolder extends RecyclerView.ViewHolder
	{
		
		// Binding :
		private ViewDataBinding binding;
		
		
		/**
		 * Constructeur.
		 * @param binding ViewDataBinding
		 */
		MemoViewHolder(final ViewDataBinding binding)
		{
			super(binding.getRoot());
			this.binding = binding;
			
			// exemple listener :
			binding.getRoot().setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					mainActivity.onClicItem(getAdapterPosition());
				}
			});
		}
		
		/**
		 * Binding depuis l'adapter.
		 * @param memo Memo
		 */
		void bind(Memo memo)
		{
			binding.setVariable(BR.memo, memo);
			binding.executePendingBindings();
		}
		
	}
	
}
