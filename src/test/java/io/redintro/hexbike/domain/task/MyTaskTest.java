package io.redintro.hexbike.domain.task;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyTaskTest {
    @Test
    public void shouldRunMyTask() {
        MyTask myTask = spy(new MyTask());
        myTask.execute();
        verify(myTask).execute();
    }
}
