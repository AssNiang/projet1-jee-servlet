package sn.ept.git.dic2.projet1jeeservlet;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("api")
@OpenAPIDefinition(
        info = @Info(
                title = "API FOR DIC2 STUDENTS",
                description = "Thinking about what to put here ...",
                contact = @Contact(
                        name = "Ass",
                        email = "nianga@ept.sn",
                        url = "link-to-my-website"
                ),
                version = "1.0",
                license = @License(name = "OpenSource")
        ),
        servers = {@Server(
                url = "{urlDeployment}",
                variables = {
                        @ServerVariable(
                                name = "urlDeployment",
                                defaultValue = "http://localhost:8080/projet1-jee-servlet-1.0-SNAPSHOT/"
                        )
                }
        )}
)
public class ApiRestConfig extends Application {
}
