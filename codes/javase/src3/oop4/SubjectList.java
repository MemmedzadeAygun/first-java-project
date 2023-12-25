package oop4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubjectList {
	private final List<String> subjects=new ArrayList<>();
	
	public void addSubject(String subject) {
		subjects.add(subject);
	}
	
	public void removeSubject(String subject) {
		subjects.remove(subject);
	}
	
	public List<String> getSubject() {
		return Collections.unmodifiableList(subjects);
	}
}
