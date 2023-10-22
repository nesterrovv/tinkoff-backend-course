package edu.hw2.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CallingInfoManagerTest {

    @Test
    @DisplayName("Test should print calling test method name")
    void assertToItself() {
        CallingInfo result = CallingInfoManager.callingInfo();
        assertThat(result.methodName()).isEqualTo("assertToItself");
    }

}
