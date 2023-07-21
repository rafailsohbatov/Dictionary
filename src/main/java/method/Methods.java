package method;

public interface Methods {
      boolean logIn(String username, String password) throws Exception;

     boolean signUp(String username, String password) throws Exception;

     void seeAllDictName() throws Exception;

     String findWord(String word, String fileName) throws Exception;

     void updateWord(String word,String newWord,String fileName) throws Exception;

     void deleteWord(String word,String fileName) throws Exception;
}
