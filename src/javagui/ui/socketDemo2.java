//package ui;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.XMLWriter;
//import java.io.*;
//import java.lang.reflect.InvocationTargetException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.text.MessageFormat;
//
///*
//    服务器端
// */
//
//public class socketDemo2 {
////    public static void main(String[] args) throws IOException {
////        //创建服务器Socket套接字
////        ServerSocket ss=new ServerSocket(10095);
////        //监听客户端连接，返回一个对应的Socket对象
////        Socket s=ss.accept();
////        //获取输入流，接收客户端的内容
////        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
////        PrintWriter out = new PrintWriter(s.getOutputStream());
////        String line;
////        while ((line = br.readLine()) != null) {
////            System.out.println("服务器收到数据："+line);
////        }
////        //释放资源
////        ss.close();
////    }
//
//    private static String[] strList;
//    private static StringBuilder stringBuilder = new StringBuilder();
////    private static String filePath = "july14\\src\\student.owl";
//
//    private static String filePath  = "src\\student.owl";
//    //路径我只是修改成了去掉july14，就可以了。
//
//    private static String preFinalString;
//    private static boolean loadInit = true;
//    private static String readLine;
//
//    public static void main(String[] args) throws IOException {
//        ServerSocket server = new ServerSocket(10100);
//        Socket socket = server.accept();
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        PrintWriter out = new PrintWriter(socket.getOutputStream());
//
////        while ((readLine=in.readLine())!=null) {
////            bw.write(line);//该方法不会换行，所以需要换行的方法
////            bw.newLine();//行分隔符
////            bw.flush();	//刷新一下，事实证明，没有这句，仍然可以
////            System.out.println(readLine);
////        }
//
//        while (true) {
//            readLine = in.readLine();       //这里得到的数据是空
//            System.out.println(readLine);
//            if(readLine==null){
//                break;
//            }
//
//            out.println("Server received  " + readLine);    //自己添加
//            strList = readLine.split("\\s+");   //根据空格分隔
//            String[] strList= readLine.split("\\s+");
//            //  \\s是空格
//            for (int i = 0; i < strList.length; i++) {
//                System.out.println(i+strList[i]);
//            }
//
//            socketDemo2 myServer = new socketDemo2();
//
//            try {
//                myServer.stringToXml();
//                if (loadInit) {
//                    loadInit = false;
//                }
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//            out.flush();
////            if (readLine.equals("bye")) {
////                break;
////            }
//        }
//        socket.close();
//    }
//
//    public void stringToXml() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        //stringBuilder = (preFinalString.length() != 0)? preFinalString. :
////        if(preFinalString == null){
////            stringBuilder.append(preFinalString);
////        }else{
////            stringBuilder = new StringBuilder(Constants.sb);
////        }
//
//        if(loadInit){
//            /**
//             * sb就是owl文件中的开头部分
//             */
//            stringBuilder = new StringBuilder(Constants.sb);
//        }
//
//        String goal = strList[0];
//
//        System.out.println("此次要做" + goal);
//
//        switch (goal) {
//            case "addObject":
//                addObject();
//                break;
//            case "addClass":
//                addClass();
//                break;
//            case "addDataProperty":
//                addDataPropertyForObject();
//                break;
//            case "addSubClass":
//                addSubClass();
//                break;
//            case "addObjectProperty":
//                addObjectProperty();
//                break;
//            case "addDataPropertyDomain":
//                addDataPropertyDomain();
//                break;
//            case "addObjectPropertyDomain":
//                addObjectPropertyDomain();
//        }
//        writeToXml();
//    }
//
//    /**
//     * 对象调用方法
//     *     <ObjectPropertyAssertion>
//     *         <ObjectProperty IRI="#获得网络资源"/>
//     *         <NamedIndividual IRI="#警戒雷达"/>
//     *         <NamedIndividual IRI="#发射机"/>
//     *     </ObjectPropertyAssertion>
//     * inputExample: addObjectPropertyAssertion  警戒雷达  获得网络资源  发射机
//     * 还有种可能  输入的对象还没有创建，服务端应给出提示。
//     */
//
//    private void addObjectPropertyDomain() {
//        //没有创建警戒雷达对象，先创建对象。
//        if (stringBuilder.indexOf(strList[1]) == -1){
//
//        }
//        //没有创建发射机对象，先创建对象。
//        if(stringBuilder.indexOf(strList[3]) == -1){
//
//        }
//
//        String objectPropertyAssertion = MessageFormat.format(Constants.objectPropertyAssertion, strList[2], strList[1], strList[3]);
//        stringBuilder.append(objectPropertyAssertion);
//    }
//
//    /**
//     * 	给类添加方法 包含两步： 添加方法、添加方法与类关系、添加方法与类和返回值的关系
//     * 	   	 <Declaration>
//     *         <ObjectProperty IRI="#信号处理"/>
//     * 	     </Declaration>
//     * 	   <ObjectPropertyDomain>
//     * 	        <ObjectProperty IRI="#信号处理"/>
//     * 	        <Class IRI="#计算资源"/>
//     * 	    </ObjectPropertyDomain>
//     *
//     * 	    <ObjectPropertyRange>
//     *         <ObjectProperty IRI="#信号处理"/>
//     *         <Class IRI="#网络资源"/>
//     *      </ObjectPropertyRange>
//     * 	input example: addObjectPropertyDomain  计算资源  信号处理  通信资源
//     */
//
//    private void addObjectProperty() {
//        String objectProperty = MessageFormat.format(Constants.objectProperty, strList[2]);
//        stringBuilder.append(objectProperty);
//        String objectPropertyDomain = MessageFormat.format(Constants.objectPropertyDomain, strList[1], strList[2]);
//        stringBuilder.append(objectPropertyDomain);
//        String objectPropertyRange = MessageFormat.format(Constants.objectPropertyRange, strList[2], strList[3]);
//        stringBuilder.append(objectPropertyRange);
//    }
//
//    /**
//     * 	//给类添加属性
//     * 	    <DataPropertyDomain>
//     * 	        <DataProperty abbreviatedIRI="owl:topDataProperty"/>
//     * 	        <Class IRI="#雷达"/>
//     * 	    </DataPropertyDomain>
//     * 	    inputExample： addDataPropertyDomain  雷达  topDataProperty
//     */
//    private void addDataPropertyDomain() {
//        String dataPropertyDomain = MessageFormat.format(Constants.dataPropertyDomain, strList[2], strList[1]);
//        stringBuilder.append(dataPropertyDomain);
//    }
//
//    /**
//     * 添加子类
//     *     <SubClassOf>
//     *         <Class IRI="#主存"/>
//     *         <Class IRI="#存储资源"/>
//     *     </SubClassOf>
//     *     inputExample: addSubClass 存储资源  主存
//     */
//
//    private void addSubClass() {
//        String subClassOf = MessageFormat.format(Constants.subClassOf, strList[2], strList[1]);
//        stringBuilder.append(subClassOf);
//    }
//
//    /**
//     * 给对象属性赋值
//     *     <NegativeDataPropertyAssertion>
//     *         <DataProperty IRI="#位价"/>
//     *         <NamedIndividual IRI="#光盘"/>
//     *         <Literal datatypeIRI="http://www.w3.org/2001/XMLSchema#integer">10</Literal>
//     *     </NegativeDataPropertyAssertion>
//     *     inputExample: addDataProperty 光盘  位价   10
//     */
//
//    //这个没看到
//    private void addDataPropertyForObject(){
//        String negativeDataPropertyAssertion = MessageFormat.format(Constants.negativeDataPropertyAssertion, strList[2], strList[1], strList[3]);
//        stringBuilder.append(negativeDataPropertyAssertion);
//    }
//
//    /**
//     * 添加类
//     *     <Declaration>
//     *         <Class IRI="#主存"/>
//     *     </Declaration>
//     * inputExample： addClass 存储资源  主存
//     */
//
//    private void addClass() {
//        String classSample = MessageFormat.format(Constants.classSample, strList[2]);
//        stringBuilder.append(classSample);
//        String subClassOf = MessageFormat.format(Constants.subClassOf, strList[2], strList[1]);
//        stringBuilder.append(subClassOf);
//    }
//
//    /**
//     * 	//添加对象中包含： 添加对象、添加对象与类的关系、添加对象的属性
//     * 	    <Declaration>
//     * 	        <NamedIndividual IRI="#光盘"/>
//     * 	    </Declaration>
//     * 	    inputExample: addObject 辅存  光盘  （价格 10） //括号内可选
//     */
//
//    private  void addObject() {
//        for (int i = 2; i < strList.length; i++) {
//            if (i == 2) {
//                String object = MessageFormat.format(Constants.namedIndividual, strList[2]);
//                stringBuilder.append(object);
//            } else {
//                String dataProperty = MessageFormat.format(Constants.negativeDataPropertyAssertion, strList[2], strList[i - 1], strList[i]);
//                stringBuilder.append(dataProperty);
//            }
//        }
//        //可以抽取到最开始分流的时候
//        //writeToXml();
//    }
//
//    /**
//     * 把数据写入到xml,每次写入之前要加上后缀 </Ontology>
//     */
//    private void writeToXml() {
//        preFinalString = stringBuilder.toString();
//        String finalString = preFinalString.concat("</Ontology>");
//        XMLWriter xmlwriter=null;
//        try{
//            //获取文本对象
//            Document document= DocumentHelper.parseText(finalString);   //创建一个dom树
//
//            OutputFormat format=OutputFormat.createPrettyPrint();/*输出格式对象*/
//
//            xmlwriter=new XMLWriter(new FileOutputStream(filePath),format);
//            xmlwriter.write(document);/*将document对象放入到xml输出对象中*/
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            if(xmlwriter!=null){
//                try{
//                    xmlwriter.close();
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
//
