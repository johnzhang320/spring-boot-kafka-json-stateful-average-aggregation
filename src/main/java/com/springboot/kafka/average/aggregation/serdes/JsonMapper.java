package com.springboot.kafka.average.aggregation.serdes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonMapper {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		objectMapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, true);
		objectMapper.findAndRegisterModules();
	}

	/**
	 * Map the given JSON String to the required class type.
	 */
	public static <T> T readFromJson(String json, Class<T> clazz) throws MappingException {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new MappingException(e);
		}
	}

	/**
	 * Map the given Object to a JSON String.
	 */
	public static String writeToJson(Object obj) throws MappingException {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new MappingException(e);
		}
	}

	public static String writeJsonToPretty (String json)    {
		try {
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		} catch (Exception e) {
			throw new MappingException(e);
		}
	}
	public static String writeObjectToPrettyJson (Object obj)  {
		String json = writeToJson(obj);
		return writeJsonToPretty (json);

	}
}
