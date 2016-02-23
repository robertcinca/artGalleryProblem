package de.polygonal.ds;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class DLLIterator<T> extends haxe.lang.HxObject implements de.polygonal.ds.Itr<T>
{
	public    DLLIterator(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    DLLIterator(de.polygonal.ds.DLL<T> f)
	{
		de.polygonal.ds.DLLIterator.__hx_ctor_de_polygonal_ds_DLLIterator(this, f);
	}
	
	
	public static  <T_c> void __hx_ctor_de_polygonal_ds_DLLIterator(de.polygonal.ds.DLLIterator<T_c> __temp_me17, de.polygonal.ds.DLL<T_c> f)
	{
		__temp_me17._f = f;
		{
			__temp_me17._walker = __temp_me17._f.head;
			__temp_me17._hook = null;
			de.polygonal.ds.DLLIterator<T_c> __temp_expr80 = __temp_me17;
		}
		
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new de.polygonal.ds.DLLIterator<java.lang.Object>(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new de.polygonal.ds.DLLIterator<java.lang.Object>(((de.polygonal.ds.DLL<java.lang.Object>) (arr.__get(0)) ));
	}
	
	
	public  de.polygonal.ds.DLL<T> _f;
	
	public  de.polygonal.ds.DLLNode<T> _walker;
	
	public  de.polygonal.ds.DLLNode<T> _hook;
	
	public final   de.polygonal.ds.Itr<T> reset()
	{
		this._walker = this._f.head;
		this._hook = null;
		return this;
	}
	
	
	public final   boolean hasNext()
	{
		return ( this._walker != null );
	}
	
	
	public final   T next()
	{
		T x = this._walker.val;
		this._hook = this._walker;
		this._walker = this._walker.next;
		return x;
	}
	
	
	@Override public   java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef77 = true;
			switch (field.hashCode())
			{
				case 90942978:
				{
					if (field.equals("_hook")) 
					{
						__temp_executeDef77 = false;
						this._hook = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 3047:
				{
					if (field.equals("_f")) 
					{
						__temp_executeDef77 = false;
						this._f = ((de.polygonal.ds.DLL<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 1913277781:
				{
					if (field.equals("_walker")) 
					{
						__temp_executeDef77 = false;
						this._walker = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef77) 
			{
				return super.__hx_setField(field, value, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		{
			boolean __temp_executeDef78 = true;
			switch (field.hashCode())
			{
				case 3377907:
				{
					if (field.equals("next")) 
					{
						__temp_executeDef78 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("next"))) );
					}
					
					break;
				}
				
				
				case 3047:
				{
					if (field.equals("_f")) 
					{
						__temp_executeDef78 = false;
						return this._f;
					}
					
					break;
				}
				
				
				case 696759469:
				{
					if (field.equals("hasNext")) 
					{
						__temp_executeDef78 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("hasNext"))) );
					}
					
					break;
				}
				
				
				case 1913277781:
				{
					if (field.equals("_walker")) 
					{
						__temp_executeDef78 = false;
						return this._walker;
					}
					
					break;
				}
				
				
				case 108404047:
				{
					if (field.equals("reset")) 
					{
						__temp_executeDef78 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("reset"))) );
					}
					
					break;
				}
				
				
				case 90942978:
				{
					if (field.equals("_hook")) 
					{
						__temp_executeDef78 = false;
						return this._hook;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef78) 
			{
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		{
			boolean __temp_executeDef79 = true;
			switch (field.hashCode())
			{
				case 3377907:
				{
					if (field.equals("next")) 
					{
						__temp_executeDef79 = false;
						return this.next();
					}
					
					break;
				}
				
				
				case 108404047:
				{
					if (field.equals("reset")) 
					{
						__temp_executeDef79 = false;
						return this.reset();
					}
					
					break;
				}
				
				
				case 696759469:
				{
					if (field.equals("hasNext")) 
					{
						__temp_executeDef79 = false;
						return this.hasNext();
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef79) 
			{
				return super.__hx_invokeField(field, dynargs);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("_hook");
		baseArr.push("_walker");
		baseArr.push("_f");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}


