package org.example.qlkv;

//import org.example.qlkv.config.SSLHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class QlkvApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlkvApplication.class, args);

	/*	SSLHelper.disableSSLVerification();

		try {
			// Kết nối đến URL qua HTTPS
			URL url = new URL("https://your-secure-url.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Đọc phản hồi từ máy chủ
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			// In phản hồi
			System.out.println("Response: " + content.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
