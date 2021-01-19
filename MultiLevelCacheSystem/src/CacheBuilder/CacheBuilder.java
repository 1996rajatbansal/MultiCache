package CacheBuilder;

import Cache.Cache;
import Cache.MultiCache;
import Cache.MultiCacheInterface;

public class CacheBuilder<k,v> implements MultiCacheInterface{
	
	MultiCache<Integer,Cache<String,String>>multCache;
	int level;
	public CacheBuilder(int level)
	{
		this.level=level;
		multCache=new MultiCache<Integer, Cache<String,String>>(level);
		this.init(level, multCache);
	}
	
	
	
	private  void  init(int level,MultiCache<Integer,Cache<String,String>> multiCache)
	{
		
		
		for(int i=0;i<this.level;i++)
		{
		
			
			multiCache.put(i,new Cache<String, String>(2,1,1));//TODO we can change it also
		}
		
	}
	
	@Override
	public void insertKey(String key, String value) {
		// TODO Auto-generated method stub
		
		int totalTime=0;

		for(int i=0;i<this.level;i++)
		{

			Cache<String,String>cache=(Cache<String, String>)this.multCache.get(i);
			if(cache.containsKey(key)&&cache.get(key).equals(value)) {
			
				System.out.println("Value Already present at level :"+(i+1)+" traverseed time:"+totalTime);
				return;
			//no need to write	
			}
			else {
				cache.put(key,value);
			}
			totalTime++;
			
		}
		System.out.println("Value was not present at any level :"+" traverseed time:"+totalTime);
		return;
		
		
	}

	@Override
	public void getKey(String key) {
		// TODO Auto-generated method stub
		
		
		int totalTime=0;
		int i=0;
		String value = null;
		for(i=0;i<this.level;i++)
		{
			Cache<String,String>cache=(Cache<String, String>)this.multCache.get(i);
			if(cache.containsKey(key)) {
			value=cache.get(key);
			break;
			}
			totalTime++;
		}
	
		if(value!=null) {
			for(int j=0;j<i;j++)
			{
				Cache<String,String>cache=(Cache<String, String>)this.multCache.get(i);
				cache.put(key,value);
				totalTime++;
			}
		System.out.println("Key:"+key+" Found at level:"+(i+1)+"..traversed time:"+totalTime);
	}
		else {
			System.out.println("Key:"+key+" Not Found at any level:"+"..traversed time:"+totalTime);	
		}
		}

}
