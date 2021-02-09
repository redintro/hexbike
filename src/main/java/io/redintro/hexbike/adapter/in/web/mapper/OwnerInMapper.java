package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;
import io.vavr.Value;
import io.vavr.control.Option;
import io.vavr.control.Try;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OwnerInMapper {
  public static Option<Owner> mapToDomainEntity(OwnerResource resource) {
    return Try.of(
            () ->
                Owner.getInstance(
                    resource.getId(), resource.getFirstName(), resource.getLastName()))
        .toOption();
  }

  public static Option<OwnerResource> mapToRestResource(Owner owner) {
    return OwnerInMapper.toOwnerRestResource(owner);
  }

  public static List<OwnerResource> mapToListRestResource(List<Owner> owners) {
    return Try.of(
            () ->
                owners.stream()
                    .map(OwnerInMapper::toOwnerRestResource)
                    .flatMap(Value::toJavaStream)
                    .collect(Collectors.toList()))
        .getOrElse(Collections::emptyList);
  }

  private static Option<OwnerResource> toOwnerRestResource(Owner owner) {
    return Try.of(() -> new OwnerResource(owner.getId(), owner.getFirstName(), owner.getLastName()))
        .toOption();
  }
}
