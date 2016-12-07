package br.com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.test.model.Usuario;
import br.com.test.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/home")
	public @ResponseBody String home() {
		return "home";
	}

	@GetMapping(value = "/usuario/{id}")
	public @ResponseBody ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.findById(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		List<Usuario> list = usuarioService.getAll();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id) {
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public @ResponseBody String sayHello() {
		return "hellll";
	}

}