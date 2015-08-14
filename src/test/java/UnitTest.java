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

   @Test
   public void encryptWord_programAcceptsPunctuationAndNumbers_true() {
     WordPuzzle testWordPuzzle = new WordPuzzle();
     String testString ="B-L--V- Y-- C-N -ND Y--'R- H-LFW-Y TH-R-. TH--D-R- R--S-V-LT. N-MB-R 1.";
     assertEquals(testString, testWordPuzzle.encryptWord("Believe you can and you're halfway there. Theodore Roosevelt. Number 1."));
   }
}
