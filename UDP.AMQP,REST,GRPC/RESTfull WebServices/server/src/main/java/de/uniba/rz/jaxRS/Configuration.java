package de.uniba.rz.jaxRS;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Configuration {
    private static final Logger LOGGER = Logger.getLogger(Configuration.class.getName());

    public static Properties loadProperties() {
        try (InputStream stream = TicketApi.class.getClassLoader().getResourceAsStream("config.properties")) {
        	if(stream==null) {
        		LOGGER.severe("Stream is null/not connected");
        	}
            Properties properties = new Properties();
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            LOGGER.severe("Cannot load configuration file.");
            return null;
        }
    }
}
