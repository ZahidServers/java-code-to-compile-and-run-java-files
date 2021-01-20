//java code to compile and run other java files
package com.journaldev.files;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
public class CompileRunJavaProgram {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter an file address(without .java and file name same as class): ");
            String name = input.nextLine();
            runProcess("pwd");
            System.out.println("**********");
            runProcess("javac -cp src "+name+".java");
            System.out.println("**********");
            runProcess("java -cp src "+name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }
      private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }
}
