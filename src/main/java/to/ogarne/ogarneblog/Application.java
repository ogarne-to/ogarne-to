package to.ogarne.ogarneblog;

import com.github.slugify.Slugify;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import to.ogarne.ogarneblog.dao.StorageDao;

/**
 * Created by jedrz on 16.07.2017.
 */

@ComponentScan
@EnableAutoConfiguration
@EnableSpringDataWebSupport

public class Application {



    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);


    }


    @Bean
    public CommandLineRunner init(StorageDao storageDao) {
        return (args) -> {
            storageDao.init();
        };
    }

    @Bean
    public Slugify slugify() {
        return new Slugify();
    }

}



