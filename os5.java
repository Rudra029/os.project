import java.util.Scanner;
import java.util.ArrayList;
class STRF
{
        int id,arrival,cpu,cpu2,exit;
	boolean iq=false;
        STRF(int id,int arrival,int cpu){
                this.id=id;
                this.arrival=arrival;
                this.cpu=cpu;
		cpu2=cpu;
        }
        STRF(){}
	public static void main(String[] argu){
      		Scanner input=new Scanner(System.in);
        	STRF[] ob=new STRF[50];
		STRF[] temp=new STRF[20];
		STRF x=new STRF();
        	ArrayList<STRF> que=new ArrayList<STRF>(50);
           	int np,np2,i,j=0,t=0,tcpu=0,r=0,tcpu2=0,s=0,wait=0,turnaround=0,avgw=0,avgt=0;
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
		System.out.println("\n\n++++++++++++++Gannt Chart for Que1+++++++++++++++\n");
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
					x.exit=(t+1);
					for(int q=0;q<np+np2;q++){
						if(x.id==ob[q].id)
							x.exit=ob[q].exit;
					}
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
					x.exit=t;
                                        for(int q=0;q<np+np2;q++){
                                                if(x.id==ob[q].id)
                                                        x.exit=ob[q].exit;
                                        }
                                        x.cpu=x.cpu-1;
                                        System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+t+"\n\t\t   --------");
                                }
			}
		}
		ArrayList<STRF> que2=new ArrayList<STRF>(20);
		STRF[] temp2=new STRF[20];
		int u=0;
		j=0;
		wait=0;
		turnaround=0;
		System.out.println("\n+++++++++++++++Gannt Chart for Que2+++++++++++++++");
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
					x.exit=u+1;
                                        for(int q=np;q<np2;q++){
                                                if(x.id==ob[q].id)
                                                        x.exit=ob[q].exit;
                                        }
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
					x.exit=u;
                                        for(int q=np;q<np2;q++){
                                                if(x.id==ob[q].id)
                                                        x.exit=ob[q].exit;
                                        }
                                        x.cpu=x.cpu-1;
                                        System.out.println("\t\t   ________"+"\n\t\t  |   P"+x.id+"   | "+u+"\n\t\t   --------");
                                }
                        }
		}
		for(i=0;i<np+np2;i++){
                        System.out.print("\nTurn Around time for P"+ob[i].id+" is : "+(ob[i].exit-ob[i].arrival+1));
                        System.out.print("      Waiting time for P"+ob[i].id+" is : "+(ob[i].exit-ob[i].cpu2-ob[i].arrival+1));
                        wait=wait+ob[i].exit-ob[i].cpu2-ob[i].arrival+1;
                        turnaround=turnaround+ob[i].exit-ob[i].arrival+1;
                }
                wait=wait/np+np2;
                turnaround=turnaround/np+np2;
                System.out.print("\n\nAvarage Turn Around time : "+turnaround);
                System.out.print("\n\nAvarage waiting time : "+wait+"\n");
	}
}
