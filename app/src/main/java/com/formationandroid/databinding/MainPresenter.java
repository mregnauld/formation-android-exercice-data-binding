package com.formationandroid.databinding;

import androidx.databinding.BaseObservable;

public class MainPresenter extends BaseObservable
{
	
	// Opérations :
	public enum Operation
	{
		ADDITION,
		SOUSTRACTION,
		MULTIPLICATION,
		DIVISION
	}
	
	// Attributs :
	private long nombre1 = 0;
	private long nombre2 = 0;
	private Operation operation = Operation.ADDITION;
	
	
	/**
	 * Setter nombre 1.
	 * @param nombre1 Nombre 1
	 */
	void setNombre1(long nombre1)
	{
		this.nombre1 = nombre1;
		notifyChange();
	}
	
	/**
	 * Setter nombre 2.
	 * @param nombre2 Nombre 2
	 */
	void setNombre2(long nombre2)
	{
		this.nombre2 = nombre2;
		notifyChange();
	}
	
	/**
	 * Setter opération.
	 * @param operation Opération
	 */
	public void setOperation(Operation operation)
	{
		this.operation = operation;
		notifyChange();
	}
	
	/**
	 * Retourne le résultat formaté pour le XML de l'activité.
	 * @return Résultat au format String
	 */
	public String getResultatFormate()
	{
		switch (operation)
		{
			case ADDITION:
				return String.valueOf(nombre1 + nombre2);
				
			case SOUSTRACTION:
				return String.valueOf(nombre1 - nombre2);
				
			case MULTIPLICATION:
				return String.valueOf(nombre1 * nombre2);
				
			case DIVISION:
				return (nombre2 != 0 ? String.valueOf(nombre1 / (double) nombre2) : "Division par zéro !");
				
			default:
				return "Aucune opération";
		}
	}
	
}
