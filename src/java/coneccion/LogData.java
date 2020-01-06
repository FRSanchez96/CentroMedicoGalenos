/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coneccion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Felipe
 */
public class LogData {
    public static void  log(String metodo,String data){
        //if (1==1) return;
        try(FileWriter fw = new FileWriter("c:/Harrys/rutea.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(metodo +  "==>" + data);
            //more code
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }        
    }
}
