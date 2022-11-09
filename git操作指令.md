```java
初始化

git init
查看当前仓库状态

git status
将项目的文件添加到仓库中

git add test.txt
git add -A
git add .
将add的文件commit到仓库

git commit -m "提交内容介绍"
    
    
将本地的仓库关联到远程仓库上：git remote add origin 远程仓库地址
    
从远程仓库拉取合并代码：git pull origin master


代码上传到远程仓库master，此时要输入账号密码
git push -u origin master
    
强制push到远程仓库
    
    查看远程仓库命令：

    $ git remote -v 
    
    
    git提供了一种强制上传的方式：git push -f ，它会忽略版本不一致等问题，强制将本地库上传的远程库，但是一定要！！谨慎使用！！！，因为-f会用本地库覆盖掉远程库，！如果远程库上有重要更新！！！，或者有其他同伴做的修改！！！，也都会被覆盖！！！！，所以一定要在确定无严重后果的前提下使用此操作。
————————————————
版权声明：本文为CSDN博主「enterprising boy」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/NMdemon/article/details/127329047
    
    git push -u origin master -f 
        
        查看目录：ls socket
        
       删除目录以及其内容： git rm -r socket/out
        将会删除out文件夹和其内容
        
   解救每次操作都要输入密码：$ git config --global credential.helper store
待下一次提交代码的时候，输入了正确的用户名和密码，之后就不需要输入用户名密码     
        
```

远程仓库已存在该仓库：

操作：删除远程，然后重新上传

