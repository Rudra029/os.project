import java.util.Scanner;
class ProjectR
{
        int id,arrival,cpu,t=2;
        ProjectR(int id,int arrival,int cpu){
                this.id=id;
                this.arrival=arrival;
                this.cpu=cpu;
        }
        ProjectR(){}
        void disp(){
                System.out.println(" _______________\n"+"|      P "+id+"\t|\n"+"| Arrival   Cpu |\n"+"|    "+arr$        }
        public static void main(String[] argu){
                Scanner input=new Scanner(System.in);
                ProjectR[] pro=new ProjectR[50];
                int count,i,j,tcpu=0,st;
                System.out.println("How many processes are there?");
                count=input.nextInt();
                for(i=0;i<count;i++){
                        int id,arrival,cpu;
                        System.out.print("Process Id :- ");
                        id=sc.nextInt();
                        System.out.print("Arrival Time :- ");
                        arrival=input.nextInt();
                        System.out.print("CPU Time :- ");
                        cpu=input.nextInt();
                        ProjectR x=new ProjectR(id,arrival,cpu);
                        pro[i]=x;
                        tcpu=tcpu+cpu;
                }
                for(i=0;i<count-1;i++){
                        for(j=i+1;j<count;j++){
                                if(pro[i].arrival>pro[j].arrival){
                                        ProjectR temp=new ProjectR();
                                        temp=pro[i];
                                        pro[i]=pro[j];
                                        pro[j]=temp;
                                }
                        }
                }
                for(i=0;i<count-1;i++){
                        for(j=i+1;j<count;j++){
                                if(pro[i].arrival==pro[j].arrival){
                                        if(pro[i].cpu<pro[j].cpu){
                                        ProjectR temp=new ProjectR();
                                        temp=pro[i];
                                        pro[i]=pro[j];
                                        pro[j]=temp;
                                        }
                                }
                        }