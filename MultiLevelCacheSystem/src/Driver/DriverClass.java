package Driver;

import Cache.Cache;
import Cache.MultiCache;
import CacheBuilder.CacheBuilder;

public class DriverClass {

	
	public static void main(String[] args) {
		
		
		CacheBuilder builder=new CacheBuilder(4);
		builder.insertKey("1","rajat");
		builder.insertKey("2", "bansal");
		builder.insertKey("3","rajat");
		builder.getKey("1");
		builder.getKey("2");
	}
}
