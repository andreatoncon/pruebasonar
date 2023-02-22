package com.nttdata.pd.msorder.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Initial configuration that scan the exception rest library
 */
@Configuration
@EnableCassandraRepositories(basePackages = {"com.nttdata"})
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${spring.cassandra.contact-points:placeholder}")
    private String contactPoints;
  
    @Value("${spring.cassandra.port:0000}")
    private int port;
  
    @Value("${spring.cassandra.keyspace:placeholder}")
    private String keySpace;
  
    @Override
    protected String getKeyspaceName() {
      return keySpace;
    }
  
    @Override
    protected String getContactPoints() {
      return contactPoints;
    }
  
    @Override
    protected int getPort() {
      return port;
    }
}