package 文件类操作;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCreate {
    @Test
    //创建文件
    public void cteate() throws IOException {
        File file = new File("D://a.te");
        file.createNewFile();
    }

//    OutputStream
//    InputStream
}

