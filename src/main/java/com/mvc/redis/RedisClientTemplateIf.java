package com.mvc.redis;

public interface RedisClientTemplateIf {
	public String get(String key);
	public String set(String key, String value);
}
