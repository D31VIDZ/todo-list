package com.example.TodoList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.TodoList.entities.Task;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {

	@Autowired
	private WebTestClient webTest;
	
	@Test
	void testCreateTodoSucess() {
		Task task = new Task("task1", "desc", 3);
		
		webTest.post()
					.uri("/tasks")
						.bodyValue(task)
						.exchange()
						.expectStatus()
						.isCreated()
						.expectBody()
						.jsonPath("$.nome").isEqualTo(task.getNome())
						.jsonPath("$.descricao").isEqualTo(task.getDescricao())
						.jsonPath("$.prioridade").isEqualTo(task.getPrioridade());
	}

	@Test
	void testCreateTodoFailure() {
		webTest.post()
		.uri("/tasks")
			.bodyValue(
					new Task("", "adsd", 2))
			.exchange()
			.expectStatus().is5xxServerError();
	}
	
	@Test
	void testgetAllTodoSucess() {
		
		webTest.get()
					.uri("/tasks")
						.exchange()
						.expectStatus()
						.isOk();
	}
	
	@Test
	void testgetIdTodoSucess() {
		
		webTest.get()
					.uri("/tasks/1")
						.exchange()
						.expectStatus()
						.isOk();
	}
	
	@Test
	void testgetIdTodoFailure() {
		
		webTest.get()
					.uri("/tasks/15")
						.exchange()
						.expectStatus()
						.is5xxServerError();
	}

}
