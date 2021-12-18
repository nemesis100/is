// Ex 4
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
public class BlowFishCipher
{
public static void main(String[] args) throws Exception
{
// create a key generator based upon the Blowfish cipher
KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
// create a key
SecretKey secretkey = keygenerator.generateKey();
// create a cipher based upon Blowfish
Cipher cipher = Cipher.getInstance("Blowfish");
// initialise cipher to with secret key
cipher.init(Cipher.ENCRYPT_MODE, secretkey);
// get the text to encrypt
String inputText = JOptionPane.showInputDialog("Input your message:");

// encrypt message

byte[] encrypted = cipher.doFinal(inputText.getBytes());
// re-initialise the cipher to be in decrypt mode
cipher.init(Cipher.DECRYPT_MODE, secretkey);
// decrypt message
byte[] decrypted = cipher.doFinal(encrypted);
// and display the results
JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
"\nEncrypted text: " + new String(encrypted) + "\n" +
"\nDecrypted text: " + new String(decrypted));
System.exit(0);
}
}