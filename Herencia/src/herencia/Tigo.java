package Herencia;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class Tigo {
    
    static private ArrayList<PlanSamsung> listasamsung = new ArrayList();
    static private ArrayList<Planiphone> listaiphone = new ArrayList();
    
    public void agregarPlan(int numerotel, String nombre, String extra, String tipo){
        if(busqueda(numerotel,extra,tipo,0)==false){
        if (tipo.equals("Samsung")){
            listasamsung.add(new PlanSamsung(numerotel,nombre,extra));
            JOptionPane.showMessageDialog(null, "Se ha agregado el plan","Listo", JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("iPhone")){
            listaiphone.add(new Planiphone(numerotel,nombre, extra));
        JOptionPane.showMessageDialog(null, "Se ha agregado el plan","Listo", JOptionPane.INFORMATION_MESSAGE);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Este numero ya esta registrado","Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public boolean busqueda(int numero, String extra, String tipo, int i){
        if (tipo.equals("Samsung")){
            if(i<listasamsung.size()){
                if(numero==listasamsung.get(i).getNumero() || extra.equals(listasamsung.get(i).getPin())){
                    return true;
                }
                return busqueda(numero,extra,tipo,i-1);
            }
        } else if (tipo.equals("iPhone")){
            if(i<listaiphone.size()){
                if(numero==listaiphone.get(i).getNumero() || extra.equals(listaiphone.get(i).getEmail())){
                    return true;
                }
                return busqueda(numero,extra,tipo,i-1);
            }
        }
        return false;
    }
    
    public PlanSamsung buscarNumero(int numeroTel, String extra){
        String tipo="Samsung";
        if(busqueda(numeroTel,extra,tipo,0)==true){
            for(int i=0; i<listasamsung.size();i++){
                if (numeroTel==listasamsung.get(i).getNumero()){
                    return listasamsung.get(i);
                }
            }
        }
        return null;
    }
    
    public double pagoPlan(int numero,int mins,int msgs ){
        for (int i=0;i<listasamsung.size();i++){
            if(numero==listasamsung.get(i).getNumero()){
                return listasamsung.get(i).PagoMensual(mins, msgs);
            }
        }
        
        for (int i=0;i<listaiphone.size();i++){
            if(numero==listaiphone.get(i).getNumero()){
                return listaiphone.get(i).PagoMensual(mins, msgs);
            }
        }
        
        return 0;
    }
    
    public void agregarAmigo(int numeroTel, String pin){
        if (buscarNumero(numeroTel,pin)!=null){
            buscarNumero(numeroTel,pin).agregarPinAmigo(pin);
        } else
            System.out.println("Oe chamo, este pin está malo");
    }
    
    public String listar(){
            String listado="\n";
            
            for (int i = 0; i < listasamsung.size(); i++) {
                listado=listado+listasamsung.get(i).Print();
            }
            
            for(int i=0;i<listaiphone.size();i++){
                listado=listado+listaiphone.get(i).Print();
            }
            return listado;
    }
    
}
