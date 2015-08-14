import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("Enter your word/sentence:");
  }

  @Test
  public void lowerCaseWord() {
    goTo("http://localhost:4567/");
    fill("#userWord").with("summer");
    submit(".btn");
    assertThat(pageSource()).contains("S-MM-R");
  }

  @Test
  public void fullSentence() {
    goTo("http://localhost:4567/");
    fill("#userWord").with("Hi, my name is Summer.");
    submit(".btn");
    assertThat(pageSource()).contains("H-, MY N-M- -S S-MM-R.");
  }

  @Test
  public void answerShown() {
    goTo("http://localhost:4567/answer?");
    assertThat(pageSource()).contains("The Answer:");
  }

}
