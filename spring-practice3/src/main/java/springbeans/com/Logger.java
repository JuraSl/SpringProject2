package springbeans.com;

public class Logger {
	
	private LogWriter consoleWriter;
	private LogWriter fileWriter;
	
	
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}

	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeConsole(String s) {
		consoleWriter.write(s);
	}
    public void writeFile(String s) {
		fileWriter.write(s);
	}
}
