package me.fabricionogueira.api.modules.hello;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Api(description = "Say hello to the world")
public class HelloController {

	private HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping("{name}")
	@ApiOperation(
		value = "Say somenthing",
		notes = "Just return values"
	)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Usuários listados com sucesso")
	})
	public HelloDTO myName(
		@RequestParam(required = true)
		@ApiParam(value = "Send a new param")
			String name) {

		return helloService.sayHello(name);
	}

}
