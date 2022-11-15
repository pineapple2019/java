package Socket6;

import java.io.*;
import java.net.Socket;
//接收到的数据写到文本文件，给出反馈，代码用线程封装，为每一个客户端开启线程
public class ServerThread implements Runnable{
    private  Socket s;
    public ServerThread(Socket s){
        this.s=s;
    }

    @Override
    public void run() {
        //接收到的数据写入文本文件
        try {
            //接收客户端的文件
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //解决名称冲突问题
            int count = 0;
            File file = new File("SocketXml\\src\\copy["+count+"].owl");

            while(file.exists()){
                count++;
                file = new File("SocketXml\\src\\copy["+count+"].owl");
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SocketXml\\src\\test.owl")));

            String line;

            while ((line= br.readLine())!=null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            //给出反馈
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();

            //释放资源
            s.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }


}
