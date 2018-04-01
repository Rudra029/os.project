import java.util.Scanner;

import java.util.ArrayList;

class ProjectR

{
        
int id,arrival,cpu;
      
  ProjectR(int id,int arrival,int cpu)
{
                
this.id=id;
               
 this.arrival=arrival;
                
this.cpu=cpu;
       
 }
        
ProjectR(){}
       
 void disp()
{
              
  System.out.println(id+arrival+cpu);
     
   }
      
  public static void main(String[] argu)
{
              
  Scanner input=new Scanner(System.in);
   
    ArrayList<ProjectR> ob=new ArrayList();
          
      ProjectR[] pro=new ProjectR[50];
       
         int count,i,j,tcpu=0;
             
   System.out.println("How many processes are there?");
            
    count=input.nextInt();
               
 for(i=0;i<count;i++){
                       
 int arrival,cpu;
                      
  System.out.print("Arrival Time :- ");
              
          arrival=input.nextInt();
                      
  System.out.print("CPU Time :- ");
                       
 cpu=input.nextInt();
                     
   ProjectR x=new ProjectR(i+1,arrival,cpu);
                 
       pro[i]=x;
                     
   tcpu=tcpu+cpu;
               
 }
}
}