package com.github.example;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import java.util.List;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

@GraphQLClientApi
public interface ExampleResolverClient {

  @Query @NonNull List<@NonNull DescribedValue<Option>> getOptions();

  @Query @NonNull DescribedValue<Option> getOption();

}
