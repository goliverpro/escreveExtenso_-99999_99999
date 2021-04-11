package com.certi.sapientia;

import com.certi.sapientia.services.ExtensoPathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SapientiaApplicationTests {

	@Autowired
	ExtensoPathService service;

	@Test
	void testeDeFalha() {
		
		service.retornaValorExtenso(10000000);
	}
	@Test
	void testeDeSucesso(){

		service.retornaValorExtenso(100);
	}

}
