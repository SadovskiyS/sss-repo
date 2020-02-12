import java.util.Random;
import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    public int random_correct = rand(0, 100);

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public int rand(int min, int max){
        Random random = new Random();
        int diff = max - min;
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    public void output(){
        Scanner scan = new Scanner(System.in);
        model.setInputNumber(inputValue(scan));
        view.viewer(String.valueOf(model.getInputNumber()));
    }


    public int inputValue(Scanner scanner) {
        int inputNumber;
        do{
            inputNumber = scanner.nextInt();
            if(inputNumber < 0 || inputNumber > 100){
                view.viewer(View.WRONG_INPUT);
            }
            else if(random_correct > inputNumber){
                view.viewer(View.WRONG_MORE);
            }
            else if(random_correct < inputNumber){
                view.viewer((View.WRONG_LESS));
            }
            else{
                System.out.println("Winner");
            }
        }
        while (inputNumber != random_correct);
        return inputNumber;
    }
}
