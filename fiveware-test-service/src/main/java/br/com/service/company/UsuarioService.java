
package br.com.service.company;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.model.company.Usuario;
import br.com.repositorio.company.UsuarioRepository;

@Controller
class UsuarioService {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "usuarios/createOrUpdateUsuarioForm";
    private final UsuarioRepository usuarios;


    @Autowired
    public UsuarioService(UsuarioRepository userService) {
        this.usuarios = userService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/usuario/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/usuarios/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            this.usuarios.save(usuario);
            return "redirect:/usuarios/" + usuario.getId();
        }
    }

    @RequestMapping(value = "/usuarios/find", method = RequestMethod.GET)
    public String initFindForm(Map<String, Object> model) {
        model.put("usuario", new Usuario());
        return "usuarios/procurarUsuarios";
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String processFindForm(Usuario usuario, BindingResult result, Map<String, Object> model) {

        if (usuario.getNomeCurto() == null) {
            usuario.setNomeCurto(""); 
        }

        Collection<Usuario> results = this.usuarios.procurarPorNomeCurto(usuario.getNomeCurto());
        if (results.isEmpty()) {
            result.rejectValue("nomeCurto", "notFound", "not found");
            return "usuarios/procurarUsuarios";
        } else if (results.size() == 1) {
            usuario = results.iterator().next();
            return "redirect:/usuarios/" + usuario.getId();
        } else {
            model.put("selections", results);
            return "usuarios/usuariosList";
        }
    }

    @RequestMapping(value = "/usuarios/{usuarioId}/edit", method = RequestMethod.GET)
    public String initUpdateUsuarioForm(@PathVariable("usuarioId") int id, Model model) {
        Usuario usuario = this.usuarios.procurarPorId(id);
        model.addAttribute(usuario);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/usuarios/{usuarioId}/edit", method = RequestMethod.POST)
    public String processUpdateUsuaioForm(@Valid Usuario usuario, BindingResult result, @PathVariable("usuarioId") long usuarioId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            usuario.setId(usuarioId);
            this.usuarios.save(usuario);
            return "redirect:/usuarios/{usuarioId}";
        }
    }
    
    @RequestMapping("/usuarios/{usuarioId}")
    public ModelAndView showUsuario(@PathVariable("usuarioId") int id) {
        ModelAndView mav = new ModelAndView("usuarios/usuarioDetails");
        mav.addObject(this.usuarios.procurarPorId(id));
        return mav;
    }

}
