package project3;

public class CreateMap {
    static int i1=4800,j1=4800;
    static int i2=0,j2=0;
    static color colors1[][]=new color[20][20];
    static color colors2[][]=new color[20][20];
    static color colorsterrain1[][]=new color[20][20];
    static color colorsterrain2[][]=new color[20][20];
    public int[][] CheckMap(int i,int j,int size) {
        int array[][]=new int[size][size];
        int x1,y1,x2,y2,r;
        for (Unit element : DoDGameManager.Units){
            if(element.getHealth()>0){
                x1=x2=element.getPosition().getCenterX();
                y1=y2=element.getPosition().getCenterY();
                r=element.getPosition().getRadius();
                x1-=r;
                x2+=r;
                y1-=r;
                y2+=r;
                if(x1<i) x1=i;
                if(x2>i+size) x2=i+size;
                if(y1<j) y1=j;
                if(y2>j+size) y2=j+size;
                for (int k=x1-i;k<x2-i;k++)
                    for (int l=y1-j;l<y2-j;l++){
                        if(element.getUnitName()==UnitName.MAIN_BASE)
                            array[k][l]=3;

                        else
                            array[k][l]=element.getTeamPlayer().ordinal()+1;
                    }
            }
            /*if(i==4000&&j==4000)
            for (int k=950;k<1050;k++){
                System.out.println();
                for (int l=950;l<1050;l++)
                    System.out.print(" "+array[k][l]);
            }*/
        }
        return array;
    }
    public int[][]CheckTerrain(int i,int j,int size){
        int array[][]=new int[size][size];
        int x1,y1,x2,y2,r;
        for (Terrain element : DoDGameManager.Terrains){
                x1=x2=element.getPosition().getCenterX();
                y1=y2=element.getPosition().getCenterY();
                r=element.getPosition().getRadius();
                x1-=r;
                x2+=r;
                y1-=r;
                y2+=r;
                if(x1<i) x1=i;
                if(x2>i+size) x2=i+size;
                if(y1<j) y1=j;
                if(y2>j+size) y2=j+size;
                for (int k=x1-i;k<x2-i;k++)
                    for (int l=y1-j;l<y2-j;l++){
                        array[k][l]=element.getType().ordinal()+1;
            }
        }
        return array;
    }
    public void MapTerrain(){
        int array[][]= CheckTerrain(i1,j1,200);
        for(int k=i1;k<i1+200;k+=10)
            for (int l=j1;l<j1+200;l+=10){
                int R=0,B=0,V=0,BF=0,Z=0;
                for (int i=(k-i1);i<(k-i1)+10;i++){
                    for (int j=(l-j1);j<(l-j1)+10;j++){
                        if(array[i][j]==1)
                            R++;
                        else if(array[i][j]==2)
                            B++;
                        else if(array[i][j]==3)
                            V++;
                        else if(array[i][j]==4)
                            BF++;
                        else Z++;
                    }
                }
                int i=(k-i1)/10;
                int j=(l-j1)/10;
                //System.out.println(i+" "+j);
                if(R>=V&&R>0&&R>=B&&R>=BF){
                    colorsterrain1[i][j]=color.CORNFLOWERBLUE;
                }
                else if(B>0&&B>=V&&B>=BF)
                    colorsterrain1[i][j]=color.GRAY;
                else if(V>0&&V>=BF)
                    colorsterrain1[i][j]=color.CORAL;
                else if(BF>0)
                    colorsterrain1[i][j]=color.DARKBLUE;
                else
                    colorsterrain1[i][j]=color.WHITE;
                //System.out.println(colors1[i][j]);
            }
    }
    public void MapZoomTerrain(){
        int array[][]= CheckTerrain(i2,j2,2000);
        for(int k=i2;k<i2+2000;k+=100)
            for (int l=j2;l<j2+2000;l+=100){
                int R=0,B=0,V=0,BF=0,Z=0;
                for (int i=(k-i2);i<(k-i2)+100;i++){
                    for (int j=(l-j2);j<(l-j2)+100;j++){
                        if(array[i][j]==1)
                            R++;
                        else if(array[i][j]==2)
                            B++;
                        else if(array[i][j]==3)
                            V++;
                        else if(array[i][j]==4)
                            BF++;
                        else Z++;
                    }
                }
                int i=(k-i2)/100;
                int j=(l-j2)/100;
                //System.out.println(i+" "+j);
                if(R>=V&&R>0&&R>=B&&R>=BF){
                    colorsterrain2[i][j]=color.CORNFLOWERBLUE;
                }
                else if(B>0&&B>=V&&B>=BF)
                    colorsterrain2[i][j]=color.GRAY;
                else if(V>0&&V>=BF)
                    colorsterrain2[i][j]=color.CORAL;
                else if(BF>0)
                    colorsterrain2[i][j]=color.DARKBLUE;
                else
                    colorsterrain2[i][j]=color.WHITE;
                //System.out.println(colorsterrain2[i][j]);
            }
    }
    public void Map(){
        int array[][]= CheckMap(i1,j1,200);
        for(int k=i1;k<i1+200;k+=10)
            for (int l=j1;l<j1+200;l+=10){
                int A=0,D=0,MB=0,Z=0;
                for (int i=(k-i1);i<(k-i1)+10;i++){
                    for (int j=(l-j1);j<(l-j1)+10;j++){
                        if(array[i][j]==1)
                            A++;
                        else if(array[i][j]==2)
                            D++;
                        else if(array[i][j]==3)
                            MB++;
                        else Z++;
                    }
                }
                int i=(k-i1)/10;
                int j=(l-j1)/10;
                //System.out.println(i+" "+j);
                if(A>=D&&A>0&&A>=MB){
                    colors1[i][j]=color.DARKBLUE;
                }
                else if(D>0&&D>=MB)
                    colors1[i][j]=color.red;
                else if(MB>0)
                    colors1[i][j]=color.YELLOW;
                else
                    colors1[i][j]=color.WHITE;
                //System.out.println(colors1[i][j]);
            }
    }
    public void MapZoom(){
        int array[][]= CheckMap(i2,j2,2000);
        for(int k=i2;k<i2+2000;k+=100)
            for (int l=j2;l<j2+2000;l+=100){
                int A=0,D=0,MB=0,Z=0;
                for (int i=(k-i2);i<(k-i2)+100;i++){
                    for (int j=(l-j2);j<(l-j2)+100;j++){
                        if(array[i][j]==1)
                            A++;
                        else if(array[i][j]==2)
                            D++;
                        else if(array[i][j]==3)
                            MB++;
                        else Z++;
                    }
                }
                int i=(k-i2)/100;
                int j=(l-j2)/100;
                //System.out.println(i+" "+j);
                if(A>=D&&A>0&&A>=MB){
                    colors2[i][j]=color.DARKBLUE;
                }
                else if(D>0&&D>=MB)
                    colors2[i][j]=color.red;
                else if(MB>0)
                    colors2[i][j]=color.YELLOW;
                else
                    colors2[i][j]=color.WHITE;
                //System.out.println(colors1[i][j]);
            }
    }
}
