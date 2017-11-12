package sample.data.jpa.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class APIOpenWeather implements Previsions {

	private static final String APPID = "d33e23fe59e1aa524697b7bbde449911";

	public void getPrevision() {
		try {
			// 2983990 = id de Rennes
			URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=35000,fr&APPID=" + APPID
					+ "&units=metric&lang=fr");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
