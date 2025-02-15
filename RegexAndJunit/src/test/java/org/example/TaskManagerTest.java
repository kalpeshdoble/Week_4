package org.example;

import org.example.Junit.TaskManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class TaskManagerTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fail if it takes more than 2 seconds
    void testLongRunningTaskTimeout() throws InterruptedException {
        assertEquals("Task Completed", TaskManager.longRunningTask());
    }
}

