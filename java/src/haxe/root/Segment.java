package haxe.root;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class Segment extends haxe.lang.HxObject
{
	public    Segment(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    Segment()
	{
		haxe.root.Segment.__hx_ctor__Segment(this);
	}
	
	
	public static   void __hx_ctor__Segment(haxe.root.Segment __temp_me9)
	{
		{
		}
		
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new haxe.root.Segment(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new haxe.root.Segment();
	}
	
	
	public  haxe.root.EndPoint p1;
	
	public  haxe.root.EndPoint p2;
	
	public  double d;
	
	@Override public   double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef63 = true;
			switch (field.hashCode())
			{
				case 100:
				{
					if (field.equals("d")) 
					{
						__temp_executeDef63 = false;
						this.d = ((double) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef63) 
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
			boolean __temp_executeDef64 = true;
			switch (field.hashCode())
			{
				case 100:
				{
					if (field.equals("d")) 
					{
						__temp_executeDef64 = false;
						this.d = ((double) (haxe.lang.Runtime.toDouble(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 3521:
				{
					if (field.equals("p1")) 
					{
						__temp_executeDef64 = false;
						this.p1 = ((haxe.root.EndPoint) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 3522:
				{
					if (field.equals("p2")) 
					{
						__temp_executeDef64 = false;
						this.p2 = ((haxe.root.EndPoint) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef64) 
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
			boolean __temp_executeDef65 = true;
			switch (field.hashCode())
			{
				case 100:
				{
					if (field.equals("d")) 
					{
						__temp_executeDef65 = false;
						return this.d;
					}
					
					break;
				}
				
				
				case 3521:
				{
					if (field.equals("p1")) 
					{
						__temp_executeDef65 = false;
						return this.p1;
					}
					
					break;
				}
				
				
				case 3522:
				{
					if (field.equals("p2")) 
					{
						__temp_executeDef65 = false;
						return this.p2;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef65) 
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
			boolean __temp_executeDef66 = true;
			switch (field.hashCode())
			{
				case 100:
				{
					if (field.equals("d")) 
					{
						__temp_executeDef66 = false;
						return this.d;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef66) 
			{
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("d");
		baseArr.push("p2");
		baseArr.push("p1");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}


