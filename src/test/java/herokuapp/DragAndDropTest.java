package herokuapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    /**
     * 3. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
     * - Откройте https://the-internet.herokuapp.com/drag_and_drop
     * - Перенесите прямоугольник А на место В
     * - Проверьте, что прямоугольники действительно поменялись
     */
    @BeforeAll
    static void beforeAll() {
        //System.setProperty("selenide.browser", "firefox");
        //Configuration.browser = "firefox";
    }

    @Test
    void moveBlockTest() {
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("h3").shouldHave(text("Drag and Drop"));
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));
        sleep(1000);
        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b"); //Так работает
        //actions().moveToElement($("#column-a")).clickAndHold()
        //        .moveToElement($("#column-b")).release().perform();// Так не работает почему-то (((
        //actions().dragAndDrop($("#column-a"),$("#column-b")).release().perform(); //И так не работает(((
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));
        sleep(1000);
    }

}
