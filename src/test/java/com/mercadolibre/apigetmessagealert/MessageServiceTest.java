package com.mercadolibre.apigetmessagealert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.apigetmessagealert.services.IMessageService;

@SpringBootTest
public class MessageServiceTest {

	@Autowired
	private IMessageService messageService;

	/**
	 * valida la funcionalidad que interpreta y construye el mensaje
	 */
	@Test
	public void validateMessage() {

		List<String> lista1 = new ArrayList<String>();
		lista1.add("este");
		lista1.add("");
		lista1.add("");
		lista1.add("mensaje");
		lista1.add("");

		List<String> lista2 = new ArrayList<String>();
		lista2.add("");
		lista2.add("es");
		lista2.add("");
		lista2.add("");
		lista2.add("secreto");

		List<String> lista3 = new ArrayList<String>();
		lista3.add("este");
		lista3.add("");
		lista3.add("un");
		lista3.add("");
		lista3.add("");

		List<List<String>> messages = new ArrayList<List<String>>();
		messages.add(lista1);
		messages.add(lista2);
		messages.add(lista3);

		assertThat(messageService.getMessage(messages)).isEqualTo("este es un mensaje secreto");

	}
}
