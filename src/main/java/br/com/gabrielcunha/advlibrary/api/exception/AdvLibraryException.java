package br.com.gabrielcunha.advlibrary.api.exception;

public class AdvLibraryException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AdvLibraryException() {
		super();
	}

	public AdvLibraryException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdvLibraryException(String message) {
		super(message);
	}
	
	public AdvLibraryException(Throwable cause) {
		super(cause);
	}
	
}
