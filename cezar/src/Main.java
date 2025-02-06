public class Main {

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char base = (Character.isLowerCase(c)) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }

            encryptedText.append(c);
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); 
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        int shift = 3;

        String encrypted = encrypt(text, shift);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted: " + decrypted);
    }
}
