package com.example.kekeplayer.utils.https;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpApiImpl {

	private HttpParams getHttpParams()
	  {
	    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
	    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
	    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
	    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
	    HttpClientParams.setRedirecting(localBasicHttpParams, true);
	    return localBasicHttpParams;
	  }
	
	public String doHttpGet(String httpUrl){
		String strResult = "";
		try {
			HttpGet httpRequest = new HttpGet(httpUrl);
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				strResult = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (Exception e) {
		}
		return strResult;
		
	}
}
