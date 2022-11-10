package my_energy_GA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;



public class WorkflowParser {
	 /**
     * The path to DAX file.
     */
    private final String daxPath;
    /**
     * The path to DAX files.
     */
    /**
     * All tasks.
     */
    private List<task> taskList;
    /**
     * User id. used to create a new task.
     */
    private final int userId;

    /**
     * current job id. In case multiple workflow submission
     */
    private int jobIdStartsFrom;

    /**
     * Gets the task list
     *
     * @return the task list
     */
    @SuppressWarnings("unchecked")
    public List<task> getTaskList() {
        return taskList;
    }

    /**
     * Sets the task list
     *
     * @param taskList the task list
     */
    protected void setTaskList(List<task> taskList) {
        this.taskList = taskList;
    }
    /**
     * Map from task name to task.
     */
    protected Map<String, task> mName2Task;

    /**
     * Initialize a WorkflowParser
     *
     * @param userId the user id. Currently we have just checked single user
     * mode
     */
    public WorkflowParser(int userId,String path) {
        this.userId = userId;
        this.mName2Task = new HashMap<>();
        this.daxPath = path;
        this.jobIdStartsFrom = 0;

        setTaskList(new ArrayList<>());
    }

    /**
     * Start to parse a workflow which is a xml file(s).
     */
	public void pharse() {
		
	
		try {
		String path=this.daxPath;
			
	    SAXBuilder builder = new SAXBuilder();
	        //parse using builder to get DOM representation of the XML file
	    Document dom;
		dom = builder.build(new File(path));
        //得到根节点，是指xml文件中的根<>用来遍历xml文件的
        Element root = dom.getRootElement();
      
        //list里面是全部的节点
        List<Element> list = root.getChildren();
        for (Element node : list) {
        	//System.out.println("root,child:"+ root.getName()+","+node.getName());
        	//getName()得到的是xml文件<后面跟的第一个属性值
            switch (node.getName().toLowerCase()) {
                case "job":
                    int length = 0;
                    String nodeName = node.getAttributeValue("id");
                    String nodeType = node.getAttributeValue("name");
                    /**
                     * capture runtime. If not exist, by default the runtime
                     * is 0.1. Otherwise CloudSim would ignore this task.
                     * BUG/#11
                     */
                    double runtime;
                    if (node.getAttributeValue("runtime") != null) {
                        String nodeTime = node.getAttributeValue("runtime");
                        //把从文件中读出来的runtime转成double类型，然后乘1000，原来小于0.1，也就是100的任务都当成100
                        runtime = Double.parseDouble(nodeTime);
                        runtime =  runtime*1000;
                        if(runtime<100) {
                        	runtime=100;
                        }
                        length=(int)runtime;
                    } else {
                    	 System.out.println("Cannot find runtime for " + nodeName + ",set it to be 0");
                    }   //multiple the scale, by default it is 1.0
                    
                    //不知道runtime的范围应该怎么设置
                    //length *= Parameters.getRuntimeScale();
                    
                    
                    List<Element> fileList = node.getChildren();
                    List<FileItem> inputfile=new ArrayList<>();
                    List<FileItem> outputfile=new ArrayList<>();
                    //List<FileItem> mFileList = new ArrayList<>();
                    for (Element file : fileList) {
                        if (file.getName().toLowerCase().equals("uses")) {
                            String fileName = file.getAttributeValue("name");//DAX version 3.3
                            if (fileName == null) {
                                fileName = file.getAttributeValue("file");//DAX version 3.0
                            }
                            if (fileName == null) {
                            	 System.out.println("Error in parsing xml");
                            }

                            String link = file.getAttributeValue("link");
                            String inout=link;
                            double size = 0.0;

                            String fileSize = file.getAttributeValue("size");
                            if (fileSize != null) {
                            	//转成duoble
                                size = Double.parseDouble(fileSize) /*/ 1024*/;
                            } else {
                            	System.out.println("File Size not found for " + fileName);
                            }

                            /**
                             * a bug of cloudsim, size 0 causes a problem. 1
                             * is ok.
                             */
                            if (size == 0) {
                                size++;
                            }
                            /**
                             * Sets the file type 1 is input 2 is output
                             */
                            
                            
                            
                            if(inout.equals("input")) {
                            	FileItem ft=new FileItem(fileName,size);
                            	inputfile.add(ft);
                            }                
                            else if(inout.equals("output")) {
                            	FileItem oft=new FileItem(fileName,size);
                            	outputfile.add(oft);}
                            else {
                            	  System.out.println("Parsing Error");
                            }
                         
                              
             
                            
                            
                            
          /*                  FileType type = FileType.NONE;
                            switch (inout) {
                                case "input":
                                    type = FileType.INPUT;
                                    break;
                                case "output":
                                    type = FileType.OUTPUT;
                                    break;
                                default:
                                    Log.printLine("Parsing Error");
                                    break;
                            }
                            FileItem tFile;
                            
                             * Already exists an input file (forget output file)
                             
                            if (size < 0) {
                                
                                 * Assuming it is a parsing error
                                 
                                size = 0 - size;
                                Log.printLine("Size is negative, I assume it is a parser error");
                            }
                            
                             * Note that CloudSim use size as MB, in this case we use it as Byte
                             
                            if (type == FileType.OUTPUT) {
                                *//**
                                 * It is good that CloudSim does tell
                                 * whether a size is zero
                                 *//*
                                tFile = new FileItem(fileName, size);
                            } else if (ReplicaCatalog.containsFile(fileName)) {
                                tFile = ReplicaCatalog.getFile(fileName);
                            } else {

                                tFile = new FileItem(fileName, size);
                                ReplicaCatalog.setFile(fileName, tFile);
                            }

                            tFile.setType(type);
                            mFileList.add(tFile);
*/
                        } 
                    }
                    
                    
                    
                    task task;
                    //In case of multiple workflow submission. Make sure the jobIdStartsFrom is consistent.
                    synchronized (this) {
                    	//新建一个task(id，执行时间)
                        task = new task(this.jobIdStartsFrom, length);
                        task.setInputFile(inputfile);
                        task.setOutputFile(outputfile);
                        this.jobIdStartsFrom++;
                    }
                    task.setType(nodeType);
                    //task.setUserId(userId);
                    //建立名字和task的映射
                    mName2Task.put(nodeName, task);
                    
                    //每个任务执行需要的文件，然后把此tak添加到task列表中
                    /*for (FileItem file : mFileList) {
                        task.addRequiredFile(file.getName());
                    }
                    task.setFileList(mFileList);*/
                    this.getTaskList().add(task);

                    /**
                     * Add dependencies info.
                     */
                    break;
                case "child":
                    List<Element> pList = node.getChildren();
                    String childName = node.getAttributeValue("ref");
                    //建立子 的任务
                    if (mName2Task.containsKey(childName)) {

                        task childTask = (task) mName2Task.get(childName);
                        	
                        //建立父 的任务
                        for (Element parent : pList) {
                        	
                            String parentName = parent.getAttributeValue("ref");
                            if (mName2Task.containsKey(parentName)) {
                      
                            	//Random rd=new Random();
                            	double commtime=0;
                            	
                                task parentTask = (task) mName2Task.get(parentName);
                                List <FileItem> parentOutput=parentTask.getOutputFile();
                                List<FileItem> childInput=childTask.getInputFile();
                                for(FileItem ft:childInput) {
                                	for(FileItem f:parentOutput)
                                	{
                                	if(f.getname().equals(ft.getname())) {
                                		commtime+=ft.getsize();
                                	}
                                	}
                                }
                                
                             
                                double time=commtime/20000000;
                                parentTask.setcommTime(time, childTask.getId());
                                parentTask.addChild(childTask);
                                //parentTask.setcommTime(commtime,childTask.getId());
                                childTask.addParent(parentTask);
                                //childTask.setcommTime(commtime,parentTask.getId());
                                childTask.setcommTime(time, parentTask.getId());
                               // System.out.println(" parent "+parentTask.getId()+" child "+childTask.getId()+" ct "+time );
                            }
                        }
                        
                        
                    }
                    break;
            }
        }
        /**
         * If a task has no parent, then it is root task.
         */
        ArrayList roots = new ArrayList<>();
        for (task task : mName2Task.values()) {
            task.setDepth(0);
            if (task.getParentList().isEmpty()) {
                roots.add(task);
            }
        }

        /**
         * Add depth from top to bottom.
         */
        for (Iterator it = roots.iterator(); it.hasNext();) {
            task task = (task) it.next();
            setDepth(task, 1);
        }
        /**
         * Clean them so as to save memory. Parsing workflow may take much
         * memory
         */
        this.mName2Task.clear();
		
		
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	private void setDepth(task task, int depth) {
		// TODO Auto-generated method stub
		 if (depth > task.getDepth()) {
	            task.setDepth(depth);
	        }
	        for (task cTask : task.getChildList()) {
	            setDepth(cTask, task.getDepth() + 1);
	        }
		
		
		
	}
	
	
	
	
}
