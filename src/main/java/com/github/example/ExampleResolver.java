package com.github.example;

import java.util.List;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class ExampleResolver {

  @Query
  public @NonNull List<@NonNull DescribedValue<Option>> getOptions() {
    return List.of(new DescribedValue<>(Option.OPTION_A, "Option A"));
  }

  @Query
  public @NonNull List<@NonNull DescribedValue<@NonNull Option>> getOptionsNullSafe() {
    return List.of(new DescribedValue<>(Option.OPTION_A, "Option A"));
  }

  @Query
  public @NonNull DescribedValue<Option> getOption() {
    return new DescribedValue<>(Option.OPTION_B, "Option B");
  }
}
