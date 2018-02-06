package com.iot.spring.dao.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.codehaus.jackson.map.ObjectMapper;

import com.iot.spring.dao.NaverTransDAO;
import com.iot.spring.vo.NaverMsg;

public class NaverTransDAOImpl implements NaverTransDAO {
	private String clientId;
	private String clientSecret;
	private String clientIdAdd;
	private String clientSecretAdd;
	private String apiURL;
	private String source;
	private String target;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getClientIdAdd() {
		return clientIdAdd;
	}

	public void setClientIdAdd(String clientIdAdd) {
		this.clientIdAdd = clientIdAdd;
	}

	public String getClientSecretAdd() {
		return clientSecretAdd;
	}

	public void setClientSecretAdd(String clientSecretAdd) {
		this.clientSecretAdd = clientSecretAdd;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	@Override
	public String getText(String eMsg) throws IOException {
		HttpURLConnection con = null;
		BufferedReader br = null;
		try {
			String text = URLEncoder.encode(eMsg, "UTF-8");
			URL url = new URL(getApiURL());
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty(getClientIdAdd(), getClientId());
			con.setRequestProperty(getClientSecretAdd(), getClientSecret());
			// post request
			String postParams = "source=" + getSource() + "&target=" + getTarget() + "&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}

			br.close();
			ObjectMapper om = new ObjectMapper();
			String json = response.toString();
			NaverMsg nm = om.readValue(json, NaverMsg.class);
			return nm.getMessage().getResult().getTranslatedText();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (br != null) {
				br.close();
			}
			if (con != null) {
				con.disconnect();
			}
		}
		return "";
	}

}
