/*Existe uma classe Point:
tem 2 métodos construtores:
--se nenhum argumento for dado, assume x=y=0
--se forem dados os valores de x e y assume
métodos: 
1- imprimir o ponto*/

class Rectangle{
    Point a,b;

    //métodos construtores
    Rectangle(int x1,int y1,int x2,int y2){
        a= new Point(x1,y1);
        b= new Point(x2,y2);
    }

    Rectangle(Point p1, Point p2){
        a= new Point(p1.x,p1.y);
        b= new Point(p2.x,p2.y);
    }

    //outros métodos
    public int area(){
        //System.out.println((b.x-a.x)+" "+ (b.y-a.y));
        return (b.x-a.x)*(b.y-a.y);
    }

    public int perimeter(){
        int base= b.x - a.x;
        int alt= b.y - a.y;
        return 2*base+2*alt;
    } 


    public boolean pointInside(Point p){
        boolean intervx= (a.x<=p.x)&&(p.x<=b.x);
        boolean intervy= (a.y<=p.y)&&(p.y<=b.x);
        if(intervx && intervy){
            return true;
        }
        return false;
    }

    public boolean rectangleInside(Rectangle r){
        Point c=r.a;
        Point d=r.b;
        if(pointInside(c)&&pointInside(d)) return true;
        return false;
    }
}
