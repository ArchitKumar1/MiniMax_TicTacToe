package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Gui extends JFrame implements ItemListener, ActionListener{
    int i,j,ii,jj,x,y,yesnull;
    int a[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
               {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},
               {10,7,8,9,11} };
    int a1[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };

    boolean state,type,set;

    Icon ic1,ic2,icon,ic11,ic22;
    Checkbox c1,c2;
    JLabel l1,l2;
    JButton b[]=new JButton[9];
    JButton reset;

    public void showButton(){

        x=10; y=10;j=0;
        for(i=0;i<=8;i++,x+=100,j++){
            b[i]=new JButton();
            if(j==3)
            {j=0; y+=100; x=10;}
            b[i].setBounds(x,y,100,100);
            add(b[i]);
            b[i].addActionListener(this);
        }//eof for

        reset=new JButton("RESET");
        reset.setBounds(100,350,100,50);
        add(reset);
        reset.addActionListener(this);

    }//eof showButton

    /*********************************************************/
    public  void check(int num1){
        for(ii=0;ii<=7;ii++){
            for(jj=1;jj<=3;jj++){
                if(a[ii][jj]==num1){ a[ii][4]=11;  }

            }//eof for jj

        }//eof for ii
    }//eof check
/**********************************************************/

    /*********************************************************/

    public void complogic(int num){



    }//eof complogic


    /*********************************************************/

    Gui(){
        super("tic tac toe by ashwani");

        CheckboxGroup cbg=new CheckboxGroup();
        c1=new Checkbox("vs computer",cbg,false);
        c2=new Checkbox("vs friend",cbg,false);
        c1.setBounds(120,80,100,40);
        c2.setBounds(120,150,100,40);
        add(c1); add(c2);
        c1.addItemListener(this);
        c2.addItemListener(this);


        state=true;type=true;set=true;
        ic1=new ImageIcon("ic1.jpg");
        ic2=new ImageIcon("ic2.jpg");
        ic11=new ImageIcon("ic11.jpg");
        ic22=new ImageIcon("ic22.jpg");

        setLayout(null);
        setSize(330,450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//eof constructor

    /*************************************************************/
    public void itemStateChanged(ItemEvent e){
        if(c1.getState())
        {
            type=false;
        }

        else if(c2.getState())
        { type=true;
        }
        remove(c1);remove(c2);
        repaint(0,0,330,450);
        showButton();
    }//eof itemstate
    /************************************************************/

    public void actionPerformed(ActionEvent e) {
/********************************/
    }
    public static void main(String []args){
        new Gui();
    }//eof main
}//eof class
