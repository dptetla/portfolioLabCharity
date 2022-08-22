package pl.coderslab.charity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    private String email;
    private String password;
}
