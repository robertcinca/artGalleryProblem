package de.polygonal.ds;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class DLLNode<T> extends haxe.lang.HxObject
{
	public    DLLNode(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    DLLNode(T x, de.polygonal.ds.DLL<T> list)
	{
		de.polygonal.ds.DLLNode.__hx_ctor_de_polygonal_ds_DLLNode(this, x, list);
	}
	
	
	public static  <T_c> void __hx_ctor_de_polygonal_ds_DLLNode(de.polygonal.ds.DLLNode<T_c> __temp_me19, T_c x, de.polygonal.ds.DLL<T_c> list)
	{
		__temp_me19.val = x;
		__temp_me19._list = list;
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new de.polygonal.ds.DLLNode<java.lang.Object>(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new de.polygonal.ds.DLLNode<java.lang.Object>(((java.lang.Object) (arr.__get(0)) ), ((de.polygonal.ds.DLL<java.lang.Object>) (arr.__get(1)) ));
	}
	
	
	public  T val;
	
	public  de.polygonal.ds.DLLNode<T> next;
	
	public  de.polygonal.ds.DLLNode<T> prev;
	
	public  de.polygonal.ds.DLL<T> _list;
	
	public final   de.polygonal.ds.DLLNode<T> _unlink()
	{
		de.polygonal.ds.DLLNode<T> t = this.next;
		if (( this.prev != null )) 
		{
			this.prev.next = this.next;
		}
		
		if (( this.next != null )) 
		{
			this.next.prev = this.prev;
		}
		
		this.next = this.prev = null;
		return t;
	}
	
	
	public final   void _insertAfter(de.polygonal.ds.DLLNode<T> node)
	{
		node.next = this.next;
		node.prev = this;
		if (( this.next != null )) 
		{
			this.next.prev = node;
		}
		
		this.next = node;
	}
	
	
	public final   void _insertBefore(de.polygonal.ds.DLLNode<T> node)
	{
		node.next = this;
		node.prev = this.prev;
		if (( this.prev != null )) 
		{
			this.prev.next = node;
		}
		
		this.prev = node;
	}
	
	
	@Override public   double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef87 = true;
			switch (field.hashCode())
			{
				case 116513:
				{
					if (field.equals("val")) 
					{
						__temp_executeDef87 = false;
						this.val = ((T) (((java.lang.Object) (value) )) );
						return ((double) (haxe.lang.Runtime.toDouble(((java.lang.Object) (value) ))) );
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef87) 
			{
				return super.__hx_setField_f(field, value, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef88 = true;
			switch (field.hashCode())
			{
				case 91056509:
				{
					if (field.equals("_list")) 
					{
						__temp_executeDef88 = false;
						this._list = ((de.polygonal.ds.DLL<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 116513:
				{
					if (field.equals("val")) 
					{
						__temp_executeDef88 = false;
						this.val = ((T) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 3449395:
				{
					if (field.equals("prev")) 
					{
						__temp_executeDef88 = false;
						this.prev = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 3377907:
				{
					if (field.equals("next")) 
					{
						__temp_executeDef88 = false;
						this.next = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef88) 
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
			boolean __temp_executeDef89 = true;
			switch (field.hashCode())
			{
				case -1850300041:
				{
					if (field.equals("_insertBefore")) 
					{
						__temp_executeDef89 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_insertBefore"))) );
					}
					
					break;
				}
				
				
				case 116513:
				{
					if (field.equals("val")) 
					{
						__temp_executeDef89 = false;
						return this.val;
					}
					
					break;
				}
				
				
				case -753304348:
				{
					if (field.equals("_insertAfter")) 
					{
						__temp_executeDef89 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_insertAfter"))) );
					}
					
					break;
				}
				
				
				case 3377907:
				{
					if (field.equals("next")) 
					{
						__temp_executeDef89 = false;
						return this.next;
					}
					
					break;
				}
				
				
				case 1868023602:
				{
					if (field.equals("_unlink")) 
					{
						__temp_executeDef89 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_unlink"))) );
					}
					
					break;
				}
				
				
				case 3449395:
				{
					if (field.equals("prev")) 
					{
						__temp_executeDef89 = false;
						return this.prev;
					}
					
					break;
				}
				
				
				case 91056509:
				{
					if (field.equals("_list")) 
					{
						__temp_executeDef89 = false;
						return this._list;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef89) 
			{
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		{
			boolean __temp_executeDef90 = true;
			switch (field.hashCode())
			{
				case 116513:
				{
					if (field.equals("val")) 
					{
						__temp_executeDef90 = false;
						return ((double) (haxe.lang.Runtime.toDouble(((java.lang.Object) (this.val) ))) );
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef90) 
			{
				return super.__hx_getField_f(field, throwErrors, handleProperties);
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
			boolean __temp_executeDef91 = true;
			switch (field.hashCode())
			{
				case -1850300041:
				{
					if (field.equals("_insertBefore")) 
					{
						__temp_executeDef91 = false;
						this._insertBefore(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
				case 1868023602:
				{
					if (field.equals("_unlink")) 
					{
						__temp_executeDef91 = false;
						return this._unlink();
					}
					
					break;
				}
				
				
				case -753304348:
				{
					if (field.equals("_insertAfter")) 
					{
						__temp_executeDef91 = false;
						this._insertAfter(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef91) 
			{
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		return null;
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("_list");
		baseArr.push("prev");
		baseArr.push("next");
		baseArr.push("val");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}


