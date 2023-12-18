package edu.hw10.task1;

import edu.hw10.task1.models.Student;
import edu.hw10.task1.models.StudentRecord;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomObjectGeneratorTest {

    private final RandomObjectGenerator rog = new RandomObjectGenerator();

    @Test
    void createObjectWithConstructor()
        throws InvocationTargetException,
               InstantiationException,
               IllegalAccessException {
        var myClass = rog.nextObject(Student.class);

        assertThat(myClass.getCourse()).isBetween(1, 4);
        assertThat(myClass.getName()).isNotNull();
    }

    @Test
    void createObjectWithStaticMethod()
        throws InvocationTargetException,
        InstantiationException,
        IllegalAccessException {
        var myClass = rog.nextObject(Student.class, "create");

        assertThat(myClass.getCourse()).isBetween(1, 4);
        assertThat(myClass.getName()).isNotNull();
    }

    @Test
    void createRecord()
        throws InvocationTargetException,
               InstantiationException,
               IllegalAccessException {
        var myRecord = rog.nextObject(StudentRecord.class);

        assertThat(myRecord.course()).isBetween(1, 4);
        assertThat(myRecord.name()).isNotNull();
    }

}
