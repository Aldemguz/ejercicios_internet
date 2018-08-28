
//num 0(48) - 9(57)
//a(97) - z(122)
//A(65) - Z(90)
package javaapplication24;

import javax.swing.JOptionPane;

/**
 *
 * @author aldemaro
 */
public class Main {

    public static void main(String[] args) {
        
        int cantPasswords=0;
        cantPasswords = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"
                + " de contraseñas a crear"));
         Password []passwords = new Password[cantPasswords];
        boolean [] checkpasswords = new boolean[cantPasswords];
        int longitud;
        longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud"
                + " de las contraseñas"));
       
        
        for(int i=0;i<longitud;i++){
            passwords[i]= new Password(longitud);
            checkpasswords[i] = passwords[i].esFuerte();
            System.out.print(passwords[i].getContraseña());
            if(checkpasswords[i])
                System.out.println(" es fuerte!");
            else
                System.out.println(" es debil");
        }
    }
    
}

class Password{
   private int longitud;
   private String contraseña;
   
   public Password(){ 
       this.longitud = 8;
       contraseña = generarPassword();
   }
   public Password(int longitud){
       this.longitud = longitud;
       contraseña = generarPassword();
   }
   
   //methods setters
   
   public void setLongitud(int longitud){
       if(longitud<=0)
           System.out.println("No se puede aplicar longitud negativa, quedará por defecto");
       else
           this.longitud=longitud;
   }
   
   //Methods get
   public int getLongitud(){
       return this.longitud;
   }
   public String getContraseña(){
       return this.contraseña;
   }
   
   
   public boolean esFuerte(){
       boolean resultado=false;
       int contMayusculas=0;
       int contMinusculas=0;
       int contNum=0;
       int asciiChar;
       //num 0(48) - 9(57)
       //a(97) - z(122)
       //A(65) - Z(90)
       for(int i=0;i<contraseña.length();i++){
       asciiChar = (int)contraseña.charAt(i);
       if(asciiChar>=48 && asciiChar<=57)
           contNum++;
       else if(asciiChar>=97 && asciiChar<=122)
           contMinusculas++;
       else
           contMayusculas++;
       if(contNum>=5 && contMinusculas>=1 && contMayusculas>=2)
           resultado=true;
   }
       return resultado;
   }

   
  public String generarPassword(){
      String pass = "";
      int tipo=0; // 1: generar un numero, 2: generar una minuscula, 3: generar mayuscula
      int select=0; //Seleccionara el caracter correspondiente (codigo ASCII)
      for(int i=0;i<longitud;i++){
           
      tipo = Metodos.genNum(1, 3);
      switch(tipo){
          case 1:
              select = Metodos.genNum(48,57);
              pass+=(char)select;
              break;
          case 2:
              select = Metodos.genNum(97,122);
              pass+=(char)select;
              break;
          default:
              select = Metodos.genNum(65, 90);
              pass+=(char)select;
              break;
      }
      }
      return pass;
  } 
}
class Metodos{
    
    public static final int genNum(int minimo, int maximo){
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
}