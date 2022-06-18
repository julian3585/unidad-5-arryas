import java.io.*;
import java.util.ArrayList;

public class leerArchivo {
    private String linea;
    private ArrayList<String> lineasArchivos = new ArrayList<String>();

    public ArrayList<String> leerArchivo (String ruta){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{

            archivo = new File(ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            while((linea=br.readLine()) != null) {
                if (linea !="") {
                    lineasArchivos.add(linea);
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }finally{

            try{
                if (null != fr) {
                    fr.close();

                }
            }
            catch (Exception e2){
                e2.printStackTrace();

            }
        }
        return  lineasArchivos;
    }
    private void escribirArchivo (String archivo){
        File f = new File(archivo);
        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("");
            wr.append("Texto");
            wr.append("\n");
            wr.close();
            bw.close();
        }catch (IOException e){

        }
    }
    public static void main (String args[]){
        leerArchivo leer = new leerArchivo();

        System.out.println(leer.leerArchivo("/Users/JulianIdeaProjects/yakshuri/src/datos.txt"));

    }

}
