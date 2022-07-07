package com.github.example;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.graphql.client.typesafe.api.TypesafeGraphQLClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ExampleResolverTest {

  @TestHTTPResource("/graphql")
  String endpoint;

  ExampleResolverClient client;

  @BeforeEach
  void setupClient() {
    client = TypesafeGraphQLClientBuilder.newBuilder().endpoint(endpoint)
        .build(ExampleResolverClient.class);
  }

  @Test
  void getOptions() {
    client.getOptions();
  }

  @Test
  void getOption() {
    client.getOption();
  }

}
