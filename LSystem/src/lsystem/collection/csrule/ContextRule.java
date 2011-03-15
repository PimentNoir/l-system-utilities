package lsystem.collection.csrule;

/**
 *
 * @author Martin Prout
 */
public class ContextRule{

  private int idx;       // direction of context -1 = before, 1 = after
  private String keyHash;   // hash to store rules by
  private char premis;   // character to replace by rule
  private char context;  // character that is context

  /**
  Constructor for ContextRule, holds all the logic so that only relevant data is
  stored
  */

  public ContextRule(String context) {
    this.keyHash = context;
    this.idx = ('<' == context.charAt(1))? -1 : ('>' == context.charAt(1))? 1 : 0;
    this.premis = context.charAt(2);
    this.context = context.charAt(0);
  }

	/**
	* Returns the value of context char.
	*/
	public char getContextChar() {
		return this.context;
	}

	/**
	* Returns the value of keyHash.
	*/
	public String getKeyHash() {
		return keyHash;
	}

  /**
  * Returns the value of premis.
  */
	public char getPremis() {
		return premis;
	}

	/**
	* Returns the value of context index.
	*/
	public int getIndex() {
		return idx;
	}


}
