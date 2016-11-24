package br.com.model.company.fixture;

import java.text.SimpleDateFormat;

import br.com.model.company.Endereco;
import br.com.model.company.Sexo;
import br.com.model.company.Usuario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UsuarioTemplateLoader implements TemplateLoader {
	@Override
	public void load() {
		Fixture.of(Usuario.class).addTemplate("usuario-first", new Rule() {
			{
				add("id", random(Long.class, range(1L, 200L)));
				add("nomeCurto", random("Mirla Braga", "Rafaela Chucre"));
				add("nomeCompleto", random("Mirla Rafaela Braga", "Rafaela RafaelChucre"));
				add("dataNascimento", randomDate("2011-04-15", "2011-11-07", new SimpleDateFormat("yyyy-MM-dd"))); 
				add("sexo", Sexo.FEMININO);
				add("cpf", "00843223308");
				add("telefone", "8439483984");
				add("celular", "483984942");
				add("email", "mirlabraga@gmail.com");
				add("senha", "123456");
				add("endereco", one(Endereco.class, "valid"));
			}
		});

		Fixture.of(Endereco.class).addTemplate("endereco-first", new Rule() {
			{
				add("id", random(Long.class, range(1L, 100L)));
				add("logradouro", random("Paulista Avenue", "Ibirapuera Avenue"));
				add("bairro", "Vila Mariana");
				add("cidade", "São Paulo");
				add("uf", "SP");
				add("cep", random("06608000", "17720000"));
			}
		});
	}
}