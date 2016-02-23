package haxe.root;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class EndPoint extends haxe.root.Point
{
	public    EndPoint(haxe.lang.EmptyObject empty)
	{
		super(haxe.lang.EmptyObject.EMPTY);
	}
	
	
	public    EndPoint(double x_, double y_)
	{
		super(haxe.lang.EmptyObject.EMPTY);
		haxe.root.EndPoint.__hx_ctor__EndPoint(this, x_, y_);
	}
	
	
	public static   void __hx_ctor__EndPoint(haxe.root.EndPoint __temp_me8, double x_, double y_)
	{
		haxe.root.Point.__hx_ctor__Point(__temp_me8, x_, y_);
		__temp_me8.visualize = false;
		__temp_me8.angle = 0.0;
		__temp_me8.segment = null;
		__temp_me8.begin = false;
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new haxe.root.EndPoint(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new haxe.root.EndPoint(((double) (haxe.lang.Runtime.toDouble(arr.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(arr.__get(1))) ));
	}
	
	
	public  boolean begin;
	
	public  haxe.root.Segment segment;
	
	public  double angle;
	
	public  boolean visualize;
	
	@Override public   double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef59 = true;
			switch (field.hashCode())
			{
				case 92960979:
				{
					if (field.equals("angle")) 
					{
						__temp_executeDef59 = false;
						this.angle = ((double) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef59) 
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
			boolean __temp_executeDef60 = true;
			switch (field.hashCode())
			{
				case -2088515052:
				{
					if (field.equals("visualize")) 
					{
						__temp_executeDef60 = false;
						this.visualize = haxe.lang.Runtime.toBool(value);
						return value;
					}
					
					break;
				}
				
				
				case 93616297:
				{
					if (field.equals("begin")) 
					{
						__temp_executeDef60 = false;
						this.begin = haxe.lang.Runtime.toBool(value);
						return value;
					}
					
					break;
				}
				
				
				case 92960979:
				{
					if (field.equals("angle")) 
					{
						__temp_executeDef60 = false;
						this.angle = ((double) (haxe.lang.Runtime.toDouble(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 1973722931:
				{
					if (field.equals("segment")) 
					{
						__temp_executeDef60 = false;
						this.segment = ((haxe.root.Segment) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef60) 
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
			boolean __temp_executeDef61 = true;
			switch (field.hashCode())
			{
				case -2088515052:
				{
					if (field.equals("visualize")) 
					{
						__temp_executeDef61 = false;
						return this.visualize;
					}
					
					break;
				}
				
				
				case 93616297:
				{
					if (field.equals("begin")) 
					{
						__temp_executeDef61 = false;
						return this.begin;
					}
					
					break;
				}
				
				
				case 92960979:
				{
					if (field.equals("angle")) 
					{
						__temp_executeDef61 = false;
						return this.angle;
					}
					
					break;
				}
				
				
				case 1973722931:
				{
					if (field.equals("segment")) 
					{
						__temp_executeDef61 = false;
						return this.segment;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef61) 
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
			boolean __temp_executeDef62 = true;
			switch (field.hashCode())
			{
				case 92960979:
				{
					if (field.equals("angle")) 
					{
						__temp_executeDef62 = false;
						return this.angle;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef62) 
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
		baseArr.push("visualize");
		baseArr.push("angle");
		baseArr.push("segment");
		baseArr.push("begin");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}


