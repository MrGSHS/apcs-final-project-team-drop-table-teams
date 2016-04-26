
/**
 * Write a description of class Hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hand
{
    private int sticksOut;
    public Hand()
    {
        sticksOut = 1;
    }
    
    public Hand(int sticks)
    {
        sticksOut = sticks;
    }
    
    public void changeSticks(int addition)
    {
        sticksOut+=addition; //stick adn stones may brea, my bonse (thanks jerry_
        sticksOut%=5;
    }
    
    public int getSticks()
    {
        return sticksOut;
    }
}
