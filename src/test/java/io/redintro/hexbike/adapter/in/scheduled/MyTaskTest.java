package io.redintro.hexbike.adapter.in.scheduled;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class MyTaskTest {
  @Test
  public void shouldRunMyTask() {
    MyTask myTask = spy(new MyTask());
    myTask.execute();
    verify(myTask).execute();
  }
}
