package com.ashokit.prop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.Data;

@Data
//read the properties from properties file
@EnableConfigurationProperties
@ConfigurationProperties(prefix ="app")
public class AppProperties {

	private Map<String, String> messages = new HashMap<>();
	
	
}
