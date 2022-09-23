package com.memely.memely;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = MemelyApplication.class)
class MemelyApplicationTests {

	  @Test
	  void contextLoads(ApplicationContext context) {
	    assertThat(context).isNotNull();
	  }

}
