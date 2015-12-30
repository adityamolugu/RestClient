/**
 * 
 */
package dataobject;

/**
 * @author Aditya.Molugu
 *
 */
public class Structure {
	
	String element_type;
	
	Children[] children;

	/**
	 * @return the element_type
	 */
	public String getElement_type() {
		return element_type;
	}

	/**
	 * @param element_type the element_type to set
	 */
	public void setElement_type(String element_type) {
		this.element_type = element_type;
	}

	/**
	 * @return the children
	 */
	public Children[] getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Children[] children) {
		this.children = children;
	}
	
	

}
