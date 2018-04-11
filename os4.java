import java.util.Scanner;
import java.util.ArrayList;
class STRF
{
        int id,arrival,cpu;
	boolean iq=false;
        STRF(int id,int arrival,int cpu){
                this.id=id;
                this.arrival=arrival;
                this.cpu=cpu;
        }
        STRF(){}
	public static void main(String[] argu){
      		Scanner input=new Scanner(System.in);
        	STRF[] ob=new STRF[50];
		STRF[] temp=new STRF[20];
		STRF x=new STRF();
        	ArrayList<STRF> que=new ArrayList<STRF>(50);
           	int np,np2,i,j=0,t=0,tcpu=0,r=0,tcpu2=0,s=0;
                System.out.print("\nEnter No of processes for Que1 : ");
                np=input.nextInt();
		System.out.print("\nEnter No of processes for Que2 : ");
		np2=input.nextInt();
                for(i=0;i<np+np2;i++){
                        int arrival,cpu;
                        System.out.print("\nArrival Time : ");
                        arrival=input.nextInt();
                        System.out.print("CPU Time : ");
                        cpu=input.nextInt();
                        ob[i]=new STRF(i+1,arrival,cpu);
			if(i<np){
                        	tcpu=tcpu+cpu;
			}
			else{
				tcpu2=tcpu2+cpu;
			}
                }
		System.out.println("Gannt Chart for Que1");
		for(t=0;t<tcpu;t++){
			STRF min=new STRF(99,99,99);
			for(i=0;i<np;i++){
				if(ob[i].arrival<=t){
					if(ob[i].iq==false && ob[i].cpu<min.cpu){
						min.iq=false;
						ob[i].iq=true;
						min=ob[i];
					}
				}
			}
			if(min.arrival<=t && min.iq==true){
				que.add(min);
				j++;
			}
			if(que.size()==0 && r>0){
                                        for(int k=0;k<r;k++){
						que.add(temp[k]);
					}
                                }
			if(que.size()==0 && j==0){
				System.out.println("\t\t   ________"+"\n\t\t  | NO Pro | "+t+"\n\t\t   --------");
				tcpu++;
			}
			else{
                                x=que.get(0);
                                if(x.cpu>=2){
                                        que.remove(0);
                                        x.cpu=x.cpu-2;
                                        System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+t+"\n\t\t   --------");
					System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+(t+1)+"\n\t\t   --------");
                                        if(x.cpu!=0){
						temp[r]=new STRF();
						temp[r]=x;
						temp[r].iq=true;
						r++;
                                        }
					t++;
                                }
                                else{
                                        que.remove(0);
                                        x.cpu=x.cpu-1;
                                        System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+t+"\n\t\t   --------");
                                }
			}
		}
		ArrayList<STRF> que2=new ArrayList<STRF>(20);
		STRF[] temp2=new STRF[20];
		int u=0;
		j=0;
		System.out.println("\nGannt Chart for Que2");
		for(u=0;u<tcpu2;u++){
                        STRF min=new STRF(99,99,99);
                        for(i=np;i<np+np2;i++){
                                if(ob[i].arrival<=u){
                                        if(ob[i].iq==false && ob[i].cpu<min.cpu){
                                                min.iq=false;
                                                ob[i].iq=true;
                                                min=ob[i];
                                        }
                                }
                        }
                        if(min.arrival<=u && min.iq==true){
                                que2.add(min);
                                j++;
                        }
			if(que2.size()==0 && s>0){
                                for(int k=0;k<s;k++){
        	                        que2.add(temp2[k]);
                        	}
                        }
                        if(que2.size()==0 && j==0){
                                System.out.println("\t\t   ________"+"\n\t\t  | NO Pro | "+u+"\n\t\t   --------");
                                tcpu2++;
                        }
			else{
                                x=que2.get(0);
                                if(x.cpu>=2){
                                        que2.remove(0);
                                        x.cpu=x.cpu-2;
                                        System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+u+"\n\t\t   --------");
                                        System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+(u+1)+"\n\t\t   --------");
                                        if(x.cpu!=0){
                                                temp2[s]=new STRF();
                                                temp2[s]=x;
                                                temp2[s].iq=true;
                                                s++;
                                        }
                                        u++;
                                }
                                else{
                                        que2.remove(0);
                                        x.cpu=x.cpu-1;
                                        System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+u+"\n\t\t   --------");
                                }
                        }
		}
	}
}
