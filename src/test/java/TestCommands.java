import com.chubanova.Command;
import com.chubanova.Movable;
import com.chubanova.UObject;
import com.chubanova.adapter.Adapter;
import com.chubanova.ioc.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class TestCommands {

    @BeforeAll
    protected static void setUp() {
        ScopeDictionary<IoCDictionary> scopesDictionary = ScopeDictionaryImpl.getInstance();
        Initializer<ScopeDictionary<IoCDictionary>> initializerScopeDictionary = new InitializerScopeDictionary();
        initializerScopeDictionary.initialize(scopesDictionary);
        registerAllCommands();
    }

    private static void registerAllCommands() {
        IoC.<Command>resolve(
                "IoC.Register",
                new Object[]{
                        "ListCommandsOnRegister",
                        (Function<Object[], Object>) (
                                (args) -> new ListCommandsOnRegister()
                        )

                }
        ).execute();

        IoC.<Command>resolve(
                "ListCommandsOnRegister",
                null
        ).execute();
    }

    @Test
    @DisplayName("Тест создания адаптера")
    public void TestCreateAdapter() {
        UObject uObject = UObjectImpl.getInstanse();

        Adapter moveable =
                ((GetAdapter) (IoC.resolve(
                        "Adapter",
                        new Object[]{
                                Movable.class,
                                uObject
                        }
                ))).get();

        assertAll(
                () -> assertNotNull(moveable),
                () -> assertEquals(moveable.getClass().getSimpleName(), Movable.class.getSimpleName() + "Adapter")
        );
    }
}
