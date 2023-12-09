package com.ws.soap.email;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiEmail {


	// The class used to make the API request
	@Service
	public class MailtrapClient {

	  private final OkHttpClient client;

	  public MailtrapClient() {
	    this.client = new OkHttpClient().newBuilder().build();
	  }

	  public void sendEmail(String from, String to, String subject, String text, String category) throws IOException {
	    MediaType mediaType = MediaType.parse("application/json");
	    RequestBody body = RequestBody.create(mediaType,
	        "{\"from\":{\"email\":\"" + from + "\",\"name\":\"Mailtrap Test\"},\"to\":[{\"email\":\"" + to + "\"}],\"subject\":\"" + subject + "\",\"text\":\"" + text + "\",\"category\":\"" + category + "\"}");
	    Request request = new Request.Builder()
	        .url("https://send.api.mailtrap.io/api/send")
	        .method("POST", body)
	        .addHeader("Authorization", "Bearer ********67a4")
	        .addHeader("Content-Type", "application/json")
	        .build();
	    Response response = client.newCall(request).execute();
	  }
	}

	// The class where the API request is made
	@Controller
	public class MyController {

	  private final MailtrapClient mailtrapClient;

	  public MyController(MailtrapClient mailtrapClient) {
	    this.mailtrapClient = mailtrapClient;
	  }


	  @GetMapping("/send-email")
	  public void sendEmail() {
	    try {
	      mailtrapClient.sendEmail("mailtrap@mailtrap.club", "example@railsware.com",
	          "You are awesome!", "Congrats for sending test email with Mailtrap!", "Integration Test");
	    } catch (IOException e) {
	      // Handle the error
	    }
	  }
	}
}
