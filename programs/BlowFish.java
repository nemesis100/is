// Ex 3
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.util.Base64;
public class BlowFish {
public static void main(String[] args) throws Exception {
KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
keyGenerator.init(128);
Key secretKey = keyGenerator.generateKey();
Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);
// BASE64Encoder encoder = new BASE64Encoder();
byte iv[] = cipherOut.getIV();
if (iv != null) {
System.out.println("Initialization Vector of the Cipher: " + Base64.getEncoder().encode(iv)); }
FileInputStream fin = new FileInputStream("input.txt");
FileOutputStream fout = new FileOutputStream("output.txt");
CipherOutputStream cout = new CipherOutputStream(fout, cipherOut);
int input = 0;
while ((input = fin.read()) != -1) {
cout.write(input); }
fin.close(); cout.close(); } }