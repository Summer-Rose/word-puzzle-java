import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

   @Test
   public void encryptWord_userEntryConvertedToUppercase_true() {
     WordPuzzle testWordPuzzle = new WordPuzzle();
     String testString = "A";
     assertEquals(testString, testWordPuzzle.encryptWord("a"));
   }
}
