package vsu.javablog.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {
    "vsu.javablog.db.entity"
})
@EnableJpaRepositories(basePackages = "vsu.javablog.db.repositories")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
