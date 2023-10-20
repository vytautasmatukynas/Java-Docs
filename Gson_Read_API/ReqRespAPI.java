import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class ReqRespAPI {
	
	public static String getStringFromUrl(String url) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			
			HttpGet httpGet = new HttpGet(url);
			
			httpGet.setHeader("Accept", "application/json");
			
			try(CloseableHttpResponse responce = httpClient.execute(httpGet)) {
				
				HttpEntity entity = responce.getEntity();
				
				if (entity != null)
					return EntityUtils.toString(entity);	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	public static <T> List<T> fetchDataAsList(String url, Class<T> type) {
		String json = getStringFromUrl(url);
		
		try {
			Gson gson = new Gson();
			
			Type dataList = TypeToken.getParameterized(List.class, type).getType();
			
			return gson.fromJson(json, dataList);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	
	public static <T> Optional<T> fetchDataAsObject(String url, Class<T> type) {
		String json = getStringFromUrl(url);
		
        try {
        	return Optional.ofNullable(new Gson()
        			.fromJson(json, type));
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		return Optional.empty();
	}
	
}
