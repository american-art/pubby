package de.fuberlin.wiwiss.pubby;

import java.util.HashMap;

class Property {
	String prefix = null;
	String base = null;
	String name = null;
	String homepage = null;
}

public class MultiURIMapping {
	private HashMap<String, Property> prefixMap;
	private HashMap<String, String> baseMap; // reverse mapping

	public MultiURIMapping() {
		prefixMap = new HashMap<String, Property>();
		baseMap = new HashMap<String, String>();
	}

	public void add(String prefix, String base) {
		if(prefixMap.containsKey(prefix)) return;

		Property p = new Property();
		p.prefix = prefix;
		p.base = base;
		prefixMap.put(prefix, p);
		baseMap.put(base, prefix);
	}

	public void setName(String prefix, String name) {
		if(!prefixMap.containsKey(prefix)) return;
		prefixMap.get(prefix).name = name;
	}

	public void setHomepage(String prefix, String homepage) {
		if(!prefixMap.containsKey(prefix)) return;
		prefixMap.get(prefix).homepage = homepage;
	}

	public boolean isPrefix(String prefix) {
		return prefixMap.containsKey(prefix);
	}

	public String getURIBase(String prefix) {
		if(prefixMap.containsKey(prefix)) return prefixMap.get(prefix).base;
		return null;
	}

	public String getPrefix(String URI) {
		for(String key : baseMap.keySet()) {
			if(URI.startsWith(key))
				return baseMap.get(key);
		}
		return null;
	}

	public String getName(String URI) {
		String prefix = getPrefix(URI);
		if(prefix == null) return null;
		return prefixMap.get(prefix).name;
	}

	public String getHomepage(String URI) {
		String prefix = getPrefix(URI);
		if(prefix == null) return null;
		return prefixMap.get(prefix).homepage;
	}
}