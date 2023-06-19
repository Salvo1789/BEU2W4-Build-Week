package epicode.bw5.entities.payloads;

import lombok.Getter;

@Getter
public class UserLoginPayload {
	String username;
	String password;
}