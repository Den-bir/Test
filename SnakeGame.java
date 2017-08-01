import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Admin on 17.07.17.
 */
public class SnakeGame {

    public static void main(String[] args) throws Exception {
        Game aa = new Game();
        ByteArrayOutputStream qwe = new ByteArrayOutputStream();
        try(ObjectOutputStream wer = new ObjectOutputStream(qwe)){
            wer.writeObject(aa);
        }

        final Game ss;
        ByteArrayInputStream asd = new ByteArrayInputStream(qwe.toByteArray());
        try(ObjectInputStream wer = new ObjectInputStream(asd)){
            ss = (Game)wer.readObject();
        }

        System.out.println(aa);
        System.out.println(ss);


        Thread t = new Thread(){
            @Override
            public void run() {
                ss.run();
            }
        };
        t.setDaemon(true);
        t.start();
        aa.run();


    }

}
