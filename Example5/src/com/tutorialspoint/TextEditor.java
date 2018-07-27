package com.tutorialspoint;

public class TextEditor {
	private SpellingCheck spellingCheck;
	
	public TextEditor(SpellingCheck spellingCheck) {
		this.spellingCheck = spellingCheck;
	}
	
	
	public void startSpellCheck() {
		spellingCheck.doSpellCheck();
	}
}
