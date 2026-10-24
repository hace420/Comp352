public class OddonacciResult {
        int first;
        int second;
        int third;

    public OddonacciResult(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;

    }

    @Override 
    public String toString(){
        return ""+first;
    }
}