package beforeDream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetDatasWarming {
    /**
     * 使用接口获取实时数据，主要记录第一分钟是上升还是下跌。且记录第一分的量能。之后量能大于第一分钟输出到TXT文件（追加输出）。
     * 输出格式包括：股票代码名称和时间
     * 建议：最好使用多线程，接收数据存储map集合是一个线程，map集合计算的预警是另一个线程
     * 使用说明：只有9点30之后代码才会正式获取数据
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //1.初始化集合和设置监控股票信息（这个离可以设置智能化读取文件，文件从通达信下载）
        // "http://hq.sinajs.cn/list=sh600151,sz000830,s_sh000001,s_sz399001,s_sz399106";
        String url = "http://hq.sinajs.cn/list=sh601006,sz000002,sh600212"; // 多只股票获取方法.沪证sh开头。深证sz开头，

        //解析监控的股票，初始化map集合和list集合
        List resolving = resolving("sh601006,sz000002,sh600212");

        //需要把监控的股票，存储map集合，键是股票代码。值是list集合。list集合存储为：本日开盘价格，昨日收盘价格，开盘第一分钟结束的量能，本分钟的量能
        Map<String , List<String>> map = new HashMap<String ,List<String>>();
        //检测的股票几个就初始化几个list集合.map集合就初始化多少列
        for (Object code : resolving) {
            map.put((String)code,new ArrayList<String>());
        }

        //2.接口数据处理和接收
        getdatas(url,map);

        //3.预警方案一：开盘1分钟阳线，且价格大于等于0轴
        warming1(map); //这个不能使用多线程，容易出问题

        //4.预警方案二：1分之后实时量能创新高


    }


    /**
     * 接口数据处理和接收代码
     * @param url 访问接口路径
     * @param map 初始化的监控股票的map集合
     */
    private static void getdatas(String url,Map<String , List<String>> map) {

/*    // "http://hq.sinajs.cn/list=sh600151,sz000830,s_sh000001,s_sz399001,s_sz399106";
    String url = "http://hq.sinajs.cn/list=sh601006,sz000002"; // 多只股票获取方法.沪证sh开头。深证sz开头，

    //解析监控的股票，初始化map集合和list集合
    List resolving = resolving("sh601006,sz000002");

    //需要把监控的股票，存储map集合，键是股票代码。值是list集合。list集合存储为：本日开盘价格，昨日收盘价格，开盘第一分钟结束的量能，本分钟的量能
      Map<String , List<String>> map = new HashMap<String ,List<String>>();
    //检测的股票几个就初始化几个list集合.map集合就初始化多少列
      for (Object code : resolving) {
      //System.out.println(code);
        //  List<String> name = new ArrayList<String>();
      map.put((String)code,new ArrayList<String>());
    }*/



        try {
            URL u = new URL(url);
            byte[] b = new byte[256];
            InputStream in = null;

            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            while (true) { // 因为是死循环，这里一直获取就行。下面开启睡眠1秒获取一次数据，获取太多机器压力大
                //Thread.sleep(1000); // 1000 毫秒，也就是1秒.
                Thread.sleep(500);  //防止数据大的时候时间偏差，睡眠0.5秒
                try {
                    in = u.openStream();
                    int i;
                    while ((i = in.read(b)) != -1) {
                        bo.write(b, 0, i);

                    }
                    // String result = bo.toString();
                    String result = bo.toString("GBK"); // 转换成字符串的时候必须加上解码，不然就乱码了
                    // System.out.println(result);

                    String[] stocks = result.split(";"); // 多只股票的话需要使用这个进行切分一下
                    // System.out.println("stocks1:"+stocks[0].trim());
                    // System.out.println("stocks2:"+stocks[1].trim());
                    String name = null;
                    String price = null;
                    String vol = null;
                    String dates = null;
                    String time = null;
                    String Openprice = null;
                    String YestodayClosePrice= null;

                    for (String stock : stocks) {
                        if (stock.length() < 3) {
                            continue; // 发现有一些杂乱数据过滤
                        }
                        String[] datas = stock.split(",");
                        // System.out.println(stock);
                        // 根据对照自己对应数据
                        String[] name1 = datas[0].split("\\\""); // 股票的名字。但是前面多了一些没用的 var hq_str_sh600151="航天机电。在截去
                        // 获取股票的名字
                        name = name1[1];

                        // 获取股票代码
                        String code = datas[0].trim().substring(13, 19);

                        // 获取今日开盘价格
                        Openprice = datas[1];

                        // 获取昨日收盘价格
                        YestodayClosePrice = datas[2];

                        // 获取当前价格
                        price = datas[3]; // 注意：每一分钟的最高价格和最低价格要进行标记，这一分钟收盘时候确认最高价最低价，开盘价和收盘价

                        // 获取成交量（这个是总量，想要获取每一份的成交量，需要减去前一分钟的量能即可）
                        vol = datas[8];

                        // 获取当前日期
                        dates = datas[30];

                        // 获取当前时间
                        time = datas[31];

                        System.out.println("股票代码：" + code + "|股票名称：" + name + "|今日开盘价格：" + Openprice+ "|昨日收盘价格：" + YestodayClosePrice+ "|当前价格：" + price + "|总成交量：" + vol + "|日期："
                                + dates + "|当前时间：" + time);

//---------------------------------------       //测试代码
/*              //遍历map集合
              for(String key : map.keySet()){
                  //System.out.println("我是KEY:" + key);
                //  System.out.println("我是value:" + map.get(key));

              List<String> list = map.get(key.trim());
              //测试代码
              if (key.trim().endsWith("000002")) {
                  list.add("zzz");
              } else {
                  list.add("xxx");
              }

              }

              for(String key : map.keySet()){
                  System.out.println("我是KEY:" + key);
                  System.out.println("我是value:" + map.get(key));
              }*/
//---------------------------------------


                        //需要把监控的股票，存储map集合，键是股票代码。值是list集合。list集合存储为：本日开盘价格，昨日收盘价格，开盘第一分收盘价格，开盘第一分钟结束的量能，本分钟的量能
                        if (time.trim().equals("09:31:00") ||time.trim().equals("09:31:01")||time.trim().equals("09:31:03")) {  //防止时间偏差，多几个时间采样点.，然后初始化一下map集合
                            //if(true) {    //这个是测试使用的。实际中打开上面注释

                            //遍历map集合
                            for(String key : map.keySet()){
                                //System.out.println("我是KEY:" + key);
                                //  System.out.println("我是value:" + map.get(key));

                                List<String> list = map.get(key.trim());
                                //获取当前数据的股票名称。这个名称才进行存储数据，其他名称不存储
                                if (key.trim().endsWith(code)) {
                                    list.add(Openprice);  //设置本日开盘价格
                                    list.add(YestodayClosePrice);  //设置昨日收盘价格
                                    list.add(price);  //设置第一分收盘价格
                                    list.add(vol);   //设置第一分钟的成交量
                                } else {
                                    continue;
                                }


                            }


                        }


                    }

/*            for(String key : map.keySet()){
                System.out.println("我是KEY:" + key);
                System.out.println("我是value:" + map.get(key));
            }*/


                    bo.reset();
                    //测试的时候跳出while循环.正式版本需要把这个进行关闭的
                    //break;

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    if (in != null) {
                        in.close();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    /**
     * 第一个预警系统：开盘大阳+看盘价格大于等于0轴
     * @param map 股票存储的集合信息
     * @throws IOException
     */
    private static void warming1(Map<String , List<String>> map ) throws IOException {
        //如果时间是9点32才执行，否则过滤。这个预警每天只开启一次
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("hh:mm:ss");
        //System.out.println(dateFormat.format(date));
        String time = dateFormat.format(date).trim();

        if (time.equals("09:32:01") || time.equals("09:32:02")|| time.equals("09:32:03")|| time.equals("09:32:04")|| time.equals("09:32:05") ) {
            //if (true) {    //这个是测试使用的。实际中打开上面注释
            for(String key : map.keySet()){
                // System.out.println("我是KEY:" + key);
                // System.out.println("我是value:" + map.get(key));
                //list集合存储为：本日开盘价格，昨日收盘价格，开盘第一分收盘价格，开盘第一分钟结束的量能，本分钟的量能
                //获取本日开盘价格
                String open = map.get(key).get(0);
                //获取昨日收盘价格
                String close = map.get(key).get(1);
                //获取开盘第一分收盘价格
                String firstminclose = map.get(key).get(2);
                System.out.println("股票代码:"+key+"本日开盘价格:"+open+"|昨日收盘价格:"+close+"|开盘第一分收盘价格"+firstminclose);

                //判断是否开盘价格大于等于0轴
                Boolean boolean1=Double.parseDouble(open.trim())>=Double.parseDouble(close.trim());
                // System.out.println(boolean1);

                //判断是否第一分钟是阳线收盘。返回true是阳线，否则是阴线
                Boolean boolean2=!(Double.parseDouble(open.trim())>=Double.parseDouble(firstminclose.trim()));
                // System.out.println(boolean2);

                //满足上面两个条件都是true，把这个股票代码下载到本地TXT文件里面，进行预警
                if (boolean1 && boolean2) {
                    System.out.println("开盘1分钟预警启动");
                    //把股票代码写到TXT文件，追加写
                    mkdirTxt(key);
                }

            }
        }



    }
    private static void mkdirTxt(String str) throws IOException {
        //预警一：记录本日第一分钟的价格是上涨的，且价格大于等于0轴股票。存储TXT文件名字为“日期_第一分钟预警.txt”
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd");
        //System.out.println(dateFormat.format(date));
        String dates = dateFormat.format(date).trim();

        //1. 文件夹的路径  文件名
        String directory = "E:\\test";   //存储路径
        String filename =dates+"_第一分钟预警.txt";  //文件名

        //2.  创建文件夹对象     创建文件对象
        File file = new File(directory);
        //如果文件夹不存在  就创建一个空的文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(directory, filename);
        //如果文件不存在  就创建一个空的文件
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //3.写入数据
        //创建文件字节输出流
        FileOutputStream fos = new FileOutputStream(directory + "\\" + filename,true); //加上true表示追加写出
        //开始写
        // String str = "测试数据";
        byte[] bytes = str.getBytes();
        //将byte数组中的所有数据全部写入
        fos.write(bytes);
        fos.write("\r\n".getBytes());
        //关闭流
        fos.close();
    }


    /**
     * 解析股票串，返回list集合
     * @param codes  sh601006,sz000002
     * @return
     */
    @SuppressWarnings("unused")
    private static List resolving(String codes) {
        List<String> list = new ArrayList<String>();
        String[] datas = codes.split(",");
        for (String xcode : datas) {
            String code = xcode.trim().substring(2);//截取股票代码
            //System.out.println(code);
            list.add(code);
        }

        return list;

    }

}
