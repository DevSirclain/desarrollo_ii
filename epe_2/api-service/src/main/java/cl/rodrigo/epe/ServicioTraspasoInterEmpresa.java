package cl.rodrigo.epe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cl.rodrigo.epe.model.dao")
@EnableScheduling
public class ServicioTraspasoInterEmpresa  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ServicioTraspasoInterEmpresa.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServicioTraspasoInterEmpresa.class);
	}

	
}
