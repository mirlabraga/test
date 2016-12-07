package br.com.test.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import br.com.test.model.Usuario;

public class ValidatorTests {

    private Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    @Test
    public void deveNaoValidarQuandoNomeCurtoVazio() {

        LocaleContextHolder.setLocale(Locale.ENGLISH);
        Usuario usuario = new Usuario();
        usuario.setNomeCurto("");
        usuario.setNomeCompleto("smith");

        Validator validator = createValidator();
        Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

        assertThat(constraintViolations.size()).isEqualTo(1);
        ConstraintViolation<Usuario> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("nomeCurto");
        assertThat(violation.getMessage()).isEqualTo("may not be empty");
    }

}
