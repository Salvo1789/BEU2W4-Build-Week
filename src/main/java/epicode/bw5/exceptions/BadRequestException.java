package epicode.bw5.exceptions;

public class BadRequestException extends RuntimeException {
	public BadRequestException(String message) {
		super(message);
	}

}