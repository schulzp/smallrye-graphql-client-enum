# SmallRye GraphQL Reproducer Project

Showcases two issues with SmallRye GraphQL

## **\[SERVER]** Translation of Nullability

* `@NonNull List<@NonNull String> list;` correctly maps to `list: [String!]!`.
* :bug: `@NonNull List<@NonNull CustomGeneric<String>> list;` maps to `list: [CustomGeneric_String]!` (list elements are no longer null-safe im schema).
* :warning: `@NonNull List<@NonNull CustomGeneric<@NonNull String>> list;` maps to `list: [CustomGeneric_String!]!`, however.

See also [schema.graphqls](./schema.graphqls).

## **\[CLIENT]** Mapping of Enums as Generic Types

Let's assume a generic type `DescribedValue`:

```java
import org.eclipse.microprofile.graphql.NonNull;

public class DescribedValue<V> {

  @NonNull value;
  
  String description;
  
  /* ... */
  
}

public enum Option {
  OPTION_A, OPTION_B  
}

public class Resolver {
  @Query @NonNull DescribedValue<Option> getOption() {
    return new DescribedValue<>(Option.OPTION_A, "Option A");
  }
}
```

Then the client generates a query as follows:

````graphql
query option { option {value {name ordinal} description} }
````

Which fails as enums do not allow sub selection (of `name` or `ordinal`).

# Usage

```shell
./mvnw clean verify
```

## Related Guides

- SmallRye GraphQL Client ([guide](https://quarkus.io/guides/smallrye-graphql-client)): Create GraphQL Clients
- SmallRye GraphQL ([guide](https://quarkus.io/guides/microprofile-graphql)): Create GraphQL Endpoints using the code-first approach from MicroProfile GraphQL
