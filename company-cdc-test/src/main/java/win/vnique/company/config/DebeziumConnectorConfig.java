package win.vnique.company.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class provides the configurations required to setup a Debezium connector for the Company Table.
 *
 * @author Sohan
 */
@Configuration
public class DebeziumConnectorConfig {

    /**
     * Company Database details.
     */
    @Value("${company.datasource.host}")
    private String companyDBHost;

    @Value("${company.datasource.databasename}")
    private String companyDBName;

    @Value("${company.datasource.port}")
    private String companyDBPort;

    @Value("${company.datasource.username}")
    private String companyDBUserName;

    @Value("${company.datasource.password}")
    private String companyDBPassword;

    private String COMPANY_TABLE_NAME = "public.company";

    /**
     * Company database connector.
     *
     * @return Configuration.
     */
    @Bean
    public io.debezium.config.Configuration companyConnector() {
        return io.debezium.config.Configuration.create()
                .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
                .with("offset.storage",  "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", "D:\\ideaPro\\embedded-debezium\\company-offset.dat")
                .with("offset.flush.interval.ms", 30000)
                .with("name", "company-postgres-connector")
                .with("database.server.name", companyDBHost+"-"+companyDBName)
                .with("database.hostname", companyDBHost)
                .with("database.port", companyDBPort)
                .with("database.user", companyDBUserName)
                .with("database.password", companyDBPassword)
                .with("database.dbname", companyDBName)
                .with("table.whitelist", COMPANY_TABLE_NAME).build();
    }
}
