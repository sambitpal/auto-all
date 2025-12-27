package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.UserDTO;

public class RequestBodyBuilder {

	static ObjectMapper objm = new ObjectMapper();
	
	public static String postBodyProcessor(UserDTO requestDtoObject)
	{
		String jsonStringFromDto = null;
		try {
			jsonStringFromDto = objm.writeValueAsString(requestDtoObject);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStringFromDto;
	}
	
	public static String postBodyProcessor(String requestDtoObject)
	{
		String jsonStringFromDto = null;
		try {
			jsonStringFromDto = objm.writeValueAsString(requestDtoObject);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStringFromDto;
	}
}
