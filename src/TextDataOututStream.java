import javax.imageio.IIOException;
import java.io.*;

public class TextDataOututStream {

    public static void main(String[] args) {
        int[] a = {200000000, 21, 11, 8, 19};

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("text.txt");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            for (int i = 0; i < a.length; i++) {
                dataOutputStream.writeInt(a[i]);
            }
            dataOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
