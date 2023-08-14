package com.example.todolist.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import com.example.todolist.entity.Todo;
import com.example.todolist.form.TodoData;
import com.example.todolist.repository.TodoRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor // ②
public class TodoListController {
	private final TodoRepository todoRepository;
	private final TodoService todoService;

	@GetMapping("/todo")
	public ModelAndView showTodoList(ModelAndView mv) {
		// 一覧を検索して表示する
		mv.setViewName("todoList");
		List<Todo> todoList = todoRepository.findAll(); // ③
		mv.addObject("todoList", todoList); // ④
		return mv;
	}
	
	@GetMapping("/todo/create")
	public ModelAndView createTodo(ModelAndView mv) {
		mv.setViewName("todoForm");
		mv.addObject("todoData",new TodoData());
		return mv;
	}
	
	@PostMapping("/todo/create")
	public ModelAndView createTodo(@ModelAttribute @Validated TodoData todoData,
			BindingResult result,
			ModelAndView mv) {
		boolean is Valid = todoService.isValid(todoData,result);
		if(!result.hasErrors()&& isValid) {
			Todo todo =todoData.toEntity();
			todoRepository.saveAndFlush(todo);
			return showTodoList(mv);
			
		}else {
			mv.setViewName("todoForm")
			return mv;
		}
	}
	
	@PostMapping("/todo/cancel")
	public String cancel() {
		return "redirect:/todo";
	}
}
