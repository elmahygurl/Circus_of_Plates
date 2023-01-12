
package Control;

public class ObjectState  {
    private State state;

   public ObjectState(){
      state = null;
   }

   public void setState(State state){
      this.state = state;		
   }

   public State getState(){
      return state;
   }
    
}
