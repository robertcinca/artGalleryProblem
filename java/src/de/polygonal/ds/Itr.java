package de.polygonal.ds;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  interface Itr<T> extends haxe.lang.IHxObject
{
	   boolean hasNext();
	
	   T next();
	
	   de.polygonal.ds.Itr<T> reset();
	
}


