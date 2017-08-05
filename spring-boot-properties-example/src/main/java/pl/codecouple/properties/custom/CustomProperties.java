package pl.codecouple.properties.custom;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

/**
 * Created by Krzysztof Chruściel.
 */
@Data
@ConfigurationProperties(prefix="custom")
@Validated
public class CustomProperties {

    /** Property value. */
    @NotEmpty
    private String property;

    /** Map example. */
    private Map<String, String> pathMapper;

    /** Connection propeties. */
    private Connection connection;

    @Data
    public static class Connection {

        /** Connection port. */
        private int port = 8080;
        /** Connection address. */
        private String address = "localhost";
        /** This value is deprecated. */
        private String server;

        @DeprecatedConfigurationProperty(replacement = "custom.connection.address")
        @Deprecated
        public String getServer() {
            return getAddress();
        }

        @Deprecated
        public void setServer(String server){
            setAddress(server);
        }

    }


}
