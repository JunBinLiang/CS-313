
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leyal
 */
public class Y23608047 {
    public static void main(String[] args) {
        // TODO code application logic here
        class location implements Comparable<location>{
            public double x;
            public double y;
            public double distance;
            public location(double xC,double yC,double pivotx,double pivoty){
                x=xC;
                y=yC;
                distance=Math.sqrt( (x-pivotx)*(x-pivotx)+ (y-pivoty)*(y-pivoty) ); 
            } 

            @Override
            public int compareTo(location t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 return (int)Math.ceil(this.distance - t.distance);
            }
            
            @Override
            public String toString(){
            
                return x+",  "+y+",  "+distance;
            }
           
        }   
		if(args.length<2){
          System.out.println("2 arguments required");
          return;
        }
		
        int number=-1;
        String path="";
        number=Integer.parseInt(args[0]);
        path=args[1];
		
		
        if(number<0||number>5000){
            System.out.println("You must enter a valid number");
            return;
        }
        if(!(path.equals("location.txt"))){
          System.out.println("You must enter a valid file name, it shoule be location.txt");
          return;
        }
        String fileName=path;
        
        int counter=0;
        double pivotX=0;
        double pivotY=0;
        location locationArray[]; 
		String currentDirectory="";
        try {
            currentDirectory = new java.io.File( "." ).getCanonicalPath();
            
        } catch (IOException ex) {
            Logger.getLogger(Y23608047.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(currentDirectory);
        
         File file = new File("./"+fileName); 
        
         try {
            Scanner read = new Scanner(file);
             while(read.hasNextLine())
          {
              read.nextLine();
              //System.out.println(line);
              counter++;
              
          }
         // System.out.println(counter);
          locationArray=new location[counter-1];
          read = new Scanner(file);
          counter=0;
           
             while(read.hasNextLine())
          {
              int twoCounter=0;
              String sentence=read.nextLine();
              StringTokenizer st=new StringTokenizer(sentence," ");
              String token[]=new String[2];
              while (st.hasMoreTokens())
             {
                 token[twoCounter]=st.nextToken();
                 twoCounter++;
             }
              //System.out.println(line);
              if(counter==0){
               // locationArray[counter-1]=new location(Integer.parseInt(token[0]),Integer.parseInt(token[1]));
               pivotX=Double.parseDouble(token[0]);
               pivotY=Double.parseDouble(token[1]);
              
              }else{
                   
                locationArray[counter-1]=new location(Double.parseDouble(token[0]),Double.parseDouble(token[1]),pivotX,pivotY);
              }
        
              counter++;
          }
            //-5375  587
          Arrays.sort(locationArray);
          
          for(int i=0;i<locationArray.length;i++){
             // System.out.println(locationArray[i].distance+"  "+locationArray[i].x+"  "+locationArray[i].y);
          }
          
            try {  
                FileWriter fw=new FileWriter(currentDirectory+"\\"+"answer.txt");
                for(int i=0;i<number;i++){
                     fw.write(locationArray[i].toString()+"\n");   
                }
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Y23608047.class.getName()).log(Level.SEVERE, null, ex);
            }

         
            
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(Y23608047.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
