package com.zed.bookapi;

import com.zed.bookapi.controller.BookController;
import com.zed.bookapi.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookapiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService service;

	@Test
	void whenValidID_returns200() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.get("/books/1"))
//				.andDo(print())
				.andExpect(status().isOk());
	}

}
