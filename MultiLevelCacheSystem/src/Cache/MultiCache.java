package Cache;

import java.util.LinkedHashMap;

public class MultiCache<k,v> extends LinkedHashMap<k, v>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int level;
	
	public MultiCache(int level) {
		super();
		this.level = level;
	}
	



	
		

}
