import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by zhitnikov.bronislav on 09.10.2015.
 */
public class Star {
    private ArrayList<StarPoint> points;
    private ArrayList<StarPoint> word;
    public Star(){
        points=new ArrayList<>();
        points.add(new StarPoint(2,2));
        points.add(new StarPoint(6,0));
        points.add(new StarPoint(10,2));
        points.add(new StarPoint(12,6));
        points.add(new StarPoint(10,10));
        points.add(new StarPoint(6,12));
        points.add(new StarPoint(2,10));
        points.add(new StarPoint(0,6));
        //points.add(new StarPoint(4,4));
        //points.add(new StarPoint(6,3));
        //points.add(new StarPoint(4,8));
        //points.add(new StarPoint(3,6));
        //points.add(new StarPoint(9,6));
        //points.add(new StarPoint(4,8));
        //points.add(new StarPoint(6,9));
        //points.add(new StarPoint(10,8));
        word=new ArrayList<>();

    }
    public void GetWord(int length){
        int previous=17;
        word.clear();
        System.out.println("----");
        for (int i=0;i<Math.min(length,points.size()-1);i++){
            int l=(int)(Math.random()*points.size());
            while (word.indexOf(points.get(l))!=-1) l=(int)(Math.random()*points.size());
            System.out.println(l);
            word.add(points.get(l));
        }

    }
    public Image DrawWord(int width,int height) {
        Image result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics grph = result.getGraphics();
        int prvX = -1;
        int prvY = -1;
        int kx=width/12;
        int ky=height/12;
        int l=0;
        grph.setColor(Color.red);
        grph.clearRect(0,0,width,height);
        for (StarPoint point : word) {
            if (prvX != -1) {
                grph.drawLine(prvX * kx, prvY * ky, point.getX() * kx, point.getY() * ky);
                grph.drawString("" + l, point.getX() * kx, point.getY() * ky);
                prvX = point.getX();
                prvY = point.getY();
            } else {
                grph.drawString(""+l,point.getX()*kx,point.getY()*ky);
                prvX = point.getX();
                prvY = point.getY();
            }
            l++;
        }
        return result;
    }
    public void AcceptWord(){

    }


}
