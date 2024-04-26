package org.example;
import jdepend.xmlui.JDepend;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        JDepend depend =new JDepend(new PrintWriter("reports/report.xml"));
        depend.addDirectory("Library-Assistant");
        depend.analyze();
        System.out.println("Create file report.xml success");

        String workingDir = "jdepend-ui"; // Điều chỉnh đường dẫn tới jdepend-ui

        String command = "npm run jdepend-ui reports/report.xml be";

        Process process = new ProcessBuilder(command.split(" "))
                .directory(new java.io.File(workingDir))
                .start();

        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Create report html success");
        } else {
            System.err.println("Report html fail");
        }
    }

}