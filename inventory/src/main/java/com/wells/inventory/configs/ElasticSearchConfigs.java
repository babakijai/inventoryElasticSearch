package com.wells.inventory.configs;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.wells.inventory.repositories")
@ComponentScan(basePackages = "com.wells.inventory")
public class ElasticSearchConfigs extends AbstractElasticsearchConfiguration {

	@SuppressWarnings("deprecation")
	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200")
				.build();

		return RestClients.create(clientConfiguration).rest();
	}

}
