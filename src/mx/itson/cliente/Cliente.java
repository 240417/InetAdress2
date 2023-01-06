/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class Cliente {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        final int PUERTO = 450;
        System.out.println("Escriba 'FIN' en mayusculas para terminar la comunicación");
            //Creamos nuestro socket
           Socket socket = null ;
            String envio =null;
            //envio = (ObjectOutputStream) (Object)mensaje;
            while(envio!="FIN"){
                socket = new Socket("localhost", PUERTO);
            DataOutputStream salida= new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada= new DataInputStream(socket.getInputStream());
            ObjectInputStream mjs = new ObjectInputStream(socket.getInputStream());
            
            Scanner sc = new Scanner(System.in);
            envio =sc.next();
            salida.writeUTF(envio);//envia el mensaje
            
            
            String respuesta = entrada.readUTF();
            //Resivimos la fecha en que ingreso al server
            //Date fecha = (Date) mjs.readObject(); 
            
            System.out.println(""+respuesta);
            if(envio=="FIN"){
                socket.close();
            }
            }
            //Cerramos la conexión
            
            
            
            
      
         
    
    }
    
}
