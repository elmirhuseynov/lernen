package challenges.ee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientAndStatic {

    private static final String FILE_NAME = "serialization.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (var fileOutputStream = new FileOutputStream(FILE_NAME);
             var outputStream = new ObjectOutputStream(fileOutputStream)) {

            var kb = new Bank();
            kb.name = "Kapital Bank OJSC";
            kb.ceo = "Elkhan Ibrahimov";
            kb.currentBankDate = "08.08.2025";
            kb.brandColor = "red";
            outputStream.writeObject(kb);
            kb.brandColor = "gray";
        }

        try (var fileInputStream = new FileInputStream(FILE_NAME);
             var inputStream = new ObjectInputStream(fileInputStream)) {

            var deserializedBank = (Bank) inputStream.readObject();
            System.out.println(deserializedBank.name);
            System.out.println(deserializedBank.ceo);
            System.out.println(deserializedBank.currentBankDate);
            System.out.println(deserializedBank.brandColor);
        }
    }
}

class Bank implements Serializable {

    private static final long serialVersionUID = 6378380641854483044L;

    String name;
    transient String ceo;
    volatile String currentBankDate;
    static String brandColor;

}