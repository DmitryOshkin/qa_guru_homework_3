package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JUnit5CodeOnPageSoftAssertionsTest {

    /**
      1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
      Если может - приведите пример, когда.

     Ответ:
       Да, может быть ситуация, когда эти два локатора найдут разные элмементы.
     Например:
       $("h1 div") - этот локатор будет искать первый div внутри элемента h1,
       и если внутри первого h1  таковых не обнаружит будет искать внутри последующих,
       а это локатор -  $("h1").$("div") будет искать первый div
       только внутри первого найденного h1.

     */

    /**
     2. Разработайте следующий автотест:
     - Откройте страницу Selenide в Github
     - Перейдите в раздел Wiki проекта
     - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
     - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
     */

    @Test
    void jUnit5CodeOnPageTest() {

        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // check: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").$(byText("Wiki")).click();
        // check: в заголовке встречается приветствие в wiki
        $(".Layout-main h1").shouldHave(text("Welcome to the selenide wiki!"));
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions. Открыть страницу
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible).click();
        // check: в заголовке указано SoftAssertions
        $(".page h1").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));


    }


}
