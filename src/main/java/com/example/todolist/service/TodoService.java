package com.example.todolist.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import com.example.todolist.form.TodoData;

@Service
public class TodoService {
	
	public boolean is Vaild(TodoData todoData,BindingResult result) {
		boolean ans = true;
		
		String title = todoData.getTitle();
		if(title != null&& !title.equals("")) {
			boolean is AllDoubleSpace = true;
			for(int i = o;i<title.length();i++) {
				if(title.charAt(i)!=' ') {
					isAllDoubleSpace=false;
					break;
				}
			}
			if(isAllDoubleSpace) {
				FieldError fieldError=new FieldError
			}
		}
	}

}
