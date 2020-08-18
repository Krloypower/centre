import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 * @author ouyangkang
 */
@SpringBootApplication
@ComponentScan(basePackages = "rubbish")
public class RubbishApplication {

    public static void main(String[] args) {
        SpringApplication.run(RubbishApplication.class, args);
    }

}
