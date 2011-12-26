package termProject;

public class StateMachine {
  public final static int MAIN_MENU_STATE = 0;
  public final static int SEQUENCER_STATE= 1;
  public final static int CREDITS_STATE = 2;
  public static int currentState = MAIN_MENU_STATE;
  
  public StateMachine[] states = new StateMachine[3];
  
  public void init()
  {
    //Define all of our states here
    states[MAIN_MENU_STATE] = new MainMenu();
    states[SEQUENCER_STATE] = new Sequencer();
    states[CREDITS_STATE] = new Credits();
    
    //Initialize all our states
    for(int i = 0; i < states.length; i++)
      states[i].init();
    
  }
  
  public void enter(){
    states[currentState].enter();
  }
  
}