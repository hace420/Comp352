public class customStack{
    int size;
    char[] characters;
    int top; // index of last element added
   

    public customStack(){
        this.size =2;
        this.characters = new char[2];
        this.top = -1;
    }

    // constructor for array with elements already inside 
    public customStack(char[] characters){
        this.size =characters.length;
        this.characters = characters;
        this.top = characters.length -1;

    }

    // Empty array constructor of a size > 2
    public customStack(int size){
        this.size =size;
        this.characters = new char[size];
        this.top = -1;

    }

    public boolean isFull(){
        if (top+1==size){
            return true;
        } else {
            return  false;
        }
    }

    public boolean isEmpty(){
        
            if (top==-1) {
                return true;
            } else {
                return false;
            }
    }

    public char top(){
        return characters[top];
    }

    public int size(){
        return size;
    }

    public void push(char a) {
            if (isFull()){
                System.out.println("Stack is full; its current size if "+size);
                System.out.println("Will be expanding the size to "+size*10);

                char[] temp = new char[size*10];
                for (int i = 0 ; i < size-1;i++){
                    temp[i] = characters[i];
                }
                characters= temp;
                size = size * 10;
            }
            
            top++;
            characters[top] = a;


    }

    public char pop(){
        if (isEmpty()){
            System.out.println("customStack is empty");
        }
        char temp = characters[top];
        top--;
        return temp;
    }

}