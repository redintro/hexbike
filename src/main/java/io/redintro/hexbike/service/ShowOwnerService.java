package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowOwnerPort;
import io.redintro.hexbike.port.out.FindOwnerPort;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ShowOwnerService implements ShowOwnerPort {
  private final FindOwnerPort findOwnerPort;

  public ShowOwnerService(FindOwnerPort findOwnerPort) {
    this.findOwnerPort = findOwnerPort;
  }

  @Override
  public List<Owner> findAll() {
    return findOwnerPort.findAll();
  }

  @Override
  public Option<Owner> findById(UUID ownerId) {
    return findOwnerPort.findById(ownerId);
  }
}
