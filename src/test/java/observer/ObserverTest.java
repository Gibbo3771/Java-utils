package observer;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObserverTest {

    private Observer observer = new Observer();
    private ISubject subject = Mockito.mock(ISubject.class);

    @Test @Order(1) @DisplayName("It should start with no listeners")
    public void startsWithNoListeners(){
        assertEquals(0, this.observer.getSubjectCount());
    }

    @Test @Order(2) @DisplayName("It should add a subject")
    public void itCanAddASubject(){
        boolean success = this.observer.register(this.subject);
        assertTrue(success);
    }

    @Test @Order(3) @DisplayName("It should not add duplicate subjects")
    public void itCanNotAddDuplicateSubject(){
        boolean success = this.observer.register(this.subject);
        assertFalse(success);
    }

    @Test @Order(4) @DisplayName("It should remove a given subject")
    public void itCanRemoveTheSubject(){
        boolean success = this.observer.unregister(this.subject);
        assertTrue(success);
    }

    @Test @Order(5) @DisplayName("It should call onNotify of the subject")
    public void itShouldNotify() {
        this.observer.register(subject);
        int i = 1;
        String s = "some string";
        this.observer.notify(s, i);
        Mockito.verify(this.subject, Mockito.atLeastOnce()).onNotify(s, i);
        this.observer.unregister(subject);
    }

    @Test @Order(7) @DisplayName("It should clear all subjects")
    public void itShouldClear(){
        this.observer.register(Mockito.mock(ISubject.class));
        this.observer.register(Mockito.mock(ISubject.class));
        this.observer.register(Mockito.mock(ISubject.class));
        assertEquals(3, this.observer.getSubjectCount());
        this.observer.clear();
        assertEquals(0, this.observer.getSubjectCount());

    }

}
