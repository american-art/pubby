package de.fuberlin.wiwiss.pubby;

import java.util.HashMap;

public class MultiURIMapping {
	private HashMap<String, String> prefixMap;
	private HashMap<String, String> baseMap;

	public MultiURIMapping() {
		prefixMap = new HashMap<String, String>();
		baseMap = new HashMap<String, String>();
	}

	public void add(String prefix, String base) {
		prefixMap.put(prefix, base);
		baseMap.put(base, prefix);
	}

	public boolean isPrefix(String prefix) {
		return prefixMap.containsKey(prefix);
	}

	public String getURIBase(String prefix) {
		if(prefixMap.containsKey(prefix)) return prefixMap.get(prefix);
		return null;
	}

	public String getPrefix(String URI) {
		for(String key : baseMap.keySet()) {
			if(URI.startsWith(key))
				return baseMap.get(key);
		}
		return null;
	}
}