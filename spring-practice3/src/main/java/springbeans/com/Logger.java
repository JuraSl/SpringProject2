package springbeans.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import javax.annotation.*;

public class Logger {
	
	//@Autowired
	private ConsoleWriter consoleWriter;
	
	private LogWriter fileWriter;

	// Injecting beans to the set method
	@Resource(name="console")
	public void setLogWriter(ConsoleWriter logWriter) {
		this.consoleWriter = logWriter;
	}
	@Resource
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	StringBuilder sb = new StringBuilder();
	public void printToConsole(String s){
		consoleWriter.write(s);
	}

	public void printToFile(String s){
		fileWriter.write( s);
	}

	@PostConstruct
	public void init(){
		System.out.println("Init method");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Destroy method");
	}
}
