package edu.hw2.task4;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CallingInfoManagerTest {

    @Test
    public void testCallingInfo_NoStackTrace_ShouldReturnNull() {
        // Arrange
        Exception exception = new Exception("Test Exception");
        exception.setStackTrace(new StackTraceElement[0]);
        // Act
        CallingInfo callingInfo = CallingInfoManager.callingInfo(exception);
        // Assert
        assertThat(callingInfo).isNull();
    }

    @Test
    public void testCallingInfo_NullException_ShouldReturnNull() {
        // Act
        CallingInfo callingInfo = CallingInfoManager.callingInfo(null);
        // Assert
        assertThat(callingInfo).isNull();
    }

}
