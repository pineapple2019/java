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
//    ��������
// */
//
//public class socketDemo2 {
////    public static void main(String[] args) throws IOException {
////        //����������Socket�׽���
////        ServerSocket ss=new ServerSocket(10095);
////        //�����ͻ������ӣ�����һ����Ӧ��Socket����
////        Socket s=ss.accept();
////        //��ȡ�����������տͻ��˵�����
////        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
////        PrintWriter out = new PrintWriter(s.getOutputStream());
////        String line;
////        while ((line = br.readLine()) != null) {
////            System.out.println("�������յ����ݣ�"+line);
////        }
////        //�ͷ���Դ
////        ss.close();
////    }
//
//    private static String[] strList;
//    private static StringBuilder stringBuilder = new StringBuilder();
////    private static String filePath = "july14\\src\\student.owl";
//
//    private static String filePath  = "src\\student.owl";
//    //·����ֻ���޸ĳ���ȥ��july14���Ϳ����ˡ�
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
////            bw.write(line);//�÷������ỻ�У�������Ҫ���еķ���
////            bw.newLine();//�зָ���
////            bw.flush();	//ˢ��һ�£���ʵ֤����û����䣬��Ȼ����
////            System.out.println(readLine);
////        }
//
//        while (true) {
//            readLine = in.readLine();       //����õ��������ǿ�
//            System.out.println(readLine);
//            if(readLine==null){
//                break;
//            }
//
//            out.println("Server received  " + readLine);    //�Լ����
//            strList = readLine.split("\\s+");   //���ݿո�ָ�
//            String[] strList= readLine.split("\\s+");
//            //  \\s�ǿո�
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
//             * sb����owl�ļ��еĿ�ͷ����
//             */
//            stringBuilder = new StringBuilder(Constants.sb);
//        }
//
//        String goal = strList[0];
//
//        System.out.println("�˴�Ҫ��" + goal);
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
//     * ������÷���
//     *     <ObjectPropertyAssertion>
//     *         <ObjectProperty IRI="#���������Դ"/>
//     *         <NamedIndividual IRI="#�����״�"/>
//     *         <NamedIndividual IRI="#�����"/>
//     *     </ObjectPropertyAssertion>
//     * inputExample: addObjectPropertyAssertion  �����״�  ���������Դ  �����
//     * �����ֿ���  ����Ķ���û�д����������Ӧ������ʾ��
//     */
//
//    private void addObjectPropertyDomain() {
//        //û�д��������״�����ȴ�������
//        if (stringBuilder.indexOf(strList[1]) == -1){
//
//        }
//        //û�д�������������ȴ�������
//        if(stringBuilder.indexOf(strList[3]) == -1){
//
//        }
//
//        String objectPropertyAssertion = MessageFormat.format(Constants.objectPropertyAssertion, strList[2], strList[1], strList[3]);
//        stringBuilder.append(objectPropertyAssertion);
//    }
//
//    /**
//     * 	������ӷ��� ���������� ��ӷ�������ӷ��������ϵ����ӷ�������ͷ���ֵ�Ĺ�ϵ
//     * 	   	 <Declaration>
//     *         <ObjectProperty IRI="#�źŴ���"/>
//     * 	     </Declaration>
//     * 	   <ObjectPropertyDomain>
//     * 	        <ObjectProperty IRI="#�źŴ���"/>
//     * 	        <Class IRI="#������Դ"/>
//     * 	    </ObjectPropertyDomain>
//     *
//     * 	    <ObjectPropertyRange>
//     *         <ObjectProperty IRI="#�źŴ���"/>
//     *         <Class IRI="#������Դ"/>
//     *      </ObjectPropertyRange>
//     * 	input example: addObjectPropertyDomain  ������Դ  �źŴ���  ͨ����Դ
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
//     * 	//�����������
//     * 	    <DataPropertyDomain>
//     * 	        <DataProperty abbreviatedIRI="owl:topDataProperty"/>
//     * 	        <Class IRI="#�״�"/>
//     * 	    </DataPropertyDomain>
//     * 	    inputExample�� addDataPropertyDomain  �״�  topDataProperty
//     */
//    private void addDataPropertyDomain() {
//        String dataPropertyDomain = MessageFormat.format(Constants.dataPropertyDomain, strList[2], strList[1]);
//        stringBuilder.append(dataPropertyDomain);
//    }
//
//    /**
//     * �������
//     *     <SubClassOf>
//     *         <Class IRI="#����"/>
//     *         <Class IRI="#�洢��Դ"/>
//     *     </SubClassOf>
//     *     inputExample: addSubClass �洢��Դ  ����
//     */
//
//    private void addSubClass() {
//        String subClassOf = MessageFormat.format(Constants.subClassOf, strList[2], strList[1]);
//        stringBuilder.append(subClassOf);
//    }
//
//    /**
//     * ���������Ը�ֵ
//     *     <NegativeDataPropertyAssertion>
//     *         <DataProperty IRI="#λ��"/>
//     *         <NamedIndividual IRI="#����"/>
//     *         <Literal datatypeIRI="http://www.w3.org/2001/XMLSchema#integer">10</Literal>
//     *     </NegativeDataPropertyAssertion>
//     *     inputExample: addDataProperty ����  λ��   10
//     */
//
//    //���û����
//    private void addDataPropertyForObject(){
//        String negativeDataPropertyAssertion = MessageFormat.format(Constants.negativeDataPropertyAssertion, strList[2], strList[1], strList[3]);
//        stringBuilder.append(negativeDataPropertyAssertion);
//    }
//
//    /**
//     * �����
//     *     <Declaration>
//     *         <Class IRI="#����"/>
//     *     </Declaration>
//     * inputExample�� addClass �洢��Դ  ����
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
//     * 	//��Ӷ����а����� ��Ӷ�����Ӷ�������Ĺ�ϵ����Ӷ��������
//     * 	    <Declaration>
//     * 	        <NamedIndividual IRI="#����"/>
//     * 	    </Declaration>
//     * 	    inputExample: addObject ����  ����  ���۸� 10�� //�����ڿ�ѡ
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
//        //���Գ�ȡ���ʼ������ʱ��
//        //writeToXml();
//    }
//
//    /**
//     * ������д�뵽xml,ÿ��д��֮ǰҪ���Ϻ�׺ </Ontology>
//     */
//    private void writeToXml() {
//        preFinalString = stringBuilder.toString();
//        String finalString = preFinalString.concat("</Ontology>");
//        XMLWriter xmlwriter=null;
//        try{
//            //��ȡ�ı�����
//            Document document= DocumentHelper.parseText(finalString);   //����һ��dom��
//
//            OutputFormat format=OutputFormat.createPrettyPrint();/*�����ʽ����*/
//
//            xmlwriter=new XMLWriter(new FileOutputStream(filePath),format);
//            xmlwriter.write(document);/*��document������뵽xml���������*/
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
