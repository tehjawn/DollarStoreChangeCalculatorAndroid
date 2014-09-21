package tehjawn.changecalculator;

/*  File: LeastChangePossible.java
 *
 *  //Calculates the least change possible for a Dollar Store
 *
 *  //Calculates the least possible change for a purchase of 99
 *    or less with change, giving back the least amount of Quarters,
 *    Dimes, Nickles, and Pennies.
 *
 *  ..Date: 15/09/14
 *  ..Author: John Nguyen, Mauricio Graciano
 *  ..Email: tuf23738@temple.edu, mauricio.gracianoaz@udlap.mx
 */

public class LeastChangePossible {

    //Constants & Types
    private int mPayAmount, mItemPrice, mQuarters, mDimes, mNickels, mPennies, mChange;


    /*  Basic constructor, call the resetValues method as the first step
     *  of the program. In order for the program to calculate something, the
     *  calculateChange method with two variables as input needs to be called.
     */
    public LeastChangePossible() {
        resetValues();
    }

    /*  Constructor that takes two Integers, the first being the ItemPrice,
     *  and the second one being the PayAmount. As the first step of the 
     *  program, it calls the resetValues method, and then assigns the
     *  variables to global ones in the class. In order for the program to 
     *  calculate something, the simple calculateChange method needs to be 
     *  called.
     */
    public LeastChangePossible(int itemPrice, int payAmount) {
        resetValues();
        mPayAmount = payAmount;
        mItemPrice = itemPrice;
    }

    // Resets all global variables to zero, creates a clean slate.
    private void resetValues(){
        mPayAmount = 0;
        mItemPrice = 0;
        mQuarters = 0;
        mDimes = 0;
        mNickels = 0;
        mPennies = 0;
        mChange = 0;
    }

    /*  Main method of the program, calculates the exact change in the least
     *  amount of coins. This method return a boolean value that determines if
     *  the operation was successful. Before doing any calculation, the method
     *  check to see a variety of conditions, that if met, end the program 
     *  prematurely.
     */
    public boolean calculateChange(){
        if (mItemPrice > 99) return false;
        if (mItemPrice > mPayAmount) return false;
        if (mItemPrice == mPayAmount) return true;

        int change = mPayAmount - mItemPrice;
        mChange = change;

        if (change > 25) {
            mQuarters = change / 25;
            change = change % 25;
        }
        if (change > 10) {
            mDimes = change / 10;
            change = change % 10;
        }
        if (change > 5) {
            mNickels = change / 5;
            change = change % 5;
        }
        mPennies = change;

        return true;
    }

    /*  This method take in the two variables needed to do the calculation for 
     *  the program, reset the values, assigns them to global variables, and finally
     *  call the simple calculateChane method and returns it value.
     */
    public boolean calculateChange(int itemPrice, int payAmount){
        resetValues();
        mPayAmount = payAmount;
        mItemPrice = itemPrice;
        return calculateChange();
    }

    /*  Return the amount of Quarters in the current state. Should be called 
     *  after the calculateChange method has been called.
     */
    public int getQuarters(){
        return mQuarters;
    }

    /*  Return the amount of Dimes in the current state. Should be called after
     *  the calculateChange method has been called.
     */
    public int getDimes(){
        return mDimes;
    }

    /*  Return the amount of Nickels in the current state. Should be called 
     *  after the calculateChange method has been called.
     */
    public int getNickels(){
        return mNickels;
    }

    /*  Return the amount of Pennies in the current state. Should be called 
     *  after the calculateChange method has been called.
     */
    public int getPennies(){
        return mPennies;
    }

    /*  Return the total amount of change in the current state. Should be called
     *  after the calculateChange method has been called.
     */
    public int getTotalChange() {
        return mChange;
    }
}