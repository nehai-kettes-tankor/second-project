package manager.model;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import manager.database.HandleData;
import manager.database.User;

public class ManagerModel {

    private String currentUsersName = "";
    HandleData handleData = new HandleData();

    public ManagerModel() {
        //első használat esetén egy admin felhasználó létrehozása. Ha már létezik akkor csupán kijelzi, hogy már létezik
        boolean adminUserCreated = handleData.saveUser(new User("admin", "admin"));
    }

    public boolean login(String username, String password){
        String encodedPassword = encodePassword(password);
        boolean successfulLogin = handleData.checkUser(username, encodedPassword);

       return successfulLogin;
    }

    private String encodePassword(String original){
        String encoded = original;

        return encoded;
    }

    private String decodePassword(String original){
        String decoded = original;

        return decoded;
    }

    public String generatePassword(int length, boolean capitals, boolean numbers, boolean special){
        return PasswordGenerator.generate(length, capitals, numbers, special);
    }

    public void copyToClipboard(String text){
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        try{
            this.wait(20);
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }
        content.putString(text);
        clipboard.setContent(content);
    }
}
