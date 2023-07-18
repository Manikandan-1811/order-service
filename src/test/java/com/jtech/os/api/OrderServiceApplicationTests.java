package com.jtech.os.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class OrderServiceApplicationTests {

    @Autowired
    private OrderServiceApplication orderServiceApplication;
	@Test
	void contextLoads() {
        assertThat(orderServiceApplication).isNotNull();
	}

}
