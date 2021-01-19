package Cache;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<k,v> extends LinkedHashMap<k, v> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int readTime,writeTime,capacity;
	
	public Cache(int capacity,int readTime,int writeTime){
		super(capacity,0.75f,true);
		this.capacity=capacity;
		this.readTime=readTime;
		this.writeTime=writeTime;
		
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<k,v> eldest) {
		if(size()>capacity) {
			return true;
		}
		return false;
	}		
}
