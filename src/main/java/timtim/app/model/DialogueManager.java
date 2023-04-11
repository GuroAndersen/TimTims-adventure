package timtim.app.model;

import java.util.ArrayList;

public class DialogueManager {


	/**
	 * Handles dialogue in the world.
	 */

	private ArrayList<String> textboxMessages = new ArrayList<String>();
	
	protected void queueMessage(String message) {
		message = message.strip(); //simple sanitation
		textboxMessages.add(message);
	}

	private boolean continueDialogue() {
		if (textboxMessages.isEmpty()) {
			return false;
		} else {
			textboxMessages.remove(0);
			if (textboxMessages.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	public String getCurrentDialogue() {
		if (textboxMessages.isEmpty()) {
			return "";
		} else {
			return textboxMessages.get(0);
		}
	}
	
	protected boolean skipText() {
		boolean dialogueRemaining = continueDialogue();
		return dialogueRemaining;
	}
	
	protected void clear() {
		textboxMessages.clear();
	}
	
}
