package hust.soict.hedspi.aims.exception;

import javax.swing.JOptionPane;

public class PlayerException extends Exception {

	public PlayerException() {
		// TODO Auto-generated constructor stub
		JOptionPane.showMessageDialog(null,"ERROR: The media length is non-positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public PlayerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		JOptionPane.showMessageDialog(null,"ERROR: The media length is non-positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public PlayerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
