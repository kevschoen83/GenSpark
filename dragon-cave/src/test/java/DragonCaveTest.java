import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DragonCaveTest {

    DragonCave dragonCave;

    @BeforeEach
    void setUp() {
        dragonCave = new DragonCave();
    }

    @Test
     void caveChoice() {

    }

    @Test
    void getChoice() {
        assertEquals(1, 2, "What!");
    }

    @Test
    void setChoice() {

    }

    @AfterEach
    void tearDown() {
    }
}