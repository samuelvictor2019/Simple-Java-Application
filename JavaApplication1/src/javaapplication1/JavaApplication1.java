

package javaapplication1;

import java.util.Scanner;
public class JavaApplication1 {

    public static void main(String[] args) {
       
        // this line enables receiving input from user
        Scanner s = new Scanner(System.in);
        
        // the variables are declared with five arrays
        int x, n, p[], pp[], bt[], w[], t[], awt, atat, i;
        
        p=new int[10];
        pp=new int[10];
        bt=new int[10];
        w=new int[10];
        t=new int[10];
        
        //n stands for the number of process
        //p is the process
        //pp is the process priority
        //bt is the burst time
        //w is the wait time
        //t is the turnaround time
        //awt is the average wait time
        //atat is the average turnaround time
        
        
        System.out.println("Enter number of process: ");
        n = s.nextInt();
        System.out.println("Enter burst time: time priorities");
        
        for(i=0;i<n;i++){
            System.out.println("Process["+(i+1)+"]:");
            bt[i] = s.nextInt();
            pp[i] = s.nextInt();
            p[i]=i+1;
        }
        
        //priority-based sorting
        
        for(i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(pp[i]>pp[j]){
                    x=pp[i];
                    pp[i]=pp[j];
                    pp[j]=x;
                    x=bt[i];
                    bt[i]=bt[j];
                    bt[j]=x;
                    x=p[i];
                    p[i]=p[j];
                    p[j]=x;
                }
            }
        }
        w[0]=0;
        awt=0;
        t[0]=bt[0];
        atat=t[0];
        
        for(i=1;i<n;i++){
            w[i]=t[i-1];
            awt+=w[i];
            t[i]=w[i]+bt[i];
            atat+=t[i];
        }
        
        //output of processes based on their priorities
        
        System.out.println("Process \t Burst time \t Wait time \t Turn Around Time \t Priority \n");
        
        for(i=0;i<n;i++){
            System.out.println(" "+p[i]+"\t\t "+bt[i]+"\t\t "+w[i]+"\t\t "+t[i]+"\t\t "+pp[i]+"");
            
            awt/=n;
            atat/=n;
            
            System.out.println("Average wait time:" +awt);
            System.out.println("Average turn around time " +atat);
        }
    }
    
}
