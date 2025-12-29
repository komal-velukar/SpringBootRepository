package in.k.main.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;	


	@RestController
	@RequestMapping
	public class AiController {
		private ChatClient chatclient;
		
		public AiController(ChatClient.Builder builder) {
			this.chatclient=builder.build();
		}
        @GetMapping("/chat")
		public ResponseEntity<String> chat(@RequestParam(value="q") String q){
			var resultReponse=chatclient.prompt(q).call().content();
			return ResponseEntity.ok(resultReponse);
		}
	} 
