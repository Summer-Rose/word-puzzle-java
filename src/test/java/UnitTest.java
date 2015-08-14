import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

   @Test
   public void encryptWord_userEntryConvertedToUppercase_true() {
     WordPuzzle testWordPuzzle = new WordPuzzle();
     String testString = "-";
     assertEquals(testString, testWordPuzzle.encryptWord("a"));
   }

   @Test
   public void encryptWord_VowelsConvertedToDashes_true() {
     WordPuzzle testWordPuzzle = new WordPuzzle();
     String testString ="S-MM-R";
     assertEquals(testString, testWordPuzzle.encryptWord("summer"));
   }
}
