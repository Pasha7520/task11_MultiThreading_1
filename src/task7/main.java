package task7;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Pipe<String> pipe = new Pipe<>();
        pipe.put("lol");
        pipe.put("lol1");

        if(!(pipe.getE().equals(null))){
            System.out.println("asdsad");
        }

    }
}
