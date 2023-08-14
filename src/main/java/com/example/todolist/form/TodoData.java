package com.example.todolist.form;

import java.text.SimpleDateFormat;

import com.example.todolist.entity.Todo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TodoData {
	private Intger id;
	
	@NotBlank(message="件名を入力してください")
	private String title;
	
	@NotNull(message="重要度を選択してください")
	private Integer importance;
	
	@Min(value=0,message="緊急度を選択してください")
	private Integer urgency;
	
	public Todo toEntity() {
		Todo todo =newTodo();
		todo.setId(id);
		todo.setImportance(importance);
		todo.setUrgency(urgency);
		todo.setDone(done);
		
		SimpleDateFormat sdFormat = new SimpleDataFormat("yyyy-MM-dd");
		long ms;
		try {
			ms =sdFormat.parse(deadline).getTime();
			todo.setDeadline(new Date(ms));
		}catch(ParseException e) {
			todo.setDeadline(null);
		}
		
		return todo;
		
	}
	
	
	

}
