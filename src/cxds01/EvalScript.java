package cxds01;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 第一个例子， 执行脚本输出"Hello,World"
 * 通过 getEngineByName 方法得到一个JavaScript引擎实例。通过脚本引擎的eval方法来执行给定的JavaScript代码。
 */

public class EvalScript {

    public static void main(String[] args) throws Exception {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.eval("print('Hello, World')");
    }

}
