package me.fabricionogueira.api.modules.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloImpl implements HelloService {

	private HelloMapper helloMapper;

	@Autowired
	public HelloImpl(HelloMapper helloMapper) {
		this.helloMapper = helloMapper;
	}

	@Override
	public HelloDTO sayHello(String to) {
		Hello something = new Hello();
		something.setMessage(to);
		return helloMapper.toDTO(something);
	}
}
