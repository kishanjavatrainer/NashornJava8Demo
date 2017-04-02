package com.infotech.client;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ClientTest {

	public static void main(String[] args) throws FileNotFoundException, NoSuchMethodException {
		
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
		
		try {
			engine.eval(new FileReader("src/demo1.js"));
			Invocable invocable=(Invocable)engine;
			
			Object result = invocable.invokeFunction("fun1", "Seam Murphy");
			System.out.println(result);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
