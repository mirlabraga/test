package br.com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class UsuarioController {

/*	@Autowired
	private UsuarioService personService;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/")
	@ResponseBody
	public String helloWorld() {
		return "fffffffffffMirla";
	}*/

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String sayHello(
			@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
		return "hellll";
	}

}