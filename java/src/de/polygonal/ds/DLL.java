package de.polygonal.ds;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class DLL<T> extends haxe.lang.HxObject implements de.polygonal.ds.Collection<T>
{
	public    DLL(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    DLL(java.lang.Object reservedSize, java.lang.Object maxSize)
	{
		de.polygonal.ds.DLL.__hx_ctor_de_polygonal_ds_DLL(this, reservedSize, maxSize);
	}
	
	
	public static  <T_c> void __hx_ctor_de_polygonal_ds_DLL(de.polygonal.ds.DLL<T_c> __temp_me16, java.lang.Object reservedSize, java.lang.Object maxSize)
	{
		int __temp_maxSize15 = ( (( maxSize == null )) ? (((int) (-1) )) : (((int) (haxe.lang.Runtime.toInt(maxSize)) )) );
		int __temp_reservedSize14 = ( (( reservedSize == null )) ? (((int) (0) )) : (((int) (haxe.lang.Runtime.toInt(reservedSize)) )) );
		__temp_me16.maxSize = -1;
		__temp_me16._reservedSize = __temp_reservedSize14;
		__temp_me16._size = 0;
		__temp_me16._poolSize = 0;
		__temp_me16._circular = false;
		__temp_me16._iterator = null;
		if (( __temp_reservedSize14 > 0 )) 
		{
			__temp_me16._headPool = __temp_me16._tailPool = new de.polygonal.ds.DLLNode<T_c>(((T_c) (null) ), ((de.polygonal.ds.DLL<T_c>) (__temp_me16) ));
		}
		
		__temp_me16.head = __temp_me16.tail = null;
		__temp_me16.key = de.polygonal.ds.HashKey._counter++;
		__temp_me16.reuseIterator = false;
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new de.polygonal.ds.DLL<java.lang.Object>(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new de.polygonal.ds.DLL<java.lang.Object>(((java.lang.Object) (arr.__get(0)) ), ((java.lang.Object) (arr.__get(1)) ));
	}
	
	
	public  int key;
	
	public  de.polygonal.ds.DLLNode<T> head;
	
	public  de.polygonal.ds.DLLNode<T> tail;
	
	public  int maxSize;
	
	public  boolean reuseIterator;
	
	public  int _size;
	
	public  int _reservedSize;
	
	public  int _poolSize;
	
	public  de.polygonal.ds.DLLNode<T> _headPool;
	
	public  de.polygonal.ds.DLLNode<T> _tailPool;
	
	public  boolean _circular;
	
	public  de.polygonal.ds.Itr<T> _iterator;
	
	public   de.polygonal.ds.DLLNode<T> append(T x)
	{
		de.polygonal.ds.DLLNode<T> node = null;
		if (( ( this._reservedSize == 0 ) || ( this._poolSize == 0 ) )) 
		{
			node = new de.polygonal.ds.DLLNode<T>(((T) (x) ), ((de.polygonal.ds.DLL<T>) (this) ));
		}
		 else 
		{
			de.polygonal.ds.DLLNode<T> n = this._headPool;
			this._headPool = this._headPool.next;
			this._poolSize--;
			n.next = null;
			n.val = x;
			node = n;
		}
		
		if (( this.tail != null )) 
		{
			this.tail.next = node;
			node.prev = this.tail;
		}
		 else 
		{
			this.head = node;
		}
		
		this.tail = node;
		if (this._circular) 
		{
			this.tail.next = this.head;
			this.head.prev = this.tail;
		}
		
		this._size++;
		return node;
	}
	
	
	public   de.polygonal.ds.DLLNode<T> insertBefore(de.polygonal.ds.DLLNode<T> node, T x)
	{
		de.polygonal.ds.DLLNode<T> t = null;
		if (( ( this._reservedSize == 0 ) || ( this._poolSize == 0 ) )) 
		{
			t = new de.polygonal.ds.DLLNode<T>(((T) (x) ), ((de.polygonal.ds.DLL<T>) (this) ));
		}
		 else 
		{
			de.polygonal.ds.DLLNode<T> n = this._headPool;
			this._headPool = this._headPool.next;
			this._poolSize--;
			n.next = null;
			n.val = x;
			t = n;
		}
		
		node._insertBefore(t);
		if (( node == this.head )) 
		{
			this.head = t;
			if (this._circular) 
			{
				this.head.prev = this.tail;
			}
			
		}
		
		this._size++;
		return t;
	}
	
	
	public   de.polygonal.ds.DLLNode<T> unlink(de.polygonal.ds.DLLNode<T> node)
	{
		de.polygonal.ds.DLLNode<T> hook = node.next;
		if (( node == this.head )) 
		{
			this.head = this.head.next;
			if (this._circular) 
			{
				if (( this.head == this.tail )) 
				{
					this.head = null;
				}
				 else 
				{
					this.tail.next = this.head;
				}
				
			}
			
			if (( this.head == null )) 
			{
				this.tail = null;
			}
			
		}
		 else 
		{
			if (( node == this.tail )) 
			{
				this.tail = this.tail.prev;
				if (this._circular) 
				{
					this.head.prev = this.tail;
				}
				
				if (( this.tail == null )) 
				{
					this.head = null;
				}
				
			}
			
		}
		
		node._unlink();
		{
			T val = node.val;
			if (( ( this._reservedSize > 0 ) && ( this._poolSize < this._reservedSize ) )) 
			{
				this._tailPool = this._tailPool.next = node;
				node.val = ((T) (null) );
				this._poolSize++;
			}
			 else 
			{
				node._list = null;
			}
			
			T __temp_expr70 = val;
		}
		
		this._size--;
		return hook;
	}
	
	
	public   void sort(haxe.lang.Function compare, java.lang.Object useInsertionSort)
	{
		boolean __temp_useInsertionSort12 = ( (( useInsertionSort == null )) ? (haxe.lang.Runtime.toBool(false)) : (haxe.lang.Runtime.toBool(useInsertionSort)) );
		if (( this._size > 1 )) 
		{
			if (this._circular) 
			{
				this.tail.next = null;
				this.head.prev = null;
			}
			
			if (( compare == null )) 
			{
				if (__temp_useInsertionSort12) 
				{
					this.head = this._insertionSortComparable(this.head);
				}
				 else 
				{
					this.head = this._mergeSortComparable(this.head);
				}
				
			}
			 else 
			{
				if (__temp_useInsertionSort12) 
				{
					this.head = this._insertionSort(this.head, compare);
				}
				 else 
				{
					this.head = this._mergeSort(this.head, compare);
				}
				
			}
			
			if (this._circular) 
			{
				this.tail.next = this.head;
				this.head.prev = this.tail;
			}
			
		}
		
	}
	
	
	public   boolean remove(T x)
	{
		int s = this._size;
		if (( s == 0 )) 
		{
			return false;
		}
		
		de.polygonal.ds.DLLNode<T> node = this.head;
		while (( node != null ))
		{
			if (haxe.lang.Runtime.eq(node.val, x)) 
			{
				node = this.unlink(node);
			}
			 else 
			{
				node = node.next;
			}
			
		}
		
		return ( this._size < s );
	}
	
	
	public   void clear(java.lang.Object purge)
	{
		boolean __temp_purge13 = ( (( purge == null )) ? (haxe.lang.Runtime.toBool(false)) : (haxe.lang.Runtime.toBool(purge)) );
		if (( __temp_purge13 || ( this._reservedSize > 0 ) )) 
		{
			de.polygonal.ds.DLLNode<T> node = this.head;
			{
				int _g1 = 0;
				int _g = this._size;
				while (( _g1 < _g ))
				{
					int i = _g1++;
					de.polygonal.ds.DLLNode<T> next = node.next;
					node.prev = null;
					node.next = null;
					{
						T val = node.val;
						if (( ( this._reservedSize > 0 ) && ( this._poolSize < this._reservedSize ) )) 
						{
							this._tailPool = this._tailPool.next = node;
							node.val = ((T) (null) );
							this._poolSize++;
						}
						 else 
						{
							node._list = null;
						}
						
						T __temp_expr71 = val;
					}
					
					node = next;
				}
				
			}
			
		}
		
		this.head = this.tail = null;
		this._size = 0;
	}
	
	
	public   de.polygonal.ds.Itr<T> iterator()
	{
		if (this.reuseIterator) 
		{
			if (( this._iterator == null )) 
			{
				if (this._circular) 
				{
					return new de.polygonal.ds.CircularDLLIterator<T>(((de.polygonal.ds.DLL<T>) (this) ));
				}
				 else 
				{
					return new de.polygonal.ds.DLLIterator<T>(((de.polygonal.ds.DLL<T>) (this) ));
				}
				
			}
			 else 
			{
				this._iterator.reset();
			}
			
			return this._iterator;
		}
		 else 
		{
			if (this._circular) 
			{
				return new de.polygonal.ds.CircularDLLIterator<T>(((de.polygonal.ds.DLL<T>) (this) ));
			}
			 else 
			{
				return new de.polygonal.ds.DLLIterator<T>(((de.polygonal.ds.DLL<T>) (this) ));
			}
			
		}
		
	}
	
	
	public   haxe.root.Array<T> toArray()
	{
		haxe.root.Array<T> a = null;
		{
			haxe.root.Array<T> a1 = null;
			a1 = new haxe.root.Array<T>();
			{
				int _g = 0;
				while (( _g < this._size ))
				{
					int i = _g++;
					a1.__set(i, null);
				}
				
			}
			
			a = a1;
		}
		
		de.polygonal.ds.DLLNode<T> node = this.head;
		{
			int _g1 = 0;
			int _g2 = this._size;
			while (( _g1 < _g2 ))
			{
				int i1 = _g1++;
				a.__set(i1, node.val);
				node = node.next;
			}
			
		}
		
		return a;
	}
	
	
	public   de.polygonal.ds.DLLNode<T> _mergeSortComparable(de.polygonal.ds.DLLNode<T> node)
	{
		de.polygonal.ds.DLLNode<T> h = node;
		de.polygonal.ds.DLLNode<T> p = null;
		de.polygonal.ds.DLLNode<T> q = null;
		de.polygonal.ds.DLLNode<T> e = null;
		de.polygonal.ds.DLLNode<T> tail = null;
		int insize = 1;
		int nmerges = 0;
		int psize = 0;
		int qsize = 0;
		java.lang.Object i = null;
		while (true)
		{
			p = h;
			h = tail = null;
			nmerges = 0;
			while (( p != null ))
			{
				nmerges++;
				psize = 0;
				q = p;
				{
					int _g = 0;
					while (( _g < ((int) (insize) ) ))
					{
						int i1 = _g++;
						psize++;
						q = q.next;
						if (( q == null )) 
						{
							break;
						}
						
					}
					
				}
				
				qsize = insize;
				while (( ( psize > 0 ) || ( ( qsize > 0 ) && ( q != null ) ) ))
				{
					if (( psize == 0 )) 
					{
						e = q;
						q = q.next;
						qsize--;
					}
					 else 
					{
						if (( ( qsize == 0 ) || ( q == null ) )) 
						{
							e = p;
							p = p.next;
							psize--;
						}
						 else 
						{
							if (( (((de.polygonal.ds.Comparable) (((java.lang.Object) (p.val) )) )).compare(q.val) >= 0 )) 
							{
								e = p;
								p = p.next;
								psize--;
							}
							 else 
							{
								e = q;
								q = q.next;
								qsize--;
							}
							
						}
						
					}
					
					if (( tail != null )) 
					{
						tail.next = e;
					}
					 else 
					{
						h = e;
					}
					
					e.prev = tail;
					tail = e;
				}
				
				p = q;
			}
			
			tail.next = null;
			if (( nmerges <= 1 )) 
			{
				break;
			}
			
			insize <<= 1;
		}
		
		h.prev = null;
		this.tail = tail;
		return h;
	}
	
	
	public   de.polygonal.ds.DLLNode<T> _mergeSort(de.polygonal.ds.DLLNode<T> node, haxe.lang.Function cmp)
	{
		de.polygonal.ds.DLLNode<T> h = node;
		de.polygonal.ds.DLLNode<T> p = null;
		de.polygonal.ds.DLLNode<T> q = null;
		de.polygonal.ds.DLLNode<T> e = null;
		de.polygonal.ds.DLLNode<T> tail = null;
		int insize = 1;
		int nmerges = 0;
		int psize = 0;
		int qsize = 0;
		java.lang.Object i = null;
		while (true)
		{
			p = h;
			h = tail = null;
			nmerges = 0;
			while (( p != null ))
			{
				nmerges++;
				psize = 0;
				q = p;
				{
					int _g = 0;
					while (( _g < ((int) (insize) ) ))
					{
						int i1 = _g++;
						psize++;
						q = q.next;
						if (( q == null )) 
						{
							break;
						}
						
					}
					
				}
				
				qsize = insize;
				while (( ( psize > 0 ) || ( ( qsize > 0 ) && ( q != null ) ) ))
				{
					if (( psize == 0 )) 
					{
						e = q;
						q = q.next;
						qsize--;
					}
					 else 
					{
						if (( ( qsize == 0 ) || ( q == null ) )) 
						{
							e = p;
							p = p.next;
							psize--;
						}
						 else 
						{
							if (( ((int) (cmp.__hx_invoke2_f(0.0, q.val, 0.0, p.val)) ) >= 0 )) 
							{
								e = p;
								p = p.next;
								psize--;
							}
							 else 
							{
								e = q;
								q = q.next;
								qsize--;
							}
							
						}
						
					}
					
					if (( tail != null )) 
					{
						tail.next = e;
					}
					 else 
					{
						h = e;
					}
					
					e.prev = tail;
					tail = e;
				}
				
				p = q;
			}
			
			tail.next = null;
			if (( nmerges <= 1 )) 
			{
				break;
			}
			
			insize <<= 1;
		}
		
		h.prev = null;
		this.tail = tail;
		return h;
	}
	
	
	public   de.polygonal.ds.DLLNode<T> _insertionSortComparable(de.polygonal.ds.DLLNode<T> node)
	{
		de.polygonal.ds.DLLNode<T> h = node;
		de.polygonal.ds.DLLNode<T> n = h.next;
		while (( n != null ))
		{
			de.polygonal.ds.DLLNode<T> m = n.next;
			de.polygonal.ds.DLLNode<T> p = n.prev;
			T v = n.val;
			if (( (((de.polygonal.ds.Comparable) (((java.lang.Object) (p.val) )) )).compare(v) < 0 )) 
			{
				de.polygonal.ds.DLLNode<T> i = p;
				while (( i.prev != null ))
				{
					if (( (((de.polygonal.ds.Comparable) (((java.lang.Object) (i.prev.val) )) )).compare(v) < 0 )) 
					{
						i = i.prev;
					}
					 else 
					{
						break;
					}
					
				}
				
				if (( m != null )) 
				{
					p.next = m;
					m.prev = p;
				}
				 else 
				{
					p.next = null;
					this.tail = p;
				}
				
				if (( i == h )) 
				{
					n.prev = null;
					n.next = i;
					i.prev = n;
					h = n;
				}
				 else 
				{
					n.prev = i.prev;
					i.prev.next = n;
					n.next = i;
					i.prev = n;
				}
				
			}
			
			n = m;
		}
		
		return h;
	}
	
	
	public   de.polygonal.ds.DLLNode<T> _insertionSort(de.polygonal.ds.DLLNode<T> node, haxe.lang.Function cmp)
	{
		de.polygonal.ds.DLLNode<T> h = node;
		de.polygonal.ds.DLLNode<T> n = h.next;
		while (( n != null ))
		{
			de.polygonal.ds.DLLNode<T> m = n.next;
			de.polygonal.ds.DLLNode<T> p = n.prev;
			T v = n.val;
			if (( ((int) (cmp.__hx_invoke2_f(0.0, v, 0.0, p.val)) ) < 0 )) 
			{
				de.polygonal.ds.DLLNode<T> i = p;
				while (( i.prev != null ))
				{
					if (( ((int) (cmp.__hx_invoke2_f(0.0, v, 0.0, i.prev.val)) ) < 0 )) 
					{
						i = i.prev;
					}
					 else 
					{
						break;
					}
					
				}
				
				if (( m != null )) 
				{
					p.next = m;
					m.prev = p;
				}
				 else 
				{
					p.next = null;
					this.tail = p;
				}
				
				if (( i == h )) 
				{
					n.prev = null;
					n.next = i;
					i.prev = n;
					h = n;
				}
				 else 
				{
					n.prev = i.prev;
					i.prev.next = n;
					n.next = i;
					i.prev = n;
				}
				
			}
			
			n = m;
		}
		
		return h;
	}
	
	
	@Override public   double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef72 = true;
			switch (field.hashCode())
			{
				case 725594012:
				{
					if (field.equals("_poolSize")) 
					{
						__temp_executeDef72 = false;
						this._poolSize = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 106079:
				{
					if (field.equals("key")) 
					{
						__temp_executeDef72 = false;
						this.key = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 1079670056:
				{
					if (field.equals("_reservedSize")) 
					{
						__temp_executeDef72 = false;
						this._reservedSize = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 844081029:
				{
					if (field.equals("maxSize")) 
					{
						__temp_executeDef72 = false;
						this.maxSize = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 91265248:
				{
					if (field.equals("_size")) 
					{
						__temp_executeDef72 = false;
						this._size = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef72) 
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
			boolean __temp_executeDef73 = true;
			switch (field.hashCode())
			{
				case 1273051597:
				{
					if (field.equals("_iterator")) 
					{
						__temp_executeDef73 = false;
						this._iterator = ((de.polygonal.ds.Itr<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 106079:
				{
					if (field.equals("key")) 
					{
						__temp_executeDef73 = false;
						this.key = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
				case -1407567874:
				{
					if (field.equals("_circular")) 
					{
						__temp_executeDef73 = false;
						this._circular = haxe.lang.Runtime.toBool(value);
						return value;
					}
					
					break;
				}
				
				
				case 3198432:
				{
					if (field.equals("head")) 
					{
						__temp_executeDef73 = false;
						this.head = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case -605107733:
				{
					if (field.equals("_tailPool")) 
					{
						__temp_executeDef73 = false;
						this._tailPool = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 3552336:
				{
					if (field.equals("tail")) 
					{
						__temp_executeDef73 = false;
						this.tail = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case -1025369221:
				{
					if (field.equals("_headPool")) 
					{
						__temp_executeDef73 = false;
						this._headPool = ((de.polygonal.ds.DLLNode<T>) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 844081029:
				{
					if (field.equals("maxSize")) 
					{
						__temp_executeDef73 = false;
						this.maxSize = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 725594012:
				{
					if (field.equals("_poolSize")) 
					{
						__temp_executeDef73 = false;
						this._poolSize = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
				case -766976254:
				{
					if (field.equals("reuseIterator")) 
					{
						__temp_executeDef73 = false;
						this.reuseIterator = haxe.lang.Runtime.toBool(value);
						return value;
					}
					
					break;
				}
				
				
				case 1079670056:
				{
					if (field.equals("_reservedSize")) 
					{
						__temp_executeDef73 = false;
						this._reservedSize = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 91265248:
				{
					if (field.equals("_size")) 
					{
						__temp_executeDef73 = false;
						this._size = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef73) 
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
			boolean __temp_executeDef74 = true;
			switch (field.hashCode())
			{
				case -978978066:
				{
					if (field.equals("_insertionSort")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_insertionSort"))) );
					}
					
					break;
				}
				
				
				case 106079:
				{
					if (field.equals("key")) 
					{
						__temp_executeDef74 = false;
						return this.key;
					}
					
					break;
				}
				
				
				case -1022587288:
				{
					if (field.equals("_insertionSortComparable")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_insertionSortComparable"))) );
					}
					
					break;
				}
				
				
				case 3198432:
				{
					if (field.equals("head")) 
					{
						__temp_executeDef74 = false;
						return this.head;
					}
					
					break;
				}
				
				
				case 138095735:
				{
					if (field.equals("_mergeSort")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_mergeSort"))) );
					}
					
					break;
				}
				
				
				case 3552336:
				{
					if (field.equals("tail")) 
					{
						__temp_executeDef74 = false;
						return this.tail;
					}
					
					break;
				}
				
				
				case 66857137:
				{
					if (field.equals("_mergeSortComparable")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("_mergeSortComparable"))) );
					}
					
					break;
				}
				
				
				case 844081029:
				{
					if (field.equals("maxSize")) 
					{
						__temp_executeDef74 = false;
						return this.maxSize;
					}
					
					break;
				}
				
				
				case -1182381922:
				{
					if (field.equals("toArray")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("toArray"))) );
					}
					
					break;
				}
				
				
				case -766976254:
				{
					if (field.equals("reuseIterator")) 
					{
						__temp_executeDef74 = false;
						return this.reuseIterator;
					}
					
					break;
				}
				
				
				case 1182533742:
				{
					if (field.equals("iterator")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("iterator"))) );
					}
					
					break;
				}
				
				
				case 91265248:
				{
					if (field.equals("_size")) 
					{
						__temp_executeDef74 = false;
						return this._size;
					}
					
					break;
				}
				
				
				case 94746189:
				{
					if (field.equals("clear")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("clear"))) );
					}
					
					break;
				}
				
				
				case 1079670056:
				{
					if (field.equals("_reservedSize")) 
					{
						__temp_executeDef74 = false;
						return this._reservedSize;
					}
					
					break;
				}
				
				
				case -934610812:
				{
					if (field.equals("remove")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("remove"))) );
					}
					
					break;
				}
				
				
				case 725594012:
				{
					if (field.equals("_poolSize")) 
					{
						__temp_executeDef74 = false;
						return this._poolSize;
					}
					
					break;
				}
				
				
				case 3536286:
				{
					if (field.equals("sort")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("sort"))) );
					}
					
					break;
				}
				
				
				case -1025369221:
				{
					if (field.equals("_headPool")) 
					{
						__temp_executeDef74 = false;
						return this._headPool;
					}
					
					break;
				}
				
				
				case -840447469:
				{
					if (field.equals("unlink")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("unlink"))) );
					}
					
					break;
				}
				
				
				case -605107733:
				{
					if (field.equals("_tailPool")) 
					{
						__temp_executeDef74 = false;
						return this._tailPool;
					}
					
					break;
				}
				
				
				case 253181848:
				{
					if (field.equals("insertBefore")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("insertBefore"))) );
					}
					
					break;
				}
				
				
				case -1407567874:
				{
					if (field.equals("_circular")) 
					{
						__temp_executeDef74 = false;
						return this._circular;
					}
					
					break;
				}
				
				
				case -1411068134:
				{
					if (field.equals("append")) 
					{
						__temp_executeDef74 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("append"))) );
					}
					
					break;
				}
				
				
				case 1273051597:
				{
					if (field.equals("_iterator")) 
					{
						__temp_executeDef74 = false;
						return this._iterator;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef74) 
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
			boolean __temp_executeDef75 = true;
			switch (field.hashCode())
			{
				case 725594012:
				{
					if (field.equals("_poolSize")) 
					{
						__temp_executeDef75 = false;
						return ((double) (this._poolSize) );
					}
					
					break;
				}
				
				
				case 106079:
				{
					if (field.equals("key")) 
					{
						__temp_executeDef75 = false;
						return ((double) (this.key) );
					}
					
					break;
				}
				
				
				case 1079670056:
				{
					if (field.equals("_reservedSize")) 
					{
						__temp_executeDef75 = false;
						return ((double) (this._reservedSize) );
					}
					
					break;
				}
				
				
				case 844081029:
				{
					if (field.equals("maxSize")) 
					{
						__temp_executeDef75 = false;
						return ((double) (this.maxSize) );
					}
					
					break;
				}
				
				
				case 91265248:
				{
					if (field.equals("_size")) 
					{
						__temp_executeDef75 = false;
						return ((double) (this._size) );
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef75) 
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
			boolean __temp_executeDef76 = true;
			switch (field.hashCode())
			{
				case -978978066:
				{
					if (field.equals("_insertionSort")) 
					{
						__temp_executeDef76 = false;
						return this._insertionSort(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ), ((haxe.lang.Function) (dynargs.__get(1)) ));
					}
					
					break;
				}
				
				
				case -1411068134:
				{
					if (field.equals("append")) 
					{
						__temp_executeDef76 = false;
						return this.append(((T) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
				case -1022587288:
				{
					if (field.equals("_insertionSortComparable")) 
					{
						__temp_executeDef76 = false;
						return this._insertionSortComparable(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
				case 253181848:
				{
					if (field.equals("insertBefore")) 
					{
						__temp_executeDef76 = false;
						return this.insertBefore(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ), ((T) (dynargs.__get(1)) ));
					}
					
					break;
				}
				
				
				case 138095735:
				{
					if (field.equals("_mergeSort")) 
					{
						__temp_executeDef76 = false;
						return this._mergeSort(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ), ((haxe.lang.Function) (dynargs.__get(1)) ));
					}
					
					break;
				}
				
				
				case -840447469:
				{
					if (field.equals("unlink")) 
					{
						__temp_executeDef76 = false;
						return this.unlink(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
				case 66857137:
				{
					if (field.equals("_mergeSortComparable")) 
					{
						__temp_executeDef76 = false;
						return this._mergeSortComparable(((de.polygonal.ds.DLLNode<T>) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
				case 3536286:
				{
					if (field.equals("sort")) 
					{
						__temp_executeDef76 = false;
						this.sort(((haxe.lang.Function) (dynargs.__get(0)) ), dynargs.__get(1));
					}
					
					break;
				}
				
				
				case -1182381922:
				{
					if (field.equals("toArray")) 
					{
						__temp_executeDef76 = false;
						return this.toArray();
					}
					
					break;
				}
				
				
				case -934610812:
				{
					if (field.equals("remove")) 
					{
						__temp_executeDef76 = false;
						return this.remove(((T) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
				case 1182533742:
				{
					if (field.equals("iterator")) 
					{
						__temp_executeDef76 = false;
						return this.iterator();
					}
					
					break;
				}
				
				
				case 94746189:
				{
					if (field.equals("clear")) 
					{
						__temp_executeDef76 = false;
						this.clear(dynargs.__get(0));
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef76) 
			{
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		return null;
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("_iterator");
		baseArr.push("_circular");
		baseArr.push("_tailPool");
		baseArr.push("_headPool");
		baseArr.push("_poolSize");
		baseArr.push("_reservedSize");
		baseArr.push("_size");
		baseArr.push("reuseIterator");
		baseArr.push("maxSize");
		baseArr.push("tail");
		baseArr.push("head");
		baseArr.push("key");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}


