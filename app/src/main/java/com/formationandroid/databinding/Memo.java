package com.formationandroid.databinding;

import org.parceler.Parcel;

@Parcel
public class Memo
{
	
	// Attributs :
	public String intitule;
	
	
	/**
	 * Constructeur vide pour Parceler.
	 */
	public Memo() {}
	
	/**
	 * Constructeur.
	 * @param intitule Intitulé du mémo
	 */
	public Memo(String intitule)
	{
		this.intitule = intitule;
	}
	
}
