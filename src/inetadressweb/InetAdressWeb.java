/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inetadressweb;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Alejandra Medina
 */
public class InetAdressWeb {

    protected void start() throws UnknownHostException
{
ServerSocket s;
//Socket cliente;
System.out.println("Servidor web iniciado en el puerto 450");
System.out.println("presione ctrl-c to exit");
try {
// Crea el socket del servidor inicial
s = new ServerSocket(450);
} catch ( Exception e ) {
System.out.println("Error: " + e );
return;
}
Scanner sc = new Scanner(System.in);
System.out.println("Esperando Conexiones");
for ( ; ; ) {

try {
    Socket remote;
    while ((remote=s.accept())!=null){
// espera por una conexion
// se acepta la conexion
System.out.println("Conexion desde: "+remote.getInetAddress());
// leer los datos enviados,
// para de leer hasta que lee el fin de linea, es decir la linea en blanco
// la linea en blaco es la señal de fin de las cabeceras HTTP
DataInputStream entrada= new DataInputStream(remote.getInputStream());
DataOutputStream salida= new DataOutputStream(remote.getOutputStream());
ObjectOutputStream mjs= new ObjectOutputStream(remote.getOutputStream());
mjs.writeObject(new Date());
String envio= entrada.readUTF();
System.out.println("Mensaje resivido...: "+envio);
System.out.println("Respuesta:...");
String respuesta = sc.next();
salida.writeUTF(""+respuesta);//Se envia la respuesta

}
    
    remote.close();
} catch ( Exception e ) {
System.out.println("Error: " + e );
}
}
}
public static void main(String args[]) throws UnknownHostException
{
InetAdressWeb ws = new InetAdressWeb();
ws.start();
}
}
    

