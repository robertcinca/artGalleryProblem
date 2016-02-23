package haxe.root;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class Visibility extends haxe.lang.HxObject
{
	public    Visibility(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    Visibility()
	{
		haxe.root.Visibility.__hx_ctor__Visibility(this);
	}
	
	
	public static   void __hx_ctor__Visibility(haxe.root.Visibility __temp_me11)
	{
		__temp_me11.segments = new de.polygonal.ds.DLL<haxe.root.Segment>(((java.lang.Object) (null) ), ((java.lang.Object) (null) ));
		__temp_me11.endpoints = new de.polygonal.ds.DLL<haxe.root.EndPoint>(((java.lang.Object) (null) ), ((java.lang.Object) (null) ));
		__temp_me11.open = new de.polygonal.ds.DLL<haxe.root.Segment>(((java.lang.Object) (null) ), ((java.lang.Object) (null) ));
		__temp_me11.center = new haxe.root.Point(((double) (0.0) ), ((double) (0.0) ));
		__temp_me11.output = new haxe.root.Array<haxe.root.Point>();
		__temp_me11.demo_intersectionsDetected = new haxe.root.Array<haxe.root.Array>(new haxe.root.Array[]{});
		__temp_me11.segments.toArray();
	}
	
	
	public static   int _endpoint_compare(haxe.root.EndPoint a, haxe.root.EndPoint b)
	{
		if (( a.angle > b.angle )) 
		{
			return 1;
		}
		
		if (( a.angle < b.angle )) 
		{
			return -1;
		}
		
		if ((  ! (a.begin)  && b.begin )) 
		{
			return 1;
		}
		
		if (( a.begin &&  ! (b.begin)  )) 
		{
			return -1;
		}
		
		return 0;
	}
	
	
	public static   boolean leftOf(haxe.root.Segment s, haxe.root.Point p)
	{
		double cross = ( ( (( s.p2.x - s.p1.x )) * (( p.y - s.p1.y )) ) - ( (( s.p2.y - s.p1.y )) * (( p.x - s.p1.x )) ) );
		return ( cross < 0 );
	}
	
	
	public static   haxe.root.Point interpolate(haxe.root.Point p, haxe.root.Point q, double f)
	{
		return new haxe.root.Point(((double) (( ( p.x * (( 1 - f )) ) + ( q.x * f ) )) ), ((double) (( ( p.y * (( 1 - f )) ) + ( q.y * f ) )) ));
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new haxe.root.Visibility(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new haxe.root.Visibility();
	}
	
	
	public  de.polygonal.ds.DLL<haxe.root.Segment> segments;
	
	public  de.polygonal.ds.DLL<haxe.root.EndPoint> endpoints;
	
	public  haxe.root.Point center;
	
	public  de.polygonal.ds.DLL<haxe.root.Segment> open;
	
	public  haxe.root.Array<haxe.root.Point> output;
	
	public  haxe.root.Array<haxe.root.Array> demo_intersectionsDetected;
	
	public   void loadEdgeOfMap(int size, int margin)
	{
		this.addSegment(((double) (margin) ), ((double) (margin) ), ((double) (margin) ), ((double) (( size - margin )) ));
		this.addSegment(((double) (margin) ), ((double) (( size - margin )) ), ((double) (( size - margin )) ), ((double) (( size - margin )) ));
		this.addSegment(((double) (( size - margin )) ), ((double) (( size - margin )) ), ((double) (( size - margin )) ), ((double) (margin) ));
		this.addSegment(((double) (( size - margin )) ), ((double) (margin) ), ((double) (margin) ), ((double) (margin) ));
	}
	
	
	public   void loadMap(int size, int margin, haxe.root.Array<haxe.root.Block> blocks, haxe.root.Array<haxe.root.Segment> walls)
	{
		this.segments.clear(null);
		this.endpoints.clear(null);
		this.loadEdgeOfMap(size, margin);
		{
			int _g = 0;
			while (( _g < blocks.length ))
			{
				haxe.root.Block block = blocks.__get(_g);
				 ++ _g;
				double x = block.x;
				double y = block.y;
				double r = block.r;
				this.addSegment(( x - r ), ( y - r ), ( x - r ), ( y + r ));
				this.addSegment(( x - r ), ( y + r ), ( x + r ), ( y + r ));
				this.addSegment(( x + r ), ( y + r ), ( x + r ), ( y - r ));
				this.addSegment(( x + r ), ( y - r ), ( x - r ), ( y - r ));
			}
			
		}
		
		{
			int _g1 = 0;
			while (( _g1 < walls.length ))
			{
				haxe.root.Segment wall = walls.__get(_g1);
				 ++ _g1;
				this.addSegment(wall.p1.x, wall.p1.y, wall.p2.x, wall.p2.y);
			}
			
		}
		
	}
	
	
	public   void addSegment(double x1, double y1, double x2, double y2)
	{
		haxe.root.Segment segment = null;
		haxe.root.EndPoint p1 = new haxe.root.EndPoint(((double) (0.0) ), ((double) (0.0) ));
		p1.segment = segment;
		p1.visualize = true;
		haxe.root.EndPoint p2 = new haxe.root.EndPoint(((double) (0.0) ), ((double) (0.0) ));
		p2.segment = segment;
		p2.visualize = false;
		segment = new haxe.root.Segment();
		p1.x = x1;
		p1.y = y1;
		p2.x = x2;
		p2.y = y2;
		p1.segment = segment;
		p2.segment = segment;
		segment.p1 = p1;
		segment.p2 = p2;
		segment.d = 0.0;
		this.segments.append(segment);
		this.endpoints.append(p1);
		this.endpoints.append(p2);
	}
	
	
	public   void setLightLocation(double x, double y)
	{
		this.center.x = x;
		this.center.y = y;
		{
			de.polygonal.ds.Itr<haxe.root.Segment> __temp_iterator28 = this.segments.iterator();
			while (__temp_iterator28.hasNext())
			{
				haxe.root.Segment segment = __temp_iterator28.next();
				double dx = ( ( 0.5 * (( segment.p1.x + segment.p2.x )) ) - x );
				double dy = ( ( 0.5 * (( segment.p1.y + segment.p2.y )) ) - y );
				segment.d = ( ( dx * dx ) + ( dy * dy ) );
				segment.p1.angle = java.lang.Math.atan2(( segment.p1.y - y ), ( segment.p1.x - x ));
				segment.p2.angle = java.lang.Math.atan2(( segment.p2.y - y ), ( segment.p2.x - x ));
				double dAngle = ( segment.p2.angle - segment.p1.angle );
				if (( dAngle <=  - (java.lang.Math.PI)  )) 
				{
					dAngle += ( 2 * java.lang.Math.PI );
				}
				
				if (( dAngle > java.lang.Math.PI )) 
				{
					dAngle -= ( 2 * java.lang.Math.PI );
				}
				
				segment.p1.begin = ( dAngle > 0.0 );
				segment.p2.begin =  ! (segment.p1.begin) ;
			}
			
		}
		
	}
	
	
	public   boolean _segment_in_front_of(haxe.root.Segment a, haxe.root.Segment b, haxe.root.Point relativeTo)
	{
		boolean A1 = false;
		{
			haxe.root.Point p = haxe.root.Visibility.interpolate(b.p1, b.p2, 0.01);
			double cross = ( ( (( a.p2.x - a.p1.x )) * (( p.y - a.p1.y )) ) - ( (( a.p2.y - a.p1.y )) * (( p.x - a.p1.x )) ) );
			A1 = ( cross < 0 );
		}
		
		boolean A2 = false;
		{
			haxe.root.Point p1 = haxe.root.Visibility.interpolate(b.p2, b.p1, 0.01);
			double cross1 = ( ( (( a.p2.x - a.p1.x )) * (( p1.y - a.p1.y )) ) - ( (( a.p2.y - a.p1.y )) * (( p1.x - a.p1.x )) ) );
			A2 = ( cross1 < 0 );
		}
		
		boolean A3 = false;
		{
			double cross2 = ( ( (( a.p2.x - a.p1.x )) * (( relativeTo.y - a.p1.y )) ) - ( (( a.p2.y - a.p1.y )) * (( relativeTo.x - a.p1.x )) ) );
			A3 = ( cross2 < 0 );
		}
		
		boolean B1 = false;
		{
			haxe.root.Point p2 = haxe.root.Visibility.interpolate(a.p1, a.p2, 0.01);
			double cross3 = ( ( (( b.p2.x - b.p1.x )) * (( p2.y - b.p1.y )) ) - ( (( b.p2.y - b.p1.y )) * (( p2.x - b.p1.x )) ) );
			B1 = ( cross3 < 0 );
		}
		
		boolean B2 = false;
		{
			haxe.root.Point p3 = haxe.root.Visibility.interpolate(a.p2, a.p1, 0.01);
			double cross4 = ( ( (( b.p2.x - b.p1.x )) * (( p3.y - b.p1.y )) ) - ( (( b.p2.y - b.p1.y )) * (( p3.x - b.p1.x )) ) );
			B2 = ( cross4 < 0 );
		}
		
		boolean B3 = false;
		{
			double cross5 = ( ( (( b.p2.x - b.p1.x )) * (( relativeTo.y - b.p1.y )) ) - ( (( b.p2.y - b.p1.y )) * (( relativeTo.x - b.p1.x )) ) );
			B3 = ( cross5 < 0 );
		}
		
		if (( ( B1 == B2 ) && ( B2 != B3 ) )) 
		{
			return true;
		}
		
		if (( ( A1 == A2 ) && ( A2 == A3 ) )) 
		{
			return true;
		}
		
		if (( ( A1 == A2 ) && ( A2 != A3 ) )) 
		{
			return false;
		}
		
		if (( ( B1 == B2 ) && ( B2 == B3 ) )) 
		{
			return false;
		}
		
		this.demo_intersectionsDetected.push(((haxe.root.Array) (new haxe.root.Array<haxe.root.Point>(new haxe.root.Point[]{a.p1, a.p2, b.p1, b.p2})) ));
		return false;
	}
	
	
	public   void sweep(java.lang.Object maxAngle)
	{
		double __temp_maxAngle10 = ( (( maxAngle == null )) ? (((double) (999.0) )) : (((double) (haxe.lang.Runtime.toDouble(maxAngle)) )) );
		this.output = new haxe.root.Array<haxe.root.Point>(new haxe.root.Point[]{});
		this.demo_intersectionsDetected = new haxe.root.Array<haxe.root.Array>(new haxe.root.Array[]{});
		this.endpoints.sort(((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (haxe.root.Visibility.class) ), haxe.lang.Runtime.toString("_endpoint_compare"))) ), true);
		this.open.clear(null);
		double beginAngle = 0.0;
		{
			int _g = 0;
			while (( _g < 2 ))
			{
				int pass = _g++;
				{
					de.polygonal.ds.Itr<haxe.root.EndPoint> __temp_iterator29 = this.endpoints.iterator();
					while (__temp_iterator29.hasNext())
					{
						haxe.root.EndPoint p = __temp_iterator29.next();
						if (( ( pass == 1 ) && ( p.angle > __temp_maxAngle10 ) )) 
						{
							break;
						}
						
						haxe.root.Segment current_old = null;
						if (( this.open._size == 0 )) 
						{
							current_old = null;
						}
						 else 
						{
							current_old = this.open.head.val;
						}
						
						if (p.begin) 
						{
							de.polygonal.ds.DLLNode<haxe.root.Segment> node = this.open.head;
							while (( ( node != null ) && this._segment_in_front_of(p.segment, node.val, this.center) ))
							{
								node = node.next;
							}
							
							if (( node == null )) 
							{
								this.open.append(p.segment);
							}
							 else 
							{
								this.open.insertBefore(node, p.segment);
							}
							
						}
						 else 
						{
							this.open.remove(p.segment);
						}
						
						haxe.root.Segment current_new = null;
						if (( this.open._size == 0 )) 
						{
							current_new = null;
						}
						 else 
						{
							current_new = this.open.head.val;
						}
						
						if (( current_old != current_new )) 
						{
							if (( pass == 1 )) 
							{
								this.addTriangle(beginAngle, p.angle, current_old);
							}
							
							beginAngle = p.angle;
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	
	public   haxe.root.Point lineIntersection(haxe.root.Point p1, haxe.root.Point p2, haxe.root.Point p3, haxe.root.Point p4)
	{
		double s = ( (( ( (( p4.x - p3.x )) * (( p1.y - p3.y )) ) - ( (( p4.y - p3.y )) * (( p1.x - p3.x )) ) )) / (( ( (( p4.y - p3.y )) * (( p2.x - p1.x )) ) - ( (( p4.x - p3.x )) * (( p2.y - p1.y )) ) )) );
		return new haxe.root.Point(((double) (( p1.x + ( s * (( p2.x - p1.x )) ) )) ), ((double) (( p1.y + ( s * (( p2.y - p1.y )) ) )) ));
	}
	
	
	public   void addTriangle(double angle1, double angle2, haxe.root.Segment segment)
	{
		haxe.root.Point p1 = this.center;
		haxe.root.Point p2 = new haxe.root.Point(((double) (( this.center.x + java.lang.Math.cos(angle1) )) ), ((double) (( this.center.y + java.lang.Math.sin(angle1) )) ));
		haxe.root.Point p3 = new haxe.root.Point(((double) (0.0) ), ((double) (0.0) ));
		haxe.root.Point p4 = new haxe.root.Point(((double) (0.0) ), ((double) (0.0) ));
		if (( segment != null )) 
		{
			p3.x = segment.p1.x;
			p3.y = segment.p1.y;
			p4.x = segment.p2.x;
			p4.y = segment.p2.y;
		}
		 else 
		{
			p3.x = ( this.center.x + ( java.lang.Math.cos(angle1) * 500 ) );
			p3.y = ( this.center.y + ( java.lang.Math.sin(angle1) * 500 ) );
			p4.x = ( this.center.x + ( java.lang.Math.cos(angle2) * 500 ) );
			p4.y = ( this.center.y + ( java.lang.Math.sin(angle2) * 500 ) );
		}
		
		haxe.root.Point pBegin = this.lineIntersection(p3, p4, p1, p2);
		p2.x = ( this.center.x + java.lang.Math.cos(angle2) );
		p2.y = ( this.center.y + java.lang.Math.sin(angle2) );
		haxe.root.Point pEnd = this.lineIntersection(p3, p4, p1, p2);
		this.output.push(pBegin);
		this.output.push(pEnd);
	}
	
	
	@Override public   java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef67 = true;
			switch (field.hashCode())
			{
				case 1615878736:
				{
					if (field.equals("demo_intersectionsDetected")) 
					{
						__temp_executeDef67 = false;
						this.demo_intersectionsDetected = ((haxe.root.Array<haxe.root.Array>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 1055868832:
				{
					if (field.equals("segments")) 
					{
						__temp_executeDef67 = false;
						this.segments = ((de.polygonal.ds.DLL<haxe.root.Segment>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case -1005512447:
				{
					if (field.equals("output")) 
					{
						__temp_executeDef67 = false;
						this.output = ((haxe.root.Array<haxe.root.Point>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case -1860397698:
				{
					if (field.equals("endpoints")) 
					{
						__temp_executeDef67 = false;
						this.endpoints = ((de.polygonal.ds.DLL<haxe.root.EndPoint>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 3417674:
				{
					if (field.equals("open")) 
					{
						__temp_executeDef67 = false;
						this.open = ((de.polygonal.ds.DLL<haxe.root.Segment>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case -1364013995:
				{
					if (field.equals("center")) 
					{
						__temp_executeDef67 = false;
						this.center = ((haxe.root.Point) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef67) 
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
			boolean __temp_executeDef68 = true;
			switch (field.hashCode())
			{
				case 523482569:
				{
					if (field.equals("addTriangle")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("addTriangle"))) );
					}
					
					break;
				}
				
				
				case 1055868832:
				{
					if (field.equals("segments")) 
					{
						__temp_executeDef68 = false;
						return this.segments;
					}
					
					break;
				}
				
				
				case 1064296605:
				{
					if (field.equals("lineIntersection")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("lineIntersection"))) );
					}
					
					break;
				}
				
				
				case -1860397698:
				{
					if (field.equals("endpoints")) 
					{
						__temp_executeDef68 = false;
						return this.endpoints;
					}
					
					break;
				}
				
				
				case 109850348:
				{
					if (field.equals("sweep")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("sweep"))) );
					}
					
					break;
				}
				
				
				case -1364013995:
				{
					if (field.equals("center")) 
					{
						__temp_executeDef68 = false;
						return this.center;
					}
					
					break;
				}
				
				
				case -1720652868:
				{
					if (field.equals("_segment_in_front_of")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_segment_in_front_of"))) );
					}
					
					break;
				}
				
				
				case 3417674:
				{
					if (field.equals("open")) 
					{
						__temp_executeDef68 = false;
						return this.open;
					}
					
					break;
				}
				
				
				case -513808983:
				{
					if (field.equals("setLightLocation")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("setLightLocation"))) );
					}
					
					break;
				}
				
				
				case -1005512447:
				{
					if (field.equals("output")) 
					{
						__temp_executeDef68 = false;
						return this.output;
					}
					
					break;
				}
				
				
				case -413010094:
				{
					if (field.equals("addSegment")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("addSegment"))) );
					}
					
					break;
				}
				
				
				case 1615878736:
				{
					if (field.equals("demo_intersectionsDetected")) 
					{
						__temp_executeDef68 = false;
						return this.demo_intersectionsDetected;
					}
					
					break;
				}
				
				
				case 336623254:
				{
					if (field.equals("loadMap")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("loadMap"))) );
					}
					
					break;
				}
				
				
				case 1351674370:
				{
					if (field.equals("loadEdgeOfMap")) 
					{
						__temp_executeDef68 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("loadEdgeOfMap"))) );
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef68) 
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
			boolean __temp_executeDef69 = true;
			switch (field.hashCode())
			{
				case 523482569:
				{
					if (field.equals("addTriangle")) 
					{
						__temp_executeDef69 = false;
						this.addTriangle(((double) (haxe.lang.Runtime.toDouble(dynargs.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(dynargs.__get(1))) ), ((haxe.root.Segment) (dynargs.__get(2)) ));
					}
					
					break;
				}
				
				
				case 1351674370:
				{
					if (field.equals("loadEdgeOfMap")) 
					{
						__temp_executeDef69 = false;
						this.loadEdgeOfMap(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ));
					}
					
					break;
				}
				
				
				case 1064296605:
				{
					if (field.equals("lineIntersection")) 
					{
						__temp_executeDef69 = false;
						return this.lineIntersection(((haxe.root.Point) (dynargs.__get(0)) ), ((haxe.root.Point) (dynargs.__get(1)) ), ((haxe.root.Point) (dynargs.__get(2)) ), ((haxe.root.Point) (dynargs.__get(3)) ));
					}
					
					break;
				}
				
				
				case 336623254:
				{
					if (field.equals("loadMap")) 
					{
						__temp_executeDef69 = false;
						this.loadMap(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ), ((haxe.root.Array<haxe.root.Block>) (dynargs.__get(2)) ), ((haxe.root.Array<haxe.root.Segment>) (dynargs.__get(3)) ));
					}
					
					break;
				}
				
				
				case 109850348:
				{
					if (field.equals("sweep")) 
					{
						__temp_executeDef69 = false;
						this.sweep(dynargs.__get(0));
					}
					
					break;
				}
				
				
				case -413010094:
				{
					if (field.equals("addSegment")) 
					{
						__temp_executeDef69 = false;
						this.addSegment(((double) (haxe.lang.Runtime.toDouble(dynargs.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(dynargs.__get(1))) ), ((double) (haxe.lang.Runtime.toDouble(dynargs.__get(2))) ), ((double) (haxe.lang.Runtime.toDouble(dynargs.__get(3))) ));
					}
					
					break;
				}
				
				
				case -1720652868:
				{
					if (field.equals("_segment_in_front_of")) 
					{
						__temp_executeDef69 = false;
						return this._segment_in_front_of(((haxe.root.Segment) (dynargs.__get(0)) ), ((haxe.root.Segment) (dynargs.__get(1)) ), ((haxe.root.Point) (dynargs.__get(2)) ));
					}
					
					break;
				}
				
				
				case -513808983:
				{
					if (field.equals("setLightLocation")) 
					{
						__temp_executeDef69 = false;
						this.setLightLocation(((double) (haxe.lang.Runtime.toDouble(dynargs.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(dynargs.__get(1))) ));
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef69) 
			{
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		return null;
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("demo_intersectionsDetected");
		baseArr.push("output");
		baseArr.push("open");
		baseArr.push("center");
		baseArr.push("endpoints");
		baseArr.push("segments");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}


